package item;

import java.awt.*;

public class Fonts {    //创建字体类

    //粗体文字用于标题分类
    public static Font getFontH1Bold(){
        Font font=null;
        if (ScreenSize.scr_width>=2160){

            font=new Font("Microsoft YaHei UI",Font.BOLD,40);

        }else if (ScreenSize.scr_width<2160&ScreenSize.scr_width>=1600){

            font=new Font("Microsoft YaHei UI",Font.BOLD,28);

        }else if(ScreenSize.scr_width<1600){

            font=new Font("Microsoft YaHei UI",Font.BOLD,18);
        }
        return font;
    }

    //粗体文字用于标题
    public static Font getFontH2Bold(){
        Font font=null;
        if (ScreenSize.scr_width>=2160){

            font=new Font("Microsoft YaHei UI",Font.BOLD,32);

        }else if (ScreenSize.scr_width<2160&ScreenSize.scr_width>=1600){

            font=new Font("Microsoft YaHei UI",Font.BOLD,24);

        }else if(ScreenSize.scr_width<1600){

            font=new Font("Microsoft YaHei UI",Font.BOLD,15);
        }
        return font;
    }



    //常规符号字体
    public static Font getSymbolH0(){
        Font font=null;
        if (ScreenSize.scr_width>=2160){

            font=(new Font("Microsoft YaHei UI",Font.PLAIN,50));

        }else if (ScreenSize.scr_width<2160&ScreenSize.scr_width>=1600){

            font=(new Font("Microsoft YaHei UI",Font.PLAIN,40));

        }else if(ScreenSize.scr_width<1600){

            font=(new Font("Microsoft YaHei UI",Font.PLAIN,24));
        }
        return font;
    }

    //特大符号字体用于右上角关闭按钮
    public static Font getSymbolHmax(){
        Font font=null;
        if (ScreenSize.scr_width>=2160){

            font=(new Font("等线",Font.PLAIN,80));

        }else if (ScreenSize.scr_width<2160&ScreenSize.scr_width>=1600){

            font=(new Font("等线",Font.PLAIN,60));

        }else if(ScreenSize.scr_width<1600){

            font=(new Font("等线",Font.PLAIN,40));
        }
        return font;
    }

    //页面常规文字字体
    public static Font getFontStandard(){
        Font font=null;
        if (ScreenSize.scr_width>=2160){
            font=(new Font("Microsoft YaHei UI",Font.PLAIN,28));  //设置顶部标签字体
        }
        if (ScreenSize.scr_width<2160&ScreenSize.scr_width>=1600){
            font=(new Font("Microsoft YaHei UI",Font.PLAIN,20));
        }
        if (ScreenSize.scr_width<1600){
            font=(new Font("Microsoft YaHei UI",Font.PLAIN,12));
        }
        return font;
    }

    //常规文字用于搜索结果表格
    public static Font getFontH2Standard(){
        Font font=null;
        if (ScreenSize.scr_width>=2160){

            font=new Font("Microsoft YaHei UI",Font.PLAIN,32);

        }else if (ScreenSize.scr_width<2160&ScreenSize.scr_width>=1600){

            font=new Font("Microsoft YaHei UI",Font.PLAIN,24);

        }else if(ScreenSize.scr_width<1600){

            font=new Font("Microsoft YaHei UI",Font.PLAIN,15);
        }
        return font;
    }

    //常规文字用于表格头
    public static Font getFontH5Standard(){
        Font font=null;
        if (ScreenSize.scr_width>=2160){

            font=new Font("Microsoft YaHei UI",Font.PLAIN,24);

        }else if (ScreenSize.scr_width<2160&ScreenSize.scr_width>=1600){

            font=new Font("Microsoft YaHei UI",Font.PLAIN,16);

        }else if(ScreenSize.scr_width<1600){

            font=new Font("Microsoft YaHei UI",Font.PLAIN,12);
        }
        return font;
    }


}
