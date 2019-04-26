package mainFrame;


import item.Conn;
import item.Fonts;
import item.ScreenSize;
import titles.MainTitle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    public JPanel login(){
        JPanel login;

        SpringLayout springLayout=new SpringLayout();
        login=new JPanel(springLayout);
        login.setBackground(Color.WHITE);
        login.setFocusable(true);

        ImageIcon loginLogo=new ImageIcon("src/res/assets.png");
        int loginLoginWidth=loginLogo.getIconWidth();
        int loginLoginHeight=loginLogo.getIconHeight();
        loginLogo.setImage(loginLogo.getImage().getScaledInstance(ScreenSize.scr_width*8/100,(ScreenSize.scr_width*8/100)*loginLoginHeight/loginLoginWidth,Image.SCALE_AREA_AVERAGING));
        JLabel logoLabel=new JLabel(loginLogo);

        JLabel loginLabel=new JLabel("登录");
        loginLabel.setFont(Fonts.getFontH1Bold());
        logoLabel.setForeground(new Color(64,64,64));


        //错误提示文字
        String psdWrong="密码不对。如果您忘记密码，请联系管理员重置!";
        String userWrong="账号不对。如果您忘记账号，请联系管理员重置!";

        //默认提示文字
        String psdInit="请输入登录密码";
        String userInit="请输入登录账号";



        //账号输入框
        JTextField loginTextField=new JTextField();
        loginTextField.setText(userInit);
        loginTextField.setFont(Fonts.getFontH2Standard());
        loginTextField.setBorder(new EmptyBorder(0,0,0,20));
        loginTextField.setForeground(Color.GRAY);
        loginTextField.enableInputMethods(false);   //禁用输入法

        //密码输入框
        JTextField passWordField=new JTextField();
        passWordField.setText(psdInit);
        passWordField.setFont(Fonts.getFontH2Standard());
        passWordField.setBorder(new EmptyBorder(0,0,0,20));
        passWordField.setForeground(Color.GRAY);
        passWordField.enableInputMethods(false);

        //账户输入框焦点监听
        loginTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (loginTextField.getText().equals(userInit)||loginTextField.getText().equals(userWrong)){
                    loginTextField.setForeground(Color.BLACK);
                    loginTextField.setText("");
                }
                if (passWordField.getText().equals(psdWrong)){
                    passWordField.setText(psdInit);
                    passWordField.setForeground(Color.GRAY);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (loginTextField.getText().equals("")){
                    loginTextField.setText(userInit);
                    loginTextField.setForeground(Color.GRAY);
                }
            }
        });



        passWordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passWordField.getText().equals(psdInit)||passWordField.getText().equals(psdWrong)){
                    passWordField.setForeground(Color.BLACK);
                    passWordField.setText("");
                }
                if (loginTextField.getText().equals(userWrong)){
                    loginTextField.setText(userInit);
                    loginTextField.setForeground(Color.GRAY);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passWordField.getText().equals("")){
                    passWordField.setText(psdInit);
                    passWordField.setForeground(Color.GRAY);
                }
            }
        });



        //分隔线
        JSeparator loginFieldLine=new JSeparator();
        JSeparator passWordFieldLine=new JSeparator();



        //设置标签
        JLabel setUp=new JLabel("登陆选项");
        setUp.setFont(Fonts.getFontStandard());
        setUp.setForeground(new Color(0,103,184));

        JLabel enter=new JLabel("登入",SwingConstants.CENTER);
        enter.setPreferredSize(new Dimension(ScreenSize.scr_width*8/100,ScreenSize.scr_height*4/100));
        enter.setFont(Fonts.getFontH2Standard());
        enter.setBackground(new Color(0,103,184));
        enter.setOpaque(true);
        enter.setForeground(Color.WHITE);

        Conn a=new Conn();
        Connection conn=a.getCon();



        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                enter.grabFocus();  //点击时强制获取焦点

                //获取登录时间信息
                Date now=new Date();
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String times=dateFormat.format(now);

                //获取登录计算机名称信息
                Map<String,String> map=System.getenv();
                String userName1 = map.get("USERNAME").trim();// 获取计算机用户名
                String computerName = map.get("COMPUTERNAME").trim();// 获取计算机名

                try{
                    //获取用户框和密码框输入内容
                    String userNameStr1=loginTextField.getText();
                    String passWordStr1=passWordField.getText();
                    //限制输入内容为数字和英文
                    String regEx="[^(a-zA-Z0-9)]";
                    String aa = "";
                    Pattern p = Pattern.compile(regEx);
                    Matcher m1=p.matcher(userNameStr1);
                    Matcher m2=p.matcher(passWordStr1);
                    String userNameStr = m1.replaceAll(aa).trim();
                    String passWordStr = m2.replaceAll(aa).trim();



                    //如果输入框为空，点击登录时
                    if (userNameStr.equals(userInit)&passWordStr.equals(psdInit)){
                        loginTextField.setForeground(new Color(232,17,35));
                        passWordField.setForeground(new Color(232,17,35));
                    }
                    Statement userInSql=conn.createStatement();
                    Statement sql=conn.createStatement();
                    ResultSet loginRes=sql.executeQuery("SELECT * FROM users WHERE user_loginname='"+userNameStr+"'OR user_password='"+passWordStr+"'");

                    //先行判断数据集是否为空值
                    if (loginRes.isBeforeFirst()){

                        //数据集非空,则进入循环
                        while (loginRes.next()){
                            String userName=loginRes.getString("user_loginname");
                            String passWord=loginRes.getString("user_password");
                            String realName=loginRes.getString("user_realname");
                            String commonId=loginRes.getString("common_id");

                            //用户名和密码正确时执行：
                            if (userNameStr.equals(userName)&passWordStr.equals(passWord)){
                                //登录信息插入数据库
                                userInSql.execute("INSERT INTO operation (common_id,loginTime,pcName,pc_userName,onLine) VALUES ('"+commonId+"','"+times+"','"+computerName+"','"+userName1+"','0') ");

                                JLayeredView.jLayeredView.remove(JLayeredView.login); //删除登录面板
                                MainTitle.helloUserOpen.setText("您好，"+realName+" !  ∨");
                                MainTitle.helloUserClose.setText("您好，"+realName+" !  ∧");
                                MainTitle.helloUserHid.setText(commonId);
                                String userGroup=loginRes.getString("user_group");
                                JLayeredTop.light.setVisible(false);
                                JLayeredTitle.light.setVisible(false);
                                JLayeredView.light.setVisible(false);
                                JLayeredTop.topAdvert.setVisible(true);
                                JLayeredTitle.mainTitle.setVisible(true);
                                loginTextField.setForeground(Color.GRAY);
                                loginTextField.setText(userInit);
                                passWordField.setForeground(Color.GRAY);
                                passWordField.setText(psdInit);

                                if (userGroup.equals("0")){
                                    MainTitle.j1Commodity.setVisible(false);
                                    MainTitle.j2Bill.setVisible(false);
                                    MainTitle.j3Object.setVisible(false);
                                    MainTitle.j4Account.setVisible(false);
                                    MainTitle.j5Mission.setVisible(false);
                                    MainTitle.j6Life.setVisible(false);
                                    JLayeredView.administrator.setVisible(true);

                                }else {
                                    JLayeredView.recommend.setVisible(true);
                                }
                            }

                            //用户名正确，密码错误时执行：
                            else if(userNameStr.equals(userName)){
                                passWordField.setForeground(new Color(232,17,35));
                                passWordField.setText(psdWrong);
                            }
                            //密码正确，用户名错误时执行：
                            else if(passWordStr.equals(passWord)){
                                loginTextField.setForeground(new Color(232,17,35));
                                loginTextField.setText(userWrong);
                            }
                        }
                    }else {
                        //数据集为空时，显示内容
                        loginTextField.setForeground(new Color(232,17,35));
                        loginTextField.setText(userWrong);
                        passWordField.setForeground(new Color(232,17,35));
                        passWordField.setText(psdWrong);
                    }

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });





        login.add(logoLabel);
        login.add(loginLabel);
        login.add(loginFieldLine);
        login.add(passWordFieldLine);
        login.add(loginTextField);
        login.add(passWordField);
        login.add(setUp);
        login.add(enter);

        springLayout.putConstraint(SpringLayout.NORTH,logoLabel,ScreenSize.scr_height*5/100,SpringLayout.NORTH,login);
        springLayout.putConstraint(SpringLayout.WEST,logoLabel,ScreenSize.scr_width*3/100,SpringLayout.WEST,login);

        springLayout.putConstraint(SpringLayout.NORTH,loginLabel,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,logoLabel);
        springLayout.putConstraint(SpringLayout.WEST,loginLabel,ScreenSize.scr_width*3/100,SpringLayout.WEST,login);

        springLayout.putConstraint(SpringLayout.NORTH,loginTextField,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,loginLabel);
        springLayout.putConstraint(SpringLayout.WEST,loginTextField,ScreenSize.scr_width*3/100,SpringLayout.WEST,login);
        springLayout.putConstraint(SpringLayout.EAST,loginTextField,-ScreenSize.scr_width*3/100,SpringLayout.EAST,login);

        springLayout.putConstraint(SpringLayout.NORTH,loginFieldLine,ScreenSize.scr_height/100,SpringLayout.SOUTH,loginTextField);
        springLayout.putConstraint(SpringLayout.WEST,loginFieldLine,ScreenSize.scr_width*3/100,SpringLayout.WEST,login);
        springLayout.putConstraint(SpringLayout.EAST,loginFieldLine,-ScreenSize.scr_width*3/100,SpringLayout.EAST,login);

        springLayout.putConstraint(SpringLayout.NORTH,passWordField,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,loginFieldLine);
        springLayout.putConstraint(SpringLayout.WEST,passWordField,ScreenSize.scr_width*3/100,SpringLayout.WEST,login);
        springLayout.putConstraint(SpringLayout.EAST,passWordField,-ScreenSize.scr_width*3/100,SpringLayout.EAST,login);

        springLayout.putConstraint(SpringLayout.NORTH,passWordFieldLine,ScreenSize.scr_height/100,SpringLayout.SOUTH,passWordField);
        springLayout.putConstraint(SpringLayout.WEST,passWordFieldLine,ScreenSize.scr_width*3/100,SpringLayout.WEST,login);
        springLayout.putConstraint(SpringLayout.EAST,passWordFieldLine,-ScreenSize.scr_width*3/100,SpringLayout.EAST,login);

        springLayout.putConstraint(SpringLayout.NORTH,setUp,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,passWordFieldLine);
        springLayout.putConstraint(SpringLayout.WEST,setUp,ScreenSize.scr_width*3/100,SpringLayout.WEST,login);
        springLayout.putConstraint(SpringLayout.EAST,setUp,-ScreenSize.scr_width*3/100,SpringLayout.EAST,login);

        springLayout.putConstraint(SpringLayout.NORTH,enter,ScreenSize.scr_height*2/100,SpringLayout.SOUTH,setUp);
        springLayout.putConstraint(SpringLayout.EAST,enter,-ScreenSize.scr_width*3/100,SpringLayout.EAST,login);

        return login;
    }
}
