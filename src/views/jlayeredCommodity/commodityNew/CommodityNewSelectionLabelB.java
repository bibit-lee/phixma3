package views.jlayeredCommodity.commodityNew;


import item.Fonts;
import views.jlayeredCommodity.CommodityNewPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class CommodityNewSelectionLabelB {

    public JLabel commodityNewSelectionLabelB(){

        JLabel commodityNewSelectionLabelB;
        commodityNewSelectionLabelB=new JLabel();
        commodityNewSelectionLabelB.setFont(Fonts.getFontStandard());
        commodityNewSelectionLabelB.setCursor(new Cursor(Cursor.HAND_CURSOR));

        java.util.List<String> list = new ArrayList<>();
        CommodityNewIsSelectedLabel cNsl=new CommodityNewIsSelectedLabel();

        commodityNewSelectionLabelB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                commodityNewSelectionLabelB.setBorder(new LineBorder(Color.RED,2));
                commodityNewSelectionLabelB.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                commodityNewSelectionLabelB.setBorder(null);
                commodityNewSelectionLabelB.setForeground(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String selectBStr=commodityNewSelectionLabelB.getText();

                list.add("AND classifyDescribe LIKE "+"'%"+selectBStr+"%'");
                int x=0;
                String a=" ";
                while (x<list.size()){
                    a += list.get(x);  //拼接集合的所有元素
                    x++;
                }

                CommodityInfo ci=new CommodityInfo();
                ci.getCommodityInfo(a);

                JLabel commodityNewIsSelectedLabel=cNsl.getLabel();
                commodityNewIsSelectedLabel.setText(selectBStr);
                CommodityNewPanel.searchResult.add(commodityNewIsSelectedLabel);
            }
        });

        return commodityNewSelectionLabelB;
    }
}
