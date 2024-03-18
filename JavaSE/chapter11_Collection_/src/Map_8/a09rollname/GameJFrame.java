package a09rollname;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame{
    public GameJFrame() {
        //设置界面
        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    //添加组件
    public void initView() {

        JLabel countDown = new JLabel("倒计时：5秒");
        countDown.setFont(new Font(null,1,50));
        countDown.setBounds(50,50,300,60);
        this.getContentPane().add(countDown);


        JLabel namePrompt = new JLabel("中奖选手为：");
        namePrompt.setFont(new Font(null,1,20));
        namePrompt.setBounds(80,150,125,30);
        this.getContentPane().add(namePrompt);

        JLabel rollName = new JLabel("XXX");
        rollName.setFont(new Font(null,1,20));
        rollName.setBounds(200,150,125,30);
        this.getContentPane().add(rollName);

        JLabel rollImage = new JLabel(new ImageIcon("默认图片路径"));
        rollImage.setBounds(87,200,210,210);
        this.getContentPane().add(rollImage);

        JButton start = new JButton("开始");
        start.setFont(new Font(null,1,20));
        start.setBounds(118,430,150,50);
        start.setBackground(Color.WHITE);
        //start.addActionListener(this);
        this.getContentPane().add(start);

    }


    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("随机点名器");
        //设置大小
        this.setSize(400, 600);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //取消内部默认居中放置
        this.setLayout(null);
        //设置背景颜色
        this.getContentPane().setBackground(Color.white);
        this.setAlwaysOnTop(true);//置顶
    }



}
