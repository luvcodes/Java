package mySerializabal12;

import java.io.*;

public class myserializable01 {
    public static void main(String[] args) {
        serializable();
        deserializable();
    }

    public static void serializable() {
        MyClass myClass = new MyClass(1, "Hello World");
        try {
            FileOutputStream outputStream = new FileOutputStream("object.ser");
            ObjectOutputStream outputStream1 = new ObjectOutputStream(outputStream);
            outputStream1.writeObject(myClass);

            outputStream1.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializable() {
        MyClass newObject = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("object.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            newObject = (MyClass) objectInputStream.readObject();
            System.out.println("New object info: ");
            newObject.display();

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
