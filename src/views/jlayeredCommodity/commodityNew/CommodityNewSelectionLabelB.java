package views.jlayeredCommodity.commodityNew;


import item.Fonts;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommodityNewSelectionLabelB {

    public JLabel commodityNewSelectionLabelB(){

        JLabel commodityNewSelectionLabelB;
        commodityNewSelectionLabelB=new JLabel();
        commodityNewSelectionLabelB.setFont(Fonts.getFontStandard());
        commodityNewSelectionLabelB.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
                System.out.println("123");
            }
        });

        return commodityNewSelectionLabelB;
    }
}
