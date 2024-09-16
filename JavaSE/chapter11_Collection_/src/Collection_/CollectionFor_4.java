package Collection_;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ryanw
 * */
@SuppressWarnings({"all"})
public class CollectionFor_4 {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book1("三国演义", "罗贯中", 10.1));
        col.add(new Book1("小李飞刀", "古龙", 5.1));
        col.add(new Book1("红楼梦", "曹雪芹", 34.6));

        for (Object book : col) {
            System.out.println("book = " + book);
        }

        // 增强for，也可以直接在数组使用
        int[] nums = { 1, 8, 10, 90 };
        for (int i : nums) {
            System.out.println("i=" + i);
        }

    }
}

class Book1 {
    public String name;
    public String author;
    public double prize;

    public Book1(String name, String author, double prize) {
        this.name = name;
        this.author = author;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }
    
    // generate toString method
    @Override
    public String toString() {
        return "Book1{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", prize=" + prize +
                '}';
    }
}
