package jinny.study.aop;

public class RequestCaller {

    public void call(RequestRunner runner) {
        System.out.println("call: " + runner.getRequestInfo());
        runner.run();
    }
}
