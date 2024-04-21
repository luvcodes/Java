```Java
public class Homework01 {
    public static void main(String[] args) {
        try {
            ReturnExceptionDemo.methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ReturnExceptionDemo.methodB();
    }
}

class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("Enter method A");
            throw new RuntimeException("Create exception");
        } finally {
            System.out.println("Use the finally from A method");
        }
    }

    static void methodB() {
        try {
            System.out.println("Enter method B");
            return;
        } finally {
            System.out.println("Use the finally from B method");
        }
    }
}
```

```Plain
Enter method A
Use the finally from A method
Create exception
Enter method B
Use the finally from B method
```

### **可不可以理解成，finally的执行优先级，高于return语句呢？**

是的。在Java中，当执行流程进入`try`块并且后续有一个`finally`块时，不论`try`或`catch`块中是否有`return`语句或抛出异常，`finally`块的内容都会在`return`语句或异常传递到上一级之前执行。

这种特性确保了`finally`块是一个放置清理资源或执行必要结尾操作的可靠位置，例如关闭文件、释放资源等，无论方法如何结束（正常结束、返回或异常）。

所以，是的，你可以认为在**涉及**`**try-catch-finally**`**结构时，**`**finally**`**的执行优先级高于**`**return**`**语句**。但要注意，这并不意味着`finally`会改变`return`的返回值或阻止异常的传递，它只是确保在这些操作发生之前执行。

### 那如果我不使用void作为methodB的返回值，使用int或者double，那我按照对应的类型进行返回，return语句也是在finally之后执行吗？会输出返回值吗？

当你**更改**`**methodB**`**的返回类型**并使用`return`语句返回一个对应的值，`**finally**`**块仍然会在**`**return**`**语句之前执行**。这种行为**不受方法返回类型**或**是否有**`**static**`**修饰符的影响**。

但是，**有一个有趣的点需要注意**：如果`finally`块中也有一个`return`语句，那么这个`return`语句会覆盖`try`或`catch`块中的`return`语句，导致`try`或`catch`块中的返回值被忽略。

```Java
public int methodB() {
    try {
        System.out.println("Enter method B");
        return 1;
    } finally {
        System.out.println("Use the finally from B method");
        // return 2;  // 如果你取消这行的注释，methodB会返回2而不是1
    }
}
```

在上面的代码中：

1. "Enter method B" 会被输出。
2. 尽管在`try`块中有一个`return 1;`语句，但在返回值1被返回给调用者之前，`finally`块会被执行。
3. "Use the finally from B method" 会被输出。
4. 如果`finally`块中的`return 2;`语句被取消注释，那么`methodB`会返回2而不是1。

总之，即使方法返回`int`、`double`或其他任何类型，`finally`块仍然在任何`return`语句之前执行。但请**尽量避免在**`**finally**`**块中使用**`**return**`**语句**，因为这会使代码更难理解并可能导致意外的结果。

上面的示例代码中的`return 1`不会输出任何内容，但是如果我在其他地方调用这个`methodB()`方法，这个1就会被输出。比如`System.out.println(methodB());`

### 但是看下面的例子就可以发现，return语句还是在等待执行的

```Java
public class Demo {
    public static String sRet = "";
    public static void func(int i)
    {
        try
        {
            if (i%2==0)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            sRet += "0";
            return;
        }
        finally
        {
            sRet += "1";
        }
        sRet += "2";
    }
    public static void main(String[] args)
    {
        func(1);
        func(2);
        System.out.println(sRet);
    }
}
```

第一步，func(1)，if条件不成立，不抛出异常，catch不运行，final运行，拼串得到“1”，程序继续往下走，拼串得到“12”。 第二步，fun(2)，if条件成立，抛出异常，catch捕获异常，运行catch里面代码，拼串得到“120”，虽然有return，但是不管出不出异常，final里代码必须执行，执行final，拼串得到“1201”，然后return结束。所以最终结果“1201”。