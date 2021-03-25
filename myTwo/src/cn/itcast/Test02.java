package cn.itcast;

import java.util.ServiceLoader;
import com.itheima_03.myService;

public class Test02 {
    public static void main(String[] args) {
        // load service
        ServiceLoader<myService> load = ServiceLoader.load(myService.class);
        for (myService my : load) {
            my.service();
        }
    }
}
