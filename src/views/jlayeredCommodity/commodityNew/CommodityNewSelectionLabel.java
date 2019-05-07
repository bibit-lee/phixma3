package views.jlayeredCommodity.commodityNew;


import item.Fonts;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommodityNewSelectionLabel {
    public JLabel commodityNewSelectionLabel(){
        JLabel commodityNewSelectionLabel;
        commodityNewSelectionLabel=new JLabel();
        commodityNewSelectionLabel.setFont(Fonts.getFontStandard());
        commodityNewSelectionLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        commodityNewSelectionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                commodityNewSelectionLabel.setBorder(new LineBorder(Color.RED,2));
                commodityNewSelectionLabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                commodityNewSelectionLabel.setBorder(null);
                commodityNewSelectionLabel.setForeground(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

            }
        });

        return commodityNewSelectionLabel;
    }
}
