package CommonClasses_.Homework;

public class Homework02 {
    public static void main(String[] args) {
        String name = "jack";
        String pwd = "123456";
        String email = "jack@sohu.com";

        try {
            userRegister(name, pwd, email);
            System.out.println("Successfully registered");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * 输入用户名、密码、又想，如果信息录入正确，则提示注册成功，否则生成异常
     * 要求:
     * (1) 用户长度为2或3或4
     * (2) 密码的长度为6，要求全是数字 isDigital
     * (3) 邮箱中包含@和. 并且@在.的前面
     *
     * 思路分析
     * (1) 先编写方法 userRegister(String name, String pwd, String email) {}
     * (2)
     * */
    public static void userRegister(String name, String pwd, String email) {
        // 再加入一些校验
        if (!(name != null && pwd != null && email != null)) {
            throw new RuntimeException("Parameter cannot be null");
        }

        // 用户长度
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("Username length should be 2 or 3 or 4");
        }

        // 密码长度
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("Password length should be 6, all numbers");
        }

        //
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i)) {
            throw new RuntimeException("Email address should contain @ and ., @ should in front of .");
        }
    }

    // 判断密码是否全部是数字字符 boolean
    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
