package views.jlayeredItem;


import item.Fonts;
import item.ScreenSize;
import mainFrame.JLayeredTitle;
import mainFrame.JLayeredTop;
import mainFrame.JLayeredView;
import tables.TopVolume6Table;
import views.jlayeredCommodity.CommodityViewPanel;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class CommoditySearchField {

    public static JPanel jPanel;
    public static JTextField commoditySearchField;
    public static JLabel brandChoiceOpen;
    public static JLabel brandChoiceClose;
    public static JPanel brandPanel;
    public static JPanel topVolume6Panel;
    public static JTable topVolume6Table;
    public static JLabel emptyLabel;
    public static JLabel hasLabel;


    public JPanel commoditySearch(){
        class CommoditySearchBorder extends AbstractBorder {  //创建内部边框类继承边框抽象类
            private final Color borderColor = new Color(255, 69, 0);  //设置边框颜色
            private int[]xs={ScreenSize.scr_width*18/100, ScreenSize.scr_width*23/100, ScreenSize.scr_width*24/100, ScreenSize.scr_width*52/100, ScreenSize.scr_width*52/100, ScreenSize.scr_width*18/100};   //声明多边形填充绘图 x 轴坐标数组
            private int[]ys={ScreenSize.scr_height*2/100, ScreenSize.scr_height*2/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*10/100, ScreenSize.scr_height*10/100};   //声明多边形填充绘图 y 轴坐标数组
            private int[]xu={ScreenSize.scr_width*235/1000, ScreenSize.scr_width*285/1000, ScreenSize.scr_width*295/1000, ScreenSize.scr_width*235/1000};   //声明多边形空心绘图 x 轴坐标数组
            private int[]yu={ScreenSize.scr_height*2/100, ScreenSize.scr_height*2/100, ScreenSize.scr_height*6/100, ScreenSize.scr_height*6/100};  //声明多边形空心绘图 y 轴坐标数组

            //图形绘制方法
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
                Graphics2D g2d=(Graphics2D)g;
                g2d.setColor(new Color(255,255,255,255));  //设置图形填充颜色
                g2d.fillPolygon(xs,ys,6);  //设置图形坐标和顶点
                g2d.drawPolygon(xu,yu,4);
                g2d.setColor(borderColor);  //设置图形边框颜色

            }
        }

        class CommoditySearchBorder2 extends AbstractBorder{
            private final Color borderColor = new Color(255, 69, 0);  //设置边框颜色
            private int[]xs={ScreenSize.scr_width*18/100, ScreenSize.scr_width*235/1000, ScreenSize.scr_width*235/1000, ScreenSize.scr_width*285/1000, ScreenSize.scr_width*295/1000, ScreenSize.scr_width*52/100, ScreenSize.scr_width*52/100, ScreenSize.scr_width*18/100};   //声明多边形填充绘图 x 轴坐标数组
            private int[]ys={ScreenSize.scr_height*5/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*2/100, ScreenSize.scr_height*2/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*10/100, ScreenSize.scr_height*10/100};   //声明多边形填充绘图 y 轴坐标数组
            private int[]xu={ScreenSize.scr_width*18/100, ScreenSize.scr_width*23/100, ScreenSize.scr_width*24/100, ScreenSize.scr_width*18/100};   //声明多边形空心绘图 x 轴坐标数组
            private int[]yu={ScreenSize.scr_height*2/100, ScreenSize.scr_height*2/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*5/100};  //声明多边形空心绘图 y 轴坐标数组

            public void paintBorder(Component c,Graphics g,int x,int y,int width,int height){
                Graphics2D g2d=(Graphics2D)g;
                g2d.setColor(new Color(255,255,255,255));
                g2d.fillPolygon(xs,ys,8);
                g2d.drawPolygon(xu,yu,4);
                g2d.setColor(borderColor);
            }
        }

        //产品选择模块面板
        jPanel=new JPanel();  //实例化面板对象
        jPanel.setLayout(null);  //图形坐标改变麻烦，取消布局管理器采用自由布局
        jPanel.setOpaque(false);  //设置面板透明
        jPanel.setBorder(new CommoditySearchBorder());  //绘制图形


        //品牌选择按钮1
        brandChoiceOpen =new JLabel("",SwingConstants.CENTER);
        brandChoiceOpen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        brandChoiceOpen.setVisible(false);
        brandChoiceOpen.setBorder(new LineBorder(new Color(229,229,229),1));
        brandChoiceOpen.setBounds(ScreenSize.scr_width*42/100, ScreenSize.scr_height*5/100-1, ScreenSize.scr_height*15/100, ScreenSize.scr_height*5/100+2);
        brandChoiceOpen.setFont(Fonts.getFontStandard());

        //品牌选择按钮2
        brandChoiceClose =new JLabel("",SwingConstants.CENTER);
        brandChoiceClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        brandChoiceClose.setVisible(false);
        brandChoiceClose.setBorder(new LineBorder(new Color(229,229,229),1));
        brandChoiceClose.setBounds(ScreenSize.scr_width*42/100, ScreenSize.scr_height*5/100-1, ScreenSize.scr_height*15/100, ScreenSize.scr_height*5/100+2);
        brandChoiceClose.setFont(Fonts.getFontStandard());
        brandChoiceClose.setBackground(Color.PINK);
        brandChoiceClose.setOpaque(true);


        //品牌选择面板
        brandPanel=new JPanel();
        brandPanel.setBounds(ScreenSize.scr_width*30/100,ScreenSize.scr_height*11/100,ScreenSize.scr_width*22/100,ScreenSize.scr_height*70/100);
        brandPanel.setLayout(null);
        brandPanel.setVisible(false);

        //数据选项面板
        topVolume6Panel=new JPanel();
        topVolume6Panel.setLayout(null);
        topVolume6Panel.setBounds(ScreenSize.scr_width*18/100,ScreenSize.scr_height*10/100,ScreenSize.scr_width*34/100,ScreenSize.scr_height*34/100);
        topVolume6Panel.setVisible(false);


        //产品输入框
        commoditySearchField=new JTextField();
        commoditySearchField.setBorder(new EmptyBorder(0,ScreenSize.scr_width/100,0,ScreenSize.scr_width/100));  //设置输入文本边距
        commoditySearchField.setFont(Fonts.getFontH2Bold());
        commoditySearchField.setBounds(ScreenSize.scr_width*18/100, ScreenSize.scr_height*5/100, ScreenSize.scr_width*24/100, ScreenSize.scr_height*5/100);  //设置文本输入框尺寸，尽量以120的倍数建立

        //选择输入按钮
        JLabel selectLabel=new JLabel("触控搜索",SwingConstants.CENTER);  //实例化搜索框标题文本
        selectLabel.setBounds(ScreenSize.scr_width*237/1000, ScreenSize.scr_height*2/100, ScreenSize.scr_width*5/100, ScreenSize.scr_height*3/100);
        selectLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectLabel.setFont(Fonts.getFontStandard());

        //键盘输入按钮
        JLabel titleLabel=new JLabel("键入搜索",SwingConstants.CENTER);
        titleLabel.setFont(Fonts.getFontStandard());
        titleLabel.setBounds(ScreenSize.scr_width*18/100, ScreenSize.scr_height*2/100, ScreenSize.scr_width*55/1000, ScreenSize.scr_height*3/100);


        //购物车(空)
        ImageIcon emptyIcon=new ImageIcon("src/res/390940.png");
        emptyIcon.setImage(emptyIcon.getImage().getScaledInstance(ScreenSize.scr_width*3/100,ScreenSize.scr_width*3/100,Image.SCALE_AREA_AVERAGING));
        emptyLabel=new JLabel(" 0",emptyIcon,SwingConstants.CENTER);
        emptyLabel.setFont(Fonts.getFontH2Bold());
        emptyLabel.setVerticalTextPosition(JLabel.CENTER);
        emptyLabel.setHorizontalTextPosition(JLabel.RIGHT);
        emptyLabel.setBounds(ScreenSize.scr_width*60/100,ScreenSize.scr_height*5/100,ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100);

        //购物车(有)
        ImageIcon hasIcon=new ImageIcon("src/res/390939.png");
        hasIcon.setImage(hasIcon.getImage().getScaledInstance(ScreenSize.scr_width*3/100,ScreenSize.scr_width*3/100,Image.SCALE_AREA_AVERAGING));
        hasLabel=new JLabel(" 222222",hasIcon,SwingConstants.CENTER);
        hasLabel.setFont(Fonts.getFontH2Bold());
        hasLabel.setVerticalTextPosition(JLabel.CENTER);
        hasLabel.setHorizontalTextPosition(JLabel.RIGHT);
        hasLabel.setBounds(ScreenSize.scr_width*60/100,ScreenSize.scr_height*5/100,ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100);
        hasLabel.setVisible(false);

        //面板退出按钮
        JLabel exit=new JLabel("×",SwingConstants.CENTER);
        exit.setFont(Fonts.getSymbolHmax());
        exit.setBounds(ScreenSize.scr_width*90/100,ScreenSize.scr_height/100,ScreenSize.scr_width*5/100,ScreenSize.scr_height*3/100);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));


        jPanel.add(brandChoiceOpen);
        jPanel.add(brandChoiceClose);
        jPanel.add(brandPanel);
        jPanel.add(topVolume6Panel);
        jPanel.add(selectLabel);
        jPanel.add(titleLabel);
        jPanel.add(commoditySearchField);
        jPanel.add(emptyLabel);
        jPanel.add(hasLabel);
        jPanel.add(exit);



        if (ScreenSize.scr_width>=2160){
            ImageIcon logo=new ImageIcon("src/res/Bing6.png");   //实例化并设置LOGO
            JLabel logoLabel=new JLabel(logo);
            logoLabel.setBounds(ScreenSize.scr_width*6/100, ScreenSize.scr_height*5/100, ScreenSize.scr_width*9/100, ScreenSize.scr_height*5/100);

            jPanel.add(logoLabel);  //面板添加元素

        }else if(ScreenSize.scr_width<2160& ScreenSize.scr_width>=1600){

            //这里还没写

        }else if(ScreenSize.scr_width<1600){

            //这里还没写

        }

        TopVolume6Table tv6t=new TopVolume6Table();

        //添加文本框鼠标监听器
        commoditySearchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int i=e.getButton();
                if (i==MouseEvent.BUTTON1){

                    String s=CommoditySearchFieldOption.noZero.getText(); //获取非零选项内容
                    if(s.equals("不显示 0 库存产品")){
                        topVolume6Table=tv6t.topVolume6Table("SELECT * FROM kcb GROUP BY tradeName ORDER BY volume DESC LIMIT 6");
                    }else {
                        topVolume6Table=tv6t.topVolume6Table("SELECT * FROM kcb WHERE stock>0 GROUP BY tradeName ORDER BY volume DESC LIMIT 6");
                    }
                    topVolume6Panel.setVisible(true);
                    topVolume6Panel.add(topVolume6Table);   //搜索面板添加Top6表格
                    topVolume6Table.setBounds(0,0,ScreenSize.scr_width*34/100,ScreenSize.scr_height*34/100);
                    topVolume6Table.updateUI();

                    //都是必须的
                    JLayeredView.jLayeredView.setLayer(JLayeredView.light,700);
                    JLayeredView.commoditySearch.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);
                    JLayeredView.light.setVisible(true);  //光过滤层显示，聚焦文本输入框
                    JLayeredTop.light.setVisible(true);
                    JLayeredTitle.light.setVisible(true);
                    brandChoiceOpen.setText("全部品牌  ∨");
                    brandChoiceOpen.setVisible(false);   //品牌选择按键1消失
                    brandChoiceClose.setText("全部品牌  ∧");
                    brandChoiceClose.setVisible(false);   //品牌选择按键2消失
                    brandPanel.setVisible(false);   //品牌选择面板消失
                    //都是必须的
                }
            }

        });




        //设置面板鼠标监听器，点击面板则取消光过滤层显示
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                topVolume6Panel.removeAll();
                JLayeredView.jLayeredView.setLayer(JLayeredView.light,400);
                JLayeredView.commoditySearch.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height*10/100);
                brandPanel.setVisible(false);
                brandChoiceClose.setVisible(false);
                brandChoiceOpen.setVisible(true);
                String s=commoditySearchField.getText();
                if (s.equals("")){
                    brandChoiceOpen.setVisible(false);
                }

            }
        });

        selectLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                jPanel.setBorder(new CommoditySearchBorder2());
                selectLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                titleLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        titleLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                jPanel.setBorder(new CommoditySearchBorder());
                selectLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                titleLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        brandChoiceOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i=e.getButton();
                if (i==MouseEvent.BUTTON1){

                    topVolume6Panel.removeAll();
                    topVolume6Panel.setVisible(false);
                    brandPanel.setVisible(true);
                    brandChoiceOpen.setVisible(false);
                    brandChoiceClose.setVisible(true);
                    JLayeredView.commoditySearch.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);
                    JLayeredView.light.setVisible(true);  //光过滤层显示，聚焦文本输入框
                    JLayeredTop.light.setVisible(true);
                    JLayeredTitle.light.setVisible(true);
                }
            }
        });

        brandChoiceClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i=e.getButton();
                if (i==MouseEvent.BUTTON1){
                    brandPanel.setVisible(false);
                    brandChoiceOpen.setVisible(true);
                    brandChoiceClose.setVisible(false);

                }
            }
        });

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                JLayeredView.jLayeredView.removeAll();
                JLayeredView.jLayeredView.add(JLayeredView.helloUser,Integer.valueOf(400));
                JLayeredView.jLayeredView.add(JLayeredView.recommend,Integer.valueOf(300));
                JLayeredView.jLayeredView.setVisible(false);
                JLayeredView.jLayeredView.setVisible(true);
                JLayeredTop.light.setVisible(false);
                JLayeredTitle.light.setVisible(false);
                CommodityViewPanel.backPanel.removeAll();
                topVolume6Panel.setVisible(false);

            }
        });

        return jPanel;
    }


}
