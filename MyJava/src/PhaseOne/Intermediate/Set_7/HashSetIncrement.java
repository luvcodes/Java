package PhaseOne.Intermediate.Set_7;

import java.util.HashSet;

public class HashSetIncrement {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        for (int i = 1; i <= 12; i++) {
            hashSet.add(new A(i));
        }
        System.out.println("hashSet = " + hashSet);
    }
}

class A {
    private int n;
    public A(int n) {
        this.n = n;
    }
    /**
     * 这样重写hashCode方法是因为，在新的数据想要加入到hashSet(HashMap)中的时候，源码中经历了一步转变为hashCode的方法来确定input数据目标
     * 加入的位置，那通过重写HashCode方法，就可以指定让新的数据都定义为hashCode值是100，也就可以将所有的新数据都加在同一条链表上了。讲这里的时候
     * 是为了体现红黑树的生成，也就是为了满足同一条链表上有八个节点的情况。
     * */
    @Override
    public int hashCode() {
        return 100;
    }
}
