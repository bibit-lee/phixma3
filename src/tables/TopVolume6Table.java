package tables;

import item.Conn;
import item.Fonts;
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
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


//点击搜索框时展开的选择表格（设置为销量最大的六个型号）

public class TopVolume6Table {

    public JTable topVolume6Table(String sql){

        JTable topVolume6Table;

        Conn a=new Conn();
        Connection conn=a.getCon();
        //获取交易量最大的6个产品
        DefaultTableModel topVolume6TableModel=new DefaultTableModel();
        topVolume6TableModel.setColumnIdentifiers(new Object[]{"型号"});//设置类名

        try{
            Statement stmt=conn.createStatement();
            ResultSet topVolume6=stmt.executeQuery(sql);

            while (topVolume6.next()){
                String tradeName="  "+topVolume6.getString("tradeName");
                //此处为字符串添加了空格，后面获取时记得去除空格，否则无法获取
                topVolume6TableModel.addRow(new Object[]{tradeName});

            }
        }catch (Exception e1){
            e1.printStackTrace();
        }

        TableModel ctm=new TableModel();
        topVolume6Table=ctm.tableModel(topVolume6TableModel);


        topVolume6Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String zero= CommoditySearchFieldOption.noZero.getText();
                int row=topVolume6Table.rowAtPoint(e.getPoint());  //获取鼠标所在行

                if(row!=-1){

                    JLayeredView.commoditySearch.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height*10/100);
                    String si=topVolume6Table.getValueAt(row,0).toString().trim();  //获取所在行和列的值，并转换成String类型
                    //注意：获取的原本为Object类型，必须用toString()转换成字符串类型
                    //注意：因为前面在表格里面添加了空格作为边距，必须使用trim()去除空格
                    CommoditySearchField.commoditySearchField.setText(si);  //点选后在文本框显示选择的内容（必须）
                    CommodityTableModel ctm=new CommodityTableModel();  //位置必须放在这里

                    if (zero.equals("不显示 0 库存产品")){
                        String sql="SELECT * FROM kcb WHERE tradeName ='"+si+"' ORDER BY brand";
                        JTable topVolume6CommodityTable=ctm.commodityTableModel(sql);   //不能放在监听外，否则不能正常使用
                        JTableHeader commodityTableHeader= topVolume6CommodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());

                        CommodityViewPanel.backPanel.removeAll();  //表格面板添加数据前先删除所有数据(必须）
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(topVolume6CommodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);

                        topVolume6CommodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);

                    }else {
                        String sql="SELECT * FROM kcb WHERE (tradeName ='"+si+"' AND stock>0) ORDER BY brand";
                        JTable topVolume6CommodityTable=ctm.commodityTableModel(sql);   //不能放在监听外，否则不能正常使用
                        JTableHeader commodityTableHeader= topVolume6CommodityTable.getTableHeader();
                        commodityTableHeader.setFont(Fonts.getFontH5Standard());

                        CommodityViewPanel.backPanel.removeAll();  //表格面板添加数据前先删除所有数据(必须）
                        CommodityViewPanel.tableHeadPanel.removeAll();
                        CommodityViewPanel.backPanel.add(topVolume6CommodityTable);
                        CommodityViewPanel.tableHeadPanel.add(commodityTableHeader);

                        topVolume6CommodityTable.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                        commodityTableHeader.setBounds(0,0,ScreenSize.scr_width*90/100,ScreenSize.scr_height);
                    }

                    BrandChoiceTable bct=new BrandChoiceTable();
                    JTable brandChoiceTable=bct.brandChoiceTable();


                    CommoditySearchField.brandPanel.removeAll();  //品牌面板添加数据前先删除所有数据（必须）
                    CommoditySearchField.brandPanel.add(brandChoiceTable);
                    brandChoiceTable.setBounds(0,0,ScreenSize.scr_width,ScreenSize.scr_height);

                    CommoditySearchField.brandChoiceOpen.setVisible(true);   //点选后品牌选择按钮1出现（必须）
                    topVolume6Table.setVisible(false);  //点击后隐藏数据选择表格（必须）
                    CommoditySearchField.jPanel.remove(CommoditySearchField.topVolume6Table);

                    JLayeredView.jLayeredView.setLayer(JLayeredView.light,400);

                    CommodityViewPanel.backPanel.updateUI();
                    CommodityViewPanel.tableHeadPanel.updateUI();
                }


            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                topVolume6Table.clearSelection();
            }
        });

        return topVolume6Table;

    }
}
