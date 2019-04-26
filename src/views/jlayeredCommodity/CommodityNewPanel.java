package views.jlayeredCommodity;


import item.Fonts;
import item.ScreenSize;
import mainFrame.JLayeredView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommodityNewPanel {
    public JPanel commodityNew(){
        JPanel commodityNew;

        SpringLayout springLayout=new SpringLayout();
        commodityNew=new JPanel(springLayout);
        commodityNew.setBackground(Color.WHITE);

        JLabel exit=new JLabel("×",SwingConstants.CENTER);
        exit.setFont(Fonts.getSymbolHmax());
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,ScreenSize.scr_height*3/100));

        JLabel name=new JLabel("商品名称:",SwingConstants.CENTER);
        name.setFont(Fonts.getFontStandard());
        name.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));
        JTextField nameInput=new JTextField();
        nameInput.setFont(Fonts.getFontH2Bold());
        nameInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel brand=new JLabel("商品品牌:",SwingConstants.CENTER);
        brand.setFont(Fonts.getFontStandard());
        brand.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));
        JTextField brandInput=new JTextField();
        brandInput.setFont(Fonts.getFontH2Bold());
        brandInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel origin=new JLabel("产地:",SwingConstants.CENTER);
        origin.setFont(Fonts.getFontStandard());
        origin.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));
        JTextField originInput=new JTextField();
        originInput.setFont(Fonts.getFontH2Bold());
        originInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel attributeA=new JLabel("属性A:",SwingConstants.CENTER);
        attributeA.setFont(Fonts.getFontStandard());
        attributeA.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));
        JTextField aaInput=new JTextField();
        aaInput.setFont(Fonts.getFontH2Bold());
        aaInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel attributeB=new JLabel("属性B:",SwingConstants.CENTER);
        attributeB.setFont(Fonts.getFontStandard());
        attributeB.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));
        JTextField abInput=new JTextField();
        abInput.setFont(Fonts.getFontH2Bold());
        abInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel attributeC=new JLabel("属性C:",SwingConstants.CENTER);
        attributeC.setFont(Fonts.getFontStandard());
        attributeC.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));
        JTextField acInput=new JTextField();
        acInput.setFont(Fonts.getFontH2Bold());
        acInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel date=new JLabel("生产批次:",SwingConstants.CENTER);
        date.setFont(Fonts.getFontStandard());
        date.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));
        JTextField dateInput=new JTextField();
        dateInput.setFont(Fonts.getFontH2Bold());
        dateInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));



        JLabel save=new JLabel("保存商品",SwingConstants.CENTER);
        save.setFont(Fonts.getFontStandard());
        save.setForeground(Color.WHITE);
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        save.setPreferredSize(new Dimension(ScreenSize.scr_width*12/100,ScreenSize.scr_height*5/100));

        commodityNew.add(exit);
        commodityNew.add(name);
        commodityNew.add(nameInput);
        commodityNew.add(brand);
        commodityNew.add(brandInput);
        commodityNew.add(origin);
        commodityNew.add(originInput);
        commodityNew.add(attributeA);
        commodityNew.add(aaInput);
        commodityNew.add(attributeB);
        commodityNew.add(abInput);
        commodityNew.add(attributeC);
        commodityNew.add(acInput);
        commodityNew.add(date);
        commodityNew.add(dateInput);
        commodityNew.add(save);


        springLayout.putConstraint(SpringLayout.NORTH,exit,ScreenSize.scr_height/100,SpringLayout.NORTH,commodityNew);
        springLayout.putConstraint(SpringLayout.EAST,exit,0,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,brand,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,exit);
        springLayout.putConstraint(SpringLayout.WEST,brand,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,brandInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,exit);
        springLayout.putConstraint(SpringLayout.WEST,brandInput,0,SpringLayout.EAST,brand);
        springLayout.putConstraint(SpringLayout.EAST,brandInput,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,name,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,brand);
        springLayout.putConstraint(SpringLayout.WEST,name,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,nameInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,brand);
        springLayout.putConstraint(SpringLayout.WEST,nameInput,0,SpringLayout.EAST,name);
        springLayout.putConstraint(SpringLayout.EAST,nameInput,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,attributeA,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,name);
        springLayout.putConstraint(SpringLayout.WEST,attributeA,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,aaInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,name);
        springLayout.putConstraint(SpringLayout.WEST,aaInput,0,SpringLayout.EAST,attributeA);
        springLayout.putConstraint(SpringLayout.EAST,aaInput,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,attributeB,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeA);
        springLayout.putConstraint(SpringLayout.WEST,attributeB,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,abInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeA);
        springLayout.putConstraint(SpringLayout.WEST,abInput,0,SpringLayout.EAST,attributeB);
        springLayout.putConstraint(SpringLayout.EAST,abInput,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,attributeC,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeB);
        springLayout.putConstraint(SpringLayout.WEST,attributeC,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,acInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeB);
        springLayout.putConstraint(SpringLayout.WEST,acInput,0,SpringLayout.EAST,attributeC);
        springLayout.putConstraint(SpringLayout.EAST,acInput,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,origin,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeC);
        springLayout.putConstraint(SpringLayout.WEST,origin,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,originInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeC);
        springLayout.putConstraint(SpringLayout.WEST,originInput,0,SpringLayout.EAST,origin);
        springLayout.putConstraint(SpringLayout.EAST,originInput,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,date,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,origin);
        springLayout.putConstraint(SpringLayout.WEST,date,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,dateInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,origin);
        springLayout.putConstraint(SpringLayout.WEST,dateInput,0,SpringLayout.EAST,date);
        springLayout.putConstraint(SpringLayout.EAST,dateInput,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JLayeredView.jLayeredView.removeAll();
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearch,Integer.valueOf(800));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearchFieldOption,Integer.valueOf(600));
                JLayeredView.jLayeredView.add(JLayeredView.commodityViewPanel,Integer.valueOf(500));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(400));
            }
        });


        return commodityNew;
    }
}
