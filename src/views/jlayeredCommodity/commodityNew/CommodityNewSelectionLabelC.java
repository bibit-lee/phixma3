package views.jlayeredCommodity.commodityNew;


import item.Fonts;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommodityNewSelectionLabelC {

    public JLabel commodityNewSelectionLabelC(){

        JLabel commodityNewSelectionLabelC;

        commodityNewSelectionLabelC=new JLabel();
        commodityNewSelectionLabelC.setFont(Fonts.getFontStandard());
        commodityNewSelectionLabelC.setCursor(new Cursor(Cursor.HAND_CURSOR));

        commodityNewSelectionLabelC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                commodityNewSelectionLabelC.setBorder(new LineBorder(Color.RED,2));
                commodityNewSelectionLabelC.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                commodityNewSelectionLabelC.setBorder(null);
                commodityNewSelectionLabelC.setForeground(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("465");
            }
        });

        return commodityNewSelectionLabelC;
    }
}
