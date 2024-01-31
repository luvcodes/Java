package com.itheima.web.servletBasics;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author ryanw
 */ // 定义访问路径
@WebServlet(urlPatterns = "/demo3", loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    /**
     * 初始化方法
     * 1. 调用时机: 默认情况下，Servlet被第一次访问时，调用
     *  loadOnStartup: 这个是为了可以让我们控制servlet对象创建的时机。如果设置为正整数，
     *  那么就会在服务器启动的时候创建servlet对象并且调用init方法。
     *  因为一般情况下，servlet对象只有在浏览器中使用访问servlet对象的时候才会输出init，但是现在没有在浏览器中访问
     *  依然可以输出init，说明就是创建对象的时候，就已经输出init了。
     * 2. 调用次数: 一次。也就是说servlet对象只会创建一次
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 提供服务
     * 1. 调用时机: 每一次servlet被访问时，调用
     * 2. 调用次数: 多次
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet hello world");
    }

    /**
     * 销毁方法
     * 1. 调用时机: 内存释放或者服务器关闭的时候，servlet对象会被销毁，就会调用此方法
     * 2. 调用次数: 1次
     * */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
