/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sandeep-Das-og
 */

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SearchProductUI extends javax.swing.JFrame {

    String name, id, price, discount;
    Object rowData[] = new Object[5];

    private DisplayManager displayMgr;
    private ArrayList<Catalog> list;
    private ArrayList<Catalog> filterlist;

    public SearchProductUI(DisplayManager displayMgr) {
        this.displayMgr = displayMgr;
        this.list = new ArrayList<>();
        this.filterlist = new ArrayList<>();
        initComponents();
    }

    public void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        list = displayMgr.mainMgr.searchMgr.getProductList();

        for (int i = 0; i < list.size(); i++) {
            Catalog cg = list.get(i);
            rowData[0] = cg.getName();
            rowData[1] = cg.getPrice();
            rowData[2] = cg.getProductId();
            rowData[3] = cg.getDiscount();
            model.addRow(rowData);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        ShowCard = new javax.swing.JButton();
        RowItem = new javax.swing.JLabel();
        ShowProduct = new javax.swing.JButton();
        alert = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TecFresh");
        setPreferredSize(new java.awt.Dimension(600, 560));

        jPanel1.setBackground(new java.awt.Color(216, 236, 176));

        jPanel2.setBackground(new java.awt.Color(173, 207, 26));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Product");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("TecFresh");

        jTextField1.setText("Enter search query");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        Search.setBackground(new java.awt.Color(255, 153, 0));
        Search.setFont(new java.awt.Font("Segoe UI Symbol", 1, 15)); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price", "Product ID", "Discount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        ShowCard.setBackground(new java.awt.Color(255, 153, 0));
        ShowCard.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        ShowCard.setText("View Product Card");
        ShowCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowCardActionPerformed(evt);
            }
        });

        ShowProduct.setBackground(new java.awt.Color(255, 153, 0));
        ShowProduct.setFont(new java.awt.Font("Segoe UI Symbol", 1, 13)); // NOI18N
        ShowProduct.setText("CART");
        ShowProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowProductActionPerformed(evt);
            }
        });

        alert.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(519, Short.MAX_VALUE)
                        .addComponent(ShowProduct))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(ShowCard)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RowItem, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowProduct)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RowItem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ShowCard)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * UseCase3-TestCase SearchProduct #2
     * This part of the code has been
     * added/modified to fix the bugs or
     * issues raised in the previous version
     * of the software
     * @param evt 
     */
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed

        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        String query = jTextField1.getText().trim();
        if (query.isEmpty()) {
            alert.setText("Enter a search query first");
            filterlist = displayMgr.mainMgr.searchMgr.getProductList();
        } else {
            filterlist = displayMgr.mainMgr.searchMgr.search(query);
            if (filterlist.size() == 0) {
                alert.setText("Query not found in database");
                filterlist = displayMgr.mainMgr.searchMgr.getProductList();
            }
            else{
                alert.setText("");
            }
        }
        
        
        for (int i = 0; i < filterlist.size(); i++) {
            rowData[0] = filterlist.get(i).getName();
            rowData[1] = filterlist.get(i).getPrice();
            rowData[2] = filterlist.get(i).getProductId();
            rowData[3] = filterlist.get(i).getDiscount();
            model.addRow(rowData);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int SelectedRow = Table.getSelectedRow();
        name = model.getValueAt(SelectedRow, 0).toString();
        price = model.getValueAt(SelectedRow, 1).toString();
        id = model.getValueAt(SelectedRow, 2).toString();
        discount = model.getValueAt(SelectedRow, 3).toString();

        RowItem.setText(name + "|" + price + "|" + id + "|" + discount);
    }//GEN-LAST:event_TableMouseClicked
    /**
     * UseCase3-TestCase SearchProduct #2
     * This part of the code has been
     * added/modified to fix the bugs or
     * issues raised in the previous version
     * of the software
     * @param evt 
     */
    private void ShowCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowCardActionPerformed
        int selectedRow = Table.getSelectedRow();
        if (selectedRow == -1)
            RowItem.setText("Please select an item first");
        else {
            jTextField1.setText("Enter search query");
            alert.setText("");
            RowItem.setText("");
            displayMgr.CU.cardDetails(id, name, price, discount);
            displayMgr.showCard();
        }
    }//GEN-LAST:event_ShowCardActionPerformed
    /**
     * UseCase3-TestCase SearchProduct #2
     * This part of the code has been
     * added/modified to fix the bugs or
     * issues raised in the previous version
     * of the software
     * @param evt 
     */
    private void ShowProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowProductActionPerformed
        if (displayMgr.mainMgr.orderMgr.getCart().isEmpty())
            RowItem.setText("Add items to the cart first");
        else {
            displayMgr.POU.addRowToTable();
            displayMgr.showProductScreen();
        }
    }//GEN-LAST:event_ShowProductActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        if(jTextField1.getText().equals("Enter search query"))
            jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RowItem;
    private javax.swing.JButton Search;
    private javax.swing.JButton ShowCard;
    private javax.swing.JButton ShowProduct;
    private javax.swing.JTable Table;
    private javax.swing.JLabel alert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
