package views.jlayeredCommodity.commodityNew;


import item.Fonts;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;


public class CommodityNewSelectionLabelA {

    public JLabel commodityNewSelectionLabelA(){

        JLabel commodityNewSelectionLabelA;
        commodityNewSelectionLabelA=new JLabel();
        commodityNewSelectionLabelA.setFont(Fonts.getFontStandard());
        commodityNewSelectionLabelA.setCursor(new Cursor(Cursor.HAND_CURSOR));

        List<String> list = new ArrayList<>();


        commodityNewSelectionLabelA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                commodityNewSelectionLabelA.setBorder(new LineBorder(Color.RED,2));
                commodityNewSelectionLabelA.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                commodityNewSelectionLabelA.setBorder(null);
                commodityNewSelectionLabelA.setForeground(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                String selectAStr=commodityNewSelectionLabelA.getText();  //获取点选内容
                list.add("AND classifyDescribe LIKE "+"'%"+selectAStr+"%'");

                int x=0;
                String a="";
                while (x<list.size()){
                    a += list.get(x);  //拼接集合的所有元素
                    x++;
                }

                CommodityInfo ci=new CommodityInfo();
                ci.getCommodityInfo(a);



            }
        });

        return commodityNewSelectionLabelA;
    }
}
