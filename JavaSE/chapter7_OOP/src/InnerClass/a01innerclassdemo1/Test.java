package InnerClass.a01innerclassdemo1;

/**
 * @author yangrunze
 */
public class Test {
    public static void main(String[] args) {
        /*
            ����дһ��Javabean������������
            ���ԣ�������Ʒ�ƣ����䣬��ɫ����������Ʒ�ƣ�ʹ�����ޡ�

            �ڲ���ķ����ص�:
                �ڲ������ֱ�ӷ����ⲿ��ĳ�Ա������˽��
                �ⲿ��Ҫ�����ڲ���ĳ�Ա�����봴������
        */

        Car c = new Car();
        c.carName = "����";
        c.carAge = 1;
        c.carColor = "��ɫ";

        c.show();
    }
}
