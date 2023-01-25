
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.sql.ResultSetMetaData;
import java.util.Vector;
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
public class FDESK_CHECKIN extends javax.swing.JFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public FDESK_CHECKIN() {

        initComponents();
        jPanel1.setBackground(new Color(0, 0, 0, 170));
        jPanel1.setOpaque(false);
        jPanel2.setBackground(new Color(0, 0, 0, 170));
        jPanel2.setOpaque(false);

        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        txtdate.setText(obj.format(date));

        try {
            // Connect to the database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/silvers_inn", "root", "");
            pst = conn.prepareStatement("select roomnumber from rooms where status=? AND roomtype=? AND bed=?");
            pst.setString(1, "AVAILABE");
            pst.setString(2, cbrtype.getItemAt(cbrtype.getSelectedIndex()));
            pst.setString(3, cbbed.getItemAt(cbbed.getSelectedIndex()));
            rs = pst.executeQuery();
            while (rs.next()) {
                txtrnum.addItem(rs.getString("roomnumber"));
            }
            pst = conn.prepareStatement("select price from rooms where roomnumber=?");
            pst.setString(1, txtrnum.getItemAt(txtrnum.getSelectedIndex()));
            rs = pst.executeQuery();
            if (rs.next()) {
                txtprice.setText(rs.getString("price"));
            }
            // Select the available room numbers
        } catch (ClassNotFoundException | SQLException e) {
            // Handle the exception
        }
        k();

    }
    
   
    
    public void k() {
        try {
            pst = conn.prepareStatement("Select roomnumber from rooms where bedtype=? and roomtype=? and status=?");
            pst.setString(1, cbbed.getItemAt(cbbed.getSelectedIndex()));
            pst.setString(2, cbrtype.getItemAt(cbrtype.getSelectedIndex()));
            pst.setString(3, "NOT-BOOKED");
            rs = pst.executeQuery();
            txtrnum.removeAllItems();
            while (rs.next()) {
                txtrnum.addItem(rs.getString("roomnumber"));
                txtrnum.setSelectedItem(rs.getString("roomnumber"));
            }
            pst = conn.prepareStatement("SELECT price FROM rooms WHERE roomnumber = ?");
            pst.setString(1, txtrnum.getItemAt(txtrnum.getSelectedIndex()));
            rs = pst.executeQuery();
            if (rs.next()) {
                txtprice.setText(rs.getString("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FDESK_CHECKIN.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new RoundedPanel(50);
        jLabel18 = new javax.swing.JLabel();
        cbbed = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbrtype = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtrnum = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new RoundedPanel(50);
        txtname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\check-in (3).png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, 280, 50));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\sync (2).png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, 280, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\close (5).png")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 40, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Bed type");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 40));

        cbbed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Triple", "Kingsize" }));
        cbbed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbedActionPerformed(evt);
            }
        });
        jPanel1.add(cbbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 220, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Room type");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 40));

        cbrtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "NON-AC" }));
        cbrtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbrtypeActionPerformed(evt);
            }
        });
        jPanel1.add(cbrtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 220, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Room number");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 40));

        txtrnum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtrnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrnumActionPerformed(evt);
            }
        });
        jPanel1.add(txtrnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 220, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Price");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, 40));

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 220, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Room Information");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, 470, 450));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 220, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mobile number");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 40));

        txtnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumActionPerformed(evt);
            }
        });
        jPanel2.add(txtnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 220, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Address");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 40));

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });
        jPanel2.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 220, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Check in date");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 40));

        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });
        jPanel2.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 220, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Name");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Guest Information");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 470, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\random-institute-FDcydLvV7Io-unsplash.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtname.setText("");
        txtnum.setText("");
        txtaddress.setText("");
        txtdate.setText("");
        cbbed.setSelectedItem(0);
        cbrtype.setSelectedItem(0);
        txtrnum.setSelectedItem(0);
        txtprice.setText("");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is Requied");
            txtname.requestFocus();
        } else if (txtnum.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is Requied");
            txtnum.requestFocus();
        } else if (txtaddress.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is Requied");
            txtaddress.requestFocus();
        } else if (txtprice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Sorry, This type of Room Not avaible Select another room ");
            txtaddress.requestFocus();
        } else if (txtnum.getText().length() != 11) {
            JOptionPane.showMessageDialog(this, "Mobile Number Should be 11 Digit.");
        } else {
            int yes = JOptionPane.showConfirmDialog(this, "Are you sure you want to Check-in?", "Check-in", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_NO_OPTION == yes) {
                try {
                    pst = conn.prepareStatement("INSERT INTO guest_details(name, address, mobile, checkin_date, room_number, bed, room_type, price, status) VALUES (?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, txtname.getText());
                    pst.setString(2, txtaddress.getText());
                    pst.setString(3, txtnum.getText());
                    pst.setString(4, txtdate.getText());
                    pst.setString(5, txtrnum.getItemAt(txtrnum.getSelectedIndex()));
                    pst.setString(6, cbbed.getItemAt(cbbed.getSelectedIndex()));
                    pst.setString(7, cbrtype.getItemAt(cbrtype.getSelectedIndex()));
                    pst.setString(8, txtprice.getText());
                    pst.setString(9, "BOOKED");
                    // Set amount to 0.0

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, txtname.getText() + " Successfully Checked In");
                    txtname.setText("");
                    txtaddress.setText("");
                    txtnum.setText("");
                    pst = conn.prepareStatement("UPDATE rooms set status=? WHERE roomnumber=?");
                    pst.setString(1, "BOOKED");
                    pst.setString(2, txtrnum.getItemAt(txtrnum.getSelectedIndex()));
                    pst.executeUpdate();
                    k();
                } catch (SQLException ex) {
                    Logger.getLogger(FDESK_CHECKIN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbedActionPerformed
        k();
    }//GEN-LAST:event_cbbedActionPerformed

    private void cbrtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbrtypeActionPerformed
        k();
    }//GEN-LAST:event_cbrtypeActionPerformed

    private void txtrnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrnumActionPerformed

    }//GEN-LAST:event_txtrnumActionPerformed

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
            java.util.logging.Logger.getLogger(FDESK_CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDESK_CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDESK_CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDESK_CHECKIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDESK_CHECKIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbed;
    private javax.swing.JComboBox<String> cbrtype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtprice;
    private javax.swing.JComboBox<String> txtrnum;
    // End of variables declaration//GEN-END:variables
}
