package myormawa;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static myormawa.koneksi.getKoneksi;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
/**
 *
 * @author ariputraaa-2201010182
 */
public class Jform1 extends javax.swing.JFrame {
    DefaultTableModel TM = new DefaultTableModel();

    /**
     * Creates new form Jform1
     */
    public Jform1() throws SQLException {
        initComponents();
        tabel_ormawa.setModel(TM);
        TM.addColumn("NIM");
        TM.addColumn("Nama");
        TM.addColumn("Angkatan");
        TM.addColumn("Jurusan");
        TM.addColumn("No_Telp");
        TM.addColumn("Ormawa");
        
        this.setTitle("Aplikasi Pendaftaran Ormawa");
        ImageIcon IC = new ImageIcon("img/INSTIKII.png");
        this.setIconImage(IC.getImage());
        
        
//        Object[] dta =  new Object[6];
//        dta[0] = "2201010182";
//        dta[1] = "I Gusti Made Ngurah Ari Bhawanaputra";
//        dta[2] = "2022";
//        dta[3] = "TI-KAB";
//        dta[4] = "12345";
//        dta[5] = "HIMA-TI";
//        TM.addRow(dta);
//       
//        dta[0] = "2201010183";
//        dta[1] = "NI Nyoman Sucianta Pertiwi";
//        dta[2] = "2022";
//        dta[3] = "TI-KAB";
//        dta[4] = "67890";
//        dta[5] = "BEM";
//        TM.addRow(dta);
//        

        
        List_all();
        kosongkanform();
        loadphoto("");  
    }
        private void loadphoto(String idx){
        String nopic = "src/img/instikii.png";
        String ph = "src/img/"+idx+".png";
        BufferedImage photomaba = loadIMG.loadImage(ph);
        if(photomaba == null){
            photomaba = loadIMG.loadImage(nopic);
        }
        ImageIcon iconphoto = new ImageIcon(photomaba);
        photo.setIcon(iconphoto);
    }
        
        private void List_all () throws SQLException{
        TM.getDataVector().removeAllElements();       
        TM.fireTableDataChanged();
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
            
            String sql = "SELECT * FROM daftar_maba";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            
            while(rs.next()){
                
                Object[] dta = new Object[6];
                dta [0] = rs.getString("nim");
                dta [1] = rs.getString("nama");
                dta [2] = rs.getString("angkatan");
                dta [3] = rs.getString("jurusan");
                dta [4] = rs.getString("no_telp");
                dta [5] = rs.getString("ormawa");
                TM.addRow(dta);

            }
        }
        
    }
        
        private  void storeData() throws SQLException{
        Connection cnn = getKoneksi();
        String nim = TxtNIM.getText();
        String nama = TxtNama.getText();
        String angkatan = TxtAngkatan.getText();
        String jurusan = TxtJurusan.getText();
        String no_telp = TxtNo_Telp.getText();
        String ormawa = TxtOrmawa.getText();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "INSERT INTO daftar_maba(nim,nama,angkatan,jurusan,no_telp,ormawa) VALUES (?,?,?,?,?,?);");
            PS.setString(1, nim);
            PS.setString(2, nama);
            PS.setString(3, angkatan);
            PS.setString(4 ,jurusan);
            PS.setString(5, no_telp);
            PS.setString(6, ormawa);
            PS.executeUpdate();
        }
    }
        private void updateData() throws SQLException{
        Connection cnn = getKoneksi();
        
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "UPDATE daftar_maba SET nama=?,angkatan=?,jurusan=?,no_telp=?,ormawa=? WHERE nim =?;");
            PS.setString(1, TxtNama.getText());
            PS.setString(2, TxtAngkatan.getText());
            PS.setString(3 ,TxtJurusan.getText());
            PS.setString(4, TxtNo_Telp.getText());
            PS.setString(5, TxtOrmawa.getText());
            PS.setString(6, TxtNIM.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
        private void destroyData() throws SQLException{
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
        
            PreparedStatement PS = cnn.prepareStatement(
            "DELETE FROM daftar_maba WHERE nim =?;");
            PS.setString(1, TxtNIM.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
        
        private void kosongkanform(){
        
        TxtNIM.setText("");
        TxtNama.setText("");
        TxtAngkatan.setText("");
        TxtJurusan.setText("");
        TxtNo_Telp.setText("");
        TxtOrmawa.setText("");
    }

    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_ormawa = new javax.swing.JTable();
        TxtNIM = new javax.swing.JTextField();
        TxtNama = new javax.swing.JTextField();
        TxtAngkatan = new javax.swing.JTextField();
        TxtJurusan = new javax.swing.JTextField();
        TxtNo_Telp = new javax.swing.JTextField();
        TxtOrmawa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtnInput = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnTutup = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        photo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel1.setText("FORM PENDAFTARAN ORGANISASI MAHASISWA");

        tabel_ormawa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Angkatan", "Jurusan", "No_Telp", "Ormawa"
            }
        ));
        tabel_ormawa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_ormawaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_ormawa);

        TxtNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNIMActionPerformed(evt);
            }
        });

        TxtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNamaActionPerformed(evt);
            }
        });

        TxtAngkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAngkatanActionPerformed(evt);
            }
        });

        TxtJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtJurusanActionPerformed(evt);
            }
        });

        TxtNo_Telp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNo_TelpActionPerformed(evt);
            }
        });

        TxtOrmawa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtOrmawaActionPerformed(evt);
            }
        });

        jLabel2.setText("NIM");

        jLabel3.setText("Nama");

        jLabel4.setText("Angkatan");

        jLabel5.setText("Jurusan");

        jLabel6.setText("No_Telp");

        jLabel7.setText("Ormawa");

        BtnInput.setBackground(new java.awt.Color(0, 0, 0));
        BtnInput.setForeground(new java.awt.Color(255, 255, 255));
        BtnInput.setText("INPUT");
        BtnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInputActionPerformed(evt);
            }
        });

        BtnDelete.setText("DELETE");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnTutup.setBackground(new java.awt.Color(0, 0, 0));
        BtnTutup.setForeground(new java.awt.Color(255, 255, 255));
        BtnTutup.setText("TUTUP FORM");
        BtnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTutupActionPerformed(evt);
            }
        });

        BtnUpdate.setText("UPDATE");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TxtOrmawa)
                                            .addComponent(TxtNo_Telp)
                                            .addComponent(TxtJurusan)
                                            .addComponent(TxtAngkatan)
                                            .addComponent(TxtNama)
                                            .addComponent(TxtNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(BtnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(BtnInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNo_Telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtOrmawa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(BtnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNamaActionPerformed

    private void TxtNo_TelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNo_TelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNo_TelpActionPerformed

    private void TxtNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNIMActionPerformed

    private void TxtAngkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAngkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAngkatanActionPerformed

    private void TxtOrmawaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtOrmawaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtOrmawaActionPerformed

    private void BtnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInputActionPerformed
        if(BtnInput.getText().equals("Input")){
        BtnInput.setText("Simpan");
        BtnTutup.setText("Batal");
        kosongkanform();
        tabel_ormawa.setEnabled(false);
        }else{
            BtnInput.setText("Input");
            BtnTutup.setText("Tutup Form");
            tabel_ormawa.setEnabled(true);
            try {
                storeData();
                List_all();
            } catch (SQLException ex) {
                Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtnInputActionPerformed

    private void TxtJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtJurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtJurusanActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
                int jwb = JOptionPane.showOptionDialog(
                this, 
                "Apakah anda yakin akan menghapus data dengan nim : "+ TxtNIM.getText() + "?" , 
                "Hapus data", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE, 
                null, 
                null, 
                null);
        if(jwb == JOptionPane.YES_OPTION){
           try {
            destroyData();
            List_all();
            JOptionPane.showMessageDialog(this, "Data telah dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE, null, ex);
        }  
      }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTutupActionPerformed
        if(BtnTutup.getText().equals("Tutup Form")){
            dispose();
        }else{
            BtnTutup.setText("Tutup Form");
            BtnInput.setText("Input");
        }
    }//GEN-LAST:event_BtnTutupActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        if(BtnUpdate.getText().equals("update")){
        BtnUpdate.setText("Simpan");
        BtnTutup.setText("Batal");
        }else{
            BtnUpdate.setText("update");
            BtnTutup.setText("Tutup Form");
        try {
                updateData();
                List_all();
                JOptionPane.showMessageDialog(this, "Data telah diupdate");
            } catch (SQLException ex) {
                Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE, null, ex);
            }
          }   
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void tabel_ormawaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_ormawaMouseClicked
        TxtNIM.setText(tabel_ormawa.getValueAt(tabel_ormawa.getSelectedRow(),0).toString());
        TxtNama.setText(tabel_ormawa.getValueAt(tabel_ormawa.getSelectedRow(),1).toString());
        TxtAngkatan.setText(tabel_ormawa.getValueAt(tabel_ormawa.getSelectedRow(),2).toString());
        TxtJurusan.setText(tabel_ormawa.getValueAt(tabel_ormawa.getSelectedRow(),3).toString());
        TxtNo_Telp.setText(tabel_ormawa.getValueAt(tabel_ormawa.getSelectedRow(),4).toString());
        TxtOrmawa.setText(tabel_ormawa.getValueAt(tabel_ormawa.getSelectedRow(),5).toString());
        loadphoto(TxtNIM.getText());
    }//GEN-LAST:event_tabel_ormawaMouseClicked

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
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Jform1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnInput;
    private javax.swing.JButton BtnTutup;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTextField TxtAngkatan;
    private javax.swing.JTextField TxtJurusan;
    private javax.swing.JTextField TxtNIM;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtNo_Telp;
    private javax.swing.JTextField TxtOrmawa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel photo;
    private javax.swing.JTable tabel_ormawa;
    // End of variables declaration//GEN-END:variables
}
