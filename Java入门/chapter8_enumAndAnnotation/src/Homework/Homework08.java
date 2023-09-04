package Homework;

public class Homework08 {
    public static void main(String[] args) {
        // 枚举值的switch使用
        Color green = Color.GREEN;
        green.show();

        // switch()中，放入枚举对象
        // 在每个case后，直接写上在枚举类中定义的枚举对象即可
        switch (green) {
            case RED:
                System.out.println("Match to red");
                break;
            case BLACK:
                System.out.println("Match to black");
                break;
            case BLUE:
                System.out.println("Match to blue");
            case YELLOW:
                System.out.println("Match to yellow");
                break;
            case GREEN:
                System.out.println("Match to green");
                break;
            default:
                System.out.println("Nothing matched correctly");
        }
    }
}

/**
 *
 * */

interface IMyInterface {
    public void show();
}

enum Color implements IMyInterface {
    RED(255,0,0), BLUE(0,0,255), BLACK(0,0,0),
    YELLOW(255,255,0), GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("Attribute value: " + redValue + ", " + greenValue + ", " + blueValue);
    }
}