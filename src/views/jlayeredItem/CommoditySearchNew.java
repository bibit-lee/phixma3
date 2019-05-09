package views.jlayeredItem;


import item.Fonts;
import item.ScreenSize;
import views.jlayeredCommodity.commodityNew.CommodityInfo;


import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.util.*;
import java.util.List;


public class CommoditySearchNew {

    public static JTextField commodityNewTextField;


    public JPanel commoditySearchNew(){


        class commodityNewBorder extends AbstractBorder{
            private final Color borderColor = new Color(255, 69, 0);  //设置边框颜色
            private int[]xs={ScreenSize.scr_width*5/100, ScreenSize.scr_width*10/100, ScreenSize.scr_width*11/100, ScreenSize.scr_width*35/100, ScreenSize.scr_width*35/100, ScreenSize.scr_width*5/100};   //声明多边形填充绘图 x 轴坐标数组
            private int[]ys={ScreenSize.scr_height*2/100, ScreenSize.scr_height*2/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*5/100, ScreenSize.scr_height*10/100, ScreenSize.scr_height*10/100};   //声明多边形填充绘图 y 轴坐标数组

            //图形绘制方法
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
                Graphics2D g2d=(Graphics2D)g;
                g2d.setColor(new Color(148,148,148));  //设置图形填充颜色
                g2d.fillPolygon(xs,ys,6);  //设置图形坐标和顶点
                g2d.setColor(borderColor);  //设置图形边框颜色
            }
        }
        JPanel commoditySearchNew;
        commoditySearchNew=new JPanel(null);
        commoditySearchNew.setBorder(new commodityNewBorder());  //绘制图形


        //产品输入框
        commodityNewTextField=new JTextField();
        commodityNewTextField.setBorder(new EmptyBorder(0,ScreenSize.scr_width/100,0,ScreenSize.scr_width/100));  //设置输入文本边距
        commodityNewTextField.setFont(Fonts.getFontH2Bold());
        commodityNewTextField.setBackground(new Color(148,148,148));
        commodityNewTextField.setBounds(ScreenSize.scr_width*5/100, ScreenSize.scr_height*5/100, ScreenSize.scr_width*30/100, ScreenSize.scr_height*5/100);  //设置文本输入框尺寸，尽量以120的倍数建立

        commoditySearchNew.add(commodityNewTextField);
        List<String> list = new ArrayList<>();




        //新增商品搜索框添加文本监听
        commodityNewTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            //文本插入时执行
            public void insertUpdate(DocumentEvent e) {

                list.clear();
                try {
                    Document document=e.getDocument();
                    String insertText=document.getText(0,document.getLength());  //获取文本内容
                    int i=insertText.length();  //获取文本长度

                    //字符串循环添加到 List集合
                    for (int j=0;j<i;j++){
                        String oneStr=insertText.substring(j,j+1);
                        if (oneStr.equals("'")|oneStr.equals(" ")){
                            //如果是空格或者单引号，则不加入数据集
                        }else {
                            list.add("AND classifyDescribe LIKE "+"'%"+oneStr+"%'");  //拼接字符串
                        }
                    }

                    //循环拼接每个字符串
                    int x=0;
                    String a="";
                    while (x<list.size()){
                        a += list.get(x);  //拼接集合的所有元素
                        x++;
                    }

                    CommodityInfo ci=new CommodityInfo();
                    ci.getCommodityInfo(a);



                }catch (BadLocationException e1){
                    e1.printStackTrace();
                }




            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        return commoditySearchNew;

    }

}
