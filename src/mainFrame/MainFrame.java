package mainFrame;


import item.ScreenSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame{
    public static JFrame jFrame;

    private MainFrame(){
        jFrame=new JFrame("Model S\n" +
                "Model X\n" +
                "Model 3\n" +
                "Roadster\n" +
                "Energy");
        jFrame.setExtendedState(MAXIMIZED_BOTH);    //设置窗体展开方式
        Container container=jFrame.getContentPane();  //窗体添加内容面板作为容器
        SpringLayout springLayout=new SpringLayout();  //实例化弹簧布局管理器
        container.setLayout(springLayout);  //内容面板添加弹簧布局管理器

        //窗口顶端文字链接--使用层面板
        JLayeredTop jlt=new JLayeredTop();  //实例化顶部标语层面板
        JLayeredPane jLayeredTop=jlt.topPanel();
        jLayeredTop.setPreferredSize(new Dimension(ScreenSize.scr_width,ScreenSize.scr_height*4/100));

        //文字链接下方主标题导航栏--使用层面板
        JLayeredTitle title=new JLayeredTitle();  //实例化标题栏层面板
        JLayeredPane jLayeredTitle=title.jLayeredTitle();
        jLayeredTitle.setPreferredSize(new Dimension(ScreenSize.scr_width,ScreenSize.scr_height*5/100));


        //主视图面板--使用层面板
        JLayeredView jlm =new JLayeredView();  //实例化主视图层面板
        JLayeredPane jLayeredView = jlm.jLayeredView();

        ImageIcon backIcon=new ImageIcon("src/res/homepage-models@2x.jpg");  //实例化背景图片
        JLabel backLabel=new JLabel(backIcon);  //实例化空标签，并添加图片
        ImageIcon backIcon1=new ImageIcon("src/res/homepage-models.jpg");
        JLabel backLabel2=new JLabel(backIcon1);
        ImageIcon backIcon3=new ImageIcon("src/res/homepage-models.jpg");
        backIcon3.setImage(backIcon3.getImage().getScaledInstance(ScreenSize.scr_width,ScreenSize.scr_height,Image.SCALE_DEFAULT));

        container.add(jLayeredTop);  //内容面板添加元素
        container.add(jLayeredTitle);
        container.add(jLayeredView);

        //根据不同的屏幕分辨率使用不同尺寸的背景图片
        if (ScreenSize.scr_width>=2160& ScreenSize.scr_width<=2880){
            container.add(backLabel);
            backLabel.setBounds(0,0,ScreenSize.scr_width,ScreenSize.scr_height);

        }else if (ScreenSize.scr_width>=1440& ScreenSize.scr_width<2160){
            JLabel backLabel3=new JLabel(backIcon3);
            container.add(backLabel2);
            backLabel3.setBounds(0,0,ScreenSize.scr_width,ScreenSize.scr_height);

        }else if (ScreenSize.scr_width<1440){
            container.add(backLabel2);
            backLabel2.setBounds(0,0,ScreenSize.scr_width,ScreenSize.scr_height);
        }


        //弹簧布局管理器设置元素的布局


        springLayout.putConstraint(SpringLayout.NORTH,jLayeredTop,0,SpringLayout.NORTH,container);
        springLayout.putConstraint(SpringLayout.WEST,jLayeredTop,0,SpringLayout.WEST,container);
        springLayout.putConstraint(SpringLayout.EAST,jLayeredTop,0,SpringLayout.EAST,container);

        springLayout.putConstraint(SpringLayout.NORTH,jLayeredTitle,0,SpringLayout.SOUTH,jLayeredTop);
        springLayout.putConstraint(SpringLayout.WEST,jLayeredTitle,0 ,SpringLayout.WEST,container);
        springLayout.putConstraint(SpringLayout.EAST,jLayeredTitle,0,SpringLayout.EAST,container);

        springLayout.putConstraint(SpringLayout.NORTH,jLayeredView,0,SpringLayout.SOUTH,jLayeredTitle);
        springLayout.putConstraint(SpringLayout.WEST,jLayeredView,0,SpringLayout.WEST,container);
        springLayout.putConstraint(SpringLayout.EAST,jLayeredView,0,SpringLayout.EAST,container);
        springLayout.putConstraint(SpringLayout.SOUTH,jLayeredView,0,SpringLayout.SOUTH,container);

        //顶部广告层面板添加鼠标点击事件
        jLayeredTop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int i=e.getButton();
                if (i==MouseEvent.BUTTON1){
                    container.remove(jLayeredTop);
                    springLayout.putConstraint(SpringLayout.NORTH,jLayeredTitle,0,SpringLayout.NORTH,container);
                    springLayout.putConstraint(SpringLayout.WEST,jLayeredTitle,0 ,SpringLayout.WEST,container);
                    springLayout.putConstraint(SpringLayout.EAST,jLayeredTitle,0,SpringLayout.EAST,container);
                    container.setVisible(false);
                    container.setVisible(true);
                }
            }
        });

        jFrame.setVisible(true);  //设置窗体可视
    }

    public static void main(String[] args) {
        new MainFrame();   //实例化窗体对象
    }

}
