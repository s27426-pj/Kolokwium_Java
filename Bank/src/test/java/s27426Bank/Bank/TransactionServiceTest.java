package s27426Bank.Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

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
    @Test
    public void addPayment(){
        //GIVEN
        Client client = new Client(1,4000);
        when(clientStorage.getClient(client.getId())).thenReturn(client);
        //WHEN
        transactionService.Payment(1,3000);
        // THEN
        assertThat(client.getBalance() == 7000);
    }
    @ParameterizedTest
    @MethodSource("inputData")
    public void shouldthrow4exeptions(double balance,double TransactionValue){
        Client client = new Client(1,balance);
        when(clientStorage.getClient(client.getId())).thenReturn(client);

        //WHEN
        transactionService.makeTransaction(clientStorage.getClient(1).getId(),TransactionValue);

        // THEN
        assertThat(client.getBalance() == balance - TransactionValue);
    }
    public static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(4000,2000),
                Arguments.of(5000,3000),
                Arguments.of(15000,7000),
                Arguments.of(7000,1545),
                Arguments.of(2000,2100),
                Arguments.of(400,450),
                Arguments.of(15000,20000),
                Arguments.of(8000,9000)
        );
    }
}