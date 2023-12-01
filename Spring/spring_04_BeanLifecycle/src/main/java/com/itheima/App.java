package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        /**
         * 关闭容器的方式
         * */

        /**
         * 这里涉及到了很多个步骤
         * 1. 想要使用BookDaoImpl中的init和destroy方法，所以需要在配置文件中的bean加上init-method="init" destroy-method="destroy"
         * 2. 发现destroy方法的内容不能输出，因为虚拟机是会在bean销毁之前就关闭了虚拟机，程序执行完成，虚拟机关闭，所以出现destroy无法输出的情况。
         * </p>
         * <p>这样就引出两个解决方法，一个是下面的第一段</p>
         * <p>
         *   3. 所以要在这里将ApplicationContext替换成ClassPathXmlApplicationContext，因为ApplicationContext没有close方法。
         *      所以必须要用close才能看到destroy方法中的内容。
         * </p>
         *   4. 第二种方式: 注册关闭钩子
         * </p>
         * 但是又发现，在配置文件中写init-method="init" destroy-method="destroy"太麻烦了，因为每一个bean可能都需要写这些。
         * 这就引出用spring定义的接口的方式来实现。
         * 因此就在BookServiceImpl中重写了destroy和afterPropertiesSet方法。尽管在App文件中没有使用BookService，但是在配置文件中
         * BookService也加载了，所以该运行的还是会运行。
         * 这里还要注意一点就是afterPropertiesSet方法，我们在setBookDao方法中加了一行输出，set...是在service init前面输出的。
         * */
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();
//        ctx.close();


        // 第二种方式来关闭容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 注册关闭钩子，就意味着告诉JVM等到bean销毁之后再关闭虚拟机。
        // 关闭钩子放在后面也可以
        ctx.registerShutdownHook();
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
    }
}
