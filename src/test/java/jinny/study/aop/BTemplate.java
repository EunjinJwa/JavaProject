package jinny.study.aop;

public class BTemplate implements RequestRunner {
    @Override
    public void run() {
        System.out.println("BTemplate.run()");
    }

    @Override
    public String getRequestInfo() {
        return "BTemplate.getRequestInfo()";
    }

}
