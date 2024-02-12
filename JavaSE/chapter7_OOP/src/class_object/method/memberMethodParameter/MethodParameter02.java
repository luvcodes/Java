package class_object.method.memberMethodParameter;

 /**
  * @author ryanw
  */
 public class MethodParameter02 {
     public static void main(String[] args) {
         B b = new B();
         int[] arr = {1,2,3};
         b.test100(arr);

         System.out.println("main的arr数组");
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + "\t");
         }
         System.out.println();

         // 测试
         Person p = new Person();
         p.name = "jack";
         p.age = 10;

 //        b.test200(p);
         // 测试题，如果test200执行的是p = null，下面的结果是10
         // 测试题，如果test200执行的是p = new Person(); 下面输出的结果是
 //        System.out.println("main的p.age = " + p.age);

     }
 }

 class Person {
     String name;
     int age;
 }

 class B {
     public void test200(Person p) {
         // 修改对象属性
         p.age = 10000;
 //        p = null;
 //        p = new Person();
 //        p.name = "tom";
 //        p.age = 99;
     }


     public void test100 (int[] arr) {
         arr[0] = 200;
         System.out.println("test100的arr数组");
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + "\t");
         }
         System.out.println();
     }
 }
