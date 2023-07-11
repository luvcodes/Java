package PhaseOne.Intermediate.CommonClasses_.String_2;

public class StringMethod02 {
    public static void main(String[] args) {
        // 1. toUpperCase转换成大写
        String s = "hello";
        System.out.println(s.toUpperCase());

        // 2. toLowerCase
        System.out.println(s.toLowerCase());

        // 3. concat拼接字符串
        String s1 = "Mark";
        s1 = s1.concat("is").concat("hansome");
        System.out.println(s1);

        // 4. replace替换字符串中的字符
        s1 = "Mark is handsome";
        // 在s1中，将所有的mark都替换成handsome
        // s1.replace() 方法执行后，返回的结果才是替换过的。
        // 注意对 s1没有任何影响
        s1 = s1.replace("Mark", "handsome");
        System.out.println(s1);

        // 5. split 分割字符串，对于某些分割自负，我们需要 转义比如 | \\等
        String poem = "To be, or not to be, that is a question.";
        // 1. 以 逗号 为标准对poem进行分割，返回一个数组
        // 2. 在对字符串进行分割时，如果有特殊字符，需要加入 转义符 \
        String[] split = poem.split(",");
        poem = "E:\\aaa\\bbb";
        split = poem.split("\\\\");
        System.out.println("===This poem content is===");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        // 6. toCharArray 转换成字符数组
        s = "happy";
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);
        }

        /**
         *          7. compareTo 比较两个字符串的大小，如果前者大
         *          则返回正数，后者大，则返回负数，如果相等，返回0
         *          (1) 如果长度相同，并且每个字符也相同 就返回0
         *          (2) 如果长度相同，或者不相同，但是在进行比较时，可以区分大小
         *             就返回 (if c1 != c2) {
         *                        return c1 - c2;
         *                    }
         *          (3) 如果前面的部分都相同，就返回str1.len - str2.len
         * */
        String a = "jackabc"; // len = 7
        String b = "jack"; // len = 4
        System.out.println(a.compareTo(b)); // 返回值是 'c' - 'a' = 2的值

        /**
         * 8. format 格式字符串
         */
        String name = "john";
        int age = 10;
        double score = 98.3 / 3;
        char gender = 'M';
        // 将所有的信息都拼接在一个字符串
        String info = "Name: " + name + " Age: " + age + " Score " + score + " Gender: " + gender;
        System.out.println(info);

        /**
         * 1. %s, %d, %.2f, %c 称为占位符
         * 2. 这些占位符由后面变量来替换
         * 3. %s 表示后面由 字符串来替换
         * 4. %d 是整数来替换
         * 5. %.2f 表示使用小数来替换，替换后，只会保留小数点两位，并且进行四舍五入的处理
         * 6. %c 使用char类型来替换
         */
        // String info2 = String.format("Name: %s Age: %d Score: %.2f Gender: %c ", name, age, score, gender);
        String formatStr = "Name: %s Age: %d Score: %.2f Gender: %c ";
        String info2 = String.format(formatStr, name, age, score, gender);
        System.out.println("Info2: " + info2);
    }
}
