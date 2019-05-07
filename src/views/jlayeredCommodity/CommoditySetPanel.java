package views.jlayeredCommodity;


import item.Fonts;
import item.ScreenSize;
import mainFrame.JLayeredView;
import tables.tableItem.CommodityTableModel;
import views.jlayeredCommodity.commoditySet.ClassBinding;
import views.jlayeredCommodity.commoditySet.DisPlayColumn;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommoditySetPanel {
    public static JPanel disPlayColumn;
    public static JPanel classBinding;

    public JPanel commoditySetPanel(){
        JPanel commoditySetPanel;

        SpringLayout springLayout=new SpringLayout();
        commoditySetPanel=new JPanel(springLayout);

        //面板退出按钮
        JLabel exit=new JLabel("×",SwingConstants.CENTER);
        exit.setFont(Fonts.getSymbolHmax());
        exit.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*3/100));
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        DisPlayColumn dsc=new DisPlayColumn();
        disPlayColumn=dsc.disPlayColumn();
        disPlayColumn.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));

        ClassBinding cbd=new ClassBinding();
        classBinding=cbd.classBinding();
        classBinding.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));

        commoditySetPanel.add(exit);
        commoditySetPanel.add(disPlayColumn);
        commoditySetPanel.add(classBinding);

        springLayout.putConstraint(SpringLayout.NORTH,exit,ScreenSize.scr_height/100,SpringLayout.NORTH,commoditySetPanel);
        springLayout.putConstraint(SpringLayout.EAST,exit,-ScreenSize.scr_width/100,SpringLayout.EAST,commoditySetPanel);

        springLayout.putConstraint(SpringLayout.NORTH,disPlayColumn,0,SpringLayout.SOUTH,exit);
        springLayout.putConstraint(SpringLayout.WEST,disPlayColumn,0,SpringLayout.WEST,commoditySetPanel);
        springLayout.putConstraint(SpringLayout.EAST,disPlayColumn,0,SpringLayout.EAST,commoditySetPanel);

        springLayout.putConstraint(SpringLayout.NORTH,classBinding,0,SpringLayout.SOUTH,disPlayColumn);
        springLayout.putConstraint(SpringLayout.WEST,classBinding,0,SpringLayout.WEST,commoditySetPanel);
        springLayout.putConstraint(SpringLayout.EAST,classBinding,0,SpringLayout.EAST,commoditySetPanel);



        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                JLayeredView.jLayeredView.removeAll();
                CommodityViewPanel.tableHeadPanel.removeAll();
                CommodityViewPanel.backPanel.removeAll();

                DisPlayColumn.disPlayColumnOpen.setVisible(true);
                DisPlayColumn.disPlayColumnClose.setVisible(false);
                DisPlayColumn.disPlayColumn.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));

                String sql="SELECT * FROM kcb ORDER BY brand";
                CommodityTableModel ctm=new CommodityTableModel();
                JTable allOwnedCommodityTable=ctm.commodityTableModel(sql);

                JTableHeader commodityTableHeader= allOwnedCommodityTable.getTableHeader();
                commodityTableHeader.setFont(Fonts.getFontH5Standard());

                CommodityViewPanel.backPanel.add(allOwnedCommodityTable);
                CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);
                allOwnedCommodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);

                JLayeredView.jLayeredView.add(JLayeredView.commoditySearch,Integer.valueOf(800));
                JLayeredView.jLayeredView.add(JLayeredView.commoditySearchFieldOption,Integer.valueOf(600));
                JLayeredView.jLayeredView.add(JLayeredView.commodityViewPanel,Integer.valueOf(500));
                JLayeredView.jLayeredView.add(JLayeredView.light,Integer.valueOf(400));

            }
        });

        return commoditySetPanel;
    }
}
