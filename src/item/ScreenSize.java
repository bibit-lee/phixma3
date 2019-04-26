package item;

import java.awt.*;

public class ScreenSize {  //创建公共类
    //声明屏幕尺寸获取方式和尺寸为全局变量
    static Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    public static int scr_width=(int)dimension.getWidth();
    public static int scr_height=(int)dimension.getHeight();

    public static int clientChoice_widht=scr_width*40/100;
    public static int clientChoice_heitht=scr_height*60/100;

    public static int productChoice_width=scr_width*90/100;
    public static int productChoice_heitht=scr_height*80/100;

    public static int commodityEditor_width=scr_width*40/100;
    public static int commodityEditor_height=scr_height*30/100;


}
