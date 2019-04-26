package tables;


import item.Conn;
import item.ScreenSize;
import mainFrame.JLayeredTitle;
import mainFrame.JLayeredTop;
import mainFrame.JLayeredView;
import tables.tableItem.CommodityTableModel;
import tables.tableItem.TableModel;
import views.jlayeredCommodity.CommodityViewPanel;
import views.jlayeredItem.CommoditySearchField;
import views.jlayeredItem.CommoditySearchFieldOption;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BrandChoiceTable {
    public JTable brandChoiceTable(){
        JTable brandChoiceTable;

        DefaultTableModel brandTableModel=new DefaultTableModel();
        brandTableModel.setColumnIdentifiers(new Object[]{"品牌"});

        TableModel ctm=new TableModel();
        brandChoiceTable=ctm.tableModel(brandTableModel);


        Conn a=new Conn();
        Connection con=a.getCon();
        String n= CommoditySearchField.commoditySearchField.getText();


        try{
            Statement sql=con.createStatement();
            ResultSet brandChoice=sql.executeQuery("SELECT * FROM kcb WHERE tradeName='"+n+"'GROUP BY brand");

            while (brandChoice.next()){
                String brand="  "+brandChoice.getString("brand");
                brandTableModel.addRow(new Object[]{brand});
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }

        brandChoiceTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String zero= CommoditySearchFieldOption.noZero.getText();
                String n= CommoditySearchField.commoditySearchField.getText();

                int row=brandChoiceTable.rowAtPoint(e.getPoint());
                if(row!=-1){
                    String b=brandChoiceTable.getValueAt(row,0).toString().trim();  //获取所在行和列的值，并转换成String类型
                    //注意：获取的原本为Object类型，必须用toString()转换成字符串类型
                    //注意：因为前面在表格里面添加了空格作为边距，必须使用trim()去除空格

                    CommoditySearchField.brandChoiceOpen.setText(b);
                    CommoditySearchField.brandChoiceClose.setText(b);

                    CommoditySearchField.brandPanel.setVisible(false);
                    CommoditySearchField.brandChoiceClose.setVisible(false);
                    CommoditySearchField.brandChoiceOpen.setVisible(true);

                    JLayeredView.commoditySearch.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height*10/100);

                    if(zero.equals("不显示 0 库存产品")){
                        String sql="SELECT * FROM kcb WHERE (brand='"+b+"' AND tradeName LIKE '%"+n+"%')";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable brandAndNameTable=ctm.commodityTableModel(sql);
                        CommodityViewPanel.backPanel.removeAll();  //表格面板添加数据前先删除所有数据(必须）
                        CommodityViewPanel.backPanel.add(brandAndNameTable);
                        brandAndNameTable.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);
                    }else {
                        String sql="SELECT * FROM kcb WHERE (stock>0 AND brand='"+b+"' AND tradeName LIKE '%"+n+"%')";
                        CommodityTableModel ctm=new CommodityTableModel();
                        JTable brandAndNameTable=ctm.commodityTableModel(sql);
                        CommodityViewPanel.backPanel.removeAll();  //表格面板添加数据前先删除所有数据(必须）
                        CommodityViewPanel.backPanel.add(brandAndNameTable);
                        brandAndNameTable.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);
                    }
                    CommodityViewPanel.backPanel.updateUI();
                }
            }
        });

        return brandChoiceTable;
    }
}
