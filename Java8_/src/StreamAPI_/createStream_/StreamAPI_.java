package StreamAPI_.createStream_;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Map;

import java.util.stream.Stream;

public class StreamAPI_ {
//    // 创建stream方式一: 通过集合
//    @Test
//    public void test1() {
//        // 顺序流
//
//        // 并行流
//    }
//
//    // 创建stream方式二: 通过数组
//    @Test
//    public void test2() {
//        // 调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
//
//    }
//
//    // 创建Stream方式三: 通过Stream的of()
//    @Test
//    public void test3() {
//        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
//    }
//
//    // 创建Stream方式四: 创建无限流
//    @Test
//    public void test4() {
//
//    }
        public static void main(String args[]){
            System.out.println("使用 Java 7: ");

            // 计算空字符串
            List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
            System.out.println("列表: " +strings);
            long count = getCountEmptyStringUsingJava7(strings);

            System.out.println("空字符数量为: " + count);
            count = getCountLength3UsingJava7(strings);

            System.out.println("字符串长度为 3 的数量为: " + count);

            // 删除空字符串
            List<String> filtered = deleteEmptyStringsUsingJava7(strings);
            System.out.println("筛选后的列表: " + filtered);

            // 删除空字符串，并使用逗号把它们合并起来
            String mergedString = getMergedStringUsingJava7(strings,", ");
            System.out.println("合并字符串: " + mergedString);
            List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);


            List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

            System.out.println("列表: " +integers);
            System.out.println("列表中最大的数 : " + getMax(integers));
            System.out.println("列表中最小的数 : " + getMin(integers));
            System.out.println("所有数之和 : " + getSum(integers));
            System.out.println("平均数 : " + getAverage(integers));
            System.out.println("随机数: ");

            // 输出10个随机数
            Random random = new Random();

            for(int i=0; i < 10; i++){
                System.out.println(random.nextInt());
            }

            System.out.println("使用 Java 8: ");
            System.out.println("列表: " +strings);

            count = strings.stream().filter(string->string.isEmpty()).count();
            System.out.println("空字符串数量为: " + count);

            count = strings.stream().filter(string -> string.length() == 3).count();
            System.out.println("字符串长度为 3 的数量为: " + count);

            filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
            System.out.println("筛选后的列表: " + filtered);

            mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
            System.out.println("合并字符串: " + mergedString);

            IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

            System.out.println("列表中最大的数 : " + stats.getMax());
            System.out.println("列表中最小的数 : " + stats.getMin());
            System.out.println("所有数之和 : " + stats.getSum());
            System.out.println("平均数 : " + stats.getAverage());
            System.out.println("随机数: ");

            random.ints().limit(10).sorted().forEach(System.out::println);

            // 并行处理
            count = strings.parallelStream().filter(string -> string.isEmpty()).count();
            System.out.println("空字符串的数量为: " + count);
        }

        private static int getCountEmptyStringUsingJava7(List<String> strings){
            int count = 0;

            for(String string: strings){

                if(string.isEmpty()){
                    count++;
                }
            }
            return count;
        }

        private static int getCountLength3UsingJava7(List<String> strings){
            int count = 0;

            for(String string: strings){

                if(string.length() == 3){
                    count++;
                }
            }
            return count;
        }

        private static List<String> deleteEmptyStringsUsingJava7(List<String> strings){
            List<String> filteredList = new ArrayList<String>();

            for(String string: strings){

                if(!string.isEmpty()){
                    filteredList.add(string);
                }
            }
            return filteredList;
        }

        private static String getMergedStringUsingJava7(List<String> strings, String separator){
            StringBuilder stringBuilder = new StringBuilder();

            for(String string: strings){

                if(!string.isEmpty()){
                    stringBuilder.append(string);
                    stringBuilder.append(separator);
                }
            }
            String mergedString = stringBuilder.toString();
            return mergedString.substring(0, mergedString.length()-2);
        }

        private static int getMax(List<Integer> numbers){
            int max = numbers.get(0);

            for(int i=1;i < numbers.size();i++){

                Integer number = numbers.get(i);

                if(number.intValue() > max){
                    max = number.intValue();
                }
            }
            return max;
        }

        private static int getMin(List<Integer> numbers){
            int min = numbers.get(0);

            for(int i=1;i < numbers.size();i++){
                Integer number = numbers.get(i);

                if(number.intValue() < min){
                    min = number.intValue();
                }
            }
            return min;
        }

        private static int getSum(List numbers){
            int sum = (int)(numbers.get(0));

            for(int i=1;i < numbers.size();i++){
                sum += (int)numbers.get(i);
            }
            return sum;
        }

        private static int getAverage(List<Integer> numbers){
            return getSum(numbers) / numbers.size();
        }
}
