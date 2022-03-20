package jinny.study.javastandard.ch16;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            // 서버 소켓을 생성하여 7777번 포트와 결합(bind) 한다.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " 서버가 준비되었습니다. ");

            while (true) {
                // 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
                System.out.println(getTime() + " 연결 요청을 기다립니다.");

                // 클라이언트의 연결 요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

                // 소켓의 출력스트림을 얻는다.
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격소켓에 데이터를 보낸다.
                dos.writeUTF("[Notis] Test message from server.");
                System.out.println(getTime() + " 데이터를 전송했습니다.");

                dos.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
