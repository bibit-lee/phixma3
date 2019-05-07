package views.jlayeredItem;


import item.Fonts;
import item.ScreenSize;
import mainFrame.JLayeredView;
import tables.tableItem.CommodityTableModel;
import titles.MainTitle;
import views.jlayeredCommodity.CommodityViewPanel;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class CommoditySearchFieldOption {
    public static JLabel noZero;

    public JPanel commoditySearchFieldOption(){
        SpringLayout springLayout=new SpringLayout();
        JPanel commoditySearchFieldOption=new JPanel(springLayout);

        JLabel stockType=new JLabel("库存类型 ∨",SwingConstants.CENTER);
        stockType.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));
        stockType.setFont(Fonts.getFontStandard());
        stockType.setBackground(new Color(7,110,189));
        stockType.setOpaque(true);
        stockType.setForeground(Color.WHITE);

        noZero=new JLabel("不显示 0 库存产品",SwingConstants.CENTER);
        noZero.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));
        noZero.setBackground(new Color(7,110,189));
        noZero.setOpaque(true);
        noZero.setFont(Fonts.getFontStandard());
        noZero.setForeground(Color.WHITE);

        SharePanel sp=new SharePanel();
        JPanel sharePanel=sp.sharePanel();
        sharePanel.setPreferredSize(new Dimension(ScreenSize.scr_width*12/100,ScreenSize.scr_height*5/100));

        PrintPanel pp=new PrintPanel();
        JPanel printPanel=pp.printPanel();
        printPanel.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*5/100));

        JLabel setting=new JLabel("设置",SwingConstants.CENTER);
        setting.setForeground(Color.WHITE);
        setting.setFont(Fonts.getFontStandard());
        setting.setBackground(new Color(7,110,189));
        setting.setOpaque(true);
        setting.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,ScreenSize.scr_height*5/100));

        JLabel added=new JLabel("新增",SwingConstants.CENTER);
        added.setForeground(Color.WHITE);
        added.setFont(Fonts.getFontStandard());
        added.setBackground(new Color(7,110,189));
        added.setOpaque(true);
        added.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,ScreenSize.scr_height*5/100));


        commoditySearchFieldOption.add(stockType);
        commoditySearchFieldOption.add(noZero);
        commoditySearchFieldOption.add(sharePanel);
        commoditySearchFieldOption.add(printPanel);
        commoditySearchFieldOption.add(setting);
        commoditySearchFieldOption.add(added);

        springLayout.putConstraint(SpringLayout.NORTH,stockType,ScreenSize.scr_height*5/100,SpringLayout.NORTH,commoditySearchFieldOption);
        springLayout.putConstraint(SpringLayout.WEST,stockType,ScreenSize.scr_width/100,SpringLayout.WEST,commoditySearchFieldOption);

        springLayout.putConstraint(SpringLayout.NORTH,noZero,ScreenSize.scr_height*5/100,SpringLayout.NORTH,commoditySearchFieldOption);
        springLayout.putConstraint(SpringLayout.WEST,noZero,ScreenSize.scr_width*5/100,SpringLayout.EAST,stockType);

        springLayout.putConstraint(SpringLayout.NORTH,sharePanel,ScreenSize.scr_height*5/100,SpringLayout.NORTH,commoditySearchFieldOption);
        springLayout.putConstraint(SpringLayout.WEST,sharePanel,ScreenSize.scr_width*15/100,SpringLayout.EAST,noZero);

        springLayout.putConstraint(SpringLayout.NORTH,printPanel,ScreenSize.scr_height*5/100,SpringLayout.NORTH,commoditySearchFieldOption);
        springLayout.putConstraint(SpringLayout.WEST,printPanel,ScreenSize.scr_width*5/100,SpringLayout.EAST,sharePanel);

        springLayout.putConstraint(SpringLayout.NORTH,setting,ScreenSize.scr_height*5/100,SpringLayout.NORTH,commoditySearchFieldOption);
        springLayout.putConstraint(SpringLayout.WEST,setting,ScreenSize.scr_width*2/100,SpringLayout.EAST,printPanel);

        springLayout.putConstraint(SpringLayout.NORTH,added,ScreenSize.scr_height*5/100,SpringLayout.NORTH,commoditySearchFieldOption);
        springLayout.putConstraint(SpringLayout.WEST,added,ScreenSize.scr_width*2/100,SpringLayout.EAST,setting);


        noZero.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String zero=noZero.getText();
                String b= CommoditySearchField.brandChoiceOpen.getText();
                String n= CommoditySearchField.commoditySearchField.getText();


                if (zero.equals("不显示 0 库存产品")){
                    if(n.equals("")&b.equals("")){

                        String sql="SELECT * FROM kcb WHERE stock>0 ORDER BY brand";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable commodityTable=ctm.commodityTableModel(sql);
                        JTableHeader commodityTableHeader= commodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());
                        CommodityViewPanel.backPanel.removeAll();
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(commodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                        commodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        CommodityViewPanel.backPanel.updateUI();
                        CommodityViewPanel.tableHeadPanel.updateUI();
                    }else if(b.equals("全部品牌  ∨")){

                        String sql="SELECT * FROM kcb WHERE (tradeName LIKE'%"+n+"%' AND  stock>0) ORDER BY brand";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable commodityTable=ctm.commodityTableModel(sql);
                        JTableHeader commodityTableHeader= commodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());
                        CommodityViewPanel.backPanel.removeAll();
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(commodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                        commodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        CommodityViewPanel.backPanel.updateUI();
                        CommodityViewPanel.tableHeadPanel.updateUI();

                    }else {

                        String sql="SELECT * FROM kcb WHERE (tradeName LIKE'%"+n+"%' AND brand LIKE'%"+b+"%' AND stock>0) ORDER BY brand";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable commodityTable=ctm.commodityTableModel(sql);
                        JTableHeader commodityTableHeader= commodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());
                        CommodityViewPanel.backPanel.removeAll();
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(commodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                        commodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        CommodityViewPanel.backPanel.updateUI();
                        CommodityViewPanel.tableHeadPanel.updateUI();
                    }
                    noZero.setText("显示 0 库存产品");
                }else {
                    if(n.equals("")&b.equals("")){

                        String sql="SELECT * FROM kcb ORDER BY brand";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable commodityTable=ctm.commodityTableModel(sql);
                        JTableHeader commodityTableHeader= commodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());
                        CommodityViewPanel.backPanel.removeAll();
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(commodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                        commodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        CommodityViewPanel.backPanel.updateUI();
                        CommodityViewPanel.tableHeadPanel.updateUI();

                    }else if(b.equals("全部品牌  ∨")){

                        String sql="SELECT * FROM kcb WHERE tradeName LIKE'%"+n+"%' ORDER BY brand";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable commodityTable=ctm.commodityTableModel(sql);
                        JTableHeader commodityTableHeader= commodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());
                        CommodityViewPanel.backPanel.removeAll();
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(commodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                        commodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        CommodityViewPanel.backPanel.updateUI();
                        CommodityViewPanel.tableHeadPanel.updateUI();

                    }else {

                        String sql="SELECT * FROM kcb WHERE (tradeName LIKE'%"+n+"%' AND brand LIKE'%"+b+"%') ORDER BY brand";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable commodityTable=ctm.commodityTableModel(sql);
                        JTableHeader commodityTableHeader= commodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());
                        CommodityViewPanel.backPanel.removeAll();
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(commodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                        commodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        CommodityViewPanel.backPanel.updateUI();
                        CommodityViewPanel.tableHeadPanel.updateUI();
                    }
                    noZero.setText("不显示 0 库存产品");
                }
            }
        });

        setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                JLayeredView.jLayeredView.add(JLayeredView.commoditySetPanel,Integer.valueOf(900));
                JLayeredView.jLayeredView.setLayer(JLayeredView.light,800);
                JLayeredView.jLayeredView.setLayer(JLayeredView.commoditySearch,700);

            }
        });

        added.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JLayeredView.jLayeredView.removeAll();
                JLayeredView.jLayeredView.add(JLayeredView.commodityNew,Integer.valueOf(800));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(700));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearch,Integer.valueOf(600));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearchFieldOption,Integer.valueOf(500));
                JLayeredView.jLayeredView.add(JLayeredView.commodityViewPanel,Integer.valueOf(400));

                CommoditySearchNew.commodityNewTextField.requestFocus();
            }
        });



        return commoditySearchFieldOption;
    }
}
