package String_2;

/**
 * @author ryanw
 * 要求打印内容方式如下：
 * 人物信息为：
 * 出生年月日：XXXX年X月X日
 * 性别为：男/女
 */
public class StringDemo11 {
    public static void main(String[] args) {
        // 1.定义一个字符串记录身份证号码
        String id = "321281202001011234";

        // 2.获取出生年月日
        String year = id.substring(6, 10);
        String month = id.substring(10, 12);
        String day = id.substring(12, 14);

        System.out.println("人物信息为：");
        System.out.println("出生年月日:" + year + "年" + month + "月" + day + "日");

        // 3.获取性别
        //'3'  ---> 3
        char gender = id.charAt(16);
        //利用ASCII码表进行转换
        //'0' --->  48
        //'1' --->  49
        //'2' --->  50
        //'3' --->  51
        //'4' --->  52
        //'5' --->  53
        //'6' --->  54
        //'7' --->  55
        //'8' --->  56
        //'9' --->  57

       int num = gender - 48;
        if(num % 2 == 0){
            System.out.println("性别为:女");
        }else{
            System.out.println("性别为:男");
        }



    }
}
