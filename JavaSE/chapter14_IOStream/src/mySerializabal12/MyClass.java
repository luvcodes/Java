package mySerializabal12;

public class MyClass {
    private static final long serialVersion1D = 1L;
    private int id;
    private String name;

    public MyClass() {

    }

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("ID: " + id + " Name: " + name);
    }
}
