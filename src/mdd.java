import oracle.sql.CHAR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.sql.*;
/*
 * Created by JFormDesigner on Wed Dec 01 15:39:53 CST 2021
 */


/**
 * @author unknown
 */
public class mdd extends JFrame {
    public mdd() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(80, 80, 55, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(135, 75, 95, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(90, 125, 40, label2.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(135, 120, 120, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(140, 195), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 400));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        button1.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        Connection conn=null;
                        String url ="jdbc:oracle:thin:@120.77.235.6:1521:orcl";
                        PreparedStatement pstmt=null;
                        ResultSet rs=null;
                        String sql="SELECT * FROM tb_user";
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn= DriverManager.getConnection(url,"mhp","mhP1234_");
                            pstmt=conn.prepareStatement(sql);
                            rs=pstmt.executeQuery();
                            while (rs.next()) {
                                Reader dept_name = rs.getCharacterStream("user_name");
                                String dept_password = rs.getString("password");
                                System.out.println("用户名：" + dept_name + "，密码：" + dept_password);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e){
                            e.printStackTrace();
                        } finally {
                            try {
                                rs.close();
                                pstmt.close();
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {
        new mdd();
    }
}
