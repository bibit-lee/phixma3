package views.jlayeredMain;


import item.Fonts;
import item.ScreenSize;
import mainFrame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class Recommend {

    int b= ScreenSize.scr_height*51/100;
    public static JPanel jPanel;

    public JPanel recommend(){
        SpringLayout springLayout=new SpringLayout();
        jPanel=new JPanel(springLayout);
        jPanel.setOpaque(false);

        JLabel Upward=new JLabel("∧",SwingConstants.CENTER);
        Upward.setForeground(Color.WHITE);
        Upward.setBackground(new Color(54,54,54,150));
        Upward.setOpaque(true);
        Upward.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_width*3/100));
        Upward.setFont(Fonts.getSymbolH0());

        JLabel Down=new JLabel("∨",SwingConstants.CENTER);
        Down.setForeground(Color.WHITE);
        Down.setBackground(new Color(54,54,54,150));
        Down.setOpaque(true);
        Down.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_width*3/100));
        Down.setFont(Fonts.getSymbolH0());

        JLabel Left=new JLabel("<",SwingConstants.CENTER);
        Left.setForeground(Color.WHITE);
        Left.setBackground(new Color(54,54,54,150));
        Left.setOpaque(true);
        Left.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_width*3/100));
        Left.setFont(Fonts.getSymbolH0());


        JLabel Right=new JLabel(">",SwingConstants.CENTER);
        Right.setForeground(Color.WHITE);
        Right.setBackground(new Color(54,54,54,150));
        Right.setOpaque(true);
        Right.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_width*3/100));
        Right.setFont(Fonts.getSymbolH0());


        JLabel Set=new JLabel("≡",SwingConstants.CENTER);
        Set.setForeground(Color.WHITE);
        Set.setBackground(new Color(54,54,54,150));
        Set.setOpaque(true);
        Set.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_width*3/100));
        Set.setFont(Fonts.getSymbolH0());

        JLabel discovery=new JLabel("探索发现",SwingConstants.CENTER);
        discovery.setForeground(Color.WHITE);
        discovery.setBackground(new Color(54,54,54,150));
        discovery.setOpaque(true);
        discovery.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_width*3/100));
        discovery.setFont(Fonts.getFontStandard());

        JLabel tips=new JLabel("FJDKFJKDJFKDJFKDJFKDFDFK33333333333333333333333333333333333333333333");
        tips.setForeground(Color.WHITE);
        tips.setBackground(new Color(28,28,28,200));
        tips.setOpaque(true);
        tips.setPreferredSize(new Dimension(ScreenSize.scr_width*22/10,ScreenSize.scr_height*2/10));
        tips.setFont(Fonts.getFontStandard());

        JPanel content=new JPanel();
        content.setPreferredSize(new Dimension(ScreenSize.scr_width,ScreenSize.scr_height*63/100));
        content.setForeground(Color.WHITE);


        jPanel.add(Upward);
        jPanel.add(Down);
        jPanel.add(Left);
        jPanel.add(Right);
        jPanel.add(Set);
        jPanel.add(discovery);
        jPanel.add(tips);
        jPanel.add(content);

        springLayout.putConstraint(SpringLayout.NORTH,tips,ScreenSize.scr_height*3/100,SpringLayout.NORTH,jPanel);
        springLayout.putConstraint(SpringLayout.WEST,tips,ScreenSize.scr_width*73/100,SpringLayout.WEST,jPanel);
        springLayout.putConstraint(SpringLayout.EAST,tips,-ScreenSize.scr_width*5/100,SpringLayout.EAST,jPanel);

        springLayout.putConstraint(SpringLayout.NORTH,Upward,ScreenSize.scr_height/100,SpringLayout.SOUTH,tips);
        springLayout.putConstraint(SpringLayout.WEST,Upward,ScreenSize.scr_width*5/100,SpringLayout.WEST,jPanel);

        springLayout.putConstraint(SpringLayout.NORTH,Down,ScreenSize.scr_height/100,SpringLayout.SOUTH,tips);
        springLayout.putConstraint(SpringLayout.WEST,Down,ScreenSize.scr_width*5/100,SpringLayout.WEST,jPanel);

        springLayout.putConstraint(SpringLayout.NORTH,discovery,ScreenSize.scr_height/100,SpringLayout.SOUTH,tips);
        springLayout.putConstraint(SpringLayout.WEST,discovery,ScreenSize.scr_width*76/100-6,SpringLayout.WEST,jPanel);

        springLayout.putConstraint(SpringLayout.NORTH,Left,ScreenSize.scr_height/100,SpringLayout.SOUTH,tips);
        springLayout.putConstraint(SpringLayout.WEST,Left,2,SpringLayout.EAST,discovery);

        springLayout.putConstraint(SpringLayout.NORTH,Right,ScreenSize.scr_height/100,SpringLayout.SOUTH,tips);
        springLayout.putConstraint(SpringLayout.WEST,Right,2,SpringLayout.EAST,Left);

        springLayout.putConstraint(SpringLayout.NORTH,Set,ScreenSize.scr_height/100,SpringLayout.SOUTH,tips);
        springLayout.putConstraint(SpringLayout.WEST,Set,2,SpringLayout.EAST,Right);
        springLayout.putConstraint(SpringLayout.EAST,Set,-ScreenSize.scr_width*5/100,SpringLayout.EAST,jPanel);

        springLayout.putConstraint(SpringLayout.NORTH,content,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,Set);
        springLayout.putConstraint(SpringLayout.WEST,content,0,SpringLayout.WEST,jPanel);
        springLayout.putConstraint(SpringLayout.EAST,content,0,SpringLayout.EAST,jPanel);
        springLayout.putConstraint(SpringLayout.SOUTH,content,0,SpringLayout.SOUTH,jPanel);



        MainFrame.jFrame.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                if (e.getWheelRotation()==1){
                    b-=100;
                    jPanel.setLocation(0,b);
                }
                if (e.getWheelRotation()==-1){
                    b+=100;
                    jPanel.setLocation(0,b);
                }
            }
        });





        return jPanel;

    }
}
