package PhaseOne.Advance.codeblock.practices;

public class CodeBlockExercise02 {
    public static void main(String[] args) {
        Test a = new Test();
    }
}

class Sample {
    Sample(String s) {
        System.out.println(s);
    }
    Sample() {
        System.out.println("Sample default constructor has been called");
    }
}

class Test {
    Sample sam1 = new Sample("sam1 member initialized");
    static Sample sam = new Sample("static member sam initialized");
    static {
        System.out.println("Static code block executed");
        if (sam == null) {
            System.out.println("sam is null");
        }
    }
    // constructor
    Test() {
        System.out.println("Test default constructor has been called");
    }
}