package item;


import com.mysql.fabric.xmlrpc.base.Value;
import com.sun.deploy.panel.NumberDocument;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    public static JTextField amount;
    public JPanel numbers(){
        JPanel numbers;
        SpringLayout springLayout=new SpringLayout();
        numbers=new JPanel(springLayout);
        numbers.setBackground(Color.WHITE);

        JLabel title=new JLabel("数量：",SwingConstants.LEFT);
        title.setFont(Fonts.getFontStandard());
        title.setSize(ScreenSize.scr_width*2/100,ScreenSize.scr_height*2/100);

        JLabel reduce=new JLabel("−",SwingConstants.CENTER);
        reduce.setFont(Fonts.getFontH1Bold());
        reduce.setPreferredSize(new Dimension(ScreenSize.scr_width*2/100,ScreenSize.scr_height*2/100));
        reduce.setBackground(new Color(204,204,204));
        reduce.setForeground(new Color(102,102,102));
        reduce.setOpaque(true);

        amount=new JTextField();
        amount.setPreferredSize(new Dimension(ScreenSize.scr_width*3/100,ScreenSize.scr_height*2/100));
        amount.setBorder(new LineBorder(new Color(204,204,204)));
        amount.setHorizontalAlignment(JTextField.CENTER);
        amount.setFont(Fonts.getFontStandard());
        amount.setDocument(new NumberDocument());
        amount.setText("1");




        JLabel increase=new JLabel("+",SwingConstants.CENTER);
        increase.setFont(Fonts.getFontH1Bold());
        increase.setPreferredSize(new Dimension(ScreenSize.scr_width*2/100,ScreenSize.scr_height*2/100));
        increase.setBackground(new Color(204,204,204));
        increase.setForeground(new Color(102,102,102));
        increase.setOpaque(true);


        springLayout.putConstraint(SpringLayout.NORTH,title,0,SpringLayout.NORTH,numbers);
        springLayout.putConstraint(SpringLayout.WEST,title,0,SpringLayout.WEST,numbers);
        springLayout.putConstraint(SpringLayout.SOUTH,title,0,SpringLayout.SOUTH,numbers);

        springLayout.putConstraint(SpringLayout.NORTH,reduce,ScreenSize.scr_height/100,SpringLayout.NORTH,numbers);
        springLayout.putConstraint(SpringLayout.WEST,reduce,0,SpringLayout.EAST,title);
        springLayout.putConstraint(SpringLayout.SOUTH,reduce,-ScreenSize.scr_height/100,SpringLayout.SOUTH,numbers);

        springLayout.putConstraint(SpringLayout.NORTH,amount,ScreenSize.scr_height/100,SpringLayout.NORTH,numbers);
        springLayout.putConstraint(SpringLayout.WEST,amount,0,SpringLayout.EAST,reduce);
        springLayout.putConstraint(SpringLayout.SOUTH,amount,-ScreenSize.scr_height/100,SpringLayout.SOUTH,numbers);

        springLayout.putConstraint(SpringLayout.NORTH,increase,ScreenSize.scr_height/100,SpringLayout.NORTH,numbers);
        springLayout.putConstraint(SpringLayout.WEST,increase,0,SpringLayout.EAST,amount);
        springLayout.putConstraint(SpringLayout.SOUTH,increase,-ScreenSize.scr_height/100,SpringLayout.SOUTH,numbers);

        numbers.add(title);
        numbers.add(reduce);
        numbers.add(amount);
        numbers.add(increase);

        reduce.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int a=Integer.parseInt(amount.getText());
                String b=String.valueOf(a-1);
                amount.setText(b);
                if (a-1<=0){
                    amount.setText("1");
                }
            }
        });

        increase.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int a=Integer.parseInt(amount.getText());
                String b=String.valueOf(a+1);
                amount.setText(b);
            }
        });


        return numbers;
    }
}
