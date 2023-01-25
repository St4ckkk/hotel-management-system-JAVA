
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class FDESK_CHECKOUT extends javax.swing.JFrame {

    /**
     * Creates new form FDESK_CHECKOUT
     */
    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public FDESK_CHECKOUT() {
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
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date();
        txtcout.setText(obj.format(date));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/silvers_inn", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(Level.SEVERE, null, ex);
        }
        showdataInToTable();
    }

    public void showdataInToTable() {
        try {
            pst = conn.prepareStatement("Select * from guest_details where status=?");
            pst.setString(1, "BOOKED");
            rs = pst.executeQuery();
            ResultSetMetaData ob = rs.getMetaData();
            int n = ob.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector columnData = new Vector();
                for (int i = 1; i < n; i++) {

                    columnData.add(rs.getString("name"));
                    columnData.add(rs.getString("address"));
                    columnData.add(rs.getString("mobile"));
                    columnData.add(rs.getString("room_number"));
                    columnData.add(rs.getString("bed"));
                    columnData.add(rs.getString("room_type"));
                    columnData.add(rs.getString("checkin_date"));
                    columnData.add(rs.getString("price"));

                }
                model.addRow(columnData);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtcin = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtcout = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        txtdays = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtrnum = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\close (5).png")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 40, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Room number");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, 40));

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 220, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mobile number");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 40));

        txtnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumActionPerformed(evt);
            }
        });
        getContentPane().add(txtnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 220, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Price per day");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 40));

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 220, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Check in date");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, 40));

        txtcin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcinActionPerformed(evt);
            }
        });
        getContentPane().add(txtcin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 220, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total Amount");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, 40));

        txtcout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcoutActionPerformed(evt);
            }
        });
        getContentPane().add(txtcout, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 220, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Check out date");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, 40));

        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });
        getContentPane().add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 220, 40));

        txtdays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdaysActionPerformed(evt);
            }
        });
        getContentPane().add(txtdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 220, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Number of days");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, 40));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\check-out (3).png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 280, 50));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\sync (2).png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 280, 50));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Address");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 40));

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 220, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Mobile", "Room number", "Bed type", "Room type", "Check in date", "Price per day"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 1000, 640));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Name");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 40));
        getContentPane().add(txtrnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 160, 40));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\loupe.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 50, 40));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 1000, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\random-institute-FDcydLvV7Io-unsplash.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtcinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcinActionPerformed

    private void txtcoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoutActionPerformed

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountActionPerformed

    private void txtdaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdaysActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtname.setText("");
        txtnum.setText("");
        txtaddress.setText("");
        txtcin.setText("");

        txtdays.setText("");
        txtprice.setText("");
        txtamount.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed

    }//GEN-LAST:event_txtaddressActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtrnum.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter room number");
        } else {
            try {
                pst = conn.prepareStatement("Select * from guest_details where room_number=? and status=?");
                pst.setString(1, txtrnum.getText());
                pst.setString(2, "BOOKED");
                rs = pst.executeQuery();
                try {
                    // execute SQL query and retrieve ResultSet
                    if (!rs.next()) {
                        // ResultSet is empty, show error message
                        JOptionPane.showMessageDialog(this, "No data found for room number " + txtrnum.getText());
                    } else {
                        // ResultSet is not empty, retrieve data and set text field values
                        txtname.setText(rs.getString("name"));
                        txtnum.setText(rs.getString("mobile"));
                        txtaddress.setText(rs.getString("address"));
                        txtcin.setText(rs.getString("checkin_date"));
                        txtprice.setText(rs.getString("price"));
                    }
                } catch (SQLException ex) {
                    // handle SQL exception
                    JOptionPane.showMessageDialog(this, "Error retrieving data: " + ex.getMessage());
                }

                String s1, s2;
                s1 = txtcout.getText();
                s2 = rs.getString("checkin_date");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    Date d1 = format.parse(s1);
                    Date d2 = format.parse(s2);
                    long diff = d1.getTime() - d2.getTime();
                    int days = (int) diff / (24 * 60 * 60 * 1000);
                    if (diff == 0) {
                        days = 1;
                    } else {
                        days = Math.max(days, 1);
                    }
                    txtdays.setText(String.valueOf(days));
                    double p = Double.parseDouble(rs.getString("price")) * days;
                    txtamount.setText(String.valueOf(p));
                } catch (Exception ex) {
                    Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(Level.SEVERE, null, ex);
                }

                /* ZoneId z = ZoneId.of("Asia/Manila");
                LocalDate todays = LocalDate.now(z);
                String s1 = todays.toString();
                SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
                String f1 = rs.getString("checkin_date");
                String f2 = s1;
                try {
                    Date d1 = sim.parse(f1);
                    Date d2 = sim.parse(f2);
                    long diff = d2.getTime() - d1.getTime();
                    int days = (int) (diff / (1000 * 24 * 60 * 60));
                    if (days == 0) {
                        days = 1;
                    } else {
                        txtdays.setText(String.valueOf(days));
                    }
                    double p = Double.parseDouble(rs.getString("price"));
                    double pri = days * p;
                    if (days == 0) {
                        txtamount.setText(String.valueOf(p));
                    } else {
                        txtamount.setText(String.valueOf(pri));
                    }
                } catch (Exception e) {
                }*/
            } catch (SQLException ex) {
                Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        showdataInToTable();
    
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Room Number And Search it,Then Check Out Customer");
        } else {
            try {
                pst = conn.prepareStatement("update guest_details set status=? where room_number=?");
                pst.setString(1, "CHECK-OUT");
                pst.setString(2, txtrnum.getText());
                pst.executeUpdate();
                pst = conn.prepareStatement("update  guest_details set amount=?,checkout_date=?,days=? where room_number=? AND checkin_date=?");
                pst.setString(1, txtamount.getText());
                pst.setString(2, txtcout.getText());
                pst.setString(3, txtdays.getText());
                pst.setString(4, txtrnum.getText());
                pst.setString(5, txtcin.getText());
                pst.executeUpdate();
                pst = conn.prepareStatement("update rooms set status=? where roomnumber=?");
                pst.setString(1, "NOT-BOOKED");
                pst.setString(2, txtrnum.getText());
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(this,"Check Out Successfully\n Goto to Cutomer Bill Details menu and Print Bill");
                int yes = JOptionPane.showConfirmDialog(this, "Room " + txtrnum.getText() + " Check out Successfully.\nDo you want to see & print bill?", "Check outed", JOptionPane.YES_NO_OPTION);
                if (JOptionPane.YES_OPTION == yes) {
                    new GuestDetailsBill().setVisible(true);
                } else {
                    showdataInToTable();
                    txtname.setText("");
                    txtnum.setText("");
                    txtcin.setText("");
                    txtprice.setText("");
                    txtdays.setText("");
                    txtamount.setText("");
                    txtrnum.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
showdataInToTable();
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDESK_CHECKOUT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDESK_CHECKOUT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtcin;
    private javax.swing.JTextField txtcout;
    private javax.swing.JTextField txtdays;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtrnum;
    // End of variables declaration//GEN-END:variables
}
