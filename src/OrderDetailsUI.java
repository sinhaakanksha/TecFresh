
/**
 * @author sinhaakanksha
 */

import java.awt.GridBagConstraints;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JTextArea;

public class OrderDetailsUI extends javax.swing.JFrame {

    GridBagConstraints constraints = new GridBagConstraints();

    private DisplayManager displayMgr;
    ArrayList<Product> prod1 = new ArrayList<>();
    Order ord;

    public OrderDetailsUI(DisplayManager displayMgr) {
        this.displayMgr = displayMgr;
        initComponents();

    }

    public void Show(int id) {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        int j = 0;

        ArrayList<Order> list = displayMgr.mainMgr.orderMgr.viewOrder("order.csv");

        jPanel3.removeAll();
        jPanel3.revalidate();
        jPanel3.repaint();

        for (int i = 0; i < list.size(); i++) {
            if (Integer.parseInt(list.get(i).getID()) == id) {

                JTextArea field = new JTextArea();
                field.setLineWrap(true);
                constraints.gridy = j++;
                field.setText("ID - " + list.get(i).getID());
                field.setEditable(false);
                field.setBorder(null);
                constraints.weightx = 1;
                constraints.weighty = 1;
                jPanel3.add(field, constraints);

                JTextArea field1 = new JTextArea();
                field1.setLineWrap(true);
                constraints.gridy = j++;
                field1.setText("Name - " + list.get(i).getName());
                field1.setEditable(false);
                field1.setBorder(null);
                constraints.weightx = 1;
                constraints.weighty = 1;
                jPanel3.add(field1, constraints);

                JTextArea field2 = new JTextArea();
                field2.setLineWrap(true);
                constraints.gridy = j++;
                field2.setText("Phone - " + list.get(i).getAddress());
                field2.setEditable(false);
                field2.setBorder(null);
                constraints.weightx = 1;
                constraints.weighty = 1;
                jPanel3.add(field2, constraints);

                JTextArea field4 = new JTextArea();
                field4.setLineWrap(true);
                constraints.gridy = j++;
                field4.setText("Address - " + list.get(i).getPhone());
                field4.setEditable(false);
                field4.setBorder(null);
                constraints.weightx = 1;
                constraints.weighty = 1;
                jPanel3.add(field4, constraints);

                JTextArea field3 = new JTextArea();
                field3.setLineWrap(true);
                constraints.gridy = j++;
                field3.setText("Product     Quantity    Price");
                field3.setEditable(false);
                field3.setBorder(null);
                constraints.weightx = 1;
                constraints.weighty = 1;
                jPanel3.add(field3, constraints);

                ArrayList<Product> p = list.get(i).getOrder();

                ord = list.get(i);

                for (int k = 0; k < p.size(); k++) {
                    JTextArea field5 = new JTextArea();
                    field5.setLineWrap(true);
                    constraints.gridy = j++;
                    field5.setText(p.get(k).NameGetter() + "      " + p.get(k).QuantityGetter()
                            + "         " + p.get(k).TotalGetter());
                    field5.setEditable(false);
                    field5.setBorder(null);
                    constraints.weightx = 1;
                    constraints.weighty = 1;
                    jPanel3.add(field5, constraints);

                }

            }
        }
    }
    /**
     * UseCase6-TestCase ManageOrders #3
     * This part of the code has been
     * added/modified to fix the bugs or
     * issues raised in the previous version
     * of the software
     * @param evt 
     */
    public void changeStatus(String status){
        ArrayList<Order> list = displayMgr.mainMgr.orderMgr.viewOrder("order.csv");
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getID() == null ? ord.getID() == null : list.get(i)
                    .getID().equals(ord.getID())){
                list.get(i).setStatus(status);
                
            }
           
        }
        
        PrintWriter writer;
        try {
            writer = new PrintWriter("order.csv");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderDetailsUI.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
       
        for( int i=0;i<list.size();i++){
            
         try {
            prod1 = list.get(i).getOrder();
            BufferedWriter bfw = new BufferedWriter(new FileWriter("order.csv",true));
            bfw.append(list.get(i).getID());
            
            bfw.append(',');
            bfw.append(list.get(i).getName());
            bfw.append(',');
            bfw.append(list.get(i).getPhone());
            bfw.append(',');
            bfw.append(list.get(i).getAddress());
            bfw.append(',');
            bfw.append(list.get(i).getDate());
            bfw.append(',');
            bfw.append(list.get(i).getStatus());

            bfw.newLine();

            for (int j = 0; j < prod1.size(); j++) {
                bfw.append(list.get(i).getID());
                bfw.append(',');
                bfw.append(prod1.get(j).NameGetter());
                bfw.append(',');
                bfw.append(String.valueOf(prod1.get(j).QuantityGetter()));
                bfw.append(',');
                bfw.append(String.valueOf(prod1.get(j).TotalGetter()));
                bfw.newLine();
            }
            bfw.close();
        } catch (IOException e) {
            System.out.println("somethings wrong");
        }}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        Confirm = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Status = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TecFresh");

        jPanel1.setBackground(new java.awt.Color(216, 236, 176));

        jPanel2.setBackground(new java.awt.Color(173, 207, 26));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setText("ORDER DETAILS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("TecFresh");

        jPanel3.setLayout(new java.awt.GridBagLayout());
        jScrollPane3.setViewportView(jPanel3);

        Confirm.setBackground(new java.awt.Color(255, 153, 0));
        Confirm.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        Confirm.setText("Accept");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        Home.setBackground(new java.awt.Color(255, 153, 0));
        Home.setFont(new java.awt.Font("Segoe UI Symbol", 1, 11)); // NOI18N
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Back.setBackground(new java.awt.Color(255, 153, 0));
        Back.setFont(new java.awt.Font("Segoe UI Symbol", 1, 11)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Status.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        Status.setForeground(new java.awt.Color(255, 0, 0));
        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jButton1.setText("Reject");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Home)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Confirm)))
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Home)
                    .addComponent(Back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Confirm)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        Status.setText("ORDER CONFIRMED");
        displayMgr.ODU.changeStatus("Accepted");
        displayMgr.mainMgr.catalogMgr.updateStock(ord);     
        displayMgr.mainMgr.catalogMgr.doHousekeeping("catalog.csv");
    }//GEN-LAST:event_ConfirmActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Status.setText("");
        displayMgr.showOrderScreen();
    }//GEN-LAST:event_BackActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        Status.setText("");
        displayMgr.showShopkeeperMain();
    }//GEN-LAST:event_HomeActionPerformed
    /**
     * UseCase6-TestCase ManageOrders #3
     * This part of the code has been
     * added/modified to fix the bugs or
     * issues raised in the previous version
     * of the software
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Status.setText("ORDER REJECTED");
        displayMgr.ODU.changeStatus("Rejected");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Confirm;
    private javax.swing.JButton Home;
    private javax.swing.JLabel Status;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
