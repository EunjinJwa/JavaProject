package jinny.study.tdd.doubletest;

import jinny.study.tdd.domain.EmailNotifier;

public class SpyEmailNotifier implements EmailNotifier {

    private boolean isCalled;
    public boolean isCalled () {
        return this.isCalled;
    }

    @Override
    public void sendRegisterEmail (String email) {
        this.isCalled = true;
    }
}
