public class CustomGenric_ {
    public static void main(String[] args) {

    }
}

/**
 * 1. Tiger后面泛型，所以我们把Tiger就称为自定义泛型类
 * 2. T, R, M泛型的标识符，一般是单个大写字母
 * 3. 泛型标识符可以有多个
 * 4. 普通成员可以使用泛型 (属性、方法)
 * 5. 
 */

class Tiger<T,R,M> {
    String name;
    R r; // 属性使用到泛型
    M m;
    T t;

    // 构造器使用泛型
    public Tiger(String name, R r, M m, T t) {
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }
}