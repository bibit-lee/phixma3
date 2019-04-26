package views.jlayeredCommodity;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OperationTypeListener {
    MouseListener operationTypeListener;

    //商品操作类型监听器
    public MouseListener sapListener(){
        operationTypeListener =new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                String s=CommodityDetailPanel.operationType.getText();
                if (s.equals("销售")){
                    CommodityDetailPanel.operationType.setText("采购");
                }else{
                    CommodityDetailPanel.operationType.setText("销售");
                }
            }
        };
        return operationTypeListener;
    }

    public MouseListener sapdListener(){
        operationTypeListener=new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                String s=CommodityDetailPanel.operationType.getText();
                if (s.equals("销售")){
                    CommodityDetailPanel.operationType.setText("采购");
                }else if (s.equals("采购")){
                    CommodityDetailPanel.operationType.setText("调拨");
                }else if (s.equals("调拨")){
                    CommodityDetailPanel.operationType.setText("销售");
                }
            }
        };
        return operationTypeListener;
    }
}
