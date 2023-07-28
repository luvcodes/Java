package PhaseOne.Intermediate.Map_8;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        /**
         * 1. 当我们使用无参构造器，创建TreeSet时，仍然是无序的
         * 2. 希望添加的元素，按照字符串大小来排序
         * 3. 使用TreeSet提供的一个构造器，可以传入一个比较器(匿名内部类), 并指定排序规则。
         * */
        TreeSet<Object> treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 下面这句话其实就是调用String的compareTo方法进行字符串大小比较
                // o1写在前面，o2写在后面就是从小到大
                // 反之，就是从大到小
                // 是根据首字母的字母表顺序来排序的
                return ((String)o1).compareTo((String)o2);
            }
        });
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("a");
        treeSet.add("sp");
        System.out.println("treeset = " + treeSet);

        /**
         *     public TreeSet(Comparator<? super E> comparator) {
         *         this(new TreeMap<>(comparator));
         *     }
         *
         * */
    }
}
