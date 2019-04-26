package views.jlayeredAdministrator;


import item.Fonts;
import item.ScreenSize;
import mainFrame.JLayeredView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Administrator {
    public JPanel administrator(){
        JPanel administrator;


        administrator=new JPanel(new GridLayout(3,3,5,5));
        administrator.setOpaque(false);

        JLabel users=new JLabel("用户",SwingConstants.CENTER);
        users.setBackground(Color.PINK);
        users.setOpaque(true);
        users.setFont(Fonts.getFontH2Standard());
        users.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));

        JLabel client=new JLabel("客户",SwingConstants.CENTER);
        client.setBackground(Color.PINK);
        client.setOpaque(true);
        client.setFont(Fonts.getFontH2Standard());
        client.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));

        JLabel supplier=new JLabel("供应商",SwingConstants.CENTER);
        supplier.setBackground(Color.PINK);
        supplier.setOpaque(true);
        supplier.setFont(Fonts.getFontH2Standard());
        supplier.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));

        JLabel logistics=new JLabel("物流",SwingConstants.CENTER);
        logistics.setBackground(Color.PINK);
        logistics.setOpaque(true);
        logistics.setFont(Fonts.getFontH2Standard());
        logistics.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));

        JLabel commodity=new JLabel("商品",SwingConstants.CENTER);
        commodity.setBackground(Color.PINK);
        commodity.setOpaque(true);
        commodity.setFont(Fonts.getFontH2Standard());
        commodity.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));

        JLabel depot=new JLabel("仓库",SwingConstants.CENTER);
        depot.setBackground(Color.PINK);
        depot.setOpaque(true);
        depot.setFont(Fonts.getFontH2Standard());
        depot.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));

        JLabel account=new JLabel("仓库",SwingConstants.CENTER);
        account.setBackground(Color.PINK);
        account.setOpaque(true);
        account.setFont(Fonts.getFontH2Standard());
        account.setPreferredSize(new Dimension(ScreenSize.scr_width*10/100,ScreenSize.scr_height*5/100));


        administrator.add(users);
        administrator.add(client);
        administrator.add(supplier);
        administrator.add(logistics);
        administrator.add(commodity);
        administrator.add(depot);
        administrator.add(account);

        users.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JLayeredView.jLayeredView.remove(JLayeredView.administrator);
                JLayeredView.jLayeredView.add(JLayeredView.adminUsers,Integer.valueOf(100));

            }
        });

        return administrator;
    }
}
