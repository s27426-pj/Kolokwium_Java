package s27426Bank.Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClientStorage {
    private List<Client> clients = new ArrayList<>();
}
