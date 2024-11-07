import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class ClientWs {
    public static void main(String[] args) {
        BanqueService stub = new BanqueWS().getBanqueServicePort();

        System.out.println(stub.conversion(100));
        Compte c = stub.getCompte(5);
        System.out.println(c.getCode());
        System.out.println(c.getSolde());
    }
}
