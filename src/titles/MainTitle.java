package titles;


import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;
import item.Conn;
import item.Fonts;
import item.ScreenSize;
import mainFrame.HelloUser;
import mainFrame.JLayeredTitle;
import mainFrame.JLayeredTop;
import mainFrame.JLayeredView;
import tables.tableItem.CommodityTableModel;
import titles.titleItem.TitleLabel;
import views.jlayeredCommodity.CommodityViewPanel;
import views.jlayeredCommodity.commoditySet.DisPlayColumn;
import views.jlayeredItem.CommoditySearchField;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainTitle {

    public static JPanel mainTitle;
    public static JLabel helloUserOpen;
    public static JLabel helloUserClose;
    public static JLabel helloUserHid;
    public static JLabel j0Logo;
    public static JLabel j1Commodity;
    public static JLabel j2Bill;
    public static JLabel j3Object;
    public static JLabel j4Account;
    public static JLabel j5Mission;
    public static JLabel j6Life;

    public static JTable allOwnedCommodityTable;
    public static JTableHeader commodityTableHeader;

    public JPanel mainTitle(){
        SpringLayout springLayout=new SpringLayout();   //实例化弹簧布局管理器
        mainTitle=new JPanel(springLayout);
        mainTitle.setOpaque(false);

        TitleLabel titleLabel=new TitleLabel();  //实例化菜单类

        //添加菜单项
        ImageIcon titleLogo=new ImageIcon("src/res/assets.png");
        int j0LogoWidth=titleLogo.getIconWidth();
        int j0LogoHeight=titleLogo.getIconHeight();
        titleLogo.setImage(titleLogo.getImage().getScaledInstance(ScreenSize.scr_width*8/100,(ScreenSize.scr_width*8/100)*j0LogoHeight/j0LogoWidth, Image.SCALE_AREA_AVERAGING));
        j0Logo=new JLabel(titleLogo);


        j1Commodity=titleLabel.titleLabel();
        j1Commodity.setText("商品");

        j2Bill=titleLabel.titleLabel();
        j2Bill.setText("单据");

        j3Object=titleLabel.titleLabel();
        j3Object.setText("对象");

        j4Account=titleLabel.titleLabel();
        j4Account.setText("账户");

        j5Mission=titleLabel.titleLabel();
        j5Mission.setText("任务");

        j6Life=titleLabel.titleLabel();
        j6Life.setText("| 生活");

        helloUserOpen =titleLabel.titleLabel();
        helloUserOpen.setText("");
        helloUserOpen.setForeground(new Color(255,255,255));
        helloUserOpen.setCursor(new Cursor(Cursor.HAND_CURSOR));

        helloUserClose =titleLabel.titleLabel();
        helloUserClose.setText("");
        helloUserClose.setForeground(new Color(255,255,255));
        helloUserClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        helloUserClose.setVisible(false);

        helloUserHid=titleLabel.titleLabel();
        helloUserHid.setVisible(false);

        //面板添加组件
        mainTitle.add(j0Logo);
        mainTitle.add(j1Commodity);
        mainTitle.add(j2Bill);
        mainTitle.add(j3Object);
        mainTitle.add(j4Account);
        mainTitle.add(j5Mission);
        mainTitle.add(j6Life);
        mainTitle.add(helloUserOpen);
        mainTitle.add(helloUserClose);

        //设置元素布局
        springLayout.putConstraint(SpringLayout.NORTH,j0Logo,ScreenSize.scr_height*15/1000,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.WEST,j0Logo,ScreenSize.scr_width*5/100,SpringLayout.WEST,mainTitle);

        springLayout.putConstraint(SpringLayout.NORTH,j1Commodity, ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.WEST,j1Commodity,ScreenSize.scr_width*4/100,SpringLayout.EAST,j0Logo);

        springLayout.putConstraint(SpringLayout.NORTH,j2Bill,ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.WEST,j2Bill,ScreenSize.scr_width*4/100,SpringLayout.EAST,j1Commodity);

        springLayout.putConstraint(SpringLayout.NORTH,j3Object,ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.WEST,j3Object,ScreenSize.scr_width*4/100,SpringLayout.EAST,j2Bill);

        springLayout.putConstraint(SpringLayout.NORTH,j4Account,ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.WEST,j4Account,ScreenSize.scr_width*4/100,SpringLayout.EAST,j3Object);

        springLayout.putConstraint(SpringLayout.NORTH,j5Mission,ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.WEST,j5Mission,ScreenSize.scr_width*4/100,SpringLayout.EAST,j4Account);

        springLayout.putConstraint(SpringLayout.NORTH,j6Life,ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.WEST,j6Life,ScreenSize.scr_width*8/100,SpringLayout.EAST,j5Mission);

        springLayout.putConstraint(SpringLayout.NORTH, helloUserOpen,ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.EAST, helloUserOpen,-ScreenSize.scr_width*5/100,SpringLayout.EAST,mainTitle);

        springLayout.putConstraint(SpringLayout.NORTH, helloUserClose,ScreenSize.scr_height*2/100,SpringLayout.NORTH,mainTitle);
        springLayout.putConstraint(SpringLayout.EAST, helloUserClose,-ScreenSize.scr_width*5/100,SpringLayout.EAST,mainTitle);

        j1Commodity.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                JLayeredTop.light.setVisible(true);
                JLayeredTitle.light.setVisible(true);
                JLayeredView.light.setVisible(true);
                JLayeredView.jLayeredView.removeAll();
                CommodityViewPanel.tableHeadPanel.removeAll();
                CommodityViewPanel.backPanel.removeAll();

                String sql="SELECT * FROM kcb ORDER BY brand";
                CommodityTableModel ctm=new CommodityTableModel();
                allOwnedCommodityTable=ctm.commodityTableModel(sql);

                commodityTableHeader= allOwnedCommodityTable.getTableHeader();
                commodityTableHeader.setFont(Fonts.getFontH5Standard());

                CommodityViewPanel.backPanel.add(allOwnedCommodityTable);
                CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                allOwnedCommodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);

                JLayeredView.jLayeredView.add(JLayeredView.commoditySearch,Integer.valueOf(800));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(700));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearchFieldOption,Integer.valueOf(600));
                JLayeredView.jLayeredView.add(JLayeredView.commodityViewPanel,Integer.valueOf(500));


                CommoditySearchField.commoditySearchField.setText(null);
                CommoditySearchField.brandChoiceOpen.setVisible(false);
                JLayeredView.commoditySearch.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);

            }
        });

        helloUserOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                HelloUser.helloUserPanel.setVisible(true);
                helloUserOpen.setVisible(false);
                helloUserClose.setVisible(true);
            }
        });

        helloUserClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                helloUserClose.setVisible(false);
                helloUserOpen.setVisible(true);
                HelloUser.helloUserPanel.setVisible(false);
            }
        });

        return mainTitle;
    }

}
