package a10test4;

import java.util.UUID;

/**
 * @author ryanw
 */
public class UUIDTest {
    public static void main(String[] args) {
        String str = UUID.randomUUID().toString().replace("-", "");
        //9f15b8c356c54f55bfcb0ee3023fce8a
        System.out.println(str);
    }
}
