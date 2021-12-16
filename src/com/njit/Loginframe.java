

package com.njit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Loginframe extends JFrame {
    private JTextField username;
    private JPasswordField password;
    private JButton login, register;

    public Loginframe() {
        super();
        this.setSize(300, 200);
        this.setTitle("Login");
        this.setLocationRelativeTo(getOwner());//居中

//设置组件布局——3行2列表格
        Container cont = getContentPane();
        cont.setLayout(new GridLayout(3, 2));

//------begin------
//添加“用户名”，“密码”
        cont.add(new JLabel("username"));
        username = new JTextField(10);
        cont.add(username);
        cont.add(new JLabel("password"));
        password = new JPasswordField(10);
        cont.add(password);
//添加“登录”、“注册”按钮
        login = new JButton(new ImageIcon("enter.gif"));
        register = new JButton(new ImageIcon("register.gif"));
        cont.add(login);
        cont.add(register);
//-----end------

//注册监听器
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
//login事件处理
                String pass = new String(password.getPassword());
                if (username.getText().equals("ding") && pass.equals("123456")) {
                    HelloWorld hello = new HelloWorld();
                    hello.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "你输入的密码没有通过验证");
                }
            }
        });
    }

    public static void main(String[] args) {
        Loginframe w = new Loginframe();
        w.setVisible(true);
    }

}

