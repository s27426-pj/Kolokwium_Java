package s27426Bank.Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClientStorage {
    private List<Client> clients = new ArrayList<>();
    public void addClient(Client client){
        clients.add(client);
    }
    public Client getClient(int clientId){
        return clients.stream()
                .filter(client -> client.getId() == clientId)
                .findFirst()
                .orElse(null);
    }

    public List<Client> getClients() {
        return clients;
    }
}
