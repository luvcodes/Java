package com.itheima.mydynamicproxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ������ã�����һ������
 * @author ryanw
 */ /*
*
* */
public class ProxyUtil {
    /*
    * ���������ã���һ�����ǵĶ��󣬴���һ������
    *
    *  �βΣ�����������Ƕ���
    *
    *  ����ֵ�������Ǵ����Ĵ���
    *
    * ����
    *   ���������Ҫ�����ǳ�һ�׸�
    *   1. ��ȡ����Ķ���
    *      ������� = ProxyUtil.createProxy(�����ǵĶ���);
    *   2. �ٵ��ô���ĳ��跽��
    *      �������.����ķ���("ֻ����̫��");
    * */
    public static Star createProxy(BigStar bigStar){
       /*
        java.lang.reflect.Proxy�ࣺ�ṩ��Ϊ��������������ķ�����

        public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        ����һ������ָ�����ĸ����������ȥ�������ɵĴ�����
        ��������ָ���ӿڣ���Щ�ӿ�����ָ�����ɵĴ���ʲô��Ҳ��������Щ����
        ������������ָ�����ɵĴ������Ҫ��ʲô����

        */

        Star star = (Star) Proxy.newProxyInstance(
                //����һ������ָ�����ĸ��������ȥ�������ɵĴ�����
                ProxyUtil.class.getClassLoader(),
                //��������ָ���ӿڣ���Щ�ӿ�����ָ�����ɵĴ���ʲô��Ҳ��������Щ����
                new Class[]{Star.class},
                //������������ָ�����ɵĴ������Ҫ��ʲô����
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                        * ����һ������Ķ���
                        * ��������Ҫ���еķ��� sing
                        * ������������sing����ʱ�����ݵ�ʵ��
                        * */
                        if("sing".equals(method.getName())){
                            System.out.println("׼����Ͳ����Ǯ");
                        }else if("dance".equals(method.getName())){
                            System.out.println("׼�����أ���Ǯ");
                        }
                        //ȥ�Ҵ����ǿ�ʼ�����������
                        //����ı�����ʽ�����ô��������泪���������ķ���
                        return method.invoke(bigStar, args);
                    }
                }
        );


        return star;
    }
}
