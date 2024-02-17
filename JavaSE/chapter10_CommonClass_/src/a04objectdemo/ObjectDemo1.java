package a04objectdemo;

/**
 * @author ryanw
 */
public class ObjectDemo1 {
    public static void main(String[] args) {
        /*
            public string tostring() 返回对象的字符串表示形式
            public boolean equals(Object obj) 比较两个对象是否相等
            protected object clone(int a) 对象克隆
        */

        //1.tostring 返回对象的字符串表示形式
        Object obj = new Object();
        String str1 = obj.toString();
        //java.lang.Object@119d7047
        System.out.println(str1);

        Student stu = new Student();
        String str2 = stu.toString();
        //a04objectdemo.student@4eec7777
        System.out.println(str2);

        // 细节:
        // a04objectdemo.student@4eec7777
        System.out.println(stu);


        //细节:
        //System:类名
        //out:静态变量
        //system.out:获取打印的对象
        //println():方法
        //参数:表示打印的内容
        //核心逻辑:
        //当我们打印一个对象的时候，底层会调用对象的tostring方法，把对象变成字符串。
        //然后再打印在控制台上，打印完毕换行处理。

        /**
         * 思考:默认情况下，因为Object类中的tostring方法返回的是地址值
         * 所以，默认情况下，打印一个对象打印的就是地址值
         * 但是地址值对于我们是没什么意义的?
         * 我想要看到对象内部的属性值?我们该怎么办? 处理方案：重写父类Object类中的toString方法
         */
        // a04objectdemo.Student@4eec7777
        System.out.println(stu);


        //tostring方法的结论:
        //如果我们打印一个对象，想要看到属性值的话，那么就重写tostring方法就可以了。
        //在重写的方法中，把对象的属性值进行拼接。
    }
}
