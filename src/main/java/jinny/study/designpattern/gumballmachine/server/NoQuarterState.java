package jinny.study.designpattern.gumballmachine.server;

public class NoQuarterState implements State{

    transient GumballMachine gumballMachine;    // transient : JVM에서 해당 필드를 직렬화 하지 않음.

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
