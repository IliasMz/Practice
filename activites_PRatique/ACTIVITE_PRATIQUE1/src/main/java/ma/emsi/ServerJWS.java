package ma.emsi;

import jakarta.xml.ws.Endpoint;
import ma.emsi.WS.BanqueService;

public class ServerJWS {
    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:9191/", new BanqueService());
        System.out.println("Web service started in adress http://0.0.0.0:9191/");
    }
}
