package jinny.study.junit;

public interface AccountManager {

    public void addAccount(String userId, Account account);
    public Account findAccountForUser(String userId);

    public void updateAccount(Account account);
}
