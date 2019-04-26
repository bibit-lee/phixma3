package mainFrame;


import item.Fonts;
import item.ScreenSize;
import titles.MainTitle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HelloUser {
    public static JPanel helloUserPanel;
    public JPanel helloUser(){

        SpringLayout springLayout=new SpringLayout();
        helloUserPanel =new JPanel(springLayout);

        JLabel works=new JLabel("考勤");
        works.setFont(Fonts.getFontH2Bold());
        works.setForeground(new Color(38,38,38));


        JLabel lists=new JLabel("清单");
        lists.setFont(Fonts.getFontH2Bold());
        lists.setForeground(new Color(38,38,38));

        JLabel settings=new JLabel("个人设置");
        settings.setFont(Fonts.getFontH2Bold());
        settings.setForeground(new Color(38,38,38));

        JLabel notices=new JLabel("通知");
        notices.setFont(Fonts.getFontH2Bold());
        notices.setForeground(new Color(38,38,38));

        JLabel logout=new JLabel("注销");
        logout.setFont(Fonts.getFontH2Bold());
        logout.setForeground(new Color(38,38,38));

        helloUserPanel.add(works);
        helloUserPanel.add(lists);
        helloUserPanel.add(settings);
        helloUserPanel.add(notices);
        helloUserPanel.add(logout);

        springLayout.putConstraint(SpringLayout.NORTH,works,ScreenSize.scr_height*3/100,SpringLayout.NORTH, helloUserPanel);
        springLayout.putConstraint(SpringLayout.WEST,works, ScreenSize.scr_width/100,SpringLayout.WEST, helloUserPanel);
        springLayout.putConstraint(SpringLayout.EAST,works,0,SpringLayout.EAST, helloUserPanel);

        springLayout.putConstraint(SpringLayout.NORTH,lists,ScreenSize.scr_height*3/100,SpringLayout.SOUTH,works);
        springLayout.putConstraint(SpringLayout.WEST,lists,ScreenSize.scr_width/100,SpringLayout.WEST, helloUserPanel);
        springLayout.putConstraint(SpringLayout.EAST,lists,0,SpringLayout.EAST, helloUserPanel);

        springLayout.putConstraint(SpringLayout.NORTH,settings,ScreenSize.scr_height*3/100,SpringLayout.SOUTH,lists);
        springLayout.putConstraint(SpringLayout.WEST,settings,ScreenSize.scr_width/100,SpringLayout.WEST, helloUserPanel);
        springLayout.putConstraint(SpringLayout.EAST,settings,0,SpringLayout.EAST, helloUserPanel);

        springLayout.putConstraint(SpringLayout.NORTH,notices,ScreenSize.scr_height*3/100,SpringLayout.SOUTH,settings);
        springLayout.putConstraint(SpringLayout.WEST,notices,ScreenSize.scr_width/100,SpringLayout.WEST, helloUserPanel);
        springLayout.putConstraint(SpringLayout.EAST,notices,0,SpringLayout.EAST, helloUserPanel);

        springLayout.putConstraint(SpringLayout.NORTH,logout,ScreenSize.scr_height*3/100,SpringLayout.SOUTH,notices);
        springLayout.putConstraint(SpringLayout.WEST,logout,ScreenSize.scr_width/100,SpringLayout.WEST, helloUserPanel);
        springLayout.putConstraint(SpringLayout.EAST,logout,0,SpringLayout.EAST, helloUserPanel);



        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JLayeredView.jLayeredView.removeAll();
                //层面板添加各层面板，数值越高为最优显示
                JLayeredView.jLayeredView.add(JLayeredView.login,Integer.valueOf(500));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(400));
                JLayeredView.jLayeredView.add(helloUserPanel,Integer.valueOf(300));
                JLayeredView.jLayeredView.add(JLayeredView.recommend,Integer.valueOf(200));
                JLayeredView.jLayeredView.add(JLayeredView.administrator,Integer.valueOf(100));
                JLayeredView.light.setVisible(true);
                JLayeredTitle.light.setVisible(true);
                JLayeredTop.light.setVisible(true);
                JLayeredTop.topAdvert.setVisible(false);
                JLayeredTitle.mainTitle.setVisible(false);
                helloUserPanel.setVisible(false);
                JLayeredView.recommend.setVisible(false);
                JLayeredView.administrator.setVisible(false);

                //管理员模式下登录隐藏的，退出时显示
                MainTitle.j1Commodity.setVisible(true);
                MainTitle.j2Bill.setVisible(true);
                MainTitle.j3Object.setVisible(true);
                MainTitle.j4Account.setVisible(true);
                MainTitle.j5Mission.setVisible(true);
                MainTitle.j6Life.setVisible(true);

                MainTitle.helloUserClose.setVisible(false);
                MainTitle.helloUserOpen.setVisible(true);
                HelloUser.helloUserPanel.setVisible(false);
            }
        });


        return helloUserPanel;
    }
}
