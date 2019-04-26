package views.jlayeredAdministrator.users.jurisdictions.sells;


import item.Fonts;
import item.ScreenSize;

import javax.swing.*;
import java.awt.*;

public class SellsJurisdiction {
    public JPanel sellsJurisdiction(){
        JPanel sellsJurisdiction;

        //销售权限类面板
        SpringLayout springLayout=new SpringLayout();
        sellsJurisdiction=new JPanel(springLayout);



        //销售类权限标题
        JLabel sellsJurTitle=new JLabel("销售权限",SwingConstants.CENTER);
        sellsJurTitle.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*3/100));
        sellsJurTitle.setFont(Fonts.getFontStandard());
        sellsJurTitle.setForeground(new Color(13,13,13));
        sellsJurTitle.setBackground(new Color(255,216,0));
        sellsJurTitle.setOpaque(true);

        Price price=new Price();
        JPanel priceJurisdiction=price.price();
        priceJurisdiction.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*30/100));



        sellsJurisdiction.add(sellsJurTitle);
        sellsJurisdiction.add(priceJurisdiction);

        springLayout.putConstraint(SpringLayout.NORTH,sellsJurTitle,ScreenSize.scr_height*3/100,SpringLayout.NORTH,sellsJurisdiction);
        springLayout.putConstraint(SpringLayout.WEST,sellsJurTitle,ScreenSize.scr_width*6/100,SpringLayout.WEST,sellsJurisdiction);
        springLayout.putConstraint(SpringLayout.EAST,sellsJurTitle,-ScreenSize.scr_width*6/100,SpringLayout.EAST,sellsJurisdiction);

        springLayout.putConstraint(SpringLayout.NORTH,priceJurisdiction,ScreenSize.scr_height*3/100,SpringLayout.SOUTH,sellsJurTitle);
        springLayout.putConstraint(SpringLayout.WEST,priceJurisdiction,0,SpringLayout.WEST,sellsJurisdiction);
        springLayout.putConstraint(SpringLayout.EAST,priceJurisdiction,0,SpringLayout.EAST,sellsJurisdiction);

        return sellsJurisdiction;
    }
}
