/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Objetos.Cliente;
import Objetos.Conductor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author chepe
 */
public class ConductoresV extends javax.swing.JFrame {

    /**
     * Creates new form ConductoresV
     */
    public ConductoresV() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboEli = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dpiCre = new javax.swing.JTextField();
        nombreCre = new javax.swing.JTextField();
        apellidoCre = new javax.swing.JTextField();
        telefonoCre = new javax.swing.JTextField();
        direccionCre = new javax.swing.JTextField();
        licenciaCre = new javax.swing.JComboBox<>();
        generoCre = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        fechaCre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        comboMod = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        direccionMod = new javax.swing.JTextField();
        telefonoMod = new javax.swing.JTextField();
        generoMod = new javax.swing.JComboBox<>();
        licenciaMod = new javax.swing.JComboBox<>();
        apellidoMod = new javax.swing.JTextField();
        nombreMod = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        fechaMod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cargar archivo de conductores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton1)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(147, 147, 147)
                .addComponent(jButton2)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Carga masiva", jPanel1);

        jLabel8.setText("Seleccione el DPI");

        comboEli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Eliminar cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(comboEli, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jButton3)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addComponent(comboEli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton3)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eliminar", jPanel3);

        jLabel1.setText("DPI");

        jLabel2.setText("Nombres");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Licencia");

        jLabel5.setText("Genero");

        jLabel6.setText("Telefono");

        jLabel7.setText("Direccion");

        licenciaCre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        generoCre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        jButton5.setText("Crear Conductor");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel16.setText("Fecha de Nac");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(146, 146, 146))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dpiCre)
                    .addComponent(nombreCre)
                    .addComponent(apellidoCre)
                    .addComponent(licenciaCre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generoCre, 0, 150, Short.MAX_VALUE)
                    .addComponent(telefonoCre)
                    .addComponent(direccionCre)
                    .addComponent(fechaCre))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dpiCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licenciaCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generoCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fechaCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Carga individual", jPanel2);

        jLabel9.setText("Seleccione el DPI");

        comboMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre");

        jLabel11.setText("Apellido");

        jLabel12.setText("Licencia");

        jLabel13.setText("Genero");

        jLabel14.setText("Telefono");

        jLabel15.setText("Direccion");

        generoMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        licenciaMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        jButton6.setText("Modificar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel17.setText("Fecha de Nac");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(comboMod, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel17)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel12)))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(direccionMod)
                            .addComponent(telefonoMod)
                            .addComponent(generoMod, 0, 140, Short.MAX_VALUE)
                            .addComponent(licenciaMod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apellidoMod)
                            .addComponent(nombreMod)
                            .addComponent(fechaMod)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jButton6)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nombreMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(apellidoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(licenciaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(generoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(fechaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(telefonoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(direccionMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Seleccion seleccion = new Seleccion();
        seleccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if( archivo != null && !(archivo.getName().equals("")) ){
            try {
                cargaMasivaConductores(archivo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(dpiCre.getText().length() > 0 && nombreCre.getText().length() > 0 && apellidoCre.getText().length() > 0 && telefonoCre.getText().length() > 0 &&
                direccionCre.getText().length() > 0 && fechaCre.getText().length() > 0) {
                crearConductor();
        }else{
            JOptionPane.showMessageDialog(this,"Debe de rellenar todos los campos");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarConductor();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        buscarConductor();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       modificarConductor();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(ConductoresV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConductoresV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConductoresV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConductoresV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConductoresV().setVisible(true);
            }
        });
    }
    
    private void modificarConductor(){
        if(conductor != null){
            if(nombreMod.getText().length() > 0){
                conductor.setNombres(nombreMod.getText().trim());
            }
            if(apellidoMod.getText().length() > 0){
                conductor.setApellidos(apellidoMod.getText().trim());
            }
            conductor.setLicencia((String)licenciaMod.getSelectedItem());
            conductor.setGenero((String)generoMod.getSelectedItem());
            if(fechaMod.getText().length() > 0){
                conductor.setFechaNac(fechaMod.getText().trim());
            }
            if(telefonoCre.getText().length() > 0){
                conductor.setTelefono(telefonoMod.getText().trim());
            }
            if(direccionMod.getText().length() > 0){
                conductor.setDireccion(direccionMod.getText().trim());
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debe de seleccionar un conductor para poder modificar sus datos!");
        }
    }
    
    Conductor conductor;
    
    private void buscarConductor(){
        conductor = Inicial.conductores.buscar(new BigInteger((String)comboMod.getSelectedItem()));
        if(conductor != null){
            JOptionPane.showMessageDialog(this, "Ya se pueden modificar los datos del conductor");
            nombreMod.setText(conductor.getNombres());
            apellidoMod.setText(conductor.getApellidos());
            licenciaMod.setSelectedItem(conductor.getLicencia().toUpperCase());
            if(conductor.getGenero().toLowerCase() == "masculino"){
                generoMod.setSelectedIndex(0);
            }else{
                generoMod.setSelectedIndex(1);
            }
            fechaMod.setText(conductor.getFechaNac());
            telefonoMod.setText(conductor.getTelefono());
            direccionMod.setText(conductor.getDireccion());
        }else{
            JOptionPane.showMessageDialog(this,"El DPI ingresado no se encuentra en el sistema!");
        }
    }
    
    private void eliminarConductor(){
       boolean res =  Inicial.conductores.eliminar(new BigInteger((String)comboEli.getSelectedItem()));
       if(res){
           JOptionPane.showMessageDialog(this,"El conductor se a eliminado corerectamente");
       }else{
           JOptionPane.showMessageDialog(this,"El DPI ingresado no se encuentra en el sistema!");
       }
    }
    
    private void crearConductor(){
        BigInteger dpi = new BigInteger(dpiCre.getText().trim());
        Inicial.conductores.insertar(new Conductor( (String)licenciaCre.getSelectedItem(), dpi, nombreCre.getText().trim(),
                apellidoCre.getText().trim(), (String)generoCre.getSelectedItem(), fechaCre.getText().trim(), telefonoCre.getText().trim(),
                direccionCre.getText().trim(), 0));
        JOptionPane.showMessageDialog(this,"Se a creado el conductor exitosamente!");
    }
    
    public void listadoDPI(){
        comboEli.removeAllItems();
        comboMod.removeAllItems();
        ArrayList <String> listado = Inicial.conductores.listadoDPI();
        for(int i = 0; i < listado.size(); i++){
            comboEli.addItem(listado.get(i));
            comboMod.addItem(listado.get(i));
        }
    }
    
    private void cargaMasivaConductores(File archivoConductores) throws FileNotFoundException, IOException{
        FileReader lector = new FileReader(archivoConductores);
        BufferedReader almacenador = new BufferedReader(lector);
        String linea, contenido = "";
        String[] aux, aux1;
        while( (linea = almacenador.readLine()) != null ){
            contenido += linea;
        }
        aux1 = contenido.split(";");
        for(int i = 0; i < aux1.length; i++){
            aux = aux1[i].split("%");
            BigInteger dpi = new BigInteger(aux[0].trim());
            Inicial.conductores.insertar(new Conductor(aux[3].trim(), dpi, aux[1].trim(), aux[2].trim(), aux[4].trim(), 
                    aux[5].trim(), aux[6].trim(), aux[7].trim(), 0));
        }
        JOptionPane.showMessageDialog(this,"Se han cargado los conductores exitosamente!\nPuede continuar con la ejecucion del programa");
        listadoDPI();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoCre;
    private javax.swing.JTextField apellidoMod;
    private javax.swing.JComboBox<String> comboEli;
    private javax.swing.JComboBox<String> comboMod;
    private javax.swing.JTextField direccionCre;
    private javax.swing.JTextField direccionMod;
    private javax.swing.JTextField dpiCre;
    private javax.swing.JTextField fechaCre;
    private javax.swing.JTextField fechaMod;
    private javax.swing.JComboBox<String> generoCre;
    private javax.swing.JComboBox<String> generoMod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> licenciaCre;
    private javax.swing.JComboBox<String> licenciaMod;
    private javax.swing.JTextField nombreCre;
    private javax.swing.JTextField nombreMod;
    private javax.swing.JTextField telefonoCre;
    private javax.swing.JTextField telefonoMod;
    // End of variables declaration//GEN-END:variables
}
