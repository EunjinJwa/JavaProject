package jinny.study.tdd.doubletest;

import jinny.study.tdd.domain.WeakPasswordChecker;

public class StubWeakPasswordChecker implements WeakPasswordChecker {

    private boolean isWeakPassword;

    public void setWeakPassword (boolean weakPassword) {
        this.isWeakPassword = isWeakPassword;
    }
    @Override
    public boolean checkPasswordWeak (String pw) {
        return this.isWeakPassword;
    }
}
