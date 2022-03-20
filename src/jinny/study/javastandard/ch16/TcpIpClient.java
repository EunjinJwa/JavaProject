package jinny.study.javastandard.ch16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {
    public static void main(String[] args) {

        try {
            String serverIp = "127.0.0.1";

            System.out.println("Socket을 생성하여 서연결을 요청한다. - " + serverIp);
            Socket socket = new Socket(serverIp, 7777);

            // 소켓의 입력스트림을 얻는다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 소켓으로부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
            System.out.println("서버 연결을 종료합니다.");

            // 스트림과 소켓을 닫는다.
            dis.close();
            socket.close();

        } catch (ConnectException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        }

    }
}
