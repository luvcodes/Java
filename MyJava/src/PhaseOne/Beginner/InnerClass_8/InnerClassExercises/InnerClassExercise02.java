package PhaseOne.Beginner.InnerClass_8.InnerClassExercises;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        // 1. 传递的是实现了Bell接口的匿名内部类 InnerClassExercise02$1
        // 2. 重写了ring方法
        // 3. bell = new Bell() {
        //            @Override
        //            public void ring() {
        //                System.out.println("Get up now!");
        //            }
        //        }
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("Get up now!");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("Time for class!");
            }
        });
    }
}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmClock(Bell bell) { // 形参是接口类型
//        System.out.println(bell.getClass());
        bell.ring();
    }
}
