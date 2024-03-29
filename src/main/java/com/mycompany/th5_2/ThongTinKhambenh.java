/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.th5_2;

import com.mycompany.th5_2.Util.MyConvert;
import com.mycompany.th5_2.dao.*;
import com.mycompany.th5_2.model.BacSi;
import com.mycompany.th5_2.model.BenhNhan;
import com.mycompany.th5_2.model.DichVu;
import com.mycompany.th5_2.model.KhamBenh;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Admin
 */
public class ThongTinKhambenh extends javax.swing.JFrame {

    /**
     * Creates new form Khambenh
     */
    ArrayList<BacSi> listBS = new ArrayList<>();
    ArrayList<BenhNhan> listBN = new ArrayList<>();
    ArrayList<DichVu> listDV = new ArrayList<>();
    HashMap<DichVu, Integer> mapDVSelected = new HashMap<DichVu, Integer>();
    private boolean keyEnter = false;
    private BacSi bacsi = new BacSi();


    public ThongTinKhambenh() {
        initComponents();
        initData();
        InputMap im = btnT.getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");

        getRootPane().setDefaultButton(btnT);
    }

    private void initData() {
        listBS = BacSiDAO.queryAllBS();

        for (BacSi t : listBS) {
            jComboBoxTBS.addItem(t.getTENBS());
        }


    }

    private void enterData() {
        listBN = BenhNhanDAO.queryAllbyBSandDate(bacsi.getMABS(), dateNGK.getDate());

        for (BenhNhan t : listBN) {
            jComboBoxTBN.addItem(t.getTENBN());
        }
        listDV = DichVuDAO.queryAllDV();
        initDV();
    }

    private void initDV() {

        DefaultTableModel dm = (DefaultTableModel) jTableTDV.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();


        String[] ColumnName = {"TENDV"};
        Object[][] Rows = new Object[listDV.size()][1];
        for (int i = 0; i < listDV.size(); i++) {
            Rows[i][0] = listDV.get(i).getTENDV();
        }
        DefaultTableModel model = new DefaultTableModel(Rows, ColumnName);
        jTableTDV.setModel(model);
        revalidate();
    }

    private void initDVC() {

        DefaultTableModel dm = (DefaultTableModel) jTableDVC.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();


        String[] ColumnName = {"TENDV", "SOLUONG"};
        Object[][] Rows = new Object[listDV.size()][2];
        Set<DichVu> keySet = mapDVSelected.keySet();
        int i = 0;
        for (DichVu key : keySet) {
            Rows[i][0] = key.getTENDV();
            Rows[i][1] = mapDVSelected.get(key);
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(Rows, ColumnName);
        jTableTDV.setModel(model);
        revalidate();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jComboBoxTBS = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTBN = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtKL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateNGK = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtYCK = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTDV = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDVC = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Bác sĩ khám");

        jComboBoxTBS.setMaximumRowCount(100);

        jLabel7.setText("Tên bệnh nhân");

        jComboBoxTBN.setMaximumRowCount(100);

        jLabel4.setText("Kết luận");

        txtKL.setText("Kết luận");
        txtKL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKLActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày khám");

        jLabel5.setText("Yêu cầu khám");

        txtYCK.setText("Yêu cầu khám");
        txtYCK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYCKActionPerformed(evt);
            }
        });

        jLabel8.setText("Danh sách dịch vụ");

        jTableTDV.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null},
                        {null},
                        {null},
                        {null}
                },
                new String[]{
                        "Tên dịch vụ"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableTDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTDV);

        jTableDVC.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Tên dịch vụ", "Số lượng"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                    false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableDVC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDVCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDVC);

        jLabel9.setText("Danh sách dịch vụ bác sĩ chọn");

        btnT.setText("Thêm");
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jComboBoxTBN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jComboBoxTBS, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dateNGK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtYCK, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtKL, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(241, 241, 241))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBoxTBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBoxTBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(dateNGK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtYCK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtKL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKLActionPerformed

    private void txtYCKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYCKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYCKActionPerformed

    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        // TODO add your handling code here:
        if (keyEnter == false) {
            keyEnter = dateNGK.getDate().compareTo(new Date(System.currentTimeMillis())) >= 0 ? true : false;
            if (keyEnter == true) {
                List<BacSi> bacsirs = listBS.stream().filter(it -> it.getTENBS().toString().equals(jComboBoxTBS)).collect(Collectors.toList());
                if (!bacsirs.isEmpty()) bacsi.setMABS(bacsirs.get(0).getMABS());
                enterData();
            }

        } else {
            KhamBenh kb = new KhamBenh();
            List<BenhNhan> benhnhanrs = listBN.stream().filter(it -> it.getTENBN().toString().equals(jComboBoxTBN)).collect(Collectors.toList());
            if (!benhnhanrs.isEmpty()) kb.setMABN(benhnhanrs.get(0).getMABN());
            List<BacSi> bacsirs = listBS.stream().filter(it -> it.getTENBS().toString().equals(jComboBoxTBS)).collect(Collectors.toList());
            if (!bacsirs.isEmpty()) kb.setMABS(bacsirs.get(0).getMABS());
            kb.setNGAYKHAM(dateNGK.getDate());
            kb.setYEUCAUKHAM(txtYCK.getText());
            kb.setKETLUAN(txtKL.getText());
            kb = KhamBenhDAO.queryKBbyBSandDate(kb);
            if (ThuPhiDAO.insertDatabase(kb, mapDVSelected)) {
                JOptionPane.showMessageDialog(null, "Đã thêm chi tiết khám bệnh thành công", "Thông báo", 1);
                dispose();
            } else JOptionPane.showMessageDialog(null, "Thêm chi tiết khám bệnh không thành công", "Thông báo", 1);
        }
    }//GEN-LAST:event_btnTActionPerformed

    private void jTableTDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTDVMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = this.jTableTDV.getSelectedRow();
            //Double clicked
            DichVu temp = new DichVu();
            List<DichVu> matches = listDV.stream().filter(it -> it.getTENDV().toString().equals(jTableTDV.getValueAt(row, 0))).collect(Collectors.toList());
            if (!matches.isEmpty()) temp = matches.get(0);
            mapDVSelected.put(temp, 0);
            initDV();
            initDVC();
        }
    }//GEN-LAST:event_jTableTDVMouseClicked

    private void jTableDVCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDVCMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int x = jTableDVC.getSelectedRow();
            int y = jTableDVC.getSelectedColumn();
            List<DichVu> matches = mapDVSelected.keySet().stream().filter(it -> it.getTENDV().equals(jTableDVC.getValueAt(x, 0))).collect(Collectors.toList());

            if (y == 0) {
                listDV.add(matches.get(0));
                mapDVSelected.remove(matches.get(0));
                initDV();
                initDVC();
            } else if (y == 1) {
                mapDVSelected.put(matches.get(0), MyConvert.parseObjToInt(jTableDVC.getValueAt(x, y)));

            }


        }
    }//GEN-LAST:event_jTableDVCMouseClicked

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
            java.util.logging.Logger.getLogger(ThongTinKhambenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinKhambenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinKhambenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinKhambenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinKhambenh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnT;
    private com.toedter.calendar.JDateChooser dateNGK;
    private javax.swing.JComboBox<String> jComboBoxTBN;
    private javax.swing.JComboBox<String> jComboBoxTBS;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDVC;
    private javax.swing.JTable jTableTDV;
    private javax.swing.JTextField txtKL;
    private javax.swing.JTextField txtYCK;
    // End of variables declaration//GEN-END:variables
}
