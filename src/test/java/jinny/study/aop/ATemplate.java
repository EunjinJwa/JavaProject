package jinny.study.aop;

public class ATemplate implements RequestRunner {
    @Override
    public void run() {
        System.out.println("ATemplate.run()");
    }

    @Override
    public String getRequestInfo() {
        return "ATemplate.getRequestInfo()";
    }

}
