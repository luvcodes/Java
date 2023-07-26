package PhaseOne.Intermediate.LinkedList_6;

public class LinkedList01 {
    public static void main(String[] args) {
        /**
         * 模拟一个简单的双向链表
         */
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("hsp");

        // 连接三个结点，形成双向链表
        jack.next = tom;
        tom.next = hsp;
        hsp.pre = tom;
        tom.pre = jack;

        Node first = jack; // 让first引用指向jack，就是双向列表的头节点
        Node last = hsp; // 让last引用指向hsp，就是双向列表的尾节点

        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
    }
}

// 定义一个Node类，Node 对象 表示双向链表的一个节点
class Node {
    public Object item;
    public Node next;
    public Node pre;
    public Node(Object name) {
        this.item = name;
    }
    // generate toString method
    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
