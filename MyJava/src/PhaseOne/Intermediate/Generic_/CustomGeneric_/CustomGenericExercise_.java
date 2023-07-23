package PhaseOne.Intermediate.Generic_.CustomGeneric_;

public class CustomGenericExercise_ {
    public static void main(String[] args) {
        // T, R, M
        Tiger1<Double, String, Integer> g = new Tiger1<>("john");
        // ok 因为setT方法本身接受T类型，而T类型对应的是Double类型
        g.setT(10.9);
        // Error 类型不匹配，原因就是上面说的
        // g.setT("yy");
        System.out.println(g);

        // 这样没有指定，所以默认就是三个Object类型
        Tiger1 g2 = new Tiger1<>("john~~");
        // ok String是Object的子类
        g2.setT("yy");
        System.out.println("g2 = " + g2);
    }
}


class Tiger1<T,R,M> {
    String name;
    R r;
    M m;
    T t;

    public Tiger1(String name) {
        this.name = name;
    }

    // 构造器使用泛型
    public Tiger1(R r, M m, T t) {
        this.r = r;
        this.m = m;
        this.t = t;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 返回类型可以使用泛型
    public R getR() {
        return r;
    }

    // 方法使用到泛型
    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger1{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                '}';
    }
}


