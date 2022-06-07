package jinny.study.javastandard.ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpServer5 {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");

            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();

        } catch (Exception e) {

        }
    }
}

class Sender extends Thread {
    Socket socket;
    DataOutputStream out;
    String name;

    Sender(Socket socket) {
        try {
            this.socket = socket;
            out = new DataOutputStream(socket.getOutputStream());
            name = String.format("[%s : %d]", socket.getInetAddress(), socket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (out != null) {
            try {
                out.writeUTF(name + scanner.nextLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Receiver extends Thread {
    Socket socket;
    DataInputStream in;

    Receiver (Socket socket) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (in != null) {
            try {
                System.out.println("in..>> " + in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}





