package quanlinhanvien.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlynhanvien.model.NhanVien;
import quanlynhanvien.service.NhanVienService;

public class FormQuanLyNhanVien extends javax.swing.JFrame {

    private DefaultTableModel model = new DefaultTableModel();

    public FormQuanLyNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblNhanvien.getModel();
        fillTable(NhanVienService.loadData());
    }

    private void fillTable(List<NhanVien> listNhanvien) {

        model.setRowCount(0);
        for (NhanVien nhanVien : listNhanvien) {
            model.addRow(new Object[]{
                nhanVien.getId(),
                nhanVien.getMa(),
                nhanVien.getTen(),
                nhanVien.getGioitinh(),
                nhanVien.getTuoi(),
                nhanVien.getLuong(),
                nhanVien.getEmail(),
                nhanVien.getSdt()});
        }
    }

    private void showdetal(int index) {
        tblNhanvien.setRowSelectionInterval(index, index);
        if (tblNhanvien.getValueAt(index, 3).toString().equals("Nam")) {
            rNam.setSelected(true);
        }
        if (tblNhanvien.getValueAt(index, 3).toString().equals("Nữ")) {
            rNu.setSelected(true);
        }
        if (tblNhanvien.getValueAt(index, 3).toString().equals("Khác")) {
            rKhac.setSelected(true);
        }
        txtid.setText(tblNhanvien.getValueAt(index, 1).toString());
        txtname.setText(tblNhanvien.getValueAt(index, 2).toString());
        txttuoi.setText(tblNhanvien.getValueAt(index, 4).toString());
        txtemail.setText(tblNhanvien.getValueAt(index, 6).toString());
        txtluong.setText(tblNhanvien.getValueAt(index, 5).toString());
        txtsdt.setText(tblNhanvien.getValueAt(index, 7).toString());
    }

    NhanVien readForm() {
        String ma = txtid.getText();
        String ten = txtname.getText();
        String gioitinh = "";
        String tuoi = txttuoi.getText();
        String luong = txtluong.getText();
        String email = txtemail.getText();
        String phone = txtsdt.getText();

        if (rNam.isSelected() == true) {
            gioitinh = "Nam";
        } else if (rNu.isSelected() == true) {
            gioitinh = "Nữ";
        } else {
            gioitinh = "Khác";
        }
        return new NhanVien(ma, ten, gioitinh, Integer.valueOf(tuoi), Integer.valueOf(luong), email, phone);
    }

    private void ClearForm() {
        txtid.setText("");
        txtname.setText("");
        txttuoi.setText("");
        txtemail.setText("");
        txtluong.setText("");
        txtsdt.setText("");
        rNam.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        btngioitinh = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanvien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txttuoi = new javax.swing.JTextField();
        rNam = new javax.swing.JCheckBox();
        rNu = new javax.swing.JCheckBox();
        rKhac = new javax.swing.JCheckBox();
        txtluong = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnDautien = new javax.swing.JButton();
        btnTruoc = new javax.swing.JButton();
        btnSau = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Nhân viên", "Họ tên", "Giới tính", "Tuổi", "Lương", "Email", "Số điện thoại"
            }
        ));
        tblNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanvien);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Nhân Viên");

        jLabel2.setText("Mã Nhân viên");

        jLabel3.setText("Họ tên");

        jLabel4.setText("Giới tính");

        jLabel5.setText("Tuổi");

        jLabel6.setText("Lương");

        jLabel7.setText("Email");

        jLabel8.setText("Số điện thoại");

        btngioitinh.add(rNam);
        rNam.setSelected(true);
        rNam.setText("Nam");

        btngioitinh.add(rNu);
        rNu.setText("Nữ");

        btngioitinh.add(rKhac);
        rKhac.setText("Khác");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(33, 33, 33)
                .addComponent(btnUpdate)
                .addGap(34, 34, 34)
                .addComponent(btnDelete)
                .addGap(33, 33, 33)
                .addComponent(btnFind)
                .addGap(21, 21, 21))
        );

        btnDautien.setText("First");
        btnDautien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDautienActionPerformed(evt);
            }
        });

        btnTruoc.setText("Pre");
        btnTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocActionPerformed(evt);
            }
        });

        btnSau.setText("Next");
        btnSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauActionPerformed(evt);
            }
        });

        btnCuoi.setText("Last");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addComponent(btnDautien)
                        .addGap(43, 43, 43)
                        .addComponent(btnTruoc)
                        .addGap(56, 56, 56)
                        .addComponent(btnSau)
                        .addGap(46, 46, 46)
                        .addComponent(btnCuoi)
                        .addGap(149, 149, 149))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtsdt)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rNam, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(rNu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtluong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttuoi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname)
                            .addComponent(txtid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rNam)
                            .addComponent(rNu)
                            .addComponent(rKhac))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDautien)
                    .addComponent(btnTruoc)
                    .addComponent(btnSau)
                    .addComponent(btnCuoi))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked

        int index = tblNhanvien.getSelectedRow();
        if (tblNhanvien.getValueAt(index, 3).toString().equals("Nam")) {
            rNam.setSelected(true);
        }
        if (tblNhanvien.getValueAt(index, 3).toString().equals("Nữ")) {
            rNu.setSelected(true);
        }
        if (tblNhanvien.getValueAt(index, 3).toString().equals("Khác")) {
            rKhac.setSelected(true);
        }
        txtid.setText(tblNhanvien.getValueAt(index, 1).toString());
        txtname.setText(tblNhanvien.getValueAt(index, 2).toString());
        txttuoi.setText(tblNhanvien.getValueAt(index, 4).toString());
        txtemail.setText(tblNhanvien.getValueAt(index, 6).toString());
        txtluong.setText(tblNhanvien.getValueAt(index, 5).toString());
        txtsdt.setText(tblNhanvien.getValueAt(index, 7).toString());
    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (NhanVienService.Insert(readForm()) < 0) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        } else {
            JOptionPane.showMessageDialog(this, "thêm thành công");
            fillTable(NhanVienService.loadData());

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblNhanvien.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
        } else {
            if (NhanVienService.deleteSV(txtid.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                fillTable(NhanVienService.loadData());
                ClearForm();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String ma = JOptionPane.showInputDialog("Nhập mã nhân viên cần tìm");
        List<NhanVien> listnv = NhanVienService.Timtheoma(ma);

        txtid.setText(listnv.get(0).getMa());
        txtname.setText(listnv.get(0).getTen());
        txttuoi.setText(listnv.get(0).getTuoi() + "");
        txtemail.setText(listnv.get(0).getEmail());
        txtluong.setText(listnv.get(0).getLuong() + "");
        txtsdt.setText(listnv.get(0).getSdt());
        if (listnv.get(0).getGioitinh().equals("Nam")) {
            rNam.setSelected(true);
        }
        if (listnv.get(0).getGioitinh().equals("Nữ")) {
            rNu.setSelected(true);
        }
        if (listnv.get(0).getGioitinh().equals("Khác")) {
            rKhac.setSelected(true);
        }
        fillTable(NhanVienService.loadData());
        
        for (int i = 0; i < tblNhanvien.getRowCount(); i++) {
            if (tblNhanvien.getValueAt(i, 1).toString().equals(txtid.getText())) {
                tblNhanvien.setRowSelectionInterval(i, i);
                break;
            }
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblNhanvien.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
        } else {
            if (NhanVienService.Update(txtid.getText(), readForm()) < 0) {
                JOptionPane.showMessageDialog(this, "Update thất bại");
            } else {
                JOptionPane.showMessageDialog(this, "Update thành công");
                fillTable(NhanVienService.loadData());
                ClearForm();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDautienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDautienActionPerformed
        showdetal(0);
    }//GEN-LAST:event_btnDautienActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        showdetal(tblNhanvien.getRowCount() - 1);
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btnTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocActionPerformed

        if (tblNhanvien.getSelectedRow() < 0 || tblNhanvien.getSelectedRow() == 0) {
            showdetal(tblNhanvien.getRowCount() - 1);
        } else {
            showdetal(tblNhanvien.getSelectedRow() - 1);
        }
    }//GEN-LAST:event_btnTruocActionPerformed

    private void btnSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauActionPerformed
        if (tblNhanvien.getSelectedRow() == tblNhanvien.getRowCount() - 1) {
            showdetal(0);
        } else {
            showdetal(tblNhanvien.getSelectedRow() + 1);
        }
    }//GEN-LAST:event_btnSauActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDautien;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSau;
    private javax.swing.JButton btnTruoc;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup btngioitinh;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox rKhac;
    private javax.swing.JCheckBox rNam;
    private javax.swing.JCheckBox rNu;
    private javax.swing.JTable tblNhanvien;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttuoi;
    // End of variables declaration//GEN-END:variables
}
