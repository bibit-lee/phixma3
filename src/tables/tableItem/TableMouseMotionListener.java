package tables.tableItem;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class TableMouseMotionListener {

    public MouseMotionListener tableMouseMotionListener(JTable table){
        MouseMotionListener mMml;



        mMml=new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int row=table.rowAtPoint(e.getPoint());

                //如果表格行为空则返回-1，则选中范围将报错，使用不能为-1
                if (row!=-1){
                    table.setRowSelectionInterval(row,row);
                }else {
                    table.clearSelection();
                }
            }
        };
        return mMml;
    }
}
