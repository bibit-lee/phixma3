package mainFrame;


import item.Light;
import item.ScreenSize;
import views.jlayeredAdministrator.users.AdminUsers;
import views.jlayeredAdministrator.users.jurisdictions.UserJurisdiction;
import views.jlayeredCommodity.CommodityDetailPanel;
import views.jlayeredCommodity.CommodityNewPanel;
import views.jlayeredCommodity.CommoditySetPanel;
import views.jlayeredCommodity.CommodityViewPanel;
import views.jlayeredItem.CommoditySearchField;
import views.jlayeredItem.CommoditySearchFieldOption;
import views.jlayeredAdministrator.Administrator;
import views.jlayeredMain.Recommend;

import javax.swing.*;
import java.awt.*;


public class JLayeredView {

    public static JLayeredPane jLayeredView;

    public static JPanel light;
    public static JPanel login;
    public static JPanel helloUser;
    //超级管理员界面
    public static JPanel administrator;
    public static JPanel adminUsers;
    public static JPanel userJurisdiction;
    //主界面面板
    public static JPanel recommend;
    //产品界面面板
    public static JPanel commoditySetPanel;
    public static JPanel commoditySearch;
    public static JPanel commodityViewPanel;
    public static JPanel commoditySearchFieldOption;
    public static JPanel commodityDetailPanel;
    public static JPanel commodityNew;

    public JLayeredPane jLayeredView(){
        jLayeredView=new JLayeredPane();

        //公共灯光聚焦层
        Light c3=new Light();
        light=c3.light();
        light.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height);  //设置坐标和尺寸


        //登陆界面
        Login lg=new Login();
        login=lg.login();
        login.setBounds(ScreenSize.scr_width*34/100,ScreenSize.scr_height*15/100,ScreenSize.scr_width*32/100,ScreenSize.scr_height*37/100);

        //Hello用户面板
        HelloUser hu=new HelloUser();
        helloUser=hu.helloUser();
        helloUser.setBounds(ScreenSize.scr_width*80/100,0,ScreenSize.scr_width*15/100,ScreenSize.scr_height*30/100);

        /*超级管理员界面*/

        //超级管理员-主界面
        Administrator admin=new Administrator();
        administrator=admin.administrator();
        administrator.setBounds(ScreenSize.scr_width*5/100,0, ScreenSize.scr_width*90/100,ScreenSize.scr_height*90/100);

        //超级管理员-用户界面
        AdminUsers au=new AdminUsers();
        adminUsers=au.adminUsers();
        adminUsers.setBounds(ScreenSize.scr_width*5/100,0, ScreenSize.scr_width*90/100,ScreenSize.scr_height*90/100);

        //超级管理员-用户-用户权限管理
        UserJurisdiction uj=new UserJurisdiction();
        userJurisdiction=uj.userJurisdiction();
        userJurisdiction.setBounds(ScreenSize.scr_width*5/100,0, ScreenSize.scr_width*90/100,ScreenSize.scr_height*90/100);


        /*超级管理员界面*/

        /*/主界面*/
        Recommend rec=new Recommend();
        recommend=rec.recommend();
        recommend.setBounds(0,ScreenSize.scr_height*51/100,ScreenSize.scr_width,ScreenSize.scr_height*18/10);

        /*/主界面*/


        /*/产品页面*/

        //产品设置面板
        CommoditySetPanel csp=new CommoditySetPanel();
        commoditySetPanel=csp.commoditySetPanel();
        commoditySetPanel.setBounds(ScreenSize.scr_width*30/100,ScreenSize.scr_height*10/100,ScreenSize.scr_width*40/100,ScreenSize.scr_height*40/100);

        //产品搜索框位于：产品--第一层
        CommoditySearchField csf=new CommoditySearchField();
        commoditySearch=csf.commoditySearch();
        commoditySearch.setBounds(0,0, ScreenSize.scr_width,ScreenSize.scr_height*10/100);

        //产品筛选面板位于：产品--第二层
        CommoditySearchFieldOption cSfo=new CommoditySearchFieldOption();
        commoditySearchFieldOption=cSfo.commoditySearchFieldOption();
        commoditySearchFieldOption.setBounds(ScreenSize.scr_width*5/100,ScreenSize.scr_height*10/100,ScreenSize.scr_width*90/100,ScreenSize.scr_height*15/100);


        //灯光过滤层位于：产品--第三层

        //产品搜索结果面板位于：产品--第四层
        CommodityViewPanel cvp=new CommodityViewPanel();
        commodityViewPanel=cvp.commodityViewPanel();
        commodityViewPanel.setBounds(ScreenSize.scr_width*5/100,0, ScreenSize.scr_width*90/100,ScreenSize.scr_height*90/100);


        //产品详情面板
        CommodityDetailPanel cdp=new CommodityDetailPanel();
        commodityDetailPanel=cdp.commodityDetailPanel();
        commodityDetailPanel.setBounds(ScreenSize.scr_width*5/100,0, ScreenSize.scr_width*90/100,ScreenSize.scr_height*90/100);

        //新增商品面板
        CommodityNewPanel cn=new CommodityNewPanel();
        commodityNew=cn.commodityNew();
        commodityNew.setBounds(ScreenSize.scr_width*5/100,0, ScreenSize.scr_width*90/100,ScreenSize.scr_height*90/100);

        /*/产品页面*/



        //层面板添加各层面板，数值越高为最优显示
        jLayeredView.add(login,Integer.valueOf(500));
        jLayeredView.add(light,Integer.valueOf(400));
        jLayeredView.add(helloUser,Integer.valueOf(300));
        jLayeredView.add(recommend,Integer.valueOf(200));
        jLayeredView.add(administrator,Integer.valueOf(100));
        light.setVisible(true);
        helloUser.setVisible(false);
        recommend.setVisible(false);
        administrator.setVisible(false);


        return jLayeredView;
    }

}
