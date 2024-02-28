package BackUp.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ryanw\\IdeaProjects\\Java\\MyJava\\src\\PhaseOne\\Amatuer\\BackUp.writer_\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            /**
             * <p>
             *     默认是覆盖写入, 覆盖的时使用write之前的原文件本身已经有的内容
             *     在原文件中已经保存着内容，在使用new FileWriter(filePath)这样的初始化之后，会把这个原本的内容进行覆盖，而不是后面的write覆盖前面的write字符串
             * </p>
             * <p>
             *     如果是new FileWriter(filePath, true)，那么这样如果在原来的文件中已经有内容，新写入的string就会加到原本已经有的内容的后面
             * </p>
             * */
            fileWriter = new FileWriter(filePath);
            // 3) write(int):写入单个字符
            fileWriter.write('a');
            // 4) write(char[]):写入指定数组
            fileWriter.write(chars);
//            // 5) write(char[],off,len):写入指定数组的指定部分
//            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
//            // 6) write（string）：写入整个字符串
//            fileWriter.write(" 你好北京~");
//            fileWriter.write("风雨之后，定见彩虹");
//            // 7) write(string,off,len):写入字符串的指定部分
//            fileWriter.write("上海天津", 0, 2);
//            //在数据量大的情况下，可以使用循环操作.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对应FileWriter , 一定要关闭流，或者flush才能真正的把数据写入到文件
            /*
                private void writeBytes() throws IOException {
                    this.bb.flip();
                    int var1 = this.bb.limit();
                    int var2 = this.bb.position();

                    assert var2 <= var1;

                    int var3 = var2 <= var1 ? var1 - var2 : 0;
                    if (var3 > 0) {
                        if (this.ch != null) {
                            assert this.ch.write(this.bb) == var3 : var3;
                        } else {
                            this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                        }
                    }
                    this.bb.clear();
                }
             */
            try {
                // fileWriter.flush();
                //关闭文件流，等价 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束...");
    }
}
