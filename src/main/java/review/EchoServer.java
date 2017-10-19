package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lx on 2017/10/13.
 */
public class EchoServer {
    public static final int ECHO_SERVER_PORT = 6789;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)) {
            System.out.println("服务器已经启动了....");
            while (true) {
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream())) {
            String msg = br.readLine();
            System.out.println("收到" + socket.getInetAddress() + " 信息" + msg);
            pw.print(msg);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class EchoClientTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容：");
        String msg = sc.nextLine();
        sc.close();
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(msg);
        pw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());
        socket.close();
    }
}