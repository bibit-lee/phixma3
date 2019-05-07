package views.jlayeredCommodity.commoditySet;


import item.Fonts;
import item.ScreenSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassBinding {
    public JPanel classBinding(){
        JPanel classBinding;
        SpringLayout springLayout=new SpringLayout();
        classBinding=new JPanel(springLayout);

        JLabel classBindingOpen=new JLabel("搜索分类绑定  ∨",SwingConstants.CENTER);
        classBindingOpen.setFont(Fonts.getFontH2Bold());
        classBindingOpen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        classBindingOpen.setBackground(new Color(148,148,148));
        classBindingOpen.setOpaque(true);
        classBindingOpen.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*4/100));

        JLabel classBindingClose=new JLabel("搜索分类绑定  ∧",SwingConstants.CENTER);
        classBindingClose.setFont(Fonts.getFontH2Bold());
        classBindingClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        classBindingClose.setPreferredSize(new Dimension(ScreenSize.scr_width*40/100,ScreenSize.scr_height*4/100));
        classBindingClose.setOpaque(true);
        classBindingClose.setVisible(false);
        classBindingClose.setBackground(new Color(216,59,1));

        springLayout.putConstraint(SpringLayout.NORTH,classBindingOpen,0,SpringLayout.NORTH,classBinding);
        springLayout.putConstraint(SpringLayout.WEST,classBindingOpen,0,SpringLayout.WEST,classBinding);
        springLayout.putConstraint(SpringLayout.EAST,classBindingOpen,0,SpringLayout.EAST,classBinding);

        springLayout.putConstraint(SpringLayout.NORTH,classBindingClose,0,SpringLayout.NORTH,classBinding);
        springLayout.putConstraint(SpringLayout.WEST,classBindingClose,0,SpringLayout.WEST,classBinding);
        springLayout.putConstraint(SpringLayout.EAST,classBindingClose,0,SpringLayout.EAST,classBinding);

        classBinding.add(classBindingOpen);
        classBinding.add(classBindingClose);

        classBindingOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

            }
        });

        return classBinding;
    }
}
