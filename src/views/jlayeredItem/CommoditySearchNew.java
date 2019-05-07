package views.jlayeredItem;


import item.Conn;
import item.Fonts;
import item.ScreenSize;
import views.jlayeredCommodity.CommodityNewPanel;
import views.jlayeredCommodity.commodityNew.CommodityNewSelectionLabel;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.List;


public class CommoditySearchNew {

    public static JTextField commodityNewTextField;



    public JPanel commoditySearchNew(){

        class commodityNewBorder extends AbstractBorder{
            private final Color borderColor = new Color(255, 69, 0);  //设置边框颜色
            private int[]xs={ScreenSize.scr_width*5/100, ScreenSize.scr_width*10/100, ScreenSize.scr_width*11/100, ScreenSize.scr_width*35/100, ScreenSize.scr_width*35/100, ScreenSize.scr_width*5/100};   //声明多边形填充绘图 x 轴坐标数组
            private int[]ys={ScreenSize.scr_height*2/100, ScreenSize.scr_height*2/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*10/100, ScreenSize.scr_height*10/100};   //声明多边形填充绘图 y 轴坐标数组

            //图形绘制方法
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
                Graphics2D g2d=(Graphics2D)g;
                g2d.setColor(new Color(148,148,148));  //设置图形填充颜色
                g2d.fillPolygon(xs,ys,6);  //设置图形坐标和顶点
                g2d.setColor(borderColor);  //设置图形边框颜色
            }
        }
        JPanel commoditySearchNew;
        commoditySearchNew=new JPanel(null);
        commoditySearchNew.setBorder(new commodityNewBorder());  //绘制图形

        //产品输入框
        commodityNewTextField=new JTextField();
        commodityNewTextField.setBorder(new EmptyBorder(0,ScreenSize.scr_width/100,0,ScreenSize.scr_width/100));  //设置输入文本边距
        commodityNewTextField.setFont(Fonts.getFontH2Bold());
        commodityNewTextField.setBackground(new Color(148,148,148));
        commodityNewTextField.setBounds(ScreenSize.scr_width*5/100, ScreenSize.scr_height*5/100, ScreenSize.scr_width*30/100, ScreenSize.scr_height*5/100);  //设置文本输入框尺寸，尽量以120的倍数建立

        commoditySearchNew.add(commodityNewTextField);


        Conn waiBu=new Conn();
        Connection con=waiBu.getCon1();
        List<String> list = new ArrayList<>();
        HashSet<String> signASet=new HashSet<>();
        HashSet<String> signBSet=new HashSet<>();
        HashSet<String> signCSet=new HashSet<>();
        HashSet<String> brandSet=new HashSet<>();
        HashSet<String> tradeNameSet=new HashSet<>();
        HashSet<String> attributeASet=new HashSet<>();
        HashSet<String> attributeBSet=new HashSet<>();
        HashSet<String> attributeCSet=new HashSet<>();
        HashSet<String> originSet=new HashSet<>();
        HashSet<String> dateSet=new HashSet<>();


        //新增商品搜索框添加文本监听
        commodityNewTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            //文本插入时执行
            public void insertUpdate(DocumentEvent e) {
                list.clear();
                signASet.clear();
                brandSet.clear();
                tradeNameSet.clear();
                attributeASet.clear();
                attributeBSet.clear();
                attributeCSet.clear();
                originSet.clear();
                dateSet.clear();


                CommodityNewPanel.selectionA.removeAll();
                CommodityNewPanel.brandInput.removeAllItems();
                CommodityNewPanel.nameInput.removeAllItems();
                CommodityNewPanel.originInput.removeAllItems();
                CommodityNewPanel.dateInput.removeAllItems();
                CommodityNewPanel.aaInput.removeAllItems();
                CommodityNewPanel.abInput.removeAllItems();
                CommodityNewPanel.acInput.removeAllItems();


                try {
                    Document document=e.getDocument();
                    String insertText=document.getText(0,document.getLength());  //获取文本内容
                    int i=insertText.length();  //获取文本长度

                    //字符串循环添加到 List集合
                    for (int j=0;j<i;j++){
                        String oneStr=insertText.substring(j,j+1);
                        list.add("AND classifyDescribe LIKE "+"'%"+oneStr+"%'");  //拼接字符串
                    }

                    try{
                        //循环拼接每个字符串
                        int x=0;
                        String a="";
                        while (x<list.size()){
                            a += list.get(x);  //拼接集合的所有元素
                            x++;
                        }

                        //把文本框输入的内容拆分搜索
                        Statement statement=con.createStatement();
                        String sqlBasic="SELECT * FROM commodity WHERE 1=1 ";
                        String sql=sqlBasic+a;
                        ResultSet clientSearch=statement.executeQuery(sql);
                        while (clientSearch.next()){
                            String signA=clientSearch.getString("signA");
                            String signB=clientSearch.getString("signB");
                            String signC=clientSearch.getString("signC");
                            String brand=clientSearch.getString("brand");
                            String tradeName=clientSearch.getString("tradeName");
                            String attributeA=clientSearch.getString("attributeA");
                            String attributeB=clientSearch.getString("attributeB");
                            String attributeC=clientSearch.getString("attributeC");
                            String origin=clientSearch.getString("origin");
                            String date=clientSearch.getString("date");
                            signASet.add(signA); //用Set集合去重
                            signBSet.add(signB);
                            signCSet.add(signC);
                            brandSet.add(brand);
                            tradeNameSet.add(tradeName);
                            attributeASet.add(attributeA);
                            attributeBSet.add(attributeB);
                            attributeCSet.add(attributeC);
                            originSet.add(origin);
                            dateSet.add(date);

                      }

                    }catch (Exception e1){
                        e1.printStackTrace();
                    }


                }catch (BadLocationException e1){
                    e1.printStackTrace();
                }

                //获取分类数据集元素数量
                int signASum=signASet.size();
                int signBSum=signBSet.size();
                int signCSum=signCSet.size();
                int brandSum=brandSet.size();
                int tradeNameSum=tradeNameSet.size();
                int originSum=originSet.size();
                int dateSum=dateSet.size();
                int attributeASum=attributeASet.size();
                int attribureBSum=attributeBSet.size();
                int attributeCSum=attributeCSet.size();


                if (signASum==1){  //如果数据集只有一个数据，则不显示选择框
                    CommodityNewPanel.selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,0));

                }else if(signASum==0){  //如果数据集没有数据，则提示重新搜索
                    CommodityNewPanel.selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*10/100));
                    JLabel signAEmpty=new JLabel("请更换关键字重新搜索  或  自行手动添加");
                    signAEmpty.setFont(Fonts.getFontStandard());
                    signAEmpty.setOpaque(true);
                    CommodityNewPanel.selectionA.add(signAEmpty);

                }else if(signASum>1){  //如果数据集有多个数据，则显示选择框供搜索
                    CommodityNewPanel.selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*10/100));
                }


                CommodityNewSelectionLabel cNsl=new CommodityNewSelectionLabel(); //实例化分类标签模板

                //遍历数据集元素，动态添加标签
                for (String signAStr : signASet){
                    JLabel signALabel=cNsl.commodityNewSelectionLabel();
                    signALabel.setText(signAStr);

                    CommodityNewPanel.selectionA.add(signALabel);  //标签选择面板添加这些标签
                    CommodityNewPanel.selectionA.updateUI();  //更新面板
                }

                //遍历数据集元素，动态添加选项到下拉框
                for (String brandStr : brandSet) {
                    CommodityNewPanel.brandInput.addItem(brandStr);
                }

                for (String tradeNameStr : tradeNameSet){
                    CommodityNewPanel.nameInput.addItem(tradeNameStr);
                }

                for (String originStr : originSet){
                    CommodityNewPanel.originInput.addItem(originStr);
                }

                for (String dateStr : dateSet){
                    CommodityNewPanel.dateInput.addItem(dateStr);
                }

                for (String attributeAStr : attributeASet){
                    CommodityNewPanel.aaInput.addItem(attributeAStr);
                }

                for (String attributeBStr : attributeBSet){
                    CommodityNewPanel.abInput.addItem(attributeBStr);
                }

                for (String attributeCStr : attributeCSet){
                    CommodityNewPanel.acInput.addItem(attributeCStr);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        return commoditySearchNew;

    }
}
