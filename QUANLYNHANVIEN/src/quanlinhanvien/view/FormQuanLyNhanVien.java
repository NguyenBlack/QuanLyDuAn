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
        showdetal(0);

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

    private boolean validates() {
        String regexMail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String ma = txtid.getText();
        String ten = txtname.getText();
        String tuoi = txttuoi.getText();
        String luong = txtluong.getText();
        String email = txtemail.getText();
        String phone = txtsdt.getText();
        int phone2 = txtsdt.getText().length();
        if ("".equals(ma)) {
            JOptionPane.showMessageDialog(this, "không được để trống mã nhân viên");
            return false;
        }
        if ("".equals(ten)) {
            JOptionPane.showMessageDialog(this, "không được để trống tên nhân viên");
            return false;
        }
        if ("".equals(tuoi)) {
            JOptionPane.showMessageDialog(this, "không được để trống tuổi nhân viên");
            return false;
        }
        try {
            int tuoi1 = Integer.valueOf(tuoi);
            if (tuoi1 < 18 || tuoi1 > 65) {
                JOptionPane.showMessageDialog(this, "Tuổi phải từ 18 đến 65");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số");
            return false;
        }
        if ("".equals(luong)) {
            JOptionPane.showMessageDialog(this, "không được để trống lương nhân viên");
            return false;
        }
        try {
            int luong1 = Integer.valueOf(luong);
            if (luong1 <= 0) {
                JOptionPane.showMessageDialog(this, "Lương phải là số dương");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương phải là số");
            return false;
        }
        if ("".equals(email)) {
            JOptionPane.showMessageDialog(this, "không được để trống email nhân viên");
            return false;
        }
         if (!email.matches(regexMail)) {
            JOptionPane.showMessageDialog(this, "không đúng định dạng email");
            return false;
        }
        if ("".equals(phone)) {
            JOptionPane.showMessageDialog(this, "không được để trống số điện thoại nhân viên");
            return false;
        }
        try {
            if (phone2 < 10 || phone2 > 12) {
                JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được nhập từ 10 đến 12 số");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        try {
            long phone1 = Long.valueOf(phone);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số diện thoại không được có chữ");
            return false;
        }
        return true;
    }

    private boolean checkMa() {
        for (int i = 0; i < tblNhanvien.getRowCount(); i++) {
            if (txtid.getText().equalsIgnoreCase(tblNhanvien.getValueAt(i, 1).toString())) {
                return false;
            }
        }
        return true;
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

    private void mouseClick() {
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
        btnNew = new javax.swing.JButton();
        btnDautien = new javax.swing.JButton();
        btnTruoc = new javax.swing.JButton();
        btnSau = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
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
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(32, 32, 32)
                .addComponent(btnUpdate)
                .addGap(33, 33, 33)
                .addComponent(btnDelete)
                .addGap(32, 32, 32)
                .addComponent(btnFind)
                .addGap(14, 14, 14))
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

        jButton1.setText("Sắp xếp nhân viên theo lương");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 56, Short.MAX_VALUE)
                        .addComponent(btnDautien)
                        .addGap(43, 43, 43)
                        .addComponent(btnTruoc)
                        .addGap(56, 56, 56)
                        .addComponent(btnSau)
                        .addGap(46, 46, 46)
                        .addComponent(btnCuoi)
                        .addGap(149, 149, 149))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(234, 234, 234))
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
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDautien)
                    .addComponent(btnTruoc)
                    .addComponent(btnSau)
                    .addComponent(btnCuoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked
        mouseClick();

    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thêm", "", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            if (validates() == false) {
                validate();
            } else {
                if (checkMa() == false) {
                    JOptionPane.showMessageDialog(null, "Mã nhân viên này đã có");
                    return;
                } else {
                    if (NhanVienService.Insert(readForm()) < 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    } else {
                        JOptionPane.showMessageDialog(this, "thêm thành công");
                        fillTable(NhanVienService.loadData());
                        ClearForm();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa", "", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
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
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn tìm kiếm", "", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
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
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sửa", "", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            if (validates() == false) {
                validate();
            } else {
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sắp xếp", "", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            NhanVienService.Sapxeptheoluong();
            fillTable(NhanVienService.Sapxeptheoluong());
            ClearForm();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa form", "", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            ClearForm();
            fillTable(NhanVienService.loadData());
        }
    }//GEN-LAST:event_btnNewActionPerformed

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
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSau;
    private javax.swing.JButton btnTruoc;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup btngioitinh;
    private javax.swing.JButton jButton1;
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
