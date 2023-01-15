package jinny.study.designpattern.gumballmachine.remote;

import jinny.study.designpattern.gumballmachine.server.GumballMachine;
import jinny.study.designpattern.gumballmachine.server.GumballMachineRemote;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GumballMachineRemoteTestDrive {

    public static void main(String[] args) {
        GumballMachineRemote stub = null;
        int count;

        System.out.println(args[0]);
        System.out.println(args[1]);

        String location = args[0];

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
            stub = new GumballMachine(location, count);

//            Naming.bind("//" + args[0] + "/gumballmachine", gumballMachine);
            Naming.rebind("gumballmachine", stub);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
