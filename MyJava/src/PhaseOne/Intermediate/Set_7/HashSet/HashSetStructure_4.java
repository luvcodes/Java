package PhaseOne.Intermediate.Set_7.HashSet;

public class HashSetStructure_4 {
    public static void main(String[] args) {
        // 模拟一个HashSet的底层 (HashMap的底层结构)

        //1. 创建一个数组，数组的类型是 Node[]
        //2. 有些人，直接把 Node[] 数组称为 表
        Node[] table = new Node[16];

        //3. 创建结点
        Node john = new Node("john", null);
        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack; // 将jack 结点挂载到john后面

        Node rose = new Node("Rose", null);
        jack.next = rose;// 将rose 结点挂载到jack后面

        Node lucy = new Node("lucy", null);
        table[3] = lucy; // 把lucy 放到 table表的索引为3的位置.
        System.out.println("table=" + table);

        /**
         * <p>
         * 上面的john -> jack -> rose形成了一条链表，在索引为2的位置，相当于是一个HashSet(HashMap)数组的index = 1的位置。
         * Lucy是放到了table表(HashSet数组)索引为3的位置，也就是第4个位置
         * </p>
         * 不直接把所有的数据放在同一个数组当中去，是因为效率太低，使用HashSet(HashMap)的操作效率会高很多
         * */
    }
}

class Node {
    // 节点，存储数据，可以指向下一个节点，从而形成链表
    Object item; // 存放数据
    Node next; // 指向下一个节点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}
