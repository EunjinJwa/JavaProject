package jinny.study.designpattern.gumballmachine.server;

import java.rmi.RemoteException;

public class WinnerState implements State {
    GumballMachine gumballMachine;
    public WinnerState(GumballMachine gumballMachine) {
    }

    @Override
    public void insertQuarter() {
        System.out.println("-");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("-");
    }

    @Override
    public void turnCrank() {
        System.out.println("-");
    }

    @Override
    public void dispense() throws RemoteException {
        System.out.println("축하합니다.! 보너스 알맹이를 획득하셨습니다");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() == 0) {
                gumballMachine.setState(gumballMachine.getSoldOutState());
            } else {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            }
        }
    }
}
