package views.jlayeredAdministrator.users;


import item.Fonts;
import item.ScreenSize;
import mainFrame.JLayeredView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminUsers {
    public JPanel adminUsers(){
        JPanel adminUsers;
        SpringLayout springLayout=new SpringLayout();
        adminUsers=new JPanel(springLayout);

        JLabel exit=new JLabel("×",SwingConstants.CENTER);
        exit.setFont(Fonts.getSymbolHmax());
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*3/100));

        JLabel jurisdiction=new JLabel("权限设置",SwingConstants.CENTER);
        jurisdiction.setFont(Fonts.getFontH2Standard());
        jurisdiction.setForeground(Color.WHITE);
        jurisdiction.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));
        jurisdiction.setOpaque(true);
        jurisdiction.setBackground(Color.BLUE);

        adminUsers.add(exit);
        adminUsers.add(jurisdiction);

        springLayout.putConstraint(SpringLayout.NORTH,exit,0,SpringLayout.NORTH,adminUsers);
        springLayout.putConstraint(SpringLayout.EAST,exit,0,SpringLayout.EAST,adminUsers);

        springLayout.putConstraint(SpringLayout.NORTH,jurisdiction,0,SpringLayout.NORTH,adminUsers);
        springLayout.putConstraint(SpringLayout.WEST,jurisdiction,0,SpringLayout.WEST,adminUsers);

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JLayeredView.jLayeredView.remove(JLayeredView.adminUsers);
                JLayeredView.jLayeredView.add(JLayeredView.administrator,Integer.valueOf(100));
            }
        });

        jurisdiction.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JLayeredView.jLayeredView.remove(JLayeredView.adminUsers);
                JLayeredView.jLayeredView.add(JLayeredView.userJurisdiction);
            }
        });

        return adminUsers;
    }
}
