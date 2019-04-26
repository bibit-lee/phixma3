package views.jlayeredAdministrator.users.jurisdictions.sells;


import item.Fonts;
import item.ScreenSize;

import javax.swing.*;
import java.awt.*;

public class Price {
    public JPanel price(){
        JPanel price;

        SpringLayout springLayout=new SpringLayout();
        price=new JPanel(springLayout);

        //开关图标
        ImageIcon titleOn=new ImageIcon("src/res/ON1.png");
        titleOn.setImage(titleOn.getImage().getScaledInstance(ScreenSize.scr_height*4/100,ScreenSize.scr_height*4/100,Image.SCALE_AREA_AVERAGING));
        ImageIcon titleOns=new ImageIcon("src/res/ON1.png");
        titleOns.setImage(titleOns.getImage().getScaledInstance(ScreenSize.scr_height*3/100,ScreenSize.scr_height*3/100,Image.SCALE_AREA_AVERAGING));

        ImageIcon titleOff=new ImageIcon("src/res/OFF1.png");
        titleOff.setImage(titleOff.getImage().getScaledInstance(ScreenSize.scr_height*4/100,ScreenSize.scr_height*4/100,Image.SCALE_AREA_AVERAGING));
        ImageIcon titleOffs=new ImageIcon("src/res/Off1.png");
        titleOffs.setImage(titleOffs.getImage().getScaledInstance(ScreenSize.scr_height*3/100,ScreenSize.scr_height*3/100,Image.SCALE_AREA_AVERAGING));

        //价格权限组
        JRadioButton priceJurisdiction=new JRadioButton("     价格查看");
        priceJurisdiction.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*5/100));
        priceJurisdiction.setFont(Fonts.getFontH1Bold());
        priceJurisdiction.setForeground(new Color(52,52,52));
        priceJurisdiction.setFocusPainted(false);  //去掉文字选中时的焦点边框
        priceJurisdiction.setSelected(true);  //默认选中状态
        priceJurisdiction.setIcon(titleOff);
        priceJurisdiction.setSelectedIcon(titleOn);

        //成本权限项
        JRadioButton costPrice=new JRadioButton("   成本价");
        costPrice.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*3/100));
        costPrice.setFont(Fonts.getFontStandard());
        costPrice.setForeground(new Color(52,52,52));
        costPrice.setFocusPainted(false);
        costPrice.setSelected(true);
        costPrice.setIcon(titleOffs);
        costPrice.setSelectedIcon(titleOns);

        JRadioButton sellPriceA=new JRadioButton("   销售价A");
        sellPriceA.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*3/100));
        sellPriceA.setFont(Fonts.getFontStandard());
        sellPriceA.setForeground(new Color(52,52,52));
        sellPriceA.setFocusPainted(false);
        sellPriceA.setSelected(true);
        sellPriceA.setIcon(titleOffs);
        sellPriceA.setSelectedIcon(titleOns);

        JRadioButton sellPriceB=new JRadioButton("   销售价B");
        sellPriceB.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*3/100));
        sellPriceB.setFont(Fonts.getFontStandard());
        sellPriceB.setForeground(new Color(52,52,52));
        sellPriceB.setFocusPainted(false);
        sellPriceB.setSelected(true);
        sellPriceB.setIcon(titleOffs);
        sellPriceB.setSelectedIcon(titleOns);

        JRadioButton sellPriceC=new JRadioButton("   销售价C");
        sellPriceC.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*3/100));
        sellPriceC.setFont(Fonts.getFontStandard());
        sellPriceC.setForeground(new Color(52,52,52));
        sellPriceC.setFocusPainted(false);
        sellPriceC.setSelected(true);
        sellPriceC.setIcon(titleOffs);
        sellPriceC.setSelectedIcon(titleOns);

        price.add(priceJurisdiction);
        price.add(costPrice);
        price.add(sellPriceA);
        price.add(sellPriceB);
        price.add(sellPriceC);


        springLayout.putConstraint(SpringLayout.NORTH,priceJurisdiction,0,SpringLayout.NORTH,price);
        springLayout.putConstraint(SpringLayout.WEST,priceJurisdiction,0,SpringLayout.WEST,price);
        springLayout.putConstraint(SpringLayout.EAST,priceJurisdiction,0,SpringLayout.EAST,price);

        springLayout.putConstraint(SpringLayout.NORTH,costPrice,0,SpringLayout.SOUTH,priceJurisdiction);
        springLayout.putConstraint(SpringLayout.WEST,costPrice,ScreenSize.scr_width*2/100,SpringLayout.WEST,price);
        springLayout.putConstraint(SpringLayout.EAST,costPrice,-ScreenSize.scr_width*2/100,SpringLayout.EAST,price);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceA,0,SpringLayout.SOUTH,costPrice);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceA,ScreenSize.scr_width*2/100,SpringLayout.WEST,price);
        springLayout.putConstraint(SpringLayout.EAST,sellPriceA,-ScreenSize.scr_width*2/100,SpringLayout.EAST,price);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceB,0,SpringLayout.SOUTH,sellPriceA);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceB,ScreenSize.scr_width*2/100,SpringLayout.WEST,price);
        springLayout.putConstraint(SpringLayout.EAST,sellPriceB,-ScreenSize.scr_width*2/100,SpringLayout.EAST,price);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceC,0,SpringLayout.SOUTH,sellPriceB);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceC,ScreenSize.scr_width*2/100,SpringLayout.WEST,price);
        springLayout.putConstraint(SpringLayout.EAST,sellPriceC,-ScreenSize.scr_width*2/100,SpringLayout.EAST,price);

        return price;
    }
}
