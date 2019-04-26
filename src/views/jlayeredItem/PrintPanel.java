package views.jlayeredItem;


import item.Fonts;
import item.ScreenSize;
import javax.swing.*;
import java.awt.*;

public class PrintPanel {
    public JPanel printPanel(){
        JPanel printPanel;
        SpringLayout springLayout=new SpringLayout();
        printPanel=new JPanel(springLayout);

        JLabel export=new JLabel("导出",SwingConstants.CENTER);
        export.setBackground(new Color(7,110,189));
        export.setForeground(Color.WHITE);
        export.setOpaque(true);
        export.setFont(Fonts.getFontStandard());
        export.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,ScreenSize.scr_height*5/100));

        JLabel print=new JLabel("打印",SwingConstants.CENTER);
        print.setBackground(new Color(7,110,189));
        print.setForeground(Color.WHITE);
        print.setOpaque(true);
        print.setFont(Fonts.getFontStandard());
        print.setPreferredSize(new Dimension(ScreenSize.scr_width*5/100,ScreenSize.scr_height*5/100));

        printPanel.add(export);
        printPanel.add(print);

        springLayout.putConstraint(SpringLayout.NORTH,export,0,SpringLayout.NORTH,printPanel);
        springLayout.putConstraint(SpringLayout.WEST,export,ScreenSize.scr_width*2/100,SpringLayout.WEST,printPanel);

        springLayout.putConstraint(SpringLayout.NORTH,print,0,SpringLayout.NORTH,printPanel);
        springLayout.putConstraint(SpringLayout.WEST,print,ScreenSize.scr_width*3/100,SpringLayout.EAST,export);




        return printPanel;
    }
}
