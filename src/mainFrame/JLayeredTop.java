package mainFrame;

import item.Light;
import item.ScreenSize;
import tops.TopAdvert;
import javax.swing.*;



public class JLayeredTop {

    public static JLayeredPane topPanel;
    public static JPanel light;
    public static JPanel topAdvert;

    public JLayeredPane topPanel(){

        topPanel=new JLayeredPane();

        //公共灯光聚焦层
        Light c1=new Light();
        light=c1.light();
        light.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);  //设置坐标和尺寸


        TopAdvert ta=new TopAdvert();
        topAdvert=ta.getTopAdvert();
        topAdvert.setBounds(0,0,ScreenSize.scr_width,ScreenSize.scr_height);

        topPanel.add(light,Integer.valueOf(500));
        topPanel.add(topAdvert,Integer.valueOf(400));
        light.setVisible(true);
        topAdvert.setVisible(false);

        return topPanel;
    }
}
