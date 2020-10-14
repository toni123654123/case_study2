/*
 * Created by JFormDesigner on Wed Oct 07 10:55:04 GMT+07:00 2020
 */

package view.listuser;

import model.User;
import service.UserService;
import view.adduser.AddUser;
import view.edituser.editUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author unknown
 */
public class ListUserForm extends JFrame {
    UserService userService;
    DefaultTableModel defaultTableModel;
    User user;



    public ListUserForm() {
        initComponents();
        userService = new UserService();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        userTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
//        defaultTableModel.addColumn("MSSV");
        defaultTableModel.addColumn("Tên");
        defaultTableModel.addColumn("Giới Tính");
        defaultTableModel.addColumn("Điện thoại");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Lớp");
        defaultTableModel.addColumn("Chuyên Ngành");
        defaultTableModel.addColumn("Điểm số");

        setData(userService.getAllUsers());
    }

    private void setData(List<User> users) {
        for (User user : users) {
            defaultTableModel.addRow(new Object[]{user.getId(), user.getName(), user.getGender(),
                    user.getPhone(), user.getEmail(), user.getClasss(), user.getMajor(), user.getScore()});
        }
    }


    private void RefresbuttonActionPerformed(ActionEvent e) {
        // TODO add your code here
        defaultTableModel.setRowCount(0);
        setData(userService.getAllUsers());
    }

    private void addBotionActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AddUser().setVisible(true);
        this.dispose();
    }

    private void DeletebuttonActionPerformed(ActionEvent e) {
        // TODO add your code here
        int row = userTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(ListUserForm.this, "Vui lòng chọn user", "lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ListUserForm.this, "Bạn có chắc chắn xoá?");

            if (confirm == JOptionPane.YES_OPTION) {

                int userid = Integer.parseInt(String.valueOf(userTable.getValueAt(row, 0)));

                userService.deleteUser(userid);

                defaultTableModel.setRowCount(0);
                setData(userService.getAllUsers());
            }
        }
    }

    private void editUserActionPerformed(ActionEvent e) {

        int row = userTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(ListUserForm.this, "Vui lòng chọn user", "lỗi", JOptionPane.ERROR_MESSAGE);
        } else {

            int userId = Integer.parseInt(String.valueOf(userTable.getValueAt(row, 0)));
            new editUser(userId).setVisible(true);
            this.dispose();
        }

    }


    private void StackScoreActionPerformed(ActionEvent e) {

        defaultTableModel.setRowCount(0);
        setData(userService.getSortScore());

    }

    private void buttonSortActionPerformed(ActionEvent e) {

        defaultTableModel.setRowCount(0);
        setData(userService.getSortClass());
    }

    private void buttonSeachActionPerformed(ActionEvent e) {
        user = new User();
       user.setName(textSeach.getText());

        defaultTableModel.setRowCount(0);
        setData(userService.searchUser(user.getName()));

    }

    private void button3ScoreActionPerformed(ActionEvent e) {
        // TODO add your code here
        defaultTableModel.setRowCount(0);
        setData(userService.getSort3());
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        addUser = new JButton();
        scrollPane1 = new JScrollPane();
        userTable = new JTable();
        refreshForm = new JButton();
        Deletebutton = new JButton();
        editUserForm = new JButton();
        buttonSeach = new JButton();
        textSeach = new JTextField();
        StackScore = new JButton();
        buttonSort = new JButton();
        button3Score = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- addUser ----
        addUser.setText("Th\u00eam");
        addUser.addActionListener(e -> addBotionActionPerformed(e));
        contentPane.add(addUser);
        addUser.setBounds(new Rectangle(new Point(0, 20), addUser.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- userTable ----
            userTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(userTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 105, 755, 165);

        //---- refreshForm ----
        refreshForm.setText("Refresh");
        refreshForm.addActionListener(e -> RefresbuttonActionPerformed(e));
        contentPane.add(refreshForm);
        refreshForm.setBounds(new Rectangle(new Point(340, 20), refreshForm.getPreferredSize()));

        //---- Deletebutton ----
        Deletebutton.setText("Xo\u00e1");
        Deletebutton.addActionListener(e -> DeletebuttonActionPerformed(e));
        contentPane.add(Deletebutton);
        Deletebutton.setBounds(new Rectangle(new Point(225, 20), Deletebutton.getPreferredSize()));

        //---- editUserForm ----
        editUserForm.setText("S\u1eeda");
        editUserForm.addActionListener(e -> editUserActionPerformed(e));
        contentPane.add(editUserForm);
        editUserForm.setBounds(new Rectangle(new Point(110, 20), editUserForm.getPreferredSize()));

        //---- buttonSeach ----
        buttonSeach.setText("T\u00ecm ki\u1ebfm");
        buttonSeach.addActionListener(e -> buttonSeachActionPerformed(e));
        contentPane.add(buttonSeach);
        buttonSeach.setBounds(new Rectangle(new Point(670, 65), buttonSeach.getPreferredSize()));
        contentPane.add(textSeach);
        textSeach.setBounds(530, 65, 140, 27);

        //---- StackScore ----
        StackScore.setText("S\u1eafp x\u1ebfp theo \u0111i\u1ec3m");
        StackScore.addActionListener(e -> StackScoreActionPerformed(e));
        contentPane.add(StackScore);
        StackScore.setBounds(new Rectangle(new Point(625, 280), StackScore.getPreferredSize()));

        //---- buttonSort ----
        buttonSort.setText("S\u1eafp x\u1ebfp theo l\u1edbp");
        buttonSort.addActionListener(e -> buttonSortActionPerformed(e));
        contentPane.add(buttonSort);
        buttonSort.setBounds(new Rectangle(new Point(470, 280), buttonSort.getPreferredSize()));

        //---- button3Score ----
        button3Score.setText("Top 3 score");
        button3Score.addActionListener(e -> button3ScoreActionPerformed(e));
        contentPane.add(button3Score);
        button3Score.setBounds(new Rectangle(new Point(340, 280), button3Score.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListUserForm().setVisible(true);
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton addUser;
    private JScrollPane scrollPane1;
    private JTable userTable;
    private JButton refreshForm;
    private JButton Deletebutton;
    private JButton editUserForm;
    private JButton buttonSeach;
    private JTextField textSeach;
    private JButton StackScore;
    private JButton buttonSort;
    private JButton button3Score;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
