# File类

## 概述

java.io.File 类是文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。

## 构造方法

- `public File(String pathname)` ：通过将给定的**路径名字符串**转换为抽象路径名来创建新的 File实例。
- `public File(String parent, String child)` ：从**父路径名字符串和子路径名字符串**创建新的 File实例。
- `public File(File parent, String child)` ：从**父抽象路径名和子路径名字符串**创建新的 File实例。
- 构造举例，代码如下：

```Java
// 1. 根据字符串表示的路径，变成File对象
String str = "C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile\\a.txt";
File file = new File(str);
System.out.println(file);

// 2. 根据父路径名字符串和子路径名字符串创建文件对象
String parent = "C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile";
String child = "a.txt";
File file2 = new File(parent, child);
System.out.println(file2);

// 3. 把一个File表示的路径和String表示路径进行拼接
File parent2 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile");
String child2 ="a.txt";
File file3 = new File(parent2, child2);
System.out.println(file3);
```

## 常用方法

### 绝对路径和相对路径

- **绝对路径**：从盘符开始的路径，这是一个完整的路径。
- **相对路径**：相对于项目目录的路径，这是一个便捷的路径，开发中经常使用。

### 获取功能的方法

- `public String getAbsolutePath()` ：返回此File的绝对路径名字符串。
- `public String getPath()` ：将此File转换为路径名字符串。
- `public String getName()` ：返回由此File表示的文件或目录的名称。
- `public long length()` ：返回由此File表示的文件的长度。

方法演示，代码如下：

```Java
        File f = new File("d:/aaa/bbb.java");
        System.out.println("文件绝对路径:"+f.getAbsolutePath());
        System.out.println("文件构造路径:"+f.getPath());
        System.out.println("文件名称:"+f.getName());
        System.out.println("文件长度:"+f.length()+"字节");

        File f2 = new File("d:/aaa");
        System.out.println("目录绝对路径:"+f2.getAbsolutePath());
        System.out.println("目录构造路径:"+f2.getPath());
        System.out.println("目录名称:"+f2.getName());
        System.out.println("目录长度:"+f2.length());
```

### 判断功能的方法

- `public boolean exists()` ：此File表示的文件或目录是否实际存在。
- `public boolean isDirectory()` ：此File表示的是否为目录。
- `public boolean isFile()` ：此File表示的是否为文件。

```Java
        File f = new File("d:\\aaa\\bbb.java");
        File f2 = new File("d:\\aaa");
      	// 判断是否存在
        System.out.println("d:\\aaa\\bbb.java 是否存在:"+f.exists());
        System.out.println("d:\\aaa 是否存在:"+f2.exists());
      	// 判断是文件还是目录
        System.out.println("d:\\aaa 文件?:"+f2.isFile());
        System.out.println("d:\\aaa 目录?:"+f2.isDirectory());
```

### 创建删除功能的方法

- `public boolean createNewFile()` ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
- `public boolean delete()` ：删除由此File表示的文件或目录。
- `public boolean mkdir()` ：创建由此File表示的目录。
- `public boolean mkdirs()` ：创建由此File表示的目录，包括任何必需但不存在的父目录。

```Java
        // 文件的创建
        File f = new File("aaa.txt");
        System.out.println("是否存在:"+f.exists()); // false
        System.out.println("是否创建:"+f.createNewFile()); // true
        System.out.println("是否存在:"+f.exists()); // true

     	// 目录的创建
      	File f2= new File("newDir");
        System.out.println("是否存在:"+f2.exists());// false
        System.out.println("是否创建:"+f2.mkdir());	// true
        System.out.println("是否存在:"+f2.exists());// true

		// 创建多级目录
      	File f3= new File("newDira\\newDirb");
        System.out.println(f3.mkdir());// false
        File f4= new File("newDira\\newDirb");
        System.out.println(f4.mkdirs());// true

      	// 文件的删除
       	System.out.println(f.delete());// true

      	// 目录的删除
        System.out.println(f2.delete());// true
        System.out.println(f4.delete());// false
```

API中说明：delete方法，如果此File表示目录，则目录必须为空才能删除。

## 目录的遍历

- `public String[] list()` ：返回一个String数组，表示该File目录中的所有子文件或目录。
- `public File[] listFiles()` ：返回一个File数组，表示该File目录中的所有的子文件或目录。

```Java
public class FileFor {
    public static void main(String[] args) {
        File dir = new File("d:\\java_code");

      	//获取当前目录下的文件以及文件夹的名称。
		String[] names = dir.list();
		for(String name : names){
			System.out.println(name);
		}
        //获取当前目录下的文件以及文件夹对象，只要拿到了文件对象，那么就可以获取更多信息
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
```

小贴士：

调用listFiles方法的File对象，表示的必须是实际存在的目录，否则返回null，无法进行遍历。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1708919877902-f04f9727-5ac7-4630-ad01-01b577f0c332.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1708919877902-f04f9727-5ac7-4630-ad01-01b577f0c332.png)

# IO流

  

[[IO流]]