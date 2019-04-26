package titles.titleItem;


import item.Fonts;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitleLabel {
    public JLabel titleLabel(){
        JLabel titleLabelModel=new JLabel("",SwingConstants.CENTER);
        titleLabelModel.setFont(Fonts.getFontH2Bold());
        titleLabelModel.setForeground(new Color(255,255,255,120));
        titleLabelModel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                titleLabelModel.setForeground(new Color(38,38,38,255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                titleLabelModel.setForeground(new Color(255,255,255,120));
            }
        });
        return titleLabelModel;
    }
}
