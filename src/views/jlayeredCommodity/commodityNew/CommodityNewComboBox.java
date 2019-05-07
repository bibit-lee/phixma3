package views.jlayeredCommodity.commodityNew;


import item.Fonts;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

//新增商品时品牌属性等输入选择框

public class CommodityNewComboBox {

    public JComboBox commodityNewComboBox(){

        JComboBox<String> commodityNewComboBox;

        commodityNewComboBox=new JComboBox<String>();
        commodityNewComboBox.setFont(Fonts.getFontH2Bold());
        commodityNewComboBox.setEditable(true);  //设置下拉框可编辑
        commodityNewComboBox.setBorder(BorderFactory.createLineBorder(new Color(148,148,148)));

        commodityNewComboBox.setUI(new BasicComboBoxUI(){
            protected JButton createArrowButton(){
                JButton selectButton=new JButton("▼");
                selectButton.setFont(Fonts.getFontStandard());
                return selectButton;
            }
        });

        return commodityNewComboBox;
    }
}
