package inheritance.improve_;

/**
 * @author yangrunze
 */
public class Graduate extends Student{
    // 和Pupil不一样
    public void testing() {
        System.out.println("大学生: " + name + " 正在考大学数学");
    }
}
