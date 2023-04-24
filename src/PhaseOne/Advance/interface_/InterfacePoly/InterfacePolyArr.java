package PhaseOne.Advance.interface_.InterfacePoly;

public class InterfacePolyArr {
    public static void main(String[] args) {
        //多态数组 -> 接口类型数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();  
        // 遍历
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work(); // 动态绑定
            // 进行类型转型，需要进行类型的向下转型
            if (usbs[i] instanceof Phone_) {  // 判断运行类型是Phone_
                ((Phone_)usbs[i]).call();
            }
        }
    }
}

interface Usb {
    void work();
}

class Phone_ implements Usb {
    public void call() {
        System.out.println("Phone can make calls");
    }

    @Override
    public void work() {
        System.out.println("Phone is working");
    }
}

class Camera_ implements Usb {
    @Override
    public void work() {
        System.out.println("Camera is working");
    }
}
