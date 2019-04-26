package mainFrame;


import item.Light;
import item.ScreenSize;
import titles.MainTitle;

import javax.swing.*;

public class JLayeredTitle {
    public static JPanel light;
    public static JPanel mainTitle;

    public JLayeredPane jLayeredTitle(){
        JLayeredPane jLayeredTitle=new JLayeredPane();

        //公共灯光聚焦层
        Light c1=new Light();
        light=c1.light();
        light.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);  //设置坐标和尺寸

        //主面板Title面板
        MainTitle mt=new MainTitle();
        mainTitle=mt.mainTitle();
        mainTitle.setBounds(0,0,ScreenSize.scr_width,ScreenSize.scr_height);

        jLayeredTitle.add(light,Integer.valueOf(300));
        jLayeredTitle.add(mainTitle,Integer.valueOf(200));

        light.setVisible(true);
        mainTitle.setVisible(false);


        return jLayeredTitle;
    }
}
