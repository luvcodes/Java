package cn.itcast.hotel;

import cn.itcast.hotel.service.IHotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class HotelDemoApplicationTests {
    @Autowired
    private IHotelService hotelService;

    @Test
    void contextLoads() {
        Map<String, List<String>> filters = hotelService.filters();

        System.out.println(filters);
    }
}
