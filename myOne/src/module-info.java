import com.itheima_03.impl.Czxy;
import com.itheima_03.myService;
import com.itheima_03.impl.Itheima;


module myOne {
    exports com.itheima_01;

    exports com.itheima_03;
//    provides myService with Itheima;
    provides myService with Czxy;
}