
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class BillPrint extends javax.swing.JFrame {

    String id = GuestDetailsBill.id;
    String name;
    String mobile;
    String roomnumber;
    String bed;
    String rtype;
    String cindate;
    String coutdate;
    String price;
    String days;
    String amount;
    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public BillPrint() {
        initComponents();
        connect();
         txtbill.setText("\t\t-: Silver's Inn Hotel :-\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"Bill ID:- "+id+"\n");
        txtbill.setText(txtbill.getText()+"Customer Details:- \n");
        txtbill.setText(txtbill.getText()+"Name:- "+name+"\n");
        txtbill.setText(txtbill.getText()+"Mobile Number:- "+mobile+"\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"Room Details:- \n");
        txtbill.setText(txtbill.getText()+"Room Number:- "+roomnumber+"\n");
        txtbill.setText(txtbill.getText()+"Type:- "+rtype+"\n");
        txtbill.setText(txtbill.getText()+"Bed:- "+bed+"\n");
        txtbill.setText(txtbill.getText()+"Price:- "+price+"\n");
        txtbill.setText(txtbill.getText()+"Check IN Date= "+cindate+"\t\tNumber of Days= "+days+"\n");
        txtbill.setText(txtbill.getText()+"Check OUT Date= "+coutdate+"\t\tTotal Amount= "+amount+"\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"\t\t"+"                    Thank You, Please Visit Again.");
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/silvers_inn", "root", "");
            pst = conn.prepareStatement("select * from guest_details where bill_id=?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
               
                name = rs.getString("name");
                mobile = rs.getString("mobile");
                roomnumber = rs.getString("room_number");
                bed = rs.getString("bed");
                rtype = rs.getString("room_type");
                cindate = rs.getString("checkin_date");
                coutdate = rs.getString("checkout_date");
                price = rs.getString("price");
                days = rs.getString("days");
                amount = rs.getString("amount");

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 470, 390));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\close (5).png")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, 50));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\printer (2).png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 190, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Downloads\\patrick-tomasso-nWvWBV0sv04-unsplash (1).jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            txtbill.print();        // TODO add your handling code here:
        } catch (PrinterException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed


    

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
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillPrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}
