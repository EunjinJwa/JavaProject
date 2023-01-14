package jinny.study.designpattern.gumballmachine.server;

import lombok.Getter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Getter
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int count) throws RemoteException {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = count;
    }

    // 동전 삽입
    public void insertQuarter() {
        state.insertQuarter();
    }

    // 동전 반환
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    // 손잡이 돌리기
    public void turnCrank() throws RemoteException {
        state.turnCrank();
        if (state == soldState || state == winnerState) {
            state.dispense();
        }
    }

    void releaseBall() {
        System.out.println("A gumball games rolling out the slot..");
        if (count != 0) {
            count--;
        }
    }

    void setState(State state) {
        this.state = state;
    }


    @Override
    public int getCount() throws RemoteException {
        return this.count;
    }

    @Override
    public String getLocation() throws RemoteException {
        return null;
    }

    @Override
    public State getState() throws RemoteException {
        return null;
    }
}
