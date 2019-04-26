package views.jlayeredCommodity.commoditySet;




import item.Conn;
import item.Fonts;
import item.ScreenSize;
import titles.MainTitle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;


public class DisPlayColumn {

    public static JPanel disPlayColumn;
    public static JLabel disPlayColumnOpen;
    public static JLabel disPlayColumnClose;
    public static JRadioButton brandBtn;
    public static JRadioButton originBtn;
    public static JRadioButton attributeABtn;
    public static JRadioButton attributeBBtn;
    public static JRadioButton attributeCBtn;
    public static JRadioButton dateBtn;
    public static JRadioButton costPriceBtn;
    public static JRadioButton sellPriceABtn;
    public static JRadioButton sellPriceBBtn;
    public static JRadioButton sellPriceCBtn;

    public JPanel disPlayColumn(){

        SpringLayout springLayout=new SpringLayout();
        disPlayColumn=new JPanel(springLayout);


        disPlayColumnOpen=new JLabel("显示列  ∨",SwingConstants.CENTER);
        disPlayColumnOpen.setFont(Fonts.getFontH2Bold());
        disPlayColumnOpen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        disPlayColumnOpen.setBackground(new Color(148,148,148));
        disPlayColumnOpen.setOpaque(true);
        disPlayColumnOpen.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*4/100));

        disPlayColumnClose=new JLabel("显示列  ∧",SwingConstants.CENTER);
        disPlayColumnClose.setFont(Fonts.getFontH2Bold());
        disPlayColumnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        disPlayColumnClose.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*4/100));
        disPlayColumnClose.setOpaque(true);
        disPlayColumnClose.setVisible(false);
        disPlayColumnClose.setBackground(new Color(216,59,1));


        ImageIcon titleOns=new ImageIcon("src/res/ON1.png");
        titleOns.setImage(titleOns.getImage().getScaledInstance(ScreenSize.scr_height*3/100,ScreenSize.scr_height*3/100,Image.SCALE_AREA_AVERAGING));

        ImageIcon titleOffs=new ImageIcon("src/res/Off1.png");
        titleOffs.setImage(titleOffs.getImage().getScaledInstance(ScreenSize.scr_height*3/100,ScreenSize.scr_height*3/100,Image.SCALE_AREA_AVERAGING));


        brandBtn=new JRadioButton("   品牌");
        brandBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        brandBtn.setFont(Fonts.getFontStandard());
        brandBtn.setForeground(new Color(52,52,52));
        brandBtn.setFocusPainted(false);
        brandBtn.setSelected(true);
        brandBtn.setIcon(titleOffs);
        brandBtn.setSelectedIcon(titleOns);

        originBtn=new JRadioButton("   产地");
        originBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        originBtn.setFont(Fonts.getFontStandard());
        originBtn.setForeground(new Color(52,52,52));
        originBtn.setFocusPainted(false);
        originBtn.setSelected(true);
        originBtn.setIcon(titleOffs);
        originBtn.setSelectedIcon(titleOns);

        attributeABtn=new JRadioButton("   属性A");
        attributeABtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        attributeABtn.setFont(Fonts.getFontStandard());
        attributeABtn.setForeground(new Color(52,52,52));
        attributeABtn.setFocusPainted(false);
        attributeABtn.setSelected(true);
        attributeABtn.setIcon(titleOffs);
        attributeABtn.setSelectedIcon(titleOns);

        attributeBBtn=new JRadioButton("   属性B");
        attributeBBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        attributeBBtn.setFont(Fonts.getFontStandard());
        attributeBBtn.setForeground(new Color(52,52,52));
        attributeBBtn.setFocusPainted(false);
        attributeBBtn.setSelected(true);
        attributeBBtn.setIcon(titleOffs);
        attributeBBtn.setSelectedIcon(titleOns);

        attributeCBtn=new JRadioButton("   属性C");
        attributeCBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        attributeCBtn.setFont(Fonts.getFontStandard());
        attributeCBtn.setForeground(new Color(52,52,52));
        attributeCBtn.setFocusPainted(false);
        attributeCBtn.setSelected(true);
        attributeCBtn.setIcon(titleOffs);
        attributeCBtn.setSelectedIcon(titleOns);

        dateBtn=new JRadioButton("   生产日期");
        dateBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        dateBtn.setFont(Fonts.getFontStandard());
        dateBtn.setForeground(new Color(52,52,52));
        dateBtn.setFocusPainted(false);
        dateBtn.setSelected(true);
        dateBtn.setIcon(titleOffs);
        dateBtn.setSelectedIcon(titleOns);

        costPriceBtn=new JRadioButton("   成本价");
        costPriceBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        costPriceBtn.setFont(Fonts.getFontStandard());
        costPriceBtn.setForeground(new Color(52,52,52));
        costPriceBtn.setFocusPainted(false);
        costPriceBtn.setSelected(true);
        costPriceBtn.setIcon(titleOffs);
        costPriceBtn.setSelectedIcon(titleOns);


        sellPriceABtn=new JRadioButton("   售价A");
        sellPriceABtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        sellPriceABtn.setFont(Fonts.getFontStandard());
        sellPriceABtn.setForeground(new Color(52,52,52));
        sellPriceABtn.setFocusPainted(false);
        sellPriceABtn.setSelected(true);
        sellPriceABtn.setIcon(titleOffs);
        sellPriceABtn.setSelectedIcon(titleOns);

        sellPriceBBtn=new JRadioButton("   售价B");
        sellPriceBBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        sellPriceBBtn.setFont(Fonts.getFontStandard());
        sellPriceBBtn.setForeground(new Color(52,52,52));
        sellPriceBBtn.setFocusPainted(false);
        sellPriceBBtn.setSelected(true);
        sellPriceBBtn.setIcon(titleOffs);
        sellPriceBBtn.setSelectedIcon(titleOns);

        sellPriceCBtn=new JRadioButton("   售价C");
        sellPriceCBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
        sellPriceCBtn.setFont(Fonts.getFontStandard());
        sellPriceCBtn.setForeground(new Color(52,52,52));
        sellPriceCBtn.setFocusPainted(false);
        sellPriceCBtn.setSelected(true);
        sellPriceCBtn.setIcon(titleOffs);
        sellPriceCBtn.setSelectedIcon(titleOns);

        springLayout.putConstraint(SpringLayout.NORTH,disPlayColumnOpen,0,SpringLayout.NORTH,disPlayColumn);
        springLayout.putConstraint(SpringLayout.WEST,disPlayColumnOpen,0,SpringLayout.WEST,disPlayColumn);
        springLayout.putConstraint(SpringLayout.EAST,disPlayColumnOpen,0,SpringLayout.EAST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,disPlayColumnClose,0,SpringLayout.NORTH,disPlayColumn);
        springLayout.putConstraint(SpringLayout.WEST,disPlayColumnClose,0,SpringLayout.WEST,disPlayColumn);
        springLayout.putConstraint(SpringLayout.EAST,disPlayColumnClose,0,SpringLayout.EAST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,brandBtn,0,SpringLayout.SOUTH,disPlayColumnOpen);
        springLayout.putConstraint(SpringLayout.WEST,brandBtn,ScreenSize.scr_width*5/100,SpringLayout.WEST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,originBtn,0,SpringLayout.SOUTH,brandBtn);
        springLayout.putConstraint(SpringLayout.WEST,originBtn,ScreenSize.scr_width*5/100,SpringLayout.WEST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,attributeABtn,0,SpringLayout.SOUTH,originBtn);
        springLayout.putConstraint(SpringLayout.WEST,attributeABtn,ScreenSize.scr_width*5/100,SpringLayout.WEST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,attributeBBtn,0,SpringLayout.SOUTH,attributeABtn);
        springLayout.putConstraint(SpringLayout.WEST,attributeBBtn,ScreenSize.scr_width*5/100,SpringLayout.WEST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,attributeCBtn,0,SpringLayout.SOUTH,attributeBBtn);
        springLayout.putConstraint(SpringLayout.WEST,attributeCBtn,ScreenSize.scr_width*5/100,SpringLayout.WEST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,dateBtn,0,SpringLayout.SOUTH,disPlayColumnOpen);
        springLayout.putConstraint(SpringLayout.WEST,dateBtn,ScreenSize.scr_width*5/100,SpringLayout.EAST,brandBtn);
        springLayout.putConstraint(SpringLayout.EAST,dateBtn,-ScreenSize.scr_width*5/100,SpringLayout.EAST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,costPriceBtn,0,SpringLayout.SOUTH,dateBtn);
        springLayout.putConstraint(SpringLayout.WEST,costPriceBtn,ScreenSize.scr_width*5/100,SpringLayout.EAST,brandBtn);
        springLayout.putConstraint(SpringLayout.EAST,costPriceBtn,-ScreenSize.scr_width*5/100,SpringLayout.EAST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceABtn,0,SpringLayout.SOUTH,costPriceBtn);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceABtn,ScreenSize.scr_width*5/100,SpringLayout.EAST,brandBtn);
        springLayout.putConstraint(SpringLayout.EAST,sellPriceABtn,-ScreenSize.scr_width*5/100,SpringLayout.EAST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceBBtn,0,SpringLayout.SOUTH,sellPriceABtn);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceBBtn,ScreenSize.scr_width*5/100,SpringLayout.EAST,brandBtn);
        springLayout.putConstraint(SpringLayout.EAST,sellPriceBBtn,-ScreenSize.scr_width*5/100,SpringLayout.EAST,disPlayColumn);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceCBtn,0,SpringLayout.SOUTH,sellPriceBBtn);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceCBtn,ScreenSize.scr_width*5/100,SpringLayout.EAST,brandBtn);
        springLayout.putConstraint(SpringLayout.EAST,sellPriceCBtn,-ScreenSize.scr_width*5/100,SpringLayout.EAST,disPlayColumn);



        disPlayColumn.add(disPlayColumnOpen);
        disPlayColumn.add(disPlayColumnClose);
        disPlayColumn.add(brandBtn);
        disPlayColumn.add(originBtn);
        disPlayColumn.add(attributeABtn);
        disPlayColumn.add(attributeBBtn);
        disPlayColumn.add(attributeCBtn);
        disPlayColumn.add(dateBtn);
        disPlayColumn.add(costPriceBtn);
        disPlayColumn.add(sellPriceABtn);
        disPlayColumn.add(sellPriceBBtn);
        disPlayColumn.add(sellPriceCBtn);

        disPlayColumnOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                disPlayColumnOpen.setVisible(false);
                disPlayColumnClose.setVisible(true);
                disPlayColumn.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*30/100));

            }
        });

        disPlayColumnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                disPlayColumnOpen.setVisible(true);
                disPlayColumnClose.setVisible(false);
                disPlayColumn.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));
            }
        });

        Conn a=new Conn();
        Connection conn=a.getCon();

        brandBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_brand=0 WHERE common_id='"+s+"'");

                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_brand=1 WHERE common_id='"+s+"'");

                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });


        originBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_origin=0 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_origin=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        attributeABtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_attributeA=0 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_attributeA=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        attributeBBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_attributeB=0 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_attributeB=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        attributeCBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_attributeC=0 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_attributeC=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        dateBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_date=0 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET column_date=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        costPriceBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_costPrice=2 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_costPrice=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        sellPriceABtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_priceA=2 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_priceA=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        sellPriceBBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_priceB=2 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_priceB=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        sellPriceCBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state=e.getStateChange();
                String s= MainTitle.helloUserHid.getText();
                switch (state){
                    case ItemEvent.DESELECTED:
                        try {
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_priceC=2 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;

                    case ItemEvent.SELECTED:
                        try{
                            Statement statement=conn.createStatement();
                            statement.execute("UPDATE permission_list SET sells_priceC=1 WHERE common_id='"+s+"'");
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });


        return disPlayColumn;
    }
}
