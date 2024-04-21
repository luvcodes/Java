# 1. IO概述

## 1.1. 什么是IO流

按照流动的方向，以内存为基准，分为输入input 和输出output ，即流向内存是输入流，流出内存的输出流。

Java中I/O操作主要是指使用java.io包下的内容，进行输入、输出操作。**输入**也叫做**读取**数据，**输出**也叫做作**写出**数据。

## 1.2. IO的分类

根据数据的流向分为：**输入流**和**输出流**。

- **输入流** ：把数据从`其他设备`上读取到`内存`中的流。
- **输出流** ：把数据从`内存` 中写出到`其他设备`上的流。

格局数据的类型分为：**字节流**和**字符流**。

- **字节流** ：以字节为单位，读写数据的流。
- **字符流** ：以字符为单位，读写数据的流。

**字节流可以操作所有类型的文件**

**字符流只能操作纯文本文件**

## 1.3. 顶级父类

|   |   |   |
|---|---|---|
||**输入流**|输出流|
|**字节流**|字节输入流**InputStream**|字节输出流**OutputStream**|
|**字符流**|字符输入流**Reader**|字符输出流**Writer**|

# 2. 字节流

## 2.1. 一切皆为字节

一切文件数据(文本、图片、视频等)在存储时，都是以二进制数字的形式保存，都一个一个的字节，那么传输时一样如此。所以，字节流可以传输任意文件数据。在操作流的时候，我们要时刻明确，无论使用什么样的流对象，底层传输的始终为二进制数据。

## 2.2. 字节输出流【OutputStream】

`java.io.OutputStream`抽象类是表示**字节输出流的所有类的超类**，将指定的字节信息写出到目的地。它定义了字节输出流的基本共性功能方法。

- `public void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。
- `public void flush()` ：刷新此输出流并强制任何缓冲的输出字节被写出。
- `public void write(byte[] b)`：将 b.length字节从指定的字节数组写入此输出流。
- `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
- `public abstract void write(int b)` ：将指定的字节输出流。

小贴士：

close方法，当完成流的操作时，必须调用此方法，释放系统资源。

### 2.2.1. 构造方法

- `public FileOutputStream(File file)`：创建文件输出流**以写入由指定的 File对象表示的文件**。
- `public FileOutputStream(String name)`： 创建文件输出流**以指定的名称写入文件**。

当你创建一个流对象时，必须传入一个文件路径。

该路径下，**如果没有这个文件，会创建该文件**。如果有这个文件，会清空这个文件的数据。

- 构造举例，代码如下：

```Java
public class FileOutputStreamConstructor throws IOException {
    public static void main(String[] args) {
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file);

        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("b.txt");
    }
}
```

当你使用`FileOutputStream`构造函数来创建一个文件输出流，**如果指定的文件不存在，Java会尝试创建这个文件**。

如果文件成功创建，接下来的写入操作会将内容输出到这个文件中。如果由于某些原因（比如没有写入权限或磁盘空间不足）文件不能被创建，将会抛出一个`FileNotFoundException`。

### 2.2.2. 写出字节数据

1. **写出字节**：`write(int b)` 方法，每次可以写出一个字节数据，代码使用演示：

```Java
public class FOSWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
      	// 写出数据
      	fos.write(97); // 写出第1个字节
      	fos.write(98); // 写出第2个字节
      	fos.write(99); // 写出第3个字节
      	// 关闭资源
        fos.close();
    }
}
输出结果：
abc
```

小贴士：

1. 虽然参数为int类型四个字节，但是只会保留一个字节的信息写出。
2. 流操作完毕后，必须释放系统资源，调用close方法。
3. **写出字节数组**：write(byte[] b)，每次可以写出数组中的数据，代码使用演示：

```Java
public class FOSWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
      	// 字符串转换为字节数组
      	byte[] b = "黑马程序员".getBytes();
      	// 写出字节数组数据
      	fos.write(b);
      	// 关闭资源
        fos.close();
    }
}
输出结果：
黑马程序员
```

1. **写出指定长度字节数组**：write(byte[] b, int off, int len) ,每次写出从off索引开始，len个字节，代码使用演示：

```Java
public class FOSWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
      	// 字符串转换为字节数组
      	byte[] b = "abcde".getBytes();
		    // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b,2,2);
      	// 关闭资源
        fos.close();
    }
}
输出结果：
cd
```

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1708988651598-8792f3f0-1d0c-4d01-9f89-e54886c25d35.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1708988651598-8792f3f0-1d0c-4d01-9f89-e54886c25d35.png)

### 2.2.3. 数据追加续写

经过以上的演示，每次程序运行，创建输出流对象，都会清空目标文件中的数据。**如何保留目标文件中数据，还能继续添加新数据呢？**

- `public FileOutputStream(File file, boolean append)`： 创建文件输出流以写入由指定的 File对象表示的文件。
- `public FileOutputStream(String name, boolean append)`： 创建文件输出流以指定的名称写入文件。

这两个构造方法，**参数中都需要传入一个boolean类型的值**，`true` 表示追加数据，`false` 表示清空原有数据。这样创建的输出流对象，就可以指定是否追加续写了，代码使用演示：

```Java
public static void main(String[] args) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\outputstream_\\mybytestream\\a.txt", true);
    String str = "backend developer";
    byte[] byte1 = str.getBytes();
    fileOutputStream.write(byte1);

    String wrap = "\r\n";
    byte[] byte2 = wrap.getBytes();
    fileOutputStream.write(byte2);

    fileOutputStream.close();
}
```

### 2.2.4. 写出换行

Windows系统里，换行符号是`\r\n` 。以指定是否追加续写了，代码使用演示：

```Java
public class FOSWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
      	// 定义字节数组
      	byte[] words = {97,98,99,100,101};
      	// 遍历数组
        for (int i = 0; i < words.length; i++) {
          	// 写出一个字节
            fos.write(words[i]);
          	// 写出一个换行, 换行符号转成数组写出
            fos.write("\r\n".getBytes());
        }
      	// 关闭资源
        fos.close();
    }
}

输出结果：
a
b
c
d
e
```

回车符`\r`和换行符`\n` ：

- 回车符：回到一行的开头（return）。
- 换行符：下一行（newline）。

系统中的换行：

- Windows系统里，每行结尾是 `回车+换行` ，即`\r\n`；
- Unix系统里，每行结尾只有 `换行` ，即`\n`；
- Mac系统里，每行结尾是 `回车` ，即`\r`。从 Mac OS X开始与Linux统一。

## 2.3. 字节输入流【InputStream】

`java.io.InputStream`抽象类是表示字节输入流的所有类的超类，可以**读取字节信息到内存**中。它定义了字节输入流的基本共性功能方法。

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。
- `public abstract int read()`： 从输入流读取数据的下一个字节。
- `public int read(byte[] b)`： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

小贴士：

close方法，当完成流的操作时，必须调用此方法，释放系统资源。

## 2.4. FileInputStream类

`java.io.FileInputStream` 类是文件输入流，**从文件中读取字节**。

### 2.4.1. 构造方法

- `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。
- `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出`FileNotFoundException`

- 构造举例，代码如下：

```Java
public class FileInputStreamConstructor throws IOException{
    public static void main(String[] args) {
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileInputStream fos = new FileInputStream(file);

        // 使用文件名称创建流对象
        FileInputStream fos = new FileInputStream("b.txt");
    }
}
```

### 2.4.2. 读取字节数据

1. **读取字节**：`read`方法，**每次可以读取一个字节的数据**，**提升为int类型**，读取到文件末尾，返回`1`，代码使用演示：

```Java
public class FISRead {
    public static void main(String[] args) throws IOException{
      	// 使用文件名称创建流对象
       	FileInputStream fis = new FileInputStream("read.txt");
      	// 读取数据，返回一个字节
        int read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
        read = fis.read();
        System.out.println((char) read);
      	// 读取到末尾,返回-1
       	read = fis.read();
        System.out.println( read);
		// 关闭资源
        fis.close();
    }
}
输出结果：
a
b
c
d
e
-1
```

**循环改进读取方式**，代码使用演示：

```Java
public class FISRead {
    public static void main(String[] args) throws IOException{
        // 使用文件名称创建流对象
        FileInputStream fis = new FileInputStream("read.txt");
        // 定义变量，保存数据
        int b ；
        // 循环读取
        while ((b = fis.read())!=-1) {
            System.out.println((char)b);
        }
        // 关闭资源
        fis.close();
    }
}
输出结果：
a
b
c
d
e
```

小贴士：

1. 虽然读取了一个字节，但是会自动提升为int类型。
2. 流操作完毕后，必须释放系统资源，调用close方法，千万记得。
3. **使用字节数组读取**：read(byte[] b)，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1 ，代码使用演示：

```Java
public class FISRead {
    public static void main(String[] args) throws IOException{
        // 使用文件名称创建流对象.
        FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
        // 定义变量，作为有效个数
        int len ；
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[2];
        // 循环读取
        while (( len= fis.read(b))!=-1) {
            // 每次读取后,把数组变成字符串打印
            System.out.println(new String(b));
        }
        // 关闭资源
        fis.close();
    }
}

输出结果：
ab
cd
ed
```

错误数据d，是由于最后一次读取时，只读取一个字节e，数组中，上次读取的数据没有被完全替换，所以要通过len ，获取有效的字节，代码使用演示：

```Java
public class FISRead {
    public static void main(String[] args) throws IOException{
        // 使用文件名称创建流对象.
        FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
        // 定义变量，作为有效个数
        int len ；
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[2];
        // 循环读取
        while (( len= fis.read(b))!=-1) {
            // 每次读取后,把数组的有效字节部分，变成字符串打印
            System.out.println(new String(b，0，len));//  len 每次读取的有效字节个数
        }
        // 关闭资源
        fis.close();
    }
}

输出结果：
ab
cd
e
```

小贴士：

使用数组读取，每次读取多个字节，减少了系统间的IO操作次数，从而提高了读写的效率，建议开发中使用。

### 2.4.3. 案例实现

复制图片文件，代码使用演示：

```Java
public class Copy {
    public static void main(String[] args) throws IOException {
        // 1.创建流对象
        // 1.1 指定数据源
        FileInputStream fis = new FileInputStream("D:\\test.jpg");
        // 1.2 指定目的地
        FileOutputStream fos = new FileOutputStream("test_copy.jpg");

        // 2.读写数据
        // 2.1 定义数组
        byte[] b = new byte[1024];
        // 2.2 定义长度
        int len;
        // 2.3 循环读取
        while ((len = fis.read(b))!=-1) {
            // 2.4 写出数据
            fos.write(b, 0 , len);
        }

        // 3.关闭资源
        fos.close();
        fis.close();
    }
}
```

小贴士：

流的关闭原则：先开后关，后开先关。

# 3. 字符流

## 3.1. 字符输入流

`java.io.Reader` 抽象类是表示用于**读取字符流的所有类的超类**，可以**读取字符信息到内存中**。它定义了字符输入流的基本共性功能方法。

- `public void close()` ：关闭此流并释放与此流相关联的任何系统资源。
- `public int read()`： **从输入流读取一个字符**。
- `public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中

## 3.2. FileReader类

`java.io.FileReader` 类是读取字符文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。

小贴士：

1. 字符编码：字节与字符的对应规则。Windows系统的中文编码默认是GBK编码表。idea中UTF-8
2. 字节缓冲区：一个字节数组，用来临时存储字节数据。

### 3.2.1. 构造方法

- `FileReader(File file)`： 创建一个新的 FileReader ，给定要读取的File对象。
- `FileReader(String fileName)`： 创建一个新的 FileReader ，给定要读取的文件的名称。

当你创建一个流对象时，必须传入一个文件路径。类似于FileInputStream 。

- 构造举例，代码如下：

```Java
public class FileReaderConstructor throws IOException{
    public static void main(String[] args) {
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileReader fr = new FileReader(file);

        // 使用文件名称创建流对象
        FileReader fr = new FileReader("b.txt");
    }
}
```

### 3.2.2. 读取字符数据

1. **读取字符**：`read`方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回`1`，循环读取，代码使用演示：

```Java
public class FRRead {
    public static void main(String[] args) throws IOException {
      	// 使用文件名称创建流对象
       	FileReader fr = new FileReader("read.txt");
      	// 定义变量，保存数据
        int b ；
        // 循环读取
        while ((b = fr.read()) != -1) {
            System.out.println((char)b);
        }
				// 关闭资源
        fr.close();
    }
}
输出结果：
黑
马
程
序
员
```

小贴士：虽然读取了一个字符，但是会自动提升为int类型。

1. **使用字符数组读取**：read(char[] cbuf)，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回-1 ，代码使用演示：

```Java
public class FISRead {
    public static void main(String[] args) throws IOException {
      	// 使用文件名称创建流对象
       	FileReader fr = new FileReader("read.txt");
      	// 定义变量，保存有效字符个数
        int len ；
        // 定义字符数组，作为装字符数据的容器
        char[] cbuf = new char[2];
        // 循环读取
        while ((len = fr.read(cbuf))!=-1) {
            System.out.println(new String(cbuf,0,len));
        }
    	// 关闭资源
        fr.close();
    }
}

输出结果：
黑马
程序
员
```

## 3.3. 字符输出流【Writer】

`java.io.Writer`抽象类是表示用于写出字符流的所有类的超类，将指定的字符信息写出到目的地。它定义了字节输出流的基本共性功能方法。

- `void write(int c)` 写入单个字符。
- `void write(char[] cbuf)`写入字符数组。
- `abstract void write(char[] cbuf, int off, int len)`写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
- `void write(String str)`写入字符串。
- `void write(String str, int off, int len)` 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
- `void flush()`刷新该流的缓冲。
- `void close()` 关闭此流，但要先刷新它。

## 3.4. FileWriter类

`java.io.FileWriter`类是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。

### 3.4.1. 构造方法

- `FileWriter(File file)`： 创建一个新的 FileWriter，给定要读取的File对象。
- `FileWriter(String fileName)`： 创建一个新的 FileWriter，给定要读取的文件的名称。

当你创建一个流对象时，必须传入一个文件路径，类似于FileOutputStream。

- 构造举例，代码如下：

```Java
public class FileWriterConstructor {
    public static void main(String[] args) throws IOException {
        // 使用File对象创建流对象
        File file = new File("a.txt");
        FileWriter fw = new FileWriter(file);

        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("b.txt");
    }
}
```

### 3.4.2. 基本写出数据

```Java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");
      	// 写出数据
      	fw.write(97); // 写出第1个字符
      	fw.write('b'); // 写出第2个字符
      	fw.write('C'); // 写出第3个字符
      	fw.write(30000); // 写出第4个字符，中文编码表中30000对应一个汉字。

      	/*
        【注意】关闭资源时,与FileOutputStream不同。
      	 如果不关闭,数据只是保存到缓冲区，并未保存到文件。
        */
        // fw.close();
    }
}
输出结果：
abC田
```

小贴士：

1. 虽然参数为int类型四个字节，但是只会保留一个字符的信息写出。
2. 未调用close方法，数据只是保存到了缓冲区，并未写出到文件中。

### 3.4.3. 关闭和刷新

**因为内置缓冲区的原因**，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。如果我们**既想写出数据**，**又想继续使用流**，就需要flush 方法了。

- flush ：刷新缓冲区，流对象可以继续使用。
- close :先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

```Java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");
        // 写出数据，通过flush
        fw.write('刷'); // 写出第1个字符
        fw.flush();
        fw.write('新'); // 继续写出第2个字符，写出成功
        fw.flush();

      	// 写出数据，通过close
        fw.write('关'); // 写出第1个字符
        fw.close();
        fw.write('闭'); // 继续写出第2个字符,【报错】java.io.IOException: Stream closed
        fw.close();
    }
}
```

### 3.4.4. 写出其他数据

1. **写出字符数组** ：`write(char[] cbuf)` 和 `write(char[] cbuf, int off, int len)` ，每次可以写出字符数组中的数据，用法类似FileOutputStream，代码使用演示：

```Java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");
      	// 字符串转换为字节数组
      	char[] chars = "黑马程序员".toCharArray();

      	// 写出字符数组
      	fw.write(chars); // 黑马程序员

		// 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(b,2,2); // 程序

      	// 关闭资源
        fos.close();
    }
}
```

1. **写出字符串**：write(String str) 和 write(String str, int off, int len) ，每次可以写出字符串中的数据，更为方便，代码使用演示：

```Java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");
      	// 字符串
      	String msg = "黑马程序员";

      	// 写出字符数组
      	fw.write(msg); //黑马程序员

		// 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(msg,2,2);	// 程序

        // 关闭资源
        fos.close();
    }
}
```

1. **续写和换行**：操作类似于FileOutputStream。

```Java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象，可以续写数据
        FileWriter fw = new FileWriter("fw.txt"，true);
      	// 写出字符串
        fw.write("黑马");
      	// 写出换行
      	fw.write("\r\n");
      	// 写出字符串
  		fw.write("程序员");
      	// 关闭资源
        fw.close();
    }
}
输出结果:
黑马
程序员
```

小贴士：字符流，只能操作文本文件，不能操作图片，视频等非文本文件。

当我们单纯读或者写文本文件时 使用字符流 其他情况使用字节流

# 4. 缓冲流

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

## 4.1. 字节缓冲流

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709178000954-6d7c51bb-94e0-4587-b177-5b4b05cedf22.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709178000954-6d7c51bb-94e0-4587-b177-5b4b05cedf22.png)

## 4.2. 字符缓冲流

### 4.2.1. 字符缓冲流的构造方法

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709247444961-e91ad69a-e65d-441d-926e-d4f9c2541360.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709247444961-e91ad69a-e65d-441d-926e-d4f9c2541360.png)

### 4.2.2. 字符缓冲流的特有方法

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709247480583-9f1d2ad2-cef8-4421-a706-dfeb1737ffc1.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709247480583-9f1d2ad2-cef8-4421-a706-dfeb1737ffc1.png)

## 4.3. 总结

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709248494804-633f7196-9924-4472-87e7-7ad603defb11.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709248494804-633f7196-9924-4472-87e7-7ad603defb11.png)

# 5. 转换流

## 5.1. 字符编码和字符集

计算机中储存的信息都是用二进制数表示的，而我们在屏幕上看到的数字、英文、标点符号、汉字等字符是二进制数转换之后的结果。

按照某种规则，将字符存储到计算机中，称为**编码**。

反之，将存储在计算机中的二进制数按照某种规则解析显示出来，称为**解码** 。

比如说，按照A规则存储，同样按照A规则解析，那么就能显示正确的文本符号。反之，按照A规则存储，再按照B规则解析，就会导致乱码现象。

编码:字符(能看懂的)--字节(看不懂的)

解码:字节(看不懂的)-->字符(能看懂的)

- **字符编码Character Encoding** : 就是一套自然语言的字符与二进制数之间的对应规则。编码表:生活中文字和计算机中二进制的对应规则
- **字符集** `**Charset**`：也叫编码表。是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等。

计算机要准确的存储和识别各种字符集符号，需要进行字符编码，一套字符集必然至少有一套字符编码。常见字符集有ASCII字符集、GBK字符集、Unicode字符集等。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709252747006-c5591c4e-6642-49e9-be48-ff22937fbcb5.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709252747006-c5591c4e-6642-49e9-be48-ff22937fbcb5.png)

## 5.2. ASCII码与GBK字符集

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709009410295-03430641-df43-465c-9b15-5565b75ac528.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709009410295-03430641-df43-465c-9b15-5565b75ac528.png)

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709009362625-2f51316d-afac-487a-b1a9-78ea9d0aaeb5.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709009362625-2f51316d-afac-487a-b1a9-78ea9d0aaeb5.png)

规则一这样设置是因为两个字节存储比较好，一个字节存储不能涵盖大部分的汉字，三个字节存储过多占用空间。

规则二的就是用来区分中文字和英文字的。**1开头的就是中文而且是16位，0开头的是英文 8位。**

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709009658274-8e9afec6-eaf1-43e6-972f-998cc22742c2.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709009658274-8e9afec6-eaf1-43e6-972f-998cc22742c2.png)

## 5.3. UniCode字符集

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709010098560-94405cea-fad4-4eee-8311-062834ec2934.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709010098560-94405cea-fad4-4eee-8311-062834ec2934.png)

UTF-8的编码规则下，英文是用1个字节表示，中文是用3个字节表示，而且中文的第一个字节的首位一定是1。

UTF-8不是字符集，是一种编码方式。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709010451196-63165cdf-3fb6-41f5-8786-153151df85ed.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709010451196-63165cdf-3fb6-41f5-8786-153151df85ed.png)

## 5.4. 编码与解码

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709014965003-27af7728-e07b-4984-80e3-de9dba30c6cf.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709014965003-27af7728-e07b-4984-80e3-de9dba30c6cf.png)

代码示例:

```Java
//1.编码
String str = "ai你哟";
byte[] bytes1 = str.getBytes();
// 8个字节，1 + 1 + 3 + 3
System.out.println(Arrays.toString(bytes1));

byte[] bytes2 = str.getBytes("GBK");
// 1 + 1 + 2 + 2
System.out.println(Arrays.toString(bytes2));

//2.解码
String str2 = new String(bytes1);
System.out.println(str2);

String str3 = new String(bytes1,"GBK");
System.out.println(str3);

[97, 105, -28, -67, -96, -27, -109, -97]
[97, 105, -60, -29, -45, -76]
ai你哟
ai浣犲摕
```

**最后一个结果中的中文变成乱码，是因为在对字符串进行解码时使用了与编码时不匹配的字符集**。在你的例子中，`str`字符串首先使用Java的默认字符集（通常是UTF-8）进行编码，得到了`bytes1`。`UTF-8`编码中，英文字符占用1个字节，而中文字符通常占用3个字节，这就是为什么`bytes1`的输出是`[97, 105, -28, -67, -96, -27, -109, -97]`的原因。

然后，你尝试使用`GBK`字符集对`bytes1`进行解码。`GBK`是一种用于简体中文的字符编码，其中英文字符依然占用1个字节，但中文字符占用2个字节。

因为`bytes1`是按UTF-8编码的，其中中文字符以3个字节的形式存在，而在尝试用`GBK`解码时，解码器会期望每个中文字符占用2个字节。由于字节的组合方式与`GBK`预期的不同，这导致了解码过程中中文字符的错误解释，进而产生了乱码。

## 5.5. 编码引出的问题

在IDEA中，使用`FileReader` 读取项目中的文本文件。由于IDEA的设置，都是默认的`UTF-8`编码，所以没有任何问题。但是，当读取Windows系统中创建的文本文件时，由于Windows系统的默认是GBK编码，就会出现乱码。

```Java
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("E:\\File_GBK.txt");
        int read;
        while ((read = fileReader.read()) != -1) {
            System.out.print((char)read);
        }
        fileReader.close();
    }
}
输出结果：
���
```

那么如何读取GBK编码的文件呢？

## 5.6. 指定编码读取字符

```Java
public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         * 利用转换流按照指定字符编码读取(了解)
         *
         * 因为JDK11：这种方式被淘汰了。
         * 替代方案(掌握)
         */

        // JDK 11之后的方法
        FileReader fileReader = new FileReader("src/myconvertstream/gbkfile.txt", Charset.forName("GBK"));
        int ch;
        while ((ch = fileReader.read()) != -1) {
            System.out.println((char) ch);
        }
        fileReader.close();
    }
}
```

### 5.6.1. InputStreamReader类

转换流java.io.InputStreamReader，是Reader的子类，是从字节流到字符流的桥梁。它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。

### 5.6.1.1. 构造方法

- InputStreamReader(InputStream in): 创建一个使用默认字符集的字符流。
- InputStreamReader(InputStream in, String charsetName): 创建一个指定字符集的字符流。

构造举例，代码如下：

```Plain
InputStreamReader isr = new InputStreamReader(new FileInputStream("in.txt"));
InputStreamReader isr2 = new InputStreamReader(new FileInputStream("in.txt") , "GBK");
```

## 5.7. 指定编码写出

```Java
public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // JDK 11 替代方案
        FileWriter fw = new FileWriter("src/myconvertstream/c.txt", Charset.forName("GBK"));
        fw.write("你好你好");
        fw.close();
    }
}
```

### 5.7.1. OutputStreamWriter类

转换流`java.io.OutputStreamWriter` ，是Writer的子类，是从字符流到字节流的桥梁。使用指定的字符集将字符编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集。

### 5.7.1.1. 构造方法

- `OutputStreamWriter(OutputStream in)`: 创建一个使用默认字符集的字符流。
- `OutputStreamWriter(OutputStream in, String charsetName)`: 创建一个指定字符集的字符流。

```Java
OutputStreamWriter isr = new OutputStreamWriter(new FileOutputStream("out.txt"));
OutputStreamWriter isr2 = new OutputStreamWriter(new FileOutputStream("out.txt") , "GBK");
```

## 5.8. 练习：转换文件编码

将GBK编码的文本文件，转换为UTF-8编码的文本文件。

### 5.8.1. 案例分析

1. 指定GBK编码的转换流，读取文本文件。
2. 使用UTF-8编码的转换流，写出文本文件。

### 5.8.2. 案例实现

```Java
// 1. JDK 11以前的方案
InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/myconvertstream/b.txt"), "GBK");
OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("src/myconvertstream/d.txt"), "UTF-8");

int b;
while ((b = inputStreamReader.read()) != -1) {
    outputStreamWriter.write(b);
}

outputStreamWriter.close();
inputStreamReader.close();

// 2. JDK 11以后的方案
//        FileReader fileReader = new FileReader("src/myconvertstream/b.txt", Charset.forName("GBK"));
//        FileWriter fileWriter = new FileWriter("src/myconvertstream/e.txt", Charset.forName("UTF-8"));
//
//        int b;
//        while ((b = fileReader.read()) != -1) {
//            fileWriter.write(b);
//        }
//
//        fileWriter.close();
//        fileReader.close();
```

## 5.9. 转换流总结

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709356886952-d5e14a39-5bba-4adc-a7e3-512e05b49d6c.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709356886952-d5e14a39-5bba-4adc-a7e3-512e05b49d6c.png)

# 6. 序列化流

## 6.1. 概述

Java 提供了一种对象**序列化**的机制。用一个字节序列可以表示一个对象，该字节序列包含该`对象的数据`、`对象的类型`和`对象中存储的属性`等信息。字节序列写出到文件之后，相当于文件中**持久保存**了一个对象的信息。

反之，该字节序列还可以从文件中读取回来，重构对象，对它进行**反序列化**。`对象的数据`、`对象的类型`和`对象中存储的数据`信息，都可以用来在内存中创建对象。看图理解序列化：

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709357464155-55bac0ef-56ad-4b99-b3a5-1e1032696ff2.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709357464155-55bac0ef-56ad-4b99-b3a5-1e1032696ff2.png)

## 6.2. ObjectOutputStream类

java.io.ObjectOutputStream 类，将Java对象的原始数据类型写出到文件,实现对象的持久存储。

### 6.2.1. 构造方法

- public ObjectOutputStream(OutputStream out) ： 创建一个指定OutputStream的`ObjectOutputStream`

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709357399239-5de08561-a403-47b2-85ec-5e967a7267db.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709357399239-5de08561-a403-47b2-85ec-5e967a7267db.png)

### 6.2.2. 序列化操作

1. 一个对象要想序列化，必须满足两个条件:

- 该类必须实现`java.io.Serializable` 接口，`Serializable` 是一个标记接口，不实现此接口的类将不会使任何状态序列化或反序列化，会抛出`NotSerializableException` 。
- 该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用`transient` 关键字修饰。

```Java
public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
      	System.out.println("Address  check : " + name + " -- " + address);
    }
}
```

2.写出对象方法

- public final void writeObject (Object obj) : 将指定的对象写出。

```Java
public class SerializeDemo{
   	public static void main(String [] args)   {
    	Employee e = new Employee();
    	e.name = "zhangsan";
    	e.address = "beiqinglu";
    	e.age = 20;
    	try {
      		// 创建序列化流对象
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
        	// 写出对象
        	out.writeObject(e);
        	// 释放资源
        	out.close();
        	fileOut.close();
        	System.out.println("Serialized data is saved"); // 姓名，地址被序列化，年龄没有被序列化。
        } catch(IOException i)   {
            i.printStackTrace();
        }
   	}
}
输出结果：
Serialized data is saved
```

## 6.3. ObjectInputStream类

ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。

### 6.3.1. 构造方法

- `public ObjectInputStream(InputStream in)`： 创建一个指定InputStream的ObjectInputStream。

### 6.3.2. 反序列化操作1

如果能找到一个对象的class文件，我们可以进行反序列化操作，调用`ObjectInputStream`读取对象的方法：

- `public final Object readObject ()` : 读取一个对象。

```Java
public class DeserializeDemo {
   public static void main(String [] args)   {
        Employee e = null;
        try {
             // 创建反序列化流
             FileInputStream fileIn = new FileInputStream("employee.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn);
             // 读取一个对象
             e = (Employee) in.readObject();
             // 释放资源
             in.close();
             fileIn.close();
        }catch(IOException i) {
             // 捕获其他异常
             i.printStackTrace();
             return;
        }catch(ClassNotFoundException c)  {
        	// 捕获类找不到异常
             System.out.println("Employee class not found");
             c.printStackTrace();
             return;
        }
        // 无异常,直接打印输出
        System.out.println("Name: " + e.name);	// zhangsan
        System.out.println("Address: " + e.address); // beiqinglu
        System.out.println("age: " + e.age); // 0
    }
}
```

### 6.3.3. **反序列化操作2**

**另外，当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，那么反序列化操作也会失败，抛出一个**`**InvalidClassException**`**异常。**发生这个异常的原因如下：

- 该类的序列版本号与从流中读取的类描述符的版本号不匹配
- 该类包含未知数据类型
- 该类没有可访问的无参数构造方法

`**Serializable**` **接口给需要序列化的类，提供了一个序列版本号**。`serialVersionUID` 该版本号的目的在于验证序列化的对象和对应类是否版本匹配。

```Java
public class Employee implements java.io.Serializable {
     // 加入序列版本号
     private static final long serialVersionUID = 1L;
     public String name;
     public String address;
     // 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值.
     public int eid;

     public void addressCheck() {
         System.out.println("Address  check : " + name + " -- " + address);
     }
}
```

## 6.4. 练习：序列化集合

1. 将存有多个自定义对象的集合序列化操作，保存到`list.txt`文件中。
2. 反序列化`list.txt` ，并遍历集合，打印对象信息。

### 6.4.1. 案例分析

1. 把若干学生对象 ，保存到集合中。
2. 把集合序列化。
3. 反序列化读取时，只需要读取一次，转换为集合类型。
4. 遍历集合，可以打印所有的学生信息

### 6.4.2. 案例实现

```Java
package myobjectstream.practice;

import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SerTest {
	@SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
		// 创建 学生对象
		Student student = new Student("老王", "laow");
		Student student2 = new Student("老张", "laoz");
		Student student3 = new Student("老李", "laol");

		ArrayList<Student> arrayList = new ArrayList<>();
		arrayList.add(student);
		arrayList.add(student2);
		arrayList.add(student3);
		// 序列化操作
		// serializ(arrayList);

		// 反序列化
		ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("src/myobjectstream/practice/list.txt"));
		// 读取对象,强转为ArrayList类型
		ArrayList<Student> list  = (ArrayList<Student>)ois.readObject();

      	for (int i = 0; i < list.size(); i++ ){
          	Student s = list.get(i);
        	System.out.println(s.getName()+"--"+ s.getNickname());
      	}
	}

	@SuppressWarnings("unused")
    private static void serializ(ArrayList<Student> arrayList) throws Exception {
		// 创建 序列化流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/myobjectstream/practice/list.txt"));
		// 写出对象
		oos.writeObject(arrayList);
		// 释放资源
		oos.close();
	}
}
```

这里能体现上面6.3.3部分的报错的可能，是先进行序列化，然后修改Student类中的内容，然后再进行反序列化，就会出现6.3.3的报错内容。

原因:

- 这个错误 **java.io.InvalidClassException** 发生在尝试反序列化一个对象时，对象在序列化后类定义已经被修改（比如添加、删除字段，或者类实现的修改等）。
- 每个可序列化的类都有一个称为 **serialVersionUID** 的版本号，它用于验证序列化的对象和对应类的版本是否匹配。
- 如果你没有显式地定义 **serialVersionUID**，JVM 会根据类的详情（包括类名、接口名、方法和属性等）自动生成一个。当你修改类定义后，重新编译，这个自动生成的 **serialVersionUID** 也可能会改变，导致无法成功反序列化之前序列化的对象。

解决方法:

```Java
package myobjectstream.practice;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // 显式定义 serialVersionUID
    private String name;
    private String nickname;

    public Student(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    // getters and setters
}
```

在 **Student** 类中显式地定义一个 **serialVersionUID** 字段。这样，无论类如何更改，这个字段都保持不变，除非你需要不兼容的更改，那时你可以手动更新这个版本号。

## 6.5. 序列化与反序列化流的细节汇总

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709367123929-69124f8a-9a8b-4b14-abf8-b497b3dc0a2e.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709367123929-69124f8a-9a8b-4b14-abf8-b497b3dc0a2e.png)

# 7. 打印流

## 7.1. 概述

平时我们在控制台打印输出，是调用print方法和println方法完成的，这两个方法都来自java.io.PrintStream类，该类能够方便地打印各种数据类型的值，是一种便捷的输出方式。

PrintStream类是字节打印流，PrintWriter是字符打印流。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709418821532-2c268ec3-72e0-4828-8af7-cda6e939b839.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709418821532-2c268ec3-72e0-4828-8af7-cda6e939b839.png)

## 7.2. PrintStream类

### 7.2.1. 构造方法

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709418910315-581626b7-93e1-41f6-938d-736812ff5698.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709418910315-581626b7-93e1-41f6-938d-736812ff5698.png)

### 7.2.2. 字节打印流方法使用

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709419051418-0c6ba2d4-74fa-4431-a362-8f427b8ca5d6.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709419051418-0c6ba2d4-74fa-4431-a362-8f427b8ca5d6.png)

### 7.2.3. 改变打印流向

`System.out`就是`PrintStream`类型的，只不过它的流向是系统规定的，打印在控制台上。不过，既然是流对象，我们就可以玩一个"小把戏"，改变它的流向。

```Java
public class PrintDemo {
    public static void main(String[] args) throws IOException {
		// 调用系统的打印流,控制台直接输出97
        System.out.println(97);

		// 创建打印流,指定文件的名称
        PrintStream ps = new PrintStream("ps.txt");

      	// 设置系统的打印流流向,输出到ps.txt
        System.setOut(ps);

      	// 调用系统的打印流,ps.txt中输出97
        System.out.println(97);
    }
}
```

### 7.2.4. 示例

```Java
public class PrintStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    /*
        字节打印流：
            构造方法
                public PrintStream(OutputStream/File/String)            关联字节输出流/文件/文件路径
                public PrintStream(String fileName, Charset charset)    指定字符编码
                public PrintStream(OutputStreamout, boolean autoFlush)  自动刷新
                public PrintStream(OutputStream out, boolean autoFlush, String encoding)    指定字符编码且自动刷新
            成员方法：
                public void write(int b)            常规方法：规则跟之前一样，将指定的字节写出
                public void println(Xxx xx)         特有方法：打印任意数据，自动刷新，自动换行
                public void print(Xxx xx)           特有方法：打印任意数据，不换行
                public void printf(String format, Object... args)   特有方法：带有占位符的打印语句，不换行
    */

        //1.创建字节打印流的对象
        PrintStream ps = new PrintStream(new FileOutputStream("src/myprintstream08/a.txt"), true, Charset.forName("UTF-8"));
        //2.写出数据
        ps.println(97);//写出 + 自动刷新 + 自动换行
        ps.print(true);
        ps.println();
        ps.printf("%s爱上了%s","阿珍","阿强");
        //3.释放资源
        ps.close();
    }
}
```

## 7.3. PrintWriter类

### 7.3.1. 构造方法

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709420510012-5db2220b-4c9d-4322-9e92-7326f310ed3f.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709420510012-5db2220b-4c9d-4322-9e92-7326f310ed3f.png)

### 7.3.2. 方法使用

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709420565236-f22875af-07eb-44b9-96ef-41815dc7e30e.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709420565236-f22875af-07eb-44b9-96ef-41815dc7e30e.png)

## 7.4. 总结打印流

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709420478876-37d8e13f-59a1-4d88-8a4a-6a798ad4195b.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1709420478876-37d8e13f-59a1-4d88-8a4a-6a798ad4195b.png)

# 8. 压缩流和解压缩流

压缩流：负责压缩文件或者文件夹

解压缩流：负责把压缩包中的文件和文件夹解压出来

```Java
/*
*   解压缩流
*
* */
public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {

        //1.创建一个File表示要解压的压缩包
        File src = new File("D:\\aaa.zip");
        //2.创建一个File表示解压的目的地
        File dest = new File("D:\\");

        //调用方法
        unzip(src,dest);

    }

    //定义一个方法用来解压
    public static void unzip(File src,File dest) throws IOException {
        //解压的本质：把压缩包里面的每一个文件或者文件夹读取出来，按照层级拷贝到目的地当中
        //创建一个解压缩流用来读取压缩包中的数据
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        //要先获取到压缩包里面的每一个zipentry对象
        //表示当前在压缩包中获取到的文件或者文件夹
        ZipEntry entry;
        while((entry = zip.getNextEntry()) != null){
            System.out.println(entry);
            if(entry.isDirectory()){
                //文件夹：需要在目的地dest处创建一个同样的文件夹
                File file = new File(dest,entry.toString());
                file.mkdirs();
            }else{
                //文件：需要读取到压缩包中的文件，并把他存放到目的地dest文件夹中（按照层级目录进行存放）
                FileOutputStream fos = new FileOutputStream(new File(dest,entry.toString()));
                int b;
                while((b = zip.read()) != -1){
                    //写到目的地
                    fos.write(b);
                }
                fos.close();
                //表示在压缩包中的一个文件处理完毕了。
                zip.closeEntry();
            }
        }
        zip.close();
    }
}
```

# 9. 工具包（Commons-io）

介绍：Commons是apache开源基金组织提供的工具包，里面有很多帮助我们提高开发效率的API。

Commons-io是apache开源基金组织提供的一组有关IO操作的开源工具包。

作用：提高IO流的开发效率。

使用方式：

1. 新建lib文件夹
2. 把第三方jar包粘贴到文件夹中
3. 右键点击add as a library

```Java
public class CommonsIODemo1 {
    public static void main(String[] args) throws IOException {
        /*
          FileUtils类
                static void copyFile(File srcFile, File destFile)                   复制文件
                static void copyDirectory(File srcDir, File destDir)                复制文件夹
                static void copyDirectoryToDirectory(File srcDir, File destDir)     复制文件夹
                static void deleteDirectory(File directory)                         删除文件夹
                static void cleanDirectory(File directory)                          清空文件夹
                static String readFileToString(File file, Charset encoding)         读取文件中的数据变成成字符串
                static void write(File file, CharSequence data, String encoding)    写出数据

            IOUtils类
                public static int copy(InputStream input, OutputStream output)      复制文件
                public static int copyLarge(Reader input, Writer output)            复制大文件
                public static String readLines(Reader input)                        读取数据
                public static void write(String data, OutputStream output)          写出数据
         */


        File src = new File("myio\\a.txt");
        File dest = new File("myio\\copy.txt");
        FileUtils.copyFile(src,dest);*/


        File src = new File("D:\\aaa");
        File dest = new File("D:\\bbb");
        FileUtils.copyDirectoryToDirectory(src,dest);

        /*File src = new File("D:\\bbb");
        FileUtils.cleanDirectory(src);
    }
}
```

# 10. 工具包（hutool）

```Java
public class Test1 {
    public static void main(String[] args) {
    /*
        FileUtil类:
                file：根据参数创建一个file对象
                touch：根据参数创建文件

                writeLines：把集合中的数据写出到文件中，覆盖模式。
                appendLines：把集合中的数据写出到文件中，续写模式。
                readLines：指定字符编码，把文件中的数据，读到集合中。
                readUtf8Lines：按照UTF-8的形式，把文件中的数据，读到集合中

                copy：拷贝文件或者文件夹
    */


       /* File file1 = FileUtil.file("D:\\", "aaa", "bbb", "a.txt");
        System.out.println(file1);//D:\aaa\bbb\a.txt

        File touch = FileUtil.touch(file1);
        System.out.println(touch);


        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");

        File file2 = FileUtil.writeLines(list, "D:\\a.txt", "UTF-8");
        System.out.println(file2);*/

      /*  ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        File file3 = FileUtil.appendLines(list, "D:\\a.txt", "UTF-8");
        System.out.println(file3);*/
        List<String> list = FileUtil.readLines("D:\\a.txt", "UTF-8");
        System.out.println(list);
    }
}
```