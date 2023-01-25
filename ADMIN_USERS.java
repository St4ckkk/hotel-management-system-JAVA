
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class ADMIN_USERS extends javax.swing.JFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ADMIN_USERS() {
        initComponents();
        jPanel1.setBackground(new Color(0, 0, 0, 150));
        jPanel1.setOpaque(true);
        jTable1.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) jTable1.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        jTable1.setGridColor(Color.WHITE);
        jTable1.setForeground(Color.WHITE);

        jScrollPane1.setOpaque(false);
        jTable1.setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/silvers_inn", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ADMIN_ROOMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShowRecordInTable();
    }

    public void ShowRecordInTable() {
        int c = 0;
        try {
            pst = conn.prepareStatement("SELECT * FROM user_accounts");
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector column = new Vector();
                for (int i = 1; i <= c; i++) {
                    column.add(rs.getString("account_name"));
                    column.add(rs.getString("account_username"));
                    column.add(rs.getString("account_password"));
                    column.add(rs.getString("account_type"));

                }
                model.addRow(column);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_ROOMS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean editUser(int id, String name, String username, String password, String type) {
        String sqlEdit = "UPDATE user_accounts SET account_name=?, account_username=?, account_password=?,account_type=? WHERE account_id=?";
        try {
            pst = conn.prepareStatement(sqlEdit);
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, type);
            pst.setInt(5, id);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean deleteUser(String account_name) {
        String sqlDelete = "DELETE FROM user_accounts WHERE account_name=?";
        try {
            pst = conn.prepareStatement(sqlDelete);
            pst.setString(1, account_name);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtid = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttype = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtname = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtid.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 210, 40));
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 210, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Type");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, 40));
        getContentPane().add(txttype, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 210, 40));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\plus (6).png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, 50));

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\edit (4).png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, -1, 50));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\delete (2).png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, -1, 50));

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\sync (2).png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 280, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username", "Password", "Type"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 1010, 610));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 210, 40));
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 210, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\close (5).png")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 40, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Search");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 40));

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 210, 40));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 1010, 610));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\milad-fakurian-E8Ufcyxz514-unsplash.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String name = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String username = model.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String password = model.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String type = model.getValueAt(jTable1.getSelectedRow(), 3).toString();
        txtname.setText(name);
        txtusername.setText(username);
        txtpass.setText(password);
        txttype.setText(type);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required!");
        } else if (txtusername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required!");
        } else if (txtpass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required!");
        } else if (txttype.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required!");
        } else {
            try {
                pst = conn.prepareStatement("SELECT * FROM user_accounts WHERE account_name=?");
                pst.setString(1, txtname.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "User already exist!");
                } else {
                    pst = conn.prepareStatement("INSERT into user_accounts(account_name, account_username, account_password, account_type) VALUES(?,?,?,?)");
                    pst.setString(1, txtname.getText());
                    pst.setString(2, txtusername.getText());
                    pst.setString(3, txtpass.getText());
                    pst.setString(4, txttype.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "User " + txtname.getText() + " Added");
                }
            } catch (Exception e) {

            }
        }
        ShowRecordInTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String name = txtname.getText();
        String username = txtusername.getText();
        String password = txtpass.getText();
        String type = txttype.getText();
        int id;
        if (name.trim().equals("") || username.trim().equals("") || password.trim().equals("") || type.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all the required fields!");
        } else {
            id = Integer.valueOf(txtid.getText());
            if (editUser(id, name, username, password, type)) {
                JOptionPane.showMessageDialog(rootPane, "User " + name + " Updated Succesfully", "Update User", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "User Not Updated", "Update User Error", JOptionPane.ERROR_MESSAGE);
            }
            ShowRecordInTable();  // refresh the table
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = txtname.getText();

        if (name.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select Data!");
        } else {
            int yes = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete User " + txtname.getText() + " ?", "User Deleted", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == yes) {
                if (deleteUser(name)) {
                    JOptionPane.showMessageDialog(rootPane, " User Deleted Succesfully", "Delete User", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, " U Not Deleted", "Delete Room Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        ShowRecordInTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
        String search = txtsearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tblmodel);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       txtname.setText("");
        txtusername.setText("");
        txtpass.setText("");
        txttype.setText("");
        txtid.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ADMIN_USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN_USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN_USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN_USERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN_USERS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttype;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
