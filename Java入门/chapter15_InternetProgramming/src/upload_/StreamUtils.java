package upload_;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法
 */
public class StreamUtils {
    /**
     * 功能：将输入流转换成byte[]
     * @param is
     * @return
     * @throws Exception
     */
    public static byte[] streamToByteArray(InputStream is) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream(); // 创建输出流对象
        byte[] b = new byte[1024]; // 字节数组
        int len;
        while((len=is.read(b))!=-1){ // 循环读取
            bos.write(b, 0, len); // 把读取到的数据写入到bos这个字节数组流中
        }
        byte[] array = bos.toByteArray(); // 然后将bos 转成字节数组
        bos.close();
        return array;
    }

    /**
     * 功能：将InputStream转换成String
     * @param is
     * @return
     * @throws Exception
     */
    public static String streamToString(InputStream is) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder= new StringBuilder();
        String line;
        while((line=reader.readLine())!=null){ // 当读取到 null时，就表示结束
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }
}
