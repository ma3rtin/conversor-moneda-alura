import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {

    public static void realizarCambio(String monedaInicial, String monedaFinal, Double cantidad) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/0122f74653f97e224fa1673a/pair/"+monedaInicial+"/"+monedaFinal+"/"+cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        try{
            CambioDeMonedaRecord cambioDeMoneda = new Gson().fromJson(response.body(), CambioDeMonedaRecord.class);
            System.out.println("La cantidad de "+ cantidad +" "+ monedaInicial + " convertida a "+monedaFinal+" es: " + cambioDeMoneda.conversion_result());
            System.out.println("\n");
        }catch (Exception e){
            System.out.println("Error al convertir.");
        }
    }
    }
