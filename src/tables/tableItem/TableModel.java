package tables.tableItem;


import item.Fonts;
import item.ScreenSize;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;


public class TableModel {
    public JTable tableModel(DefaultTableModel dtm){
        JTable tableModel=new JTable(dtm){
            //以下方法禁用表格，使其只可查看不可编辑
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }

        };

        tableModel.setRowHeight(ScreenSize.scr_height*6/100);  //设置表格行高
        tableModel.setForeground(new Color(102,51,153));  //设置表格字体色
        tableModel.setFont(Fonts.getFontStandard());   //设置表格字体大小
        tableModel.setSelectionBackground(new Color(245,245,245,200));  //设置表格行选中背景色
        tableModel.setSelectionForeground(new Color(102,51,153));   //设置表格行选中字体色
        tableModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //设置表格行选择模式为单选模式
        tableModel.setShowGrid(false);  //去除表格网格线
        tableModel.setBorder(new LineBorder(new Color(229,229,229),1,true)); //为表格增加外边框
        tableModel.setIntercellSpacing(new Dimension(0,0));//设置单元格之间的边距
        tableModel.setEnabled(false);  //设置表格单元格不可选中（去除单元格边框线）


        tableModel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                int row=tableModel.rowAtPoint(e.getPoint());

                //如果表格行为空则返回-1，则选中范围将报错，使用不能为-1
                if (row!=-1){
                    tableModel.setRowSelectionInterval(row,row);
                }else {
                    tableModel.clearSelection();
                }
            }
        });

        tableModel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                tableModel.clearSelection();
            }
        });

        return tableModel;
    }
}
