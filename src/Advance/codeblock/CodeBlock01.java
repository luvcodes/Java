package Advance.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie movie = new Movie("Avatar");
        System.out.println();
        Movie movie2 = new Movie("Interstellar", 200, "Nolan");

    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    // 三个构造器 重载
    /**
     * 下面的三个构造器都有相同的语句
     * 这样代码看起来比较冗余
     * 这是我们可以吧相同的语句，放入到一个代码块中,即可
     * 这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容
     * 代码块调用的顺序优先于构造器
     * */
    {
        System.out.println("Movie screen opens...");
        System.out.println("Ads initiates...");
        System.out.println("Movie starts...");
    }
    public Movie(String name) {
        System.out.println("Movie(String name) is called");
        this.name = name;
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        System.out.println("Movie(String name, double price, String director)");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}