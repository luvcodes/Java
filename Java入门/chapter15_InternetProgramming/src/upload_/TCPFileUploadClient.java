package upload_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //客户端连接服务端 8888，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filePath = "C:\\img\\wallhaven-2y3qrg.png";
//        String filePath = "e:\\abc.mp4";
        BufferedInputStream bis  = new BufferedInputStream(new FileInputStream(filePath));

        //bytes 就是filePath对应的字节数组
        // 也就是文件内容 (文件字节数组)，尽管在这里是一个图片或者一个音频
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流, 将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes); // 将文件对应的字节数组的内容，写入到数据通道
        bis.close();
        // 设置写入数据的结束标记
        // 为什么要写? 如果不写，服务器在读取数据的时候，不知道什么时候结束，会出现卡顿
        socket.shutdownOutput();

        // =====接收从服务端回复的消息=====
        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        
        //关闭相关的流
        inputStream.close();
        bos.close();
        socket.close();
    }
}
