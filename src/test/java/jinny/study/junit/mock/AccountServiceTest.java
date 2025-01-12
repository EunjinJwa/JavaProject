package jinny.study.junit.mock;

import jinny.study.junit.Account;
import jinny.study.junit.AccountService;
import jinny.study.junit.mock.MockAccountManager;
import org.junit.jupiter.api.Test;
import org.mockito.listeners.MockitoListener;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    public void testTransferOk() {
        // given
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        MockAccountManager mockAccountManager = new MockAccountManager();
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);

        AccountService accountService = new AccountService(mockAccountManager);

        // when
        accountService.transfer("1", "2", 50);

        // then
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

}
