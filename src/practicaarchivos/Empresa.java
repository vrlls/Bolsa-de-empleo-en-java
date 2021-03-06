/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarchivos;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author woltmannj
 */
public class Empresa extends javax.swing.JFrame {

    public static File archemp = new File("Empresa.txt");
    Oferta o = new Oferta();

    /**
     * Creates new form Vista
     */
    public Empresa() throws FileNotFoundException, IOException {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.mostrartabla();

    }
    
    public void mostrartabla() throws FileNotFoundException, IOException{
        if (archemp.exists()) {
            DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
            FileReader fr = new FileReader(archemp);
            BufferedReader br = new BufferedReader(fr);
            String y;
            while ((y = br.readLine()) != null) {
                if (y.contains(",")) {
                    int j = y.indexOf(",");
                    String nom = y.substring(0, j);
                    int val = Integer.parseInt(y.substring(j + 1));
                    table.addRow(new Object[]{nom, val});
                }

            }
             br.close();
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Nombretf = new javax.swing.JTextField();
        Telefonotf = new javax.swing.JTextField();
        Insertar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fc = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        addbutton = new javax.swing.JButton();
        elimbutton = new javax.swing.JButton();
        cleanbutton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        openbutton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        frame.setMinimumSize(new java.awt.Dimension(258, 258));
        frame.setResizable(false);

        jLabel1.setText("Teléfono");

        jLabel3.setText("Nombre:");

        Nombretf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombretfActionPerformed(evt);
            }
        });
        Nombretf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombretfKeyTyped(evt);
            }
        });

        Telefonotf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonotfActionPerformed(evt);
            }
        });
        Telefonotf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonotfKeyTyped(evt);
            }
        });

        Insertar.setText("Insertar");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/human ware.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameLayout.createSequentialGroup()
                        .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(33, 33, 33)
                                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombretf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Telefonotf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameLayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(Insertar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameLayout.createSequentialGroup()
                        .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombretf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Telefonotf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Insertar)
                .addGap(23, 23, 23))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
        }

        addbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/agregar-usuario.png"))); // NOI18N
        addbutton.setBorder(null);
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        elimbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/borrar.png"))); // NOI18N
        elimbutton.setBorder(null);
        elimbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimbuttonActionPerformed(evt);
            }
        });

        cleanbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/escoba.png"))); // NOI18N
        cleanbutton.setBorder(null);
        cleanbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanbuttonActionPerformed(evt);
            }
        });

        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/disquete.png"))); // NOI18N
        SaveButton.setBorder(null);
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        openbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/sobre-abierto.png"))); // NOI18N
        openbutton.setBorder(null);
        openbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openbuttonActionPerformed(evt);
            }
        });

        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/volver.png"))); // NOI18N
        BackButton.setBorder(null);
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(elimbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cleanbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cleanbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elimbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed

        Nombretf.setText("");
        Telefonotf.setText("");
        frame.setVisible(true);
        frame.setBounds(10, 20, 400, 400);
    }//GEN-LAST:event_addbuttonActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
if(Nombretf.getText().equals("") || Telefonotf.getText().equals("") ){JOptionPane.showMessageDialog(null,"LLene todos los campos");}else{
    if(Telefonotf.getText().length()<7 || Telefonotf.getText().length()>10){
    JOptionPane.showMessageDialog(null,"Coloque un telefono valido");
    } else{   
    String Nom = Nombretf.getText();
        long tel = Long.parseLong(Telefonotf.getText());
        DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
        table.addRow(new Object[]{Nom, tel});

        frame.setVisible(false);
    }
}
    }//GEN-LAST:event_InsertarActionPerformed

    private void elimbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimbuttonActionPerformed
          if (Tabla.getSelectedRow() == -1){JOptionPane.showMessageDialog(null,"Favor seleccione una fila");}else{
        DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
        table.removeRow(Tabla.getSelectedRow());
        }
    }//GEN-LAST:event_elimbuttonActionPerformed

    private void cleanbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanbuttonActionPerformed
        DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
        table.setRowCount(0);
    }//GEN-LAST:event_cleanbuttonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        if (!archemp.exists()) {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos .txt", "txt");
            fc.setFileFilter(filtro);
            int opcion = fc.showSaveDialog(this);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                archemp = fc.getSelectedFile();
            }
        }
        int filas = Tabla.getRowCount();
        DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
        try (FileWriter fw = new FileWriter(archemp);
                BufferedWriter bw = new BufferedWriter(fw);) {
            for (int i = 0; i < filas; i++) {
                Object nom = table.getValueAt(i, 0);
                Object tel = table.getValueAt(i, 1);

                bw.write(nom + "," + tel);
                bw.newLine();
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Guardado");

        } catch (IOException ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void openbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openbuttonActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos .txt", "txt");
        fc.setFileFilter(filtro);
        int opcion = fc.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            archemp = fc.getSelectedFile();
            DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
            try (Scanner leer = new Scanner(archemp)) {
                while (leer.hasNextLine()) {
                    String linea = leer.nextLine();
                    String[] Datos = linea.split(",");
                    String nom = Datos[0];
                    long tel = Long.parseLong(Datos[1]);
                    table.addRow(new Object[]{nom, tel});
                }
                leer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openbuttonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.dispose();
        Inicio i = new Inicio();
        i.setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void NombretfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombretfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombretfActionPerformed

    private void NombretfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombretfKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_NombretfKeyTyped

    private void TelefonotfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonotfKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_TelefonotfKeyTyped

    private void TelefonotfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonotfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonotfActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton Insertar;
    private javax.swing.JTextField Nombretf;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField Telefonotf;
    private javax.swing.JButton addbutton;
    private javax.swing.JButton cleanbutton;
    private javax.swing.JButton elimbutton;
    private javax.swing.JFileChooser fc;
    public static javax.swing.JFrame frame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openbutton;
    // End of variables declaration//GEN-END:variables
}
