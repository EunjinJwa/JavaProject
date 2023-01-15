package jinny.study.designpattern.gumballmachine.client;

import jinny.study.designpattern.gumballmachine.client.GumballMachineRemote;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive {

    public static void main(String[] args) throws RemoteException {

        String url = "rmi://127.0.0.1/gumballmachine";

        GumballMonitor[] monitors = new GumballMonitor[1];

        for (int i = 0; i < 1; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(url);
                monitors[i] = new GumballMonitor(machine);
                System.out.println(monitors[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (GumballMonitor monitor : monitors) {
            monitor.report();
        }
    }
}
