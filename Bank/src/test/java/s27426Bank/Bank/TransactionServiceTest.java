package s27426Bank.Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@SpringBootTest
class TransactionServiceTest {

    @MockBean
    private ClientStorage clientStorage;
    @MockBean
    private TransactionStorage transactionStorage;
    @Autowired
    private TransactionService transactionService;

    @Test
    public void shouldCreateAccount(){
        String  a = transactionService.createAccount(1,4000);
        assertThat(a == "Klient zarejestrowany");
    }
    @Test
    public void shouldMakeTransaction(){
        //GIVEN
        Client client = new Client(1,4000);
        when(clientStorage.getClient(client.getId())).thenReturn(client);

        //WHEN
        transactionService.makeTransaction(1,3000);

        // THEN
        assertThat(client.getBalance() == 1000);
    }
    @Test
    public void shouldntMakeTransaction(){
        //GIVEN
        Client client = new Client(1,2000);
        when(clientStorage.getClient(client.getId())).thenReturn(client);

        //WHEN
        transactionService.makeTransaction(1,3000);

        // THEN
        assertThat(client.getBalance() == 2000);
    }
}