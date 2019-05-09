package views.jlayeredCommodity.commodityNew;


import item.Conn;
import item.Fonts;
import views.jlayeredCommodity.CommodityNewPanel;
import views.jlayeredItem.CommoditySearchNew;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.*;
import java.util.List;


public class CommodityNewSelectionLabelA {

    public JLabel commodityNewSelectionLabelA(){

        JLabel commodityNewSelectionLabelA;
        commodityNewSelectionLabelA=new JLabel();
        commodityNewSelectionLabelA.setFont(Fonts.getFontStandard());
        commodityNewSelectionLabelA.setCursor(new Cursor(Cursor.HAND_CURSOR));



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

                String selectAStr=commodityNewSelectionLabelA.getText();  //获取点选内容
                list.add("AND classifyDescribe LIKE "+"'%"+selectAStr+"%'");

                int x=0;
                String a="";
                while (x<list.size()){
                    a += list.get(x);  //拼接集合的所有元素
                    x++;
                }

                CommodityInfo ci=new CommodityInfo();
                ci.getCommodityInfo(a, con, signASet ,signBSet, signCSet, brandSet, tradeNameSet, attributeASet,
                        attributeBSet, attributeCSet, originSet, dateSet, cNslA, cNslB, cNslC);

            }
        });

        return commodityNewSelectionLabelA;
    }
}
