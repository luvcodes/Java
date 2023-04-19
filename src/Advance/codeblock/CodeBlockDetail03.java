package Advance.codeblock;

public class CodeBlockDetail03 {
    public static void main(String[] args) {
        BBB bbb = new BBB();
    }
}

class AAA {
    {
        System.out.println("AAA regular code block");
    }

    public AAA() {
        // super(); // (1)
        // (2)调用本类的普通代码块
        System.out.println("AAA() constructor has been called.");
    }
}

class BBB extends AAA {
    {
        System.out.println("BBB regular codeblock");
    }

    public BBB() {
        // super(); // (1)
        // (2)调用本类的普通代码块
        System.out.println("BBB() constructor has been called.");
    }
}
