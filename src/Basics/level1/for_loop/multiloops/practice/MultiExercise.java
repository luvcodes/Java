package Basics.level1.for_loop.multiloops.practice;

import java.util.Scanner;

// 统计三个班成绩情况，每个班有五名同学
// 求各班平均数和所有班级的平均分，学生成绩键盘输入
// 统计三个班及格人数，每个班有5名同学

// 1. 先计算一个班5个学生的成绩，使用for
// 1.1 创建scanner，接收用户输入
// 1.2 得到该班级的平均分，定义double sum把该班级5个学生的成绩累积

// 2. 统计三个班平均分

// 3. 所有班级的平均分
// 3.1 定义一个变量，double totalScore 累积所有学生的成绩
// 3.2 当多重循环结束后，用totalScore除以15

// 4. 统计三个班的及格人数

// 步骤1的实现
class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (int j = 1; j <= 5; j++) {
            System.out.print("Please enter the " + j + "th student in the first class: ");
            double score = scanner.nextDouble();
            System.out.println("The score is: " + score);
            sum = sum + score; // 累积
        }
        System.out.println("sum = " + sum + ", average score: " + (sum/5));
    }
}

public class MultiExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            double sum = 0;
            for (int j = 1; j <= 5; j++) {
                System.out.print("Please enter the " + j + "th student in the" + i + "th class: ");
                double score = scanner.nextDouble();
                System.out.println("The score is: " + score);
                sum = sum + score; // 累积
            }
            System.out.println("sum = " + sum + ", average score: " + (sum/5));         // 平均分
        }
    }
}

class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalScore = 0;
        for (int i = 1; i <= 3; i++) {
            double sum = 0;
            for (int j = 1; j <= 5; j++) {
                System.out.print("Please enter the " + j + "th student in the" + i + "th class: ");
                double score = scanner.nextDouble();
                System.out.println("The score is: " + score);
                sum = sum + score; // 累积
            }
            // 平均分
            System.out.println("sum = " + sum + ", average score: " + (sum/5));
            totalScore += sum; // 把sum累积到totalScore
        }
        System.out.println("The total score is: " + totalScore + ", average score is: " + (totalScore/15));
    }
}

// 步骤4
class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalScore = 0;
        int passStuNum = 0;
        for (int i = 1; i <= 3; i++) {
            double sum = 0;
            for (int j = 1; j <= 5; j++) {
                System.out.print("Please enter the " + j + "th student in the" + i + "th class: ");
                double score = scanner.nextDouble();
                System.out.println("The score is: " + score);
                sum = sum + score; // 累积
                if (score >= 60) { // 判断是否通过考试
                    passStuNum++;
                }
            }
            System.out.println("sum = " + sum + ", average score: " + (sum/5));         // 平均分
            totalScore += sum; // 把sum累积到totalScore
        }
        System.out.println("The total score is: " + totalScore + ", average score is: " + (totalScore/15));
        System.out.println("Number of students passed the exam: " + passStuNum);
    }
}


class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalScore = 0;
        int passStuNum = 0;
        int classNum = 3; // 班级个数
        int studentNum = 5; // 学生人数

        for (int i = 1; i <= classNum; i++) {
            double sum = 0;
            for (int j = 1; j <= studentNum; j++) {
                System.out.print("Please enter the " + j + "th student in the" + i + "th class: ");
                double score = scanner.nextDouble();
                System.out.println("The score is: " + score);
                sum = sum + score; // 累积
                if (score >= 60) { // 判断是否通过考试
                    passStuNum++;
                }

            }
            System.out.println("sum = " + sum + ", average score: " + (sum/5));         // 平均分
            totalScore += sum; // 把sum累积到totalScore
        }
        System.out.println("The total score is: " + totalScore + ", average score is: " + (totalScore/(classNum*studentNum)));
        System.out.println("Number of students passed the exam: " + passStuNum);

    }
}
