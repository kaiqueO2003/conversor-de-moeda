import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServicoTaxaCambio implements ServiçoTaxaCambio{
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    @Override
    public Cambio getTaxa(Moeda de, Moeda para) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + de.getMoeda()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                double taxa = jsonResponse.getAsJsonObject("rates").get(para.getMoeda()).getAsDouble();
                return new Cambio(de, para, taxa);
            } else {
                throw new IOException("Erro ao obter taxa de câmbio: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); // Trate de forma apropriada em produção
            return null;
        }
    }
}

