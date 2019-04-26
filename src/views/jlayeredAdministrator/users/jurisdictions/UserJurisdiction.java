package views.jlayeredAdministrator.users.jurisdictions;




import item.ScreenSize;
import views.jlayeredAdministrator.users.jurisdictions.purchase.PurchaseJurisdiction;
import views.jlayeredAdministrator.users.jurisdictions.sells.SellsJurisdiction;

import javax.swing.*;
import java.awt.*;

public class UserJurisdiction {
    public JPanel userJurisdiction(){
        JPanel userJurisdiction;

        SpringLayout springLayout=new SpringLayout();
        userJurisdiction=new JPanel(springLayout);

        SellsJurisdiction sj=new SellsJurisdiction();
        JPanel sellsJurisdiction=sj.sellsJurisdiction();
        sellsJurisdiction.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*40/100));

        PurchaseJurisdiction pj=new PurchaseJurisdiction();
        JPanel purchaseJurisdiction=pj.purchaseJurisdiction();
        purchaseJurisdiction.setPreferredSize(new Dimension(ScreenSize.scr_width*20/100,ScreenSize.scr_height*40/100));

        userJurisdiction.add(sellsJurisdiction);
        userJurisdiction.add(purchaseJurisdiction);

        springLayout.putConstraint(SpringLayout.NORTH,sellsJurisdiction,0,SpringLayout.NORTH,userJurisdiction);
        springLayout.putConstraint(SpringLayout.WEST,sellsJurisdiction,ScreenSize.scr_width*5/100,SpringLayout.WEST,userJurisdiction);

        springLayout.putConstraint(SpringLayout.NORTH,purchaseJurisdiction,0,SpringLayout.NORTH,userJurisdiction);
        springLayout.putConstraint(SpringLayout.WEST,purchaseJurisdiction,ScreenSize.scr_width*5/100,SpringLayout.EAST,sellsJurisdiction);


        return userJurisdiction;
    }
}
