package a07test1;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ryanw
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 客户端：多次发送数据
        // 服务器：接收多次接收数据，并打印
        // 1. 创建对象绑定10000端口
        ServerSocket ss = new ServerSocket(10000);

        // 2. 等待客户端来连接
        Socket socket = ss.accept();

        // 3. 读取数据
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1){
            System.out.println((char) b);
        }

        // 4. 释放资源
        socket.close();
        ss.close();
    }
}
