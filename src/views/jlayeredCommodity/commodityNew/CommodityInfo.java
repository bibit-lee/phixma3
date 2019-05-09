package views.jlayeredCommodity.commodityNew;


import item.Conn;
import item.Fonts;
import item.ScreenSize;
import views.jlayeredCommodity.CommodityNewPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class CommodityInfo {


    public void getCommodityInfo(String a){

        Conn waiBu=new Conn();
        Connection con=waiBu.getCon1();

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

        CommodityNewSelectionLabelA cNslA=new CommodityNewSelectionLabelA(); //实例化分类A标签模板
        CommodityNewSelectionLabelB cNslB=new CommodityNewSelectionLabelB();
        CommodityNewSelectionLabelC cNslC=new CommodityNewSelectionLabelC();


        signASet.clear();
        signBSet.clear();
        signCSet.clear();
        brandSet.clear();
        tradeNameSet.clear();
        attributeASet.clear();
        attributeBSet.clear();
        attributeCSet.clear();
        originSet.clear();
        dateSet.clear();

        CommodityNewPanel.searchResult.removeAll();
        CommodityNewPanel.selectionA.removeAll();
        CommodityNewPanel.selectionB.removeAll();
        CommodityNewPanel.selectionC.removeAll();
        CommodityNewPanel.brandInput.removeAllItems();
        CommodityNewPanel.nameInput.removeAllItems();
        CommodityNewPanel.originInput.removeAllItems();
        CommodityNewPanel.dateInput.removeAllItems();
        CommodityNewPanel.aaInput.removeAllItems();
        CommodityNewPanel.abInput.removeAllItems();
        CommodityNewPanel.acInput.removeAllItems();




        try{  //把文本框输入的内容拆分搜索
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


            if (signASum>1){  //如果数据集只有一个数据，则不显示选择框
                CommodityNewPanel.selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));

            } else if (signASum<1){  //如果数据集没有数据，则提示重新搜索
                CommodityNewPanel.selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));
                JLabel noResult=new JLabel("请更换关键字重新搜索  或  自行手动添加");
                noResult.setFont(Fonts.getFontStandard());
                noResult.setOpaque(true);
                CommodityNewPanel.searchResult.add(noResult);

            }else if (signASum==1){
                CommodityNewPanel.selectionA.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,0));
            }


            if (signBSum>=1){
                CommodityNewPanel.selectionB.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));
            }else{
                CommodityNewPanel.selectionB.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,0));
            }

            if (signCSum>=1){
                CommodityNewPanel.selectionC.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*5/100));
            }else{
                CommodityNewPanel.selectionC.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,0));
            }

            if (brandSum==1){
                CommodityNewPanel.brandInput.setEnabled(false);
            }else {
                CommodityNewPanel.brandInput.setEnabled(true);
            }

            if (tradeNameSum==1){
                CommodityNewPanel.nameInput.setEnabled(false);
            }else {
                CommodityNewPanel.nameInput.setEnabled(true);
            }

            //遍历signASet数据集元素，动态添加标签
            for (String signAStr : signASet){
                JLabel signALabel=cNslA.commodityNewSelectionLabelA();
                signALabel.setText(signAStr);

                CommodityNewPanel.selectionA.add(signALabel);  //标签选择面板添加这些标签
                CommodityNewPanel.selectionA.updateUI();  //更新面板
            }

            for (String signBStr : signBSet){
                JLabel signBLabel=cNslB.commodityNewSelectionLabelB();
                signBLabel.setText(signBStr);

                CommodityNewPanel.selectionB.add(signBLabel);
                CommodityNewPanel.selectionB.updateUI();
            }

            for (String signCStr : signCSet){
                JLabel signCLabel=cNslC.commodityNewSelectionLabelC();
                signCLabel.setText(signCStr);

                CommodityNewPanel.selectionC.add(signCLabel);
                CommodityNewPanel.selectionC.updateUI();
            }

            //遍历数据集元素，动态添加选项到下拉框
            for (String brandStr: brandSet) {
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

        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
