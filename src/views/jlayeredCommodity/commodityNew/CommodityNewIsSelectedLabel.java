package views.jlayeredCommodity.commodityNew;


import item.Fonts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommodityNewIsSelectedLabel {
    public JLabel getLabel(){
        JLabel jLabel;

        jLabel=new JLabel();
        jLabel.setFont(Fonts.getFontStandard());
        jLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel.setBackground(new Color(148,148,148));
        jLabel.setForeground(Color.WHITE);
        jLabel.setOpaque(true);


        jLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jLabel.setBackground(Color.WHITE);
                jLabel.setForeground(Color.RED);
                jLabel.setBorder(new LineBorder(Color.RED,2));


            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jLabel.setBackground(new Color(148,148,148));
                jLabel.setForeground(Color.WHITE);
                jLabel.setBorder(null);

            }
        });

        return jLabel;
    }
}
