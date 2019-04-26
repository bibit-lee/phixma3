package views.jlayeredCommodity;





import item.Numbers;
import item.ScreenSize;
import tables.tableItem.CommodityTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CommodityViewPanel {
    public static JPanel commodityViewPanel;
    public static JPanel backPanel;
    public static JPanel tableHeadPanel;


    public JPanel commodityViewPanel(){

        SpringLayout springLayout=new SpringLayout();
        commodityViewPanel=new JPanel(springLayout);

        backPanel=new JPanel();
        backPanel.setLayout(null);

        tableHeadPanel=new JPanel();
        tableHeadPanel.setLayout(new BorderLayout());

        springLayout.putConstraint(SpringLayout.NORTH,tableHeadPanel,ScreenSize.scr_height*25/100,SpringLayout.NORTH,commodityViewPanel);
        springLayout.putConstraint(SpringLayout.WEST,tableHeadPanel,0,SpringLayout.WEST,commodityViewPanel);
        springLayout.putConstraint(SpringLayout.EAST,tableHeadPanel,0,SpringLayout.EAST,commodityViewPanel);

        springLayout.putConstraint(SpringLayout.NORTH,backPanel,0,SpringLayout.SOUTH,tableHeadPanel);
        springLayout.putConstraint(SpringLayout.WEST,backPanel,0,SpringLayout.WEST,commodityViewPanel);
        springLayout.putConstraint(SpringLayout.EAST,backPanel,0,SpringLayout.EAST,commodityViewPanel);
        springLayout.putConstraint(SpringLayout.SOUTH,backPanel,0,SpringLayout.SOUTH,commodityViewPanel);

        commodityViewPanel.add(tableHeadPanel);
        commodityViewPanel.add(backPanel);

        return commodityViewPanel;
    }
}
