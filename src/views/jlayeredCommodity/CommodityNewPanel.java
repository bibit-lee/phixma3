package views.jlayeredCommodity;



import item.Fonts;
import item.ScreenSize;
import mainFrame.JLayeredView;
import views.jlayeredCommodity.commodityNew.CommodityNewComboBox;
import views.jlayeredItem.CommoditySearchNew;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommodityNewPanel {
    public static JPanel commodityNew;
    public static JPanel commoditySearchNew;
    public static JPanel searchResult;
    public static JPanel selectionA;
    public static JPanel selectionB;
    public static JPanel selectionC;
    public static JComboBox<String> nameInput;
    public static JComboBox<String> brandInput;
    public static JComboBox<String> originInput;
    public static JComboBox<String> aaInput;
    public static JComboBox<String> abInput;
    public static JComboBox<String> acInput;
    public static JComboBox<String> dateInput;


    public JPanel commodityNew(){

        SpringLayout springLayout=new SpringLayout();
        commodityNew=new JPanel(springLayout);
        commodityNew.setBackground(Color.WHITE);


        JLabel exit=new JLabel("×",SwingConstants.CENTER);
        exit.setFont(Fonts.getSymbolHmax());
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,ScreenSize.scr_height*3/100));

        ImageIcon commodityNewRightPic=new ImageIcon("src/res/commodityNew_right.png");
        commodityNewRightPic.setImage(commodityNewRightPic.getImage().getScaledInstance(ScreenSize.scr_width*40/100,ScreenSize.scr_height*80/100,Image.SCALE_AREA_AVERAGING));
        JLabel commodityNewRightLabel=new JLabel(commodityNewRightPic);
        commodityNewRightLabel.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*80/100));


        CommoditySearchNew csn=new CommoditySearchNew();
        commoditySearchNew=csn.commoditySearchNew();
        commoditySearchNew.setBackground(Color.WHITE);
        commoditySearchNew.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*12/100));



        JLabel selectNameA=new JLabel("分类A:",SwingConstants.CENTER);
        selectNameA.setFont(Fonts.getFontStandard());
        selectNameA.setOpaque(true);
        selectNameA.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,0));

        JLabel selectNameB=new JLabel("分类B:",SwingConstants.CENTER);
        selectNameB.setFont(Fonts.getFontStandard());
        selectNameB.setOpaque(true);
        selectNameB.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,0));


        JLabel selectNameC=new JLabel("分类C:",SwingConstants.CENTER);
        selectNameC.setFont(Fonts.getFontStandard());
        selectNameC.setOpaque(true);
        selectNameC.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,0));


        JLabel selectResultName=new JLabel("搜索结果 >",SwingConstants.CENTER);
        selectResultName.setFont(Fonts.getFontH5Standard());
        selectResultName.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,0));


        //分类面板A
        FlowLayout flowLayoutA=new FlowLayout();
        flowLayoutA.setHgap(ScreenSize.scr_width*3/100); //设置面板组件横向边距
        selectionA=new JPanel(flowLayoutA);
        selectionA.setBackground(Color.WHITE);
        selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*35/100,0));

        FlowLayout flowLayoutB=new FlowLayout();
        flowLayoutB.setHgap(ScreenSize.scr_width*3/100);
        selectionB=new JPanel(flowLayoutB);
        selectionB.setBackground(Color.WHITE);
        selectionB.setPreferredSize(new Dimension(ScreenSize.scr_width*35/100,0));

        FlowLayout flowLayoutC=new FlowLayout();
        flowLayoutC.setHgap(ScreenSize.scr_width*3/100);
        selectionC=new JPanel(flowLayoutC);
        selectionC.setBackground(Color.WHITE);
        selectionC.setPreferredSize(new Dimension(ScreenSize.scr_width*35/100,0));

        //搜索结果面板
        FlowLayout flowLayoutResult=new FlowLayout();
        flowLayoutResult.setHgap(ScreenSize.scr_width*3/100); //设置面板组件横向边距
        searchResult=new JPanel(flowLayoutResult);
        searchResult.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));
        searchResult.setBackground(Color.WHITE);

        JLabel name=new JLabel("商品名称:",SwingConstants.CENTER);
        name.setFont(Fonts.getFontStandard());
        name.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));

        CommodityNewComboBox cNcb=new CommodityNewComboBox();

        nameInput=cNcb.commodityNewComboBox();
        nameInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel brand=new JLabel("商品品牌:",SwingConstants.CENTER);
        brand.setFont(Fonts.getFontStandard());
        brand.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));

        brandInput=cNcb.commodityNewComboBox();
        brandInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel origin=new JLabel("产地:",SwingConstants.CENTER);
        origin.setFont(Fonts.getFontStandard());
        origin.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));

        originInput=cNcb.commodityNewComboBox();
        originInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel attributeA=new JLabel("属性A:",SwingConstants.CENTER);
        attributeA.setFont(Fonts.getFontStandard());
        attributeA.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));

        aaInput=cNcb.commodityNewComboBox();
        aaInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel attributeB=new JLabel("属性B:",SwingConstants.CENTER);
        attributeB.setFont(Fonts.getFontStandard());
        attributeB.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));


        abInput=cNcb.commodityNewComboBox();
        abInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel attributeC=new JLabel("属性C:",SwingConstants.CENTER);
        attributeC.setFont(Fonts.getFontStandard());
        attributeC.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));

        acInput=cNcb.commodityNewComboBox();
        acInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));

        JLabel date=new JLabel("生产批次:",SwingConstants.CENTER);
        date.setFont(Fonts.getFontStandard());
        date.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*4/100));

        dateInput=cNcb.commodityNewComboBox();
        dateInput.setPreferredSize(new Dimension(ScreenSize.scr_width*30/100,ScreenSize.scr_height*4/100));


        JLabel save=new JLabel("保存商品",SwingConstants.CENTER);
        save.setFont(Fonts.getFontStandard());
        save.setForeground(Color.WHITE);
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        save.setPreferredSize(new Dimension(ScreenSize.scr_width*12/100,ScreenSize.scr_height*5/100));

        commodityNew.add(exit);
        commodityNew.add(commodityNewRightLabel);
        commodityNew.add(commoditySearchNew);
        commodityNew.add(selectNameA);
        commodityNew.add(selectNameB);
        commodityNew.add(selectNameC);
        commodityNew.add(selectResultName);
        commodityNew.add(selectionA);
        commodityNew.add(selectionB);
        commodityNew.add(selectionC);
        commodityNew.add(searchResult);
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

        springLayout.putConstraint(SpringLayout.NORTH,commodityNewRightLabel,0,SpringLayout.SOUTH,exit);
        springLayout.putConstraint(SpringLayout.EAST,commodityNewRightLabel,-ScreenSize.scr_width*3/100,SpringLayout.EAST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,commoditySearchNew,0,SpringLayout.NORTH,commodityNew);
        springLayout.putConstraint(SpringLayout.WEST,commoditySearchNew,0,SpringLayout.WEST,commodityNew);
        springLayout.putConstraint(SpringLayout.EAST,commoditySearchNew,0,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,selectionA,0,SpringLayout.SOUTH,commoditySearchNew);
        springLayout.putConstraint(SpringLayout.WEST,selectionA,0,SpringLayout.EAST,selectNameA);
        springLayout.putConstraint(SpringLayout.EAST,selectionA,0,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,selectNameA,0,SpringLayout.SOUTH,commoditySearchNew);
        springLayout.putConstraint(SpringLayout.WEST,selectNameA,0,SpringLayout.WEST,commodityNew);
        springLayout.putConstraint(SpringLayout.SOUTH,selectNameA,0,SpringLayout.SOUTH,selectionA);

        springLayout.putConstraint(SpringLayout.NORTH,selectionB,0,SpringLayout.SOUTH,selectionA);
        springLayout.putConstraint(SpringLayout.WEST,selectionB,0,SpringLayout.EAST,selectNameB);
        springLayout.putConstraint(SpringLayout.EAST,selectionB,0,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,selectNameB,0,SpringLayout.SOUTH,selectNameA);
        springLayout.putConstraint(SpringLayout.WEST,selectNameB,0,SpringLayout.WEST,commodityNew);
        springLayout.putConstraint(SpringLayout.SOUTH,selectNameB,0,SpringLayout.SOUTH,selectionB);

        springLayout.putConstraint(SpringLayout.NORTH,selectionC,0,SpringLayout.SOUTH,selectionB);
        springLayout.putConstraint(SpringLayout.WEST,selectionC,0,SpringLayout.EAST,selectNameC);
        springLayout.putConstraint(SpringLayout.EAST,selectionC,0,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,selectNameC,0,SpringLayout.SOUTH,selectNameB);
        springLayout.putConstraint(SpringLayout.WEST,selectNameC,0,SpringLayout.WEST,commodityNew);
        springLayout.putConstraint(SpringLayout.SOUTH,selectNameC,0,SpringLayout.SOUTH,selectionC);

        springLayout.putConstraint(SpringLayout.NORTH,searchResult,0,SpringLayout.SOUTH,selectionC);
        springLayout.putConstraint(SpringLayout.WEST,searchResult,0,SpringLayout.EAST,selectResultName);
        springLayout.putConstraint(SpringLayout.EAST,searchResult,0,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,selectResultName,0,SpringLayout.SOUTH,selectNameC);
        springLayout.putConstraint(SpringLayout.WEST,selectResultName,0,SpringLayout.WEST,commodityNew);
        springLayout.putConstraint(SpringLayout.SOUTH,selectResultName,0,SpringLayout.SOUTH,searchResult);

        springLayout.putConstraint(SpringLayout.NORTH,brand,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,searchResult);
        springLayout.putConstraint(SpringLayout.WEST,brand,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,brandInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,searchResult);
        springLayout.putConstraint(SpringLayout.WEST,brandInput,0,SpringLayout.EAST,brand);
        springLayout.putConstraint(SpringLayout.EAST,brandInput,-ScreenSize.scr_width*3/100,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,name,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,brand);
        springLayout.putConstraint(SpringLayout.WEST,name,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,nameInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,brand);
        springLayout.putConstraint(SpringLayout.WEST,nameInput,0,SpringLayout.EAST,name);
        springLayout.putConstraint(SpringLayout.EAST,nameInput,-ScreenSize.scr_width*3/100,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,attributeA,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,name);
        springLayout.putConstraint(SpringLayout.WEST,attributeA,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,aaInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,name);
        springLayout.putConstraint(SpringLayout.WEST,aaInput,0,SpringLayout.EAST,attributeA);
        springLayout.putConstraint(SpringLayout.EAST,aaInput,-ScreenSize.scr_width*3/100,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,attributeB,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeA);
        springLayout.putConstraint(SpringLayout.WEST,attributeB,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,abInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeA);
        springLayout.putConstraint(SpringLayout.WEST,abInput,0,SpringLayout.EAST,attributeB);
        springLayout.putConstraint(SpringLayout.EAST,abInput,-ScreenSize.scr_width*3/100,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,attributeC,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeB);
        springLayout.putConstraint(SpringLayout.WEST,attributeC,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,acInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeB);
        springLayout.putConstraint(SpringLayout.WEST,acInput,0,SpringLayout.EAST,attributeC);
        springLayout.putConstraint(SpringLayout.EAST,acInput,-ScreenSize.scr_width*3/100,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,origin,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeC);
        springLayout.putConstraint(SpringLayout.WEST,origin,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,originInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,attributeC);
        springLayout.putConstraint(SpringLayout.WEST,originInput,0,SpringLayout.EAST,origin);
        springLayout.putConstraint(SpringLayout.EAST,originInput,-ScreenSize.scr_width*3/100,SpringLayout.WEST,commodityNewRightLabel);

        springLayout.putConstraint(SpringLayout.NORTH,date,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,origin);
        springLayout.putConstraint(SpringLayout.WEST,date,0,SpringLayout.WEST,commodityNew);

        springLayout.putConstraint(SpringLayout.NORTH,dateInput,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,origin);
        springLayout.putConstraint(SpringLayout.WEST,dateInput,0,SpringLayout.EAST,date);
        springLayout.putConstraint(SpringLayout.EAST,dateInput,-ScreenSize.scr_width*3/100,SpringLayout.WEST,commodityNewRightLabel);


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JLayeredView.jLayeredView.removeAll();
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearch,Integer.valueOf(800));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearchFieldOption,Integer.valueOf(600));
                JLayeredView.jLayeredView.add(JLayeredView.commodityViewPanel,Integer.valueOf(500));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(400));

                commoditySearchNew.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*12/100));
                selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,0));
                selectionB.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,0));
                selectionC.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,0));

                CommodityNewPanel.commoditySearchNew.updateUI();
                CommoditySearchNew.commodityNewTextField.setText(null);
                brandInput.removeAllItems();
                nameInput.removeAllItems();
                aaInput.removeAllItems();
                abInput.removeAllItems();
                acInput.removeAllItems();
                originInput.removeAllItems();
                dateInput.removeAllItems();
                searchResult.removeAll();
                selectionA.removeAll();
                selectionB.removeAll();
                selectionC.removeAll();
            }
        });



        return commodityNew;
    }


}
