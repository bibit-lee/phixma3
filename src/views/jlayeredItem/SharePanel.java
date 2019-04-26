package views.jlayeredItem;


import item.Fonts;
import item.ScreenSize;
import javax.swing.*;
import java.awt.*;

public class SharePanel {
    public JPanel sharePanel(){
        JPanel sharePanel;
        SpringLayout springLayout=new SpringLayout();
        sharePanel=new JPanel(springLayout);
        sharePanel.setBackground(Color.WHITE);

        JLabel title=new JLabel("分享：",SwingConstants.CENTER);
        title.setFont(Fonts.getFontH5Standard());
        title.setPreferredSize(new Dimension(ScreenSize.scr_width*4/100,ScreenSize.scr_height*4/100));

        ImageIcon weChatIcon=new ImageIcon("src/res/weChat.png");
        weChatIcon.setImage(weChatIcon.getImage().getScaledInstance(ScreenSize.scr_width*4/100,ScreenSize.scr_height*4/100,Image.SCALE_AREA_AVERAGING));
        JLabel weChat=new JLabel(weChatIcon);

        ImageIcon qqIcon=new ImageIcon("src/res/qq.png");
        qqIcon.setImage(qqIcon.getImage().getScaledInstance(ScreenSize.scr_height*4/100,ScreenSize.scr_height*4/100,Image.SCALE_AREA_AVERAGING));
        JLabel qq=new JLabel(qqIcon);


        sharePanel.add(title);
        sharePanel.add(weChat);
        sharePanel.add(qq);

        springLayout.putConstraint(SpringLayout.NORTH,title,0,SpringLayout.NORTH,sharePanel);
        springLayout.putConstraint(SpringLayout.WEST,title,0,SpringLayout.WEST,sharePanel);

        springLayout.putConstraint(SpringLayout.NORTH,weChat,0,SpringLayout.NORTH,sharePanel);
        springLayout.putConstraint(SpringLayout.WEST,weChat,0,SpringLayout.EAST,title);

        springLayout.putConstraint(SpringLayout.NORTH,qq,0,SpringLayout.NORTH,sharePanel);
        springLayout.putConstraint(SpringLayout.WEST,qq,0,SpringLayout.EAST,weChat);

        return sharePanel;
    }
}
