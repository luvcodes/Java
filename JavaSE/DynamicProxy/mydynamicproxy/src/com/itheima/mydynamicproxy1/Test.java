package com.itheima.mydynamicproxy1;

/**
 * @author ryanw
 */
public class Test {
    public static void main(String[] args) {
    /*
        ����
            ���������Ҫ�����ǳ�һ�׸�
             1. ��ȡ����Ķ���
                ������� = ProxyUtil.createProxy(�����ǵĶ���);
             2. �ٵ��ô���ĳ��跽��
                �������.����ķ���("ֻ����̫��");
     */

        //1. ��ȡ����Ķ���
        BigStar bigStar = new BigStar("����");
        Star proxy = ProxyUtil.createProxy(bigStar);

        //2. ���ó���ķ���
        String result = proxy.sing("ֻ����̫��");
        System.out.println(result);
    }
}
