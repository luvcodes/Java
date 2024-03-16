package interface_.a08interfacedemo8;

import interface_.aaa.Inter;

/**
 * @author yangrunze
 */
public class Test implements InterA {
    public static void main(String[] args) {
      /*
       * 接口中私有方法的定义格式：
       *
       * 格式1：private 返回值类型 方法名(参数列表) { }
       * 范例1：private void show() { }
       *
       * 格式2：private static 返回值类型 方法名(参数列表) { }
       * 范例2：private static void method() { }
       */
      InterA.show1();
      InterA.show2();

      // 想要调用show3和sho5方法
      Test test = new Test();
      test.show5();
    }
}
