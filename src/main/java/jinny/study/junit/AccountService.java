package jinny.study.junit;

public class AccountService {

    private final AccountManager accountManager;

    public AccountService(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void transfer(String senderId, String beneficiaryId, long amount) {
        Account sender = accountManager.findAccountForUser(senderId);
        Account beneficiary = accountManager.findAccountForUser(beneficiaryId);

        sender.debit(amount);
        beneficiary.credit(amount);

        this.accountManager.updateAccount(sender);
        this.accountManager.updateAccount(beneficiary);
    }

}
