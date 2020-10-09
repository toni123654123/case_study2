/*
 * Created by JFormDesigner on Wed Oct 07 13:51:56 GMT+07:00 2020
 */

package view.adduser;

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
public class AddUser extends JFrame {
    UserService userService;
    User user;

    public AddUser() {
        initComponents();
        userService = new UserService();
        user = new User();
    }

    private void backButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ListUserForm().setVisible(true);
        this.dispose();
    }

    private void addButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here

        if (Integer.parseInt(textID.getText()) == user.getId()) {
            JOptionPane.showMessageDialog(this, "ID đã tồn tại", "lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            user.setId(Integer.parseInt(textID.getText()));
        }


        user.setCode(textCode.getText());
        user.setName(textName.getText());
        user.setPhone(Integer.parseInt(textPhone.getText()));
        user.setEmail(textEmail.getText());
        String gender = "GENDER_user";
        if (radioName.isSelected()) {
            gender = "Nam";
        }
        if (radioNu.isSelected()) {
            gender = "Nữ";
        }
        user.setGender(gender);

        String class1 = (String) Classs.getSelectedItem();
        user.setClasss(class1);

        String major = String.valueOf(Major1.getSelectedItem());
        user.setMajor(major);

        user.setScore(Integer.parseInt(Scoretext.getText()));

        userService.addUser(user);

        new ListUserForm().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        addUser = new JLabel();
        label1 = new JLabel();
        textID = new JTextField();
        mssv = new JLabel();
        textCode = new JTextField();
        name = new JLabel();
        textName = new JTextField();
        gender = new JLabel();
        radioName = new JRadioButton();
        radioNu = new JRadioButton();
        phone = new JLabel();
        textPhone = new JTextField();
        email = new JLabel();
        textEmail = new JTextField();
        label7 = new JLabel();
        Classs = new JComboBox<>();
        major = new JLabel();
        Major1 = new JComboBox<>();
        address = new JLabel();
        Scoretext = new JTextField();
        addButton1 = new JButton();
        backButton = new JButton();
        textPane1 = new JTextPane();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new TableLayout(new double[][] {
            {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED},
            {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}}));
        ((TableLayout)contentPane.getLayout()).setHGap(5);
        ((TableLayout)contentPane.getLayout()).setVGap(5);

        //---- addUser ----
        addUser.setText("TH\u00caM M\u1edaI");
        contentPane.add(addUser, new TableLayoutConstraints(3, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label1 ----
        label1.setText("ID");
        contentPane.add(label1, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textID, new TableLayoutConstraints(3, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- mssv ----
        mssv.setText("M\u00e3 sinh vi\u00ean ");
        contentPane.add(mssv, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textCode, new TableLayoutConstraints(3, 3, 6, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- name ----
        name.setText("T\u00ean sinh vi\u00ean ");
        contentPane.add(name, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textName, new TableLayoutConstraints(3, 4, 6, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- gender ----
        gender.setText("Gi\u1edbi t\u00ednh ");
        contentPane.add(gender, new TableLayoutConstraints(2, 5, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- radioName ----
        radioName.setText("Nam");
        contentPane.add(radioName, new TableLayoutConstraints(3, 5, 3, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- radioNu ----
        radioNu.setText("N\u1eef");
        contentPane.add(radioNu, new TableLayoutConstraints(4, 5, 4, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- phone ----
        phone.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i ");
        contentPane.add(phone, new TableLayoutConstraints(2, 6, 2, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textPhone, new TableLayoutConstraints(3, 6, 6, 6, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- email ----
        email.setText("Email ");
        contentPane.add(email, new TableLayoutConstraints(2, 7, 2, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(textEmail, new TableLayoutConstraints(3, 7, 6, 7, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- label7 ----
        label7.setText("L\u1edbp ");
        contentPane.add(label7, new TableLayoutConstraints(2, 8, 2, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Classs ----
        Classs.setModel(new DefaultComboBoxModel<>(new String[] {
            "C0720i1",
            "C0720i2",
            "C0520h1",
            "C0520h2"
        }));
        contentPane.add(Classs, new TableLayoutConstraints(3, 8, 4, 8, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- major ----
        major.setText("Chuy\u00ean ng\u00e0nh ");
        contentPane.add(major, new TableLayoutConstraints(2, 9, 2, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- Major1 ----
        Major1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Java",
            "PHP"
        }));
        contentPane.add(Major1, new TableLayoutConstraints(3, 9, 4, 9, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- address ----
        address.setText("\u0110i\u1ec3m");
        contentPane.add(address, new TableLayoutConstraints(2, 10, 2, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        contentPane.add(Scoretext, new TableLayoutConstraints(3, 10, 3, 10, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- addButton1 ----
        addButton1.setText("Th\u00eam");
        addButton1.addActionListener(e -> addButton1ActionPerformed(e));
        contentPane.add(addButton1, new TableLayoutConstraints(2, 11, 2, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //---- backButton ----
        backButton.setText("Back");
        backButton.addActionListener(e -> backButtonActionPerformed(e));
        contentPane.add(backButton, new TableLayoutConstraints(5, 11, 5, 11, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioName);
        buttonGroup1.add(radioNu);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel addUser;
    private JLabel label1;
    private JTextField textID;
    private JLabel mssv;
    private JTextField textCode;
    private JLabel name;
    private JTextField textName;
    private JLabel gender;
    private JRadioButton radioName;
    private JRadioButton radioNu;
    private JLabel phone;
    private JTextField textPhone;
    private JLabel email;
    private JTextField textEmail;
    private JLabel label7;
    private JComboBox<String> Classs;
    private JLabel major;
    private JComboBox<String> Major1;
    private JLabel address;
    private JTextField Scoretext;
    private JButton addButton1;
    private JButton backButton;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
