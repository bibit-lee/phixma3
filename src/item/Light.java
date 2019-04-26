package item;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Light {
    public static JPanel lightPanel;

    public JPanel light(){
        lightPanel=new JPanel();
        lightPanel.setOpaque(false);
        lightPanel.setLayout(null);
        lightPanel.setVisible(false);
        JLabel light =new JLabel();
        light.setBackground(new Color(34,34,34,200));
        light.setOpaque(true);
        light.setBounds(0,0,ScreenSize.scr_width,ScreenSize.scr_height);
        lightPanel.add(light);

        light.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int i=e.getButton();
                if (i==MouseEvent.BUTTON1){
                    //当我透明的，哈哈！
                }
            }
        });


        return lightPanel;   //返回面板实例对象
    }
}
