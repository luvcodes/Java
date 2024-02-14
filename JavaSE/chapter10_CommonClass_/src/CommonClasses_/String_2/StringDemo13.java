package CommonClasses_.String_2;

/**
 * @author ryanw
 * 如果要替换的敏感词比较多怎么办？
 */
public class StringDemo13 {
    public static void main(String[] args) {
        //1.获取到说的话
        String talk = "你玩的真好，以后不要再玩了，TMD,CNM";

        //2.定义一个敏感词库
        String[] arr = {"TMD","CNM","SB","MLGB"};

        //3.循环得到数组中的每一个敏感词，依次进行替换
        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i], "***");
        }

        //4.打印结果
        System.out.println(talk);
    }
}
