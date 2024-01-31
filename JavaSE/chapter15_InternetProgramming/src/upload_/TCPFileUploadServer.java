package upload_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1. 服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听....");
        //2. 等待连接
        Socket socket = serverSocket.accept();

        //3. 读取客户端发送的数据
        //   通过Socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //4. 将得到 bytes 数组，写入到指定的路径，就得到一个文件了
        String destFilePath = "src\\upload_\\wallhaven-2y3qrg.png";
//        String destFilePath = "src\\abc.mp4";
        /**
         * 上面的abc.mp4文件是为了演示netstat指令中可以显示的端口情况
         * 选择mp4文件的原因是因为mp4文件比较大，可以较长时间地看到传输的情况
         * </p>
         * 这里实际体现的情况就是，server端的端口是固定下来的8888，但是由于客户端和服务端
         * 其实两端都是使用两个端口在进行传输，client端的端口数是不固定的。
         * */
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        // 向客户端回复 "收到图片"
        // 通过socket 获取到输出流(字符)
        // 这里用字符流或者字节流都可以，这里选择的是字符流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush(); // 把内容刷新到数据通道
        socket.shutdownOutput(); // 设置写入结束标记

        //关闭其他资源
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
