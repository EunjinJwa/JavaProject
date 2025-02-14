package jinny.study.aop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestCallerTest {

    @Test
    void call() {
        RequestCaller caller = new RequestCaller();
        caller.call(new ATemplate());
        caller.call(new BTemplate());
    }

}