package Stream.a01mystream;

import java.util.stream.Stream;

/**
 * @author ryanw
 */
public class StreamDemo5 {
    public static void main(String[] args) {
        //一堆零散数据   public static<T> Stream<T> of(T... values)           Stream接口中的静态方法
        Stream.of(1,2,3,4,5).forEach(s-> System.out.println(s));
        Stream.of("a","b","c","d","e").forEach(s-> System.out.println(s));

    }
}
