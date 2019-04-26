package views.jlayeredCommodity;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import item.Conn;
import item.Fonts;
import item.Numbers;
import item.ScreenSize;
import mainFrame.JLayeredView;
import views.jlayeredItem.CommoditySearchField;
import views.jlayeredItem.SharePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class CommodityDetailPanel {

    public static JLabel commodityId;
    public static JLabel specialMark;
    public static JTextArea commodity;
    public static JLabel price;
    public static JLabel sellPriceA;
    public static JLabel sellPriceB;
    public static JLabel sellPriceC;
    public static JLabel priceName;
    public static JLabel priceNameA;
    public static JLabel priceNameB;
    public static JLabel priceNameC;
    public static JLabel picLabel;
    public static JLabel picLabel1;
    public static JLabel picLabel2;
    public static JLabel picLabel3;
    public static JLabel picLabel4;
    public static JLabel operationType;




    public JPanel commodityDetailPanel(){

        JPanel commodityDetailPanel;

        SpringLayout springLayout=new SpringLayout();
        commodityDetailPanel=new JPanel(springLayout);
        commodityDetailPanel.setBackground(Color.WHITE);

        //大图标签
        picLabel=new JLabel("",SwingConstants.CENTER);
        picLabel.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*40/100));


        //小图标签
        picLabel1 =new JLabel("",SwingConstants.CENTER);
        picLabel1.setPreferredSize(new Dimension(ScreenSize.scr_width*6/100,ScreenSize.scr_height*8/100));

        picLabel2=new JLabel("",SwingConstants.CENTER);
        picLabel2.setPreferredSize(new Dimension(ScreenSize.scr_width*6/100,ScreenSize.scr_height*8/100));

        picLabel3=new JLabel("",SwingConstants.CENTER);
        picLabel3.setPreferredSize(new Dimension(ScreenSize.scr_width*6/100,ScreenSize.scr_height*8/100));

        picLabel4=new JLabel("",SwingConstants.CENTER);
        picLabel4.setPreferredSize(new Dimension(ScreenSize.scr_width*6/100,ScreenSize.scr_height*8/100));

        JLabel left=new JLabel("<",SwingConstants.CENTER);
        left.setFont(Fonts.getFontH2Standard());
        left.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*8/100));

        JLabel right=new JLabel(">",SwingConstants.CENTER);
        right.setFont(Fonts.getFontH2Standard());
        right.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*8/100));

        //简介标签
        JLabel introduction=new JLabel();
        introduction.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*10/100));
        introduction.setBackground(Color.BLUE);  //test
        introduction.setOpaque(true);  //test

        //退出标签
        JLabel exit=new JLabel("×",SwingConstants.CENTER);
        exit.setFont(Fonts.getSymbolHmax());
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*3/100));

        JLabel setting=new JLabel("≡",SwingConstants.CENTER);
        setting.setFont(Fonts.getSymbolHmax());
        setting.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setting.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*3/100));


        //分享面板
        SharePanel sh=new SharePanel();
        JPanel share=sh.sharePanel();
        share.setPreferredSize(new Dimension(ScreenSize.scr_width*12/100,ScreenSize.scr_height*6/100));

        //特殊标记（优惠/新品/促销等信息）
        specialMark=new JLabel("",SwingConstants.CENTER);
        specialMark.setFont(Fonts.getFontStandard());
        specialMark.setForeground(Color.WHITE);
        specialMark.setBackground(new Color(16,124,16));
        specialMark.setOpaque(true);
        specialMark.setPreferredSize(new Dimension(ScreenSize.scr_width*9/100,ScreenSize.scr_height*3/100));


        //商品名称文本域
        commodity=new JTextArea();
        commodity.setFont(Fonts.getSymbolH0());
        commodity.setEditable(false);   //文本域禁止编辑
        commodity.setLineWrap(true);   //自动换行
        commodity.setWrapStyleWord(true);
        commodity.setPreferredSize(new Dimension(0,ScreenSize.scr_height*10/100));

        //隐藏的商品ID
        commodityId=new JLabel();

        //价格名称标签
        priceName=new JLabel("",SwingConstants.CENTER);
        priceName.setFont(Fonts.getFontStandard());
        priceName.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,ScreenSize.scr_height*5/100));

        priceNameA=new JLabel("",SwingConstants.CENTER);
        priceNameA.setFont(Fonts.getFontH5Standard());
        priceNameA.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*5/100));

        priceNameB=new JLabel("",SwingConstants.CENTER);
        priceNameB.setFont(Fonts.getFontH5Standard());
        priceNameB.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*5/100));

        priceNameC=new JLabel("",SwingConstants.CENTER);
        priceNameC.setFont(Fonts.getFontH5Standard());
        priceNameC.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*5/100));

        //价格标签
        price=new JLabel();
        price.setFont(Fonts.getSymbolH0());
        price.setForeground(new Color(218,59,1));
        price.setPreferredSize(new Dimension(0,ScreenSize.scr_height*5/100));

        sellPriceA=new JLabel();
        sellPriceA.setFont(Fonts.getFontStandard());
        sellPriceA.setForeground(new Color(218,59,1));
        sellPriceA.setPreferredSize(new Dimension(ScreenSize.scr_width*7/100,ScreenSize.scr_height*5/100));

        sellPriceB=new JLabel();
        sellPriceB.setFont(Fonts.getFontStandard());
        sellPriceB.setForeground(new Color(218,59,1));
        sellPriceB.setPreferredSize(new Dimension(ScreenSize.scr_width*7/100,ScreenSize.scr_height*5/100));

        sellPriceC=new JLabel();
        sellPriceC.setFont(Fonts.getFontStandard());
        sellPriceC.setForeground(new Color(218,59,1));
        sellPriceC.setPreferredSize(new Dimension(ScreenSize.scr_width*7/100,ScreenSize.scr_height*5/100));


        //购销明细标签
        JLabel details=new JLabel("购销明细",SwingConstants.CENTER);
        details.setBackground(new Color(58,156,215));
        details.setFont(Fonts.getFontStandard());
        details.setForeground(Color.WHITE);
        details.setOpaque(true);
        details.setPreferredSize(new Dimension(ScreenSize.scr_width*12/100,ScreenSize.scr_height*5/100));

        //分隔线
        JSeparator line=new JSeparator();


        //仓库分布
        SpringLayout dis_springLayout=new SpringLayout();
        JPanel distribution=new JPanel(dis_springLayout);
        distribution.setBackground(Color.PINK);
        distribution.setPreferredSize(new Dimension(0,ScreenSize.scr_height*15/100));

        //分隔线
        JSeparator line2=new JSeparator();

        //数量调整
        Numbers nbs=new Numbers();
        JPanel numbers=nbs.numbers();
        numbers.setPreferredSize(new Dimension(0,ScreenSize.scr_height*5/100));

        //操作类别
        operationType=new JLabel("",SwingConstants.CENTER);
        operationType.setBackground(new Color(16,124,16));
        operationType.setFont(Fonts.getFontStandard());
        operationType.setForeground(Color.WHITE);
        operationType.setOpaque(true);
        operationType.setCursor(new Cursor(Cursor.HAND_CURSOR));
        operationType.setPreferredSize(new Dimension(ScreenSize.scr_width*12/100,ScreenSize.scr_height*5/100));

        //加入操作台按钮
        JLabel console=new JLabel("加入操作台",SwingConstants.CENTER);
        console.setBackground(new Color(218,59,1));
        console.setFont(Fonts.getFontStandard());
        console.setForeground(Color.WHITE);
        console.setOpaque(true);
        console.setCursor(new Cursor(Cursor.HAND_CURSOR));
        console.setPreferredSize(new Dimension(ScreenSize.scr_width*12/100,ScreenSize.scr_height*5/100));

        //呼叫显示
        JPanel calls=new JPanel();

        commodityDetailPanel.add(picLabel);
        commodityDetailPanel.add(picLabel1);
        commodityDetailPanel.add(picLabel2);
        commodityDetailPanel.add(picLabel3);
        commodityDetailPanel.add(picLabel4);
        commodityDetailPanel.add(left);
        commodityDetailPanel.add(right);
        commodityDetailPanel.add(introduction);
        commodityDetailPanel.add(exit);
        commodityDetailPanel.add(setting);
        commodityDetailPanel.add(share);
        commodityDetailPanel.add(specialMark);
        commodityDetailPanel.add(commodity);
        commodityDetailPanel.add(price);
        commodityDetailPanel.add(sellPriceA);
        commodityDetailPanel.add(sellPriceB);
        commodityDetailPanel.add(sellPriceC);
        commodityDetailPanel.add(priceName);
        commodityDetailPanel.add(priceNameA);
        commodityDetailPanel.add(priceNameB);
        commodityDetailPanel.add(priceNameC);
        commodityDetailPanel.add(details);
        commodityDetailPanel.add(line);
        commodityDetailPanel.add(distribution);
        commodityDetailPanel.add(line2);
        commodityDetailPanel.add(numbers);
        commodityDetailPanel.add(operationType);
        commodityDetailPanel.add(console);
        commodityDetailPanel.add(calls);

        springLayout.putConstraint(SpringLayout.NORTH,picLabel,0,SpringLayout.NORTH,commodityDetailPanel);
        springLayout.putConstraint(SpringLayout.WEST,picLabel, 0,SpringLayout.WEST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH, left,0,SpringLayout.SOUTH,picLabel);
        springLayout.putConstraint(SpringLayout.WEST, left,ScreenSize.scr_width*5/100,SpringLayout.WEST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH, picLabel1,0,SpringLayout.SOUTH,picLabel);
        springLayout.putConstraint(SpringLayout.WEST, picLabel1,0,SpringLayout.EAST,left);

        springLayout.putConstraint(SpringLayout.NORTH, picLabel2,0,SpringLayout.SOUTH,picLabel);
        springLayout.putConstraint(SpringLayout.WEST, picLabel2,0,SpringLayout.EAST,picLabel1);

        springLayout.putConstraint(SpringLayout.NORTH, picLabel3,0,SpringLayout.SOUTH,picLabel);
        springLayout.putConstraint(SpringLayout.WEST, picLabel3,0,SpringLayout.EAST,picLabel2);

        springLayout.putConstraint(SpringLayout.NORTH, picLabel4,0,SpringLayout.SOUTH,picLabel);
        springLayout.putConstraint(SpringLayout.WEST, picLabel4,0,SpringLayout.EAST,picLabel3);

        springLayout.putConstraint(SpringLayout.NORTH, right,0,SpringLayout.SOUTH,picLabel);
        springLayout.putConstraint(SpringLayout.WEST, right,0,SpringLayout.EAST,picLabel4);

        springLayout.putConstraint(SpringLayout.NORTH,introduction,0,SpringLayout.SOUTH, picLabel1);
        springLayout.putConstraint(SpringLayout.WEST,introduction,0,SpringLayout.WEST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH,exit,0,SpringLayout.NORTH,commodityDetailPanel);
        springLayout.putConstraint(SpringLayout.EAST,exit,0,SpringLayout.EAST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH,setting,0,SpringLayout.NORTH,commodityDetailPanel);
        springLayout.putConstraint(SpringLayout.WEST,setting,0,SpringLayout.EAST,picLabel);

        springLayout.putConstraint(SpringLayout.NORTH,share,0,SpringLayout.NORTH,commodityDetailPanel);
        springLayout.putConstraint(SpringLayout.WEST,share,ScreenSize.scr_width*30/100,SpringLayout.EAST,setting);
        springLayout.putConstraint(SpringLayout.EAST,share,0,SpringLayout.WEST,exit);

        springLayout.putConstraint(SpringLayout.NORTH,specialMark,0,SpringLayout.SOUTH,share);
        springLayout.putConstraint(SpringLayout.WEST,specialMark,0,SpringLayout.EAST,picLabel);

        springLayout.putConstraint(SpringLayout.NORTH,commodity,0,SpringLayout.SOUTH,specialMark);
        springLayout.putConstraint(SpringLayout.WEST,commodity,0,SpringLayout.EAST,picLabel);
        springLayout.putConstraint(SpringLayout.EAST,commodity,-ScreenSize.scr_width*10/100,SpringLayout.EAST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH,priceName,0,SpringLayout.SOUTH,commodity);
        springLayout.putConstraint(SpringLayout.WEST,priceName,0,SpringLayout.EAST,picLabel);

        springLayout.putConstraint(SpringLayout.NORTH,price,0,SpringLayout.SOUTH,commodity);
        springLayout.putConstraint(SpringLayout.WEST,price,0,SpringLayout.EAST,priceName);
        springLayout.putConstraint(SpringLayout.EAST,price,0,SpringLayout.WEST,details);

        springLayout.putConstraint(SpringLayout.NORTH,priceNameA,0,SpringLayout.SOUTH,priceName);
        springLayout.putConstraint(SpringLayout.WEST,priceNameA,0,SpringLayout.EAST,picLabel);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceA,0,SpringLayout.SOUTH,priceName);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceA,0,SpringLayout.EAST,priceNameA);

        springLayout.putConstraint(SpringLayout.NORTH,priceNameB,0,SpringLayout.SOUTH,priceName);
        springLayout.putConstraint(SpringLayout.WEST,priceNameB,0,SpringLayout.EAST,sellPriceA);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceB,0,SpringLayout.SOUTH,priceName);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceB,0,SpringLayout.EAST,priceNameB);

        springLayout.putConstraint(SpringLayout.NORTH,priceNameC,0,SpringLayout.SOUTH,priceName);
        springLayout.putConstraint(SpringLayout.WEST,priceNameC,0,SpringLayout.EAST,sellPriceB);

        springLayout.putConstraint(SpringLayout.NORTH,sellPriceC,0,SpringLayout.SOUTH,priceName);
        springLayout.putConstraint(SpringLayout.WEST,sellPriceC,0,SpringLayout.EAST,priceNameC);
        springLayout.putConstraint(SpringLayout.EAST,sellPriceC,0,SpringLayout.WEST,details);

        springLayout.putConstraint(SpringLayout.NORTH,details,0,SpringLayout.SOUTH,commodity);
        springLayout.putConstraint(SpringLayout.EAST,details,-ScreenSize.scr_width*5/100,SpringLayout.EAST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH,line,20,SpringLayout.SOUTH,sellPriceA);
        springLayout.putConstraint(SpringLayout.WEST,line,0,SpringLayout.EAST,picLabel);
        springLayout.putConstraint(SpringLayout.EAST,line,0,SpringLayout.EAST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH,distribution,20,SpringLayout.SOUTH,line);
        springLayout.putConstraint(SpringLayout.WEST,distribution,0,SpringLayout.EAST,picLabel);
        springLayout.putConstraint(SpringLayout.EAST,distribution,0,SpringLayout.EAST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH,line2,20,SpringLayout.SOUTH,distribution);
        springLayout.putConstraint(SpringLayout.WEST,line2,0,SpringLayout.EAST,picLabel);
        springLayout.putConstraint(SpringLayout.EAST,line2,0,SpringLayout.EAST,commodityDetailPanel);

        springLayout.putConstraint(SpringLayout.NORTH,numbers,20,SpringLayout.SOUTH,line2);
        springLayout.putConstraint(SpringLayout.WEST,numbers,0,SpringLayout.EAST,picLabel);
        springLayout.putConstraint(SpringLayout.EAST,numbers,0,SpringLayout.WEST,operationType);

        springLayout.putConstraint(SpringLayout.NORTH,operationType,20,SpringLayout.SOUTH,line2);
        springLayout.putConstraint(SpringLayout.EAST,operationType,-ScreenSize.scr_width*5/100,SpringLayout.WEST,console);

        springLayout.putConstraint(SpringLayout.NORTH,console,20,SpringLayout.SOUTH,line2);
        springLayout.putConstraint(SpringLayout.EAST,console,-ScreenSize.scr_width*5/100,SpringLayout.EAST,commodityDetailPanel);


        console.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                //连接数据库
                Conn a=new Conn();
                Connection conn=a.getCon();
                String type=operationType.getText();  //获取商品操作类型
                String id=commodityId.getText();  //获取商品ID
                String quantity=Numbers.amount.getText();  //获取商品操作数量
                //执行雷同退出操作
                JLayeredView.jLayeredView.removeAll();
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearch,Integer.valueOf(800));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearchFieldOption,Integer.valueOf(600));
                JLayeredView.jLayeredView.add(JLayeredView.commodityViewPanel,Integer.valueOf(500));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(400));
                Numbers.amount.setText("1");

                //变换操作台图标和数量状态
                CommoditySearchField.emptyLabel.setVisible(false);
                CommoditySearchField.hasLabel.setVisible(true);

                //写入操作台临时数据表
                try {
                    Statement stmt=conn.createStatement();
                    stmt.execute("INSERT INTO console_list(type,quantity,id)VALUES ('"+type+"','"+quantity+"','"+id+"')");
                    Statement getStmt=conn.createStatement();
                    ResultSet sumRes=getStmt.executeQuery("SELECT SUM(quantity)FROM console_list");
                    while (sumRes.next()){
                        String sum=sumRes.getString(1);
                        CommoditySearchField.hasLabel.setText(sum+" 件");
                    }

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }

        });

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JLayeredView.jLayeredView.removeAll();
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearch,Integer.valueOf(800));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearchFieldOption,Integer.valueOf(600));
                JLayeredView.jLayeredView.add(JLayeredView.commodityViewPanel,Integer.valueOf(500));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(400));
                Numbers.amount.setText("1");
            }
        });

        commodityDetailPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (Numbers.amount.getText().equals("")||Numbers.amount.getText().startsWith("0")){
                    Numbers.amount.setText("1");
                }
            }
        });

        return commodityDetailPanel;
    }




}
