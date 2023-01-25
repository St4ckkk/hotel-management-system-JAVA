
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
import javax.swing.JPanel;
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
public class ADMIN_ROOMS extends javax.swing.JFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ADMIN_ROOMS() {
        initComponents();
        jPanel1.setBackground(new Color(0, 0, 0, 150));
        jPanel1.setOpaque(true);
        //jPanel2.setBackground(new Color(0,0,0,100));
        //jPanel2.setOpaque(false);
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
            pst = conn.prepareStatement("SELECT * FROM rooms");
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector column = new Vector();
                for (int i = 1; i <= c; i++) {
                  column.add(rs.getString("room_id"));
                    column.add(rs.getString("roomnumber"));
                    column.add(rs.getString("roomtype"));
                    column.add(rs.getString("bedtype"));
                    column.add(rs.getString("price"));
                    column.add(rs.getString("status"));
                }
                model.addRow(column);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_ROOMS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean editRoom(int id, String roomnumber, String roomtype, String bedtype, Double price, String status) {
        String sqlEdit = "UPDATE rooms SET roomnumber=?, roomtype=?, bedtype=?, price=?, status=? WHERE room_id=?";
        try {
            pst = conn.prepareStatement(sqlEdit);
            pst.setString(1, roomnumber);
            pst.setString(2, roomtype);
            pst.setString(3, bedtype);
            pst.setDouble(4, price);
            pst.setString(5, status);
            pst.setInt(6, id);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean deleteRoom(String roomnumber) {
        String sqlDelete = "DELETE FROM rooms WHERE roomnumber=?";
        try {
            pst = conn.prepareStatement(sqlDelete);
            pst.setString(1, roomnumber);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public class RoundedPanel extends JPanel {

        private int radius;

        public RoundedPanel(int radius) {
            this.radius = radius;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(getBackground());
            g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        }

        @Override
        public void paintBorder(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getForeground());
            g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbed = new javax.swing.JComboBox<>();
        cbrtype = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        txtrnum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(70, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Room number", "Room type", "Bed", "Price", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 990, 620));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\close (5).png")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 40, 50));

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\sync (2).png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 280, 50));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\plus (6).png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, -1, 50));

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\edit (4).png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, -1, 50));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\delete (2).png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, -1, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 40));
        getContentPane().add(txtstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 210, 40));
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 210, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bed");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 40));

        cbbed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Triple", "Kingsize" }));
        getContentPane().add(cbbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 210, 40));

        cbrtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "NON-AC" }));
        getContentPane().add(cbrtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 210, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Room type");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 40));

        txtid.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 210, 40));
        getContentPane().add(txtrnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Room no");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Search");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, 40));

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 220, 40));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 990, 620));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\milad-fakurian-E8Ufcyxz514-unsplash.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String id = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String roomnumber = model.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String roomtype = model.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String bedtype = model.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String price = model.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String status = model.getValueAt(jTable1.getSelectedRow(), 5).toString();

        txtid.setText(id);
        txtrnum.setText(roomnumber);
        cbrtype.setSelectedItem(roomtype);
        cbbed.setSelectedItem(bedtype);
        txtprice.setText(price);
        txtstatus.setText(status);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String rnum = txtrnum.getText();
        String rtype = cbrtype.getSelectedItem().toString();
        String bed = cbbed.getSelectedItem().toString();
        double price = Double.parseDouble(txtprice.getText());  // parse the price as a double
        String status = txtstatus.getText();
        int id;
        if (rnum.trim().equals("") || rtype.trim().equals("") || price <= 0) {
            JOptionPane.showMessageDialog(this, "Please Select Data!");
        } else {
            try {
                id = Integer.valueOf(txtid.getText());
                if (editRoom(id, rnum, rtype, bed, price, status)) {
                    JOptionPane.showMessageDialog(rootPane, " Room Updated Succesfully", "Update Room", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, " Room Not Updated", "Update Room Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage() + "Enter the Room Id(number)", "Room Id Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        ShowRecordInTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtrnum.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required!");
        } else if (txtprice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required!");
        } else {
            try {
                pst = conn.prepareStatement("SELECT * FROM rooms WHERE roomnumber=?");
                pst.setString(1, txtrnum.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Room number already exist!");
                } else {
                    pst = conn.prepareStatement("INSERT into rooms(roomnumber, roomtype, bedtype, price, status) VALUES(?,?,?,?,?)");
                    pst.setString(1, txtrnum.getText());
                    pst.setString(2, cbrtype.getItemAt(cbrtype.getSelectedIndex()));
                    pst.setString(3, cbbed.getItemAt(cbbed.getSelectedIndex()));
                    pst.setString(4, txtprice.getText());
                    pst.setString(5, "NOT-BOOKED");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Room " + txtrnum.getText() + " Added");
                }
            } catch (Exception e) {

            }
        }
        ShowRecordInTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String roomnumber = txtrnum.getText();

        if (roomnumber.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Data!");
        } else {
            int yes = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete Room " + txtrnum.getText() + " ?", "Room Deleted", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == yes) {
                if (deleteRoom(roomnumber)) {
                    JOptionPane.showMessageDialog(rootPane, " Room Deleted Succesfully");
                } else {
                    JOptionPane.showMessageDialog(rootPane, " Room Not Deleted", "Delete Room Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        ShowRecordInTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Reset the text fields and combo boxes
        txtrnum.setText("");
        cbrtype.setSelectedIndex(0);  // set the selected index to the first item in the combo box
        cbbed.setSelectedIndex(0);  // set the selected index to the first item in the combo box
        txtprice.setText("");
        txtstatus.setText("");
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
        String search = txtsearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tblmodel);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

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
            java.util.logging.Logger.getLogger(ADMIN_ROOMS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN_ROOMS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN_ROOMS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN_ROOMS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN_ROOMS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbed;
    private javax.swing.JComboBox<String> cbrtype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtrnum;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtstatus;
    // End of variables declaration//GEN-END:variables
}
