package tops;


import item.Conn;
import item.Fonts;
import item.ScreenSize;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TopAdvert {
    public JPanel getTopAdvert(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setOpaque(false);

        String topLabelText=null;  //实例化字符串型标题
        Conn conn=new Conn();
        Connection con1=conn.getCon1();

        /* 捕捉获取过程的异常 */
        try{
            Statement sql=con1.createStatement();  //实例化接口类对象
            ResultSet topLabel=sql.executeQuery("SELECT * FROM toplabel WHERE id=1");  //执行SQL语句，返回顶部标题数据集

            //指针指向数据
            while (topLabel.next()){
                String title=topLabel.getString("title");  //实例化字符串title
                String click=topLabel.getString("click");  //实例化点击字符串click
                topLabelText=title+click;  //顶部标题内容为：两个字段组合显示
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel jLabel=new JLabel(topLabelText,SwingConstants.CENTER);  //实例化标签，内容从数据集获取，文本居中
        jLabel.setForeground(Color.WHITE);  //设置文字颜色
        jLabel.setBackground(new Color(54,54,54,150));   //设置背景颜色和透明度，0最小（全透明），255最大（不透明）
        jLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));  //设置鼠标在标签上的样式
        jLabel.setOpaque(true);  //标签默认为透明的，设置标签不透明
        jLabel.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height*4/100);
        jLabel.setFont(Fonts.getFontStandard());



        jPanel.add(jLabel);


        return jPanel;  //返回标签实例对象

    }

}
