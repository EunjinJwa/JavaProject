package jinny.study.designpattern.gumballmachine.server;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface State extends Serializable {
    public void insertQuarter();

    public void ejectQuarter();

    public void turnCrank() throws RemoteException;

    public void dispense() throws RemoteException;
}
