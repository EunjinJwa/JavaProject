package jinny.study.junit.mock;

import jinny.study.junit.Account;
import jinny.study.junit.AccountManager;
import jinny.study.junit.AccountService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountServiceMockitoTest {

    @Mock
    private AccountManager mockAccountManager;

    public void testTransferOf() {
        // given
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        Mockito.lenient()
                .when(mockAccountManager.findAccountForUser("1"))
                .thenReturn(senderAccount);
        Mockito.lenient()
                .when(mockAccountManager.findAccountForUser("2"))
                .thenReturn(beneficiaryAccount);

        AccountService accountService = new AccountService(mockAccountManager);

        // when
        accountService.transfer("1", "2", 50);

        // then
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

}
