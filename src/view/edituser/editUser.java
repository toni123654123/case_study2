/*
 * Created by JFormDesigner on Fri Oct 09 11:07:28 GMT+07:00 2020
 */

package view.edituser;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;
import model.User;
import service.UserService;
import view.listuser.ListUserForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author unknown
 */
public class editUser extends JFrame {
    private User user;
    UserService userService;
    public editUser(int userid) {

        userService = new UserService();
        user = userService.getUserById(userid);

        initComponents();

//        textID.setText(String.valueOf(user.getId()));
        textName1.setText(user.getName());
//        textCode.setText(user.getCode());

        textPhone.setText(String.valueOf(user.getPhone()));
        textEmail.setText(user.getEmail());
        comboCl.setSelectedItem(user.getClasss());

        comboMajor.setSelectedItem(user.getMajor());

        textScore.setText(String.valueOf(user.getScore()));

        String gender = user.getGender();
        if (gender != null){
            if (gender.equals("Nam")){
                radioNam.setSelected(true);
            }
            if (gender.equals("Nữ")){
                radioNu.setSelected(true);
            }
        }

    }

    private void editbutton1ActionPerformed(ActionEvent e) {
        // TODO add your code here

        try {
            user.setName(textName1.getText());
            user.setPhone(Integer.parseInt(textPhone.getText()));
            user.setEmail(textEmail.getText());
            String gender = "GENDER_user";
            if (radioNam.isSelected()) {
                gender = "Nam";
            }
            if (radioNu.isSelected()) {
                gender = "Nữ";
            }
            user.setGender(gender);

            String class1 = (String) comboCl.getSelectedItem();
            user.setClasss(class1);

            String major = String.valueOf(comboMajor.getSelectedItem());
            user.setMajor(major);


            if (Double.parseDouble(textScore.getText()) > 10) {
                JOptionPane.showMessageDialog(this, "Điểm không hợp lệ", "lỗi", JOptionPane.ERROR_MESSAGE);
//                new ListUserForm().setVisible(false);
            } else{
                user.setScore(Double.parseDouble(textScore.getText()));
            }
            userService.updateUser(user);

            new ListUserForm().setVisible(true);
            this.dispose();

        }catch (Exception e1){
            JOptionPane.showMessageDialog(this, "Sai dữ liệu. Vui lòng nhập lại", "lỗi", JOptionPane.ERROR_MESSAGE);

        }


    }

    private void buttonBackActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ListUserForm().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label4 = new JLabel();
        textName1 = new JTextField();
        label5 = new JLabel();
        radioNam = new JRadioButton();
        radioNu = new JRadioButton();
        label6 = new JLabel();
        textPhone = new JTextField();
        label7 = new JLabel();
        textEmail = new JTextField();
        label8 = new JLabel();
        comboCl = new JComboBox<>();
        label9 = new JLabel();
        comboMajor = new JComboBox<>();
        label10 = new JLabel();
        textScore = new JTextField();
        editbutton1 = new JButton();
        buttonBack = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new TableLayout(new double[][] {
            {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
            {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        ((TableLayout)contentPane.getLayout()).setHGap(5);
        ((TableLayout)contentPane.getLayout()).setVGap(5);

        //---- label1 ----
        label1.setText("S\u1eeda th\u00f4ng tin");
        contentPane.add(label1, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label4 ----
        label4.setText("T\u00ean sinh vi\u00ean");
        contentPane.add(label4, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textName1, new TableLayoutConstraints(3, 3, 4, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label5 ----
        label5.setText("Gi\u1edbi t\u00ednh");
        contentPane.add(label5, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- radioNam ----
        radioNam.setText("Nam");
        contentPane.add(radioNam, new TableLayoutConstraints(3, 4, 3, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- radioNu ----
        radioNu.setText("N\u1eef");
        contentPane.add(radioNu, new TableLayoutConstraints(4, 4, 4, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label6 ----
        label6.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i");
        contentPane.add(label6, new TableLayoutConstraints(2, 5, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textPhone, new TableLayoutConstraints(3, 5, 4, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label7 ----
        label7.setText("Email");
        contentPane.add(label7, new TableLayoutConstraints(2, 6, 2, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textEmail, new TableLayoutConstraints(3, 6, 4, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label8 ----
        label8.setText("L\u1edbp");
        contentPane.add(label8, new TableLayoutConstraints(2, 7, 2, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboCl ----
        comboCl.setModel(new DefaultComboBoxModel<>(new String[] {
            "C0720i1",
            "C0720i2",
            "C0520h1",
            "C0520h2"
        }));
        contentPane.add(comboCl, new TableLayoutConstraints(3, 7, 3, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label9 ----
        label9.setText("Chuy\u00ean ng\u00e0nh");
        contentPane.add(label9, new TableLayoutConstraints(2, 8, 2, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- comboMajor ----
        comboMajor.setModel(new DefaultComboBoxModel<>(new String[] {
            "Java",
            "PHP"
        }));
        contentPane.add(comboMajor, new TableLayoutConstraints(3, 8, 3, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label10 ----
        label10.setText("\u0110i\u1ec3m");
        contentPane.add(label10, new TableLayoutConstraints(2, 9, 2, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textScore, new TableLayoutConstraints(3, 9, 3, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- editbutton1 ----
        editbutton1.setText("C\u1eadp nh\u1eadp");
        editbutton1.addActionListener(e -> editbutton1ActionPerformed(e));
        contentPane.add(editbutton1, new TableLayoutConstraints(3, 11, 3, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- buttonBack ----
        buttonBack.setText("Quay l\u1ea1i");
        buttonBack.addActionListener(e -> buttonBackActionPerformed(e));
        contentPane.add(buttonBack, new TableLayoutConstraints(4, 11, 4, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioNam);
        buttonGroup1.add(radioNu);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label4;
    private JTextField textName1;
    private JLabel label5;
    private JRadioButton radioNam;
    private JRadioButton radioNu;
    private JLabel label6;
    private JTextField textPhone;
    private JLabel label7;
    private JTextField textEmail;
    private JLabel label8;
    private JComboBox<String> comboCl;
    private JLabel label9;
    private JComboBox<String> comboMajor;
    private JLabel label10;
    private JTextField textScore;
    private JButton editbutton1;
    private JButton buttonBack;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
