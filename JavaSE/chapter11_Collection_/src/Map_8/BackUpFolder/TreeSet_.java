package Map_8.BackUpFolder;

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
//                return ((String)o1).compareTo((String)o2);
                // 长度大小比较
                return ((String)o1).compareTo((String)o2);
            }
        });
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("a");
        treeSet.add("sp");
        treeSet.add("abc"); // 加不进去 因为tom也是3个长度大小，和tom一样的
        System.out.println("treeset = " + treeSet);

        /**
         *     1. 构造器把传入的比较器对象，赋给了 TreeSet底层的TreeMap属性
         *     public TreeSet(Comparator<? super E> comparator) {
         *         this(new TreeMap<>(comparator));
         *     }
         *     2. 在调用treeSet.add("tom")，在底层会执行到
         *     if (cpr != null) { // cpr就是我们的匿名内部类(对象)
         *             do {
         *                 parent = t;
         *                 // 动态绑定到我们的匿名内部类(对象)compare方法
         *                 cmp = cpr.compare(key, t.key);
         *                 if (cmp < 0)
         *                     t = t.left;
         *                 else if (cmp > 0)
         *                     t = t.right;
         *                 else { // else的意思就是相等，即返回0，这个key就没有加入
         *                     V oldValue = t.value;
         *                     if (replaceOld || oldValue == null) {
         *                         t.value = value;
         *                     }
         *                     return oldValue;
         *                 }
         *             } while (t != null);
         * */
    }
}
