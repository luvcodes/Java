package socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端，发送 "hello, server" 给服务端
 */
@SuppressWarnings({"all"})
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, server".getBytes());
        //   设置结束标记
        /**
         * 这个结束标记不能放在读取服务端发送来的数据的后面是因为:
         * shutdownOutput() 方法的作用是关闭输出流，通知接收方（在这里是服务端）数据已经发送完毕。
         * 这个操作在客户端发送完数据之后立即执行的目的是为了告诉服务端数据的边界，以防止数据粘包问题。
         * 1. 服务端无法及时得知数据结束： 如果客户端接收完响应后再关闭输出流，服务端就无法及时得知客户端是否已经发送完数据。
         *    这可能会导致服务端在没有接收到完整数据的情况下提前开始处理数据，从而造成数据解析错误或不完整。
         * 2. 可能造成服务端阻塞： 服务端在处理数据时，可能是通过读取输入流的方式来接收数据。
         *    如果客户端不关闭输出流，服务端的输入流可能会一直等待数据的结束标志，从而导致服务端的阻塞。
         * 3. 无法及时释放资源： 如果客户端不关闭输出流，服务端可能会一直等待数据的结束标志，从而无法及时释放相关资源，导致资源泄漏。
         * */
        socket.shutdownOutput();

        //4. 获取和socket关联的输入流. 读取数据(字节)，并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        //5. 关闭流对象和socket, 必须关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
