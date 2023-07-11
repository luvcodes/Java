package CommonClasses_2.arrays_3;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦是一本好书~", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("java", 300);

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceDiff = book2.getPrice() - book1.getPrice();
                // 从小到大排序
                if (priceDiff < 0) {
                    return 1;
                } else if (priceDiff > 0) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceDiff = book2.getPrice() - book1.getPrice();
                // 从大到小排序
                if (priceDiff > 0) {
                    return 1;
                } else if (priceDiff < 0) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceDiff = book2.getPrice() - book1.getPrice();
                // 按照书名的长度来进行排序
                return book2.getName().length() - book1.getName().length();

            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
