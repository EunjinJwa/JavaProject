package jinny.study.designpattern.gumballmachine.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    final static int SOLID_OUT = 0;

    protected GumballMachine() throws RemoteException {
    }

    @Override
    public int getCount() throws RemoteException {
        return 0;
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
