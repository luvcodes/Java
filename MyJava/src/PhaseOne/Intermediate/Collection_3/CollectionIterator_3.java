package PhaseOne.Intermediate.Collection_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings({ "all" })
public class CollectionIterator_3 {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book2("test1", "a", 10.1));
        col.add(new Book2("test2", "b", 10.2));
        col.add(new Book2("test3", "c", 10.3));

        /**
         * 现在希望能够遍历 col集合
         * 1. 先得到col对应的迭代器
         */
        Iterator iterator = col.iterator();
        // 2. 使用while循环遍历
        // hasNext判断下面还有没有数据、元素
        while (iterator.hasNext()) {
            // next 返回下一个元素，类型是Object
            Object obj = iterator.next();
            System.out.println("obj = " + obj);
        }

        /**
         * 3. 当退出while循环后，这时iterator迭代器，指向最后的元素
         */
        // iterator.next(); // NoSuchElementException

        // 如果希望再次遍历，需要重置我们的迭代器
        iterator = col.iterator();
        System.out.println("Second round iteration");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("obj = " + next);
        }
    }
}

class Book2 {
    private String name;
    private String author;
    private double price;

    public Book2(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // generate toString method for this class
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

}