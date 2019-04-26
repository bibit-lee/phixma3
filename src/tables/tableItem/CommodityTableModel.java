package tables.tableItem;


import item.Conn;
import item.ScreenSize;
import mainFrame.JLayeredView;
import titles.MainTitle;
import views.jlayeredCommodity.CommodityDetailPanel;
import views.jlayeredCommodity.OperationTypeListener;
import views.jlayeredCommodity.commoditySet.DisPlayColumn;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//商品显示列表表格模型
public class CommodityTableModel {

    //指定sql语句的表格
    public JTable commodityTableModel(String sql){

        JTable commodityTableModel;

        Conn a=new Conn();
        Connection conn=a.getCon();
        String user= MainTitle.helloUserHid.getText();

        DefaultTableModel defaultTableModel=new DefaultTableModel();   //实例化表格模型
        //设置表头字段名称
        defaultTableModel.setColumnIdentifiers(new Object[]{"品牌","型号","属性C","产地","属性A","成本价","售价A","售价B","售价C","库存","生产时间","属性B",
                "picA","picB1","picB2","picB3","picB4","商品ID","商品标记"});//设置类名
        //实例化父类表格
        TableModel tm=new TableModel();
        commodityTableModel=tm.tableModel(defaultTableModel);

        //获取库存表内容
        try{
            Statement stmt=conn.createStatement();
            ResultSet res=stmt.executeQuery(sql);

            while (res.next()){
                String brand=" "+res.getString("brand");
                String tradeName=res.getString("tradeName");
                String attributeC=res.getString("attributeC");
                String origin=res.getString("origin");
                String attributeA=res.getString("attributeA");
                String costPrice="¥ "+res.getString("costPrice");
                String sellPriceA="¥ "+res.getString("sellPriceA");
                String sellPriceB="¥ "+res.getString("sellPriceB");
                String sellPriceC="¥ "+res.getString("sellPriceC");
                String stock=res.getString("stock");
                String date=res.getString("date");
                String attributeB=res.getString("attributeB");
                String picA1url=res.getString("picA1url");
                String picB1url=res.getString("picB1url");
                String picB2url=res.getString("picB2url");
                String picB3url=res.getString("picB3url");
                String picB4url=res.getString("picB4url");
                String id=res.getString("id");
                String specialMark=res.getString("specialMark");

                defaultTableModel.addRow(new Object[]{brand,tradeName,attributeC,origin,attributeA,costPrice,sellPriceA,
                        sellPriceB,sellPriceC,stock,date,attributeB,picA1url,picB1url,picB2url,picB3url,picB4url,id,specialMark});
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }

        //实例化表格列模型
        TableColumnModel tcm=commodityTableModel.getColumnModel();
        TableColumn tcBrand=tcm.getColumn(0);
        TableColumn tcTradeName=tcm.getColumn(1);
        TableColumn tcAttributeC=tcm.getColumn(2);
        TableColumn tcOrigin=tcm.getColumn(3);
        TableColumn tcAttributeA=tcm.getColumn(4);
        TableColumn tcCostPrice=tcm.getColumn(5);
        TableColumn tcSellPriceA=tcm.getColumn(6);
        TableColumn tcSellPriceB=tcm.getColumn(7);
        TableColumn tcSellPriceC=tcm.getColumn(8);
        TableColumn tcStock=tcm.getColumn(9);
        TableColumn tcDate=tcm.getColumn(10);
        TableColumn tcAttributeB=tcm.getColumn(11);
        TableColumn tcPicA1url=tcm.getColumn(12);
        TableColumn tcPicB1url=tcm.getColumn(13);
        TableColumn tcPicB2url=tcm.getColumn(14);
        TableColumn tcPicB3url=tcm.getColumn(15);
        TableColumn tcPicB4url=tcm.getColumn(16);
        TableColumn tcId=tcm.getColumn(17);
        TableColumn tcSpecialMark=tcm.getColumn(18);

        //设置商品名称列和商品库存数量列的最小宽度
        tcTradeName.setMinWidth(ScreenSize.scr_width*8/100);
        tcStock.setMinWidth(ScreenSize.scr_width*5/100);

        //表格隐藏图片列、商品ID列的数据和表头
        tcPicA1url.setWidth(0);
        tcPicA1url.setPreferredWidth(0);
        tcPicA1url.setMaxWidth(0);
        tcPicA1url.setMinWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(12).setWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(12).setMaxWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(12).setPreferredWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(12).setMinWidth(0);

        tcPicB1url.setWidth(0);
        tcPicB1url.setPreferredWidth(0);
        tcPicB1url.setMaxWidth(0);
        tcPicB1url.setMinWidth(0);

        commodityTableModel.getTableHeader().getColumnModel().getColumn(13).setWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(13).setPreferredWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(13).setMinWidth(0);

        tcPicB2url.setWidth(0);
        tcPicB2url.setPreferredWidth(0);
        tcPicB2url.setMaxWidth(0);
        tcPicB2url.setMinWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(14).setWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(14).setMaxWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(14).setPreferredWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(14).setMinWidth(0);

        tcPicB3url.setWidth(0);
        tcPicB3url.setPreferredWidth(0);
        tcPicB3url.setMaxWidth(0);
        tcPicB3url.setMinWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(15).setWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(15).setMaxWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(15).setPreferredWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(15).setMinWidth(0);

        tcPicB4url.setWidth(0);
        tcPicB4url.setPreferredWidth(0);
        tcPicB4url.setMaxWidth(0);
        tcPicB4url.setMinWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(16).setWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(16).setMaxWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(16).setPreferredWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(16).setMinWidth(0);

        tcId.setWidth(0);
        tcId.setPreferredWidth(0);
        tcId.setMaxWidth(0);
        tcId.setMinWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(17).setWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(17).setMaxWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(17).setPreferredWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(17).setMinWidth(0);

        tcSpecialMark.setWidth(0);
        tcSpecialMark.setPreferredWidth(0);
        tcSpecialMark.setMaxWidth(0);
        tcSpecialMark.setMinWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(18).setWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(18).setMaxWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(18).setPreferredWidth(0);
        commodityTableModel.getTableHeader().getColumnModel().getColumn(18).setMinWidth(0);



        //获取权限表内容
        try{
            Statement stmt=conn.createStatement();
            ResultSet permissionRes=stmt.executeQuery("SELECT * FROM permission_list WHERE common_id='"+user+"' ");
            while (permissionRes.next()){
                int costPrice=permissionRes.getInt("sells_costPrice");  //商品成本价
                int sellsPriceA=permissionRes.getInt("sells_priceA");  //销售价A
                int sellsPriceB=permissionRes.getInt("sells_priceB");  //销售价B
                int sellsPriceC=permissionRes.getInt("sells_priceC");  //销售价C

                int brand=permissionRes.getInt("column_brand");  //品牌
                int origin=permissionRes.getInt("column_origin");  //产地
                int attributeA=permissionRes.getInt("column_attributeA");  //属性A(花纹)
                int attributeB=permissionRes.getInt("column_attributeB");  //属性B(车型)
                int attributeC=permissionRes.getInt("column_attributeC");  //属性C(载重级别特殊标记)
                int date=permissionRes.getInt("column_date");  //生产日期



                switch (costPrice){
                    case 0:   //如果成本价权限是  0  则执行：
                        DisPlayColumn.costPriceBtn.setPreferredSize(new Dimension(0,0));  //隐藏成本价选择按钮
                        tcCostPrice.setWidth(0);  //隐藏成本价数据列和表头
                        tcCostPrice.setMinWidth(0);
                        tcCostPrice.setMaxWidth(0);
                        tcCostPrice.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(0);
                        break;

                    case 1:  //如果成本价权限为  1  则执行：
                        DisPlayColumn.costPriceBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));  //显示列选择按钮
                        tcCostPrice.setMinWidth(ScreenSize.scr_width*7/100);  //成本价列和表头最小宽度
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setMinWidth(ScreenSize.scr_width*7/100);
                        break;

                    case 2:  //如果成本价权限为  2  则执行：
                        DisPlayColumn.costPriceBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));  //显示列选择按钮
                        DisPlayColumn.costPriceBtn.setSelected(false);
                        tcCostPrice.setWidth(0);  //隐藏成本价数据列和表头
                        tcCostPrice.setMinWidth(0);
                        tcCostPrice.setMaxWidth(0);
                        tcCostPrice.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(0);
                        break;
                }


                switch (sellsPriceA){
                    case 0:
                        DisPlayColumn.sellPriceABtn.setPreferredSize(new Dimension(0,0));
                        tcSellPriceA.setWidth(0);
                        tcSellPriceA.setMinWidth(0);
                        tcSellPriceA.setMaxWidth(0);
                        tcSellPriceA.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.sellPriceABtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
                        tcSellPriceA.setMinWidth(ScreenSize.scr_width*7/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setMinWidth(ScreenSize.scr_width*7/100);
                        break;

                    case 2:
                        DisPlayColumn.sellPriceABtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
                        DisPlayColumn.sellPriceABtn.setSelected(false);
                        tcSellPriceA.setWidth(0);
                        tcSellPriceA.setMinWidth(0);
                        tcSellPriceA.setMaxWidth(0);
                        tcSellPriceA.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(0);
                        break;
                }

                switch (sellsPriceB){
                    case 0:
                        DisPlayColumn.sellPriceBBtn.setPreferredSize(new Dimension(0,0));
                        tcSellPriceB.setWidth(0);
                        tcSellPriceB.setMinWidth(0);
                        tcSellPriceB.setMaxWidth(0);
                        tcSellPriceB.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.sellPriceBBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
                        tcSellPriceB.setMinWidth(ScreenSize.scr_width*7/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setMinWidth(ScreenSize.scr_width*7/100);
                        break;

                    case 2:
                        DisPlayColumn.sellPriceBBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
                        DisPlayColumn.sellPriceBBtn.setSelected(false);
                        tcSellPriceB.setWidth(0);
                        tcSellPriceB.setMinWidth(0);
                        tcSellPriceB.setMaxWidth(0);
                        tcSellPriceB.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(0);
                        break;
                }

                switch (sellsPriceC){
                    case 0:
                        DisPlayColumn.sellPriceCBtn.setPreferredSize(new Dimension(0,0));
                        tcSellPriceC.setWidth(0);
                        tcSellPriceC.setMinWidth(0);
                        tcSellPriceC.setMaxWidth(0);
                        tcSellPriceC.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.sellPriceCBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
                        tcSellPriceC.setMinWidth(ScreenSize.scr_width*7/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setMinWidth(ScreenSize.scr_width*7/100);
                        break;

                    case 2:
                        DisPlayColumn.sellPriceCBtn.setPreferredSize(new Dimension(ScreenSize.scr_width*15/100,ScreenSize.scr_height*4/100));
                        DisPlayColumn.sellPriceCBtn.setSelected(false);
                        tcSellPriceC.setWidth(0);
                        tcSellPriceC.setMinWidth(0);
                        tcSellPriceC.setMaxWidth(0);
                        tcSellPriceC.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(0);
                        break;
                }

                switch (brand){
                    case 0:
                        DisPlayColumn.brandBtn.setSelected(false);
                        tcBrand.setWidth(0);
                        tcBrand.setMinWidth(0);
                        tcBrand.setMaxWidth(0);
                        tcBrand.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(0).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.brandBtn.setSelected(true);
                        tcBrand.setMinWidth(ScreenSize.scr_width*7/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(0).setMinWidth(ScreenSize.scr_width*7/100);
                        break;
                }

                switch (origin){
                    case 0:
                        DisPlayColumn.originBtn.setSelected(false);
                        tcOrigin.setWidth(0);
                        tcOrigin.setMinWidth(0);
                        tcOrigin.setMaxWidth(0);
                        tcOrigin.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(3).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.originBtn.setSelected(true);
                        tcOrigin.setMinWidth(ScreenSize.scr_width*6/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(3).setMinWidth(ScreenSize.scr_width*6/100);
                        break;
                }

                switch (attributeA){
                    case 0:
                        DisPlayColumn.attributeABtn.setSelected(false);
                        tcAttributeA.setWidth(0);
                        tcAttributeA.setMinWidth(0);
                        tcAttributeA.setMaxWidth(0);
                        tcAttributeA.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(4).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.attributeABtn.setSelected(true);
                        tcAttributeA.setMinWidth(ScreenSize.scr_width*12/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(4).setMinWidth(ScreenSize.scr_width*12/100);
                        break;
                }

                switch (attributeB){
                    case 0:
                        DisPlayColumn.attributeBBtn.setSelected(false);
                        tcAttributeB.setWidth(0);
                        tcAttributeB.setMinWidth(0);
                        tcAttributeB.setMaxWidth(0);
                        tcAttributeB.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(11).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(11).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.attributeBBtn.setSelected(true);
                        tcAttributeB.setMinWidth(ScreenSize.scr_width*10/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(11).setMinWidth(ScreenSize.scr_width*10/100);
                        break;
                }

                switch (attributeC){
                    case 0:
                        DisPlayColumn.attributeCBtn.setSelected(false);
                        tcAttributeC.setWidth(0);
                        tcAttributeC.setMinWidth(0);
                        tcAttributeC.setMaxWidth(0);
                        tcAttributeC.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(2).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.attributeCBtn.setSelected(true);
                        tcAttributeC.setMinWidth(ScreenSize.scr_width*11/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(2).setMinWidth(ScreenSize.scr_width*11/100);
                        break;
                }

                switch (date){
                    case 0:
                        DisPlayColumn.dateBtn.setSelected(false);
                        tcDate.setWidth(0);
                        tcDate.setMinWidth(0);
                        tcDate.setMaxWidth(0);
                        tcDate.setPreferredWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(10).setWidth(0);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(0);
                        break;

                    case 1:
                        DisPlayColumn.dateBtn.setSelected(true);
                        tcDate.setMinWidth(ScreenSize.scr_width*5/100);
                        commodityTableModel.getTableHeader().getColumnModel().getColumn(10).setMinWidth(ScreenSize.scr_width*5/100);
                        break;
                }
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }



        //实例化加入操作台类型监听
        OperationTypeListener otl=new OperationTypeListener();

        commodityTableModel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                int y0=commodityTableModel.getY();   //组件初始坐标
                int y1=(int)e.getLocationOnScreen().getY();  //鼠标点击按下时的坐标(直接.getY()会抖屏）

                commodityTableModel.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        super.mouseDragged(e);
                        int y2=(int)e.getLocationOnScreen().getY();  //鼠标拖拽的坐标（变化）(直接.getY()会抖屏）
                        int y=y0-(y1-y2);  //组件原始坐标-（鼠标按下坐标-鼠标拖拽坐标）=滑动后的坐标
                        commodityTableModel.setLocation(0,y);

                    }
                });
            }
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                int row=commodityTableModel.rowAtPoint(e.getPoint());
                if (row!=-1){
                    JLayeredView.jLayeredView.add(JLayeredView.commodityDetailPanel,Integer.valueOf(900));
                    JLayeredView.jLayeredView.setLayer(JLayeredView.light,800);

                    String brand=commodityTableModel.getValueAt(row,0).toString().trim();
                    String tradeName="  "+commodityTableModel.getValueAt(row,1).toString();
                    String attributeC="  "+commodityTableModel.getValueAt(row,2).toString();
                    String origin="  "+commodityTableModel.getValueAt(row,3).toString();
                    String attributeA="  "+commodityTableModel.getValueAt(row,4).toString();
                    String costPrice=commodityTableModel.getValueAt(row,5).toString();
                    String sellPriceA=commodityTableModel.getValueAt(row,6).toString();
                    String sellPriceB=commodityTableModel.getValueAt(row,7).toString();
                    String sellPriceC=commodityTableModel.getValueAt(row,8).toString();
                    String stock=commodityTableModel.getValueAt(row,9).toString();
                    String date=commodityTableModel.getValueAt(row,10).toString();
                    String attributeB=commodityTableModel.getValueAt(row,11).toString();
                    String picA1url=commodityTableModel.getValueAt(row,12).toString();
                    String picB1url=commodityTableModel.getValueAt(row,13).toString();
                    String picB2url=commodityTableModel.getValueAt(row,14).toString();
                    String picB3url=commodityTableModel.getValueAt(row,15).toString();
                    String picB4url=commodityTableModel.getValueAt(row,16).toString();
                    String id=commodityTableModel.getValueAt(row,17).toString();
                    String specialMark=commodityTableModel.getValueAt(row,18).toString();

                    CommodityDetailPanel.specialMark.setText(specialMark);
                    CommodityDetailPanel.commodity.setText(brand+tradeName+attributeC+origin+attributeA);
                    CommodityDetailPanel.commodityId.setText(id);
                    ImageIcon picA1=new ImageIcon(picA1url);
                    CommodityDetailPanel.picLabel.setIcon(picA1);

                    ImageIcon picB1=new ImageIcon(picB1url);
                    ImageIcon picB2=new ImageIcon(picB2url);
                    ImageIcon picB3=new ImageIcon(picB3url);
                    ImageIcon picB4=new ImageIcon(picB4url);
                    int picB_width=picB1.getIconWidth()*25/100;
                    int picB_height=picB1.getIconHeight()*25/100;

                    picB1.setImage(picB1.getImage().getScaledInstance(picB_width,picB_height,Image.SCALE_AREA_AVERAGING));
                    CommodityDetailPanel.picLabel1.setIcon(picB1);
                    picB2.setImage(picB2.getImage().getScaledInstance(picB_width,picB_height,Image.SCALE_AREA_AVERAGING));
                    CommodityDetailPanel.picLabel2.setIcon(picB2);
                    picB3.setImage(picB3.getImage().getScaledInstance(picB_width,picB_height,Image.SCALE_AREA_AVERAGING));
                    CommodityDetailPanel.picLabel3.setIcon(picB3);
                    picB4.setImage(picB4.getImage().getScaledInstance(picB_width,picB_height,Image.SCALE_AREA_AVERAGING));
                    CommodityDetailPanel.picLabel4.setIcon(picB4);


                    try{
                        Statement stmt=conn.createStatement();
                        ResultSet permissionRes=stmt.executeQuery("SELECT * FROM permission_list WHERE common_id='"+user+"' ");
                        while (permissionRes.next()){
                            String sells_group=permissionRes.getString("sells_group");
                            String purchase_group=permissionRes.getString("purchase_group");
                            String depot_group=permissionRes.getString("depot_group");
                            String finance_group=permissionRes.getString("finance_group");
                            String trans_group=permissionRes.getString("trans_group");
                            String sells_costPrice=permissionRes.getString("sells_costPrice");
                            String sells_priceA=permissionRes.getString("sells_priceA");
                            String sells_priceB=permissionRes.getString("sells_priceB");
                            String sells_priceC=permissionRes.getString("sells_priceC");

                            //switch语句判断操作权限
                            String str=sells_group+purchase_group+depot_group+finance_group+trans_group;
                            try{
                                int a=Integer.valueOf(str);
                                switch (a){
                                    case 10000:
                                        CommodityDetailPanel.operationType.setText("销售");
                                        break;
                                    case 11000:
                                        CommodityDetailPanel.operationType.setText("销售");
                                        MouseListener sAp=otl.sapListener();
                                        CommodityDetailPanel.operationType.addMouseListener(sAp);
                                        break;
                                    case 11100:
                                        CommodityDetailPanel.operationType.setText("销售");
                                        MouseListener sApd=otl.sapdListener();
                                        CommodityDetailPanel.operationType.addMouseListener(sApd);
                                        break;
                                    case 11110:
                                        CommodityDetailPanel.operationType.setText("销售");
                                        break;
                                }
                            }catch (NumberFormatException e1){
                                e1.printStackTrace();
                            }

                            //产品详细页面价格显示判断
                            String str1=sells_costPrice+sells_priceA+sells_priceB+sells_priceC;
                            try{
                                int b=Integer.valueOf(str1,10);
                                switch (b){
                                    //具有成本价查看权限时执行：8种方案
                                    case 1111:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.priceNameA.setText("售价A:");
                                        CommodityDetailPanel.priceNameB.setText("售价B:");
                                        CommodityDetailPanel.priceNameC.setText("售价C:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceA);
                                        CommodityDetailPanel.sellPriceB.setText(sellPriceB);
                                        CommodityDetailPanel.sellPriceC.setText(sellPriceC);
                                        break;

                                    case 1000:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        break;

                                    case 1001:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        CommodityDetailPanel.priceNameA.setText("售价C:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceC);
                                        break;

                                    case 1010:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        CommodityDetailPanel.priceNameA.setText("售价B:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceB);
                                        break;

                                    case 1100:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        CommodityDetailPanel.priceNameA.setText("售价A:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceA);
                                        break;

                                    case 1110:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        CommodityDetailPanel.priceNameA.setText("售价A:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceA);
                                        CommodityDetailPanel.priceNameB.setText("售价B:");
                                        CommodityDetailPanel.sellPriceB.setText(sellPriceB);
                                        break;

                                    case 1101:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        CommodityDetailPanel.priceNameA.setText("售价A:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceA);
                                        CommodityDetailPanel.priceNameB.setText("售价C:");
                                        CommodityDetailPanel.sellPriceB.setText(sellPriceC);
                                        break;

                                    case 1011:
                                        CommodityDetailPanel.priceName.setText("成本均价:");
                                        CommodityDetailPanel.price.setText(costPrice);
                                        CommodityDetailPanel.priceNameA.setText("售价B:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceB);
                                        CommodityDetailPanel.priceNameB.setText("售价C:");
                                        CommodityDetailPanel.sellPriceB.setText(sellPriceC);
                                        break;

                                    //不具有成本价权限时执行：8种权限
                                    case 0:
                                        CommodityDetailPanel.priceName.setText("啥都没有:");
                                        CommodityDetailPanel.price.setText("啥都不显示");
                                        break;

                                    case 1:
                                        CommodityDetailPanel.priceName.setText("售价C:");
                                        CommodityDetailPanel.price.setText(sellPriceC);
                                        break;

                                    case 10:
                                        CommodityDetailPanel.priceName.setText("售价B:");
                                        CommodityDetailPanel.price.setText(sellPriceB);
                                        break;

                                    case 100:
                                        CommodityDetailPanel.priceName.setText("售价A:");
                                        CommodityDetailPanel.price.setText(sellPriceA);
                                        break;

                                    case 101:
                                        CommodityDetailPanel.priceName.setText("售价A:");
                                        CommodityDetailPanel.price.setText(sellPriceA);
                                        CommodityDetailPanel.priceNameA.setText("售价C:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceC);
                                        break;

                                    case 110:
                                        CommodityDetailPanel.priceName.setText("售价A:");
                                        CommodityDetailPanel.price.setText(sellPriceA);
                                        CommodityDetailPanel.priceNameA.setText("售价B:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceB);
                                        break;

                                    case 11:
                                        CommodityDetailPanel.priceName.setText("售价B:");
                                        CommodityDetailPanel.price.setText(sellPriceB);
                                        CommodityDetailPanel.priceNameA.setText("售价C:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceC);
                                        break;

                                    case 111:
                                        CommodityDetailPanel.priceName.setText("售价A:");
                                        CommodityDetailPanel.price.setText(sellPriceA);
                                        CommodityDetailPanel.priceNameA.setText("售价B:");
                                        CommodityDetailPanel.sellPriceA.setText(sellPriceB);
                                        CommodityDetailPanel.priceNameB.setText("售价C:");
                                        CommodityDetailPanel.sellPriceB.setText(sellPriceC);
                                        break;
                                }
                            }catch (NumberFormatException e1){
                                e1.printStackTrace();
                            }
                        }
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            }
        });




        return  commodityTableModel;
    }
}
