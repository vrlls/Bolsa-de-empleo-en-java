/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarchivos;

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
import static practicaarchivos.Demanda.archdem;
import static practicaarchivos.Empresa.archemp;
import static practicaarchivos.Oferta.arch;
import static practicaarchivos.Oferta.arch;

/**
 *
 * @author usuario
 */
public class Evaluador extends javax.swing.JFrame {

    /**
     * Creates new form Evaluador
     */
    public Evaluador() throws IOException {
        initComponents();
        this.mostartabla2();
    }
    Nodo ptr = null;
    Nodo q = null;
    Nodo emp = null;
    Nodo p = null;
    Nodo coemp = null;
    Nodo coele = null;
    public static File archdem2 = new File("copiademandas.txt");

    public void OrdenarLista(Nodo ptr) {
        Nodo p = ptr;
        int puntuacion;
        String nombre;
        String email;
        Long salmin;
        String completa;
        String parcial;
        String titulacion;
        String habilidad;
        String valoracion;
        while (p != null) {
            Nodo q = p.link;
            while (q != null) {
                if (p.puntuacion < q.puntuacion) {
                    puntuacion = p.puntuacion;
                    nombre = p.nombre;
                    email = p.email;
                    salmin = p.salmin;
                    completa = p.completa;
                    parcial = p.parcial;
                    titulacion = p.titulacion;
                    habilidad = p.habilidad;
                    valoracion = p.valoracion;
                    p.nombre = q.nombre;
                    p.email = q.email;
                    p.salmin = q.salmin;
                    p.completa = q.completa;
                    p.parcial = q.parcial;
                    p.titulacion = q.titulacion;
                    p.habilidad = q.habilidad;
                    p.valoracion = q.valoracion;
                    q.nombre = nombre;
                    q.email = email;
                    q.salmin = salmin;
                    q.completa = completa;
                    q.parcial = parcial;
                    q.titulacion = titulacion;
                    q.habilidad = habilidad;
                    q.valoracion = valoracion;

                }
                q = q.link;
            }
            p = p.link;
        }
    }

    public void insertarNodo(String titulacion, Long salmin, Long salmax, String completa, String parcial, String habilidad, String valoracion) throws FileNotFoundException, IOException {

        p = new Nodo(titulacion, salmin, salmax, completa, parcial, habilidad, valoracion);
        if (ptr == null) {
            ptr = p;
            q = p;

        } else {
            q.link = p;
            q = p;

        }
    }

    public boolean validarval(String valoracion, String valoracion2) {
        int i = 0, sw = 0;
        while (i < valoracion.length() && sw == 0) {
            if (valoracion.substring(i, i + 1).equals("0") || valoracion.substring(i, i + 1).equals(" ")) {
                i++;
            } else {
                if (valoracion.substring(i, i + 1).equals(valoracion2.substring(i, i + 1))) {
                    i++;
                } else {
                    sw = 1;
                }
            }

        }
        if (sw == 0) {
            return true;
        } else {
            return false;
        }

    }

    public void insertarnodoemp(String titulacion, Long salmin, Long salmax, String completa, String parcial, String habilidad, String valoracion) {

        emp = new Nodo(titulacion, salmin, salmax, completa, parcial, habilidad, valoracion);
    }

    public boolean validarjornada(String parcial, String completa) {
        if (emp.parcial.equals("true") && parcial.equals("true")) {
            return true;
        } else {
            if (emp.completa.equals("true") && completa.equals("true")) {
                return true;
            } else {
                return false;
            }
        }

    }

    public void MostrarLista(Nodo ptr) {
        DefaultTableModel table = (DefaultTableModel) Tabla1.getModel();
        Nodo p = ptr;
        while (p != null) {
            table.addRow(new Object[]{(Object) p.nombre, (Object) p.email, (Object) p.salmin, (Object) Boolean.parseBoolean(p.completa),
                (Object) Boolean.parseBoolean(p.parcial), (Object) p.titulacion, (Object) p.habilidad, (Object) p.valoracion});
            p = p.link;
        }
        Tabla1.setModel(table);
    }

    public boolean escoger(String titulacion, Long salmin, Long salmax, String completa, String parcial, String habilidad, String valoracion,
            String titulacion2, Long salmin2, String completa2, String parcial2, String habilidad2, String valoracion2) {

        if (titulacion.equals(titulacion2) && (salmin >= salmin2 || salmax >= salmin2) && this.validarjornada(parcial2, completa2)) {
            return true;
        } else {
            return false;
        }
    }

    public void mostartabla2() throws FileNotFoundException, IOException {
        if (arch.exists()) {
            DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
            FileReader fr = new FileReader(arch);
            BufferedReader br = new BufferedReader(fr);
            String y;

            while ((y = br.readLine()) != null) {

                if (y.contains(",")) {

                    String[] campos = y.split(",");
                    String nom = campos[0];
                    Long salmin = Long.parseLong(campos[1]);
                    Long salmax = Long.parseLong(campos[2]);
                    Object parcial = false;
                    if (campos[3].equals("true")) {
                        parcial = true;
                    }
                    Object completa = false;
                    if (campos[4].equals("true")) {
                        completa = true;
                    }
                    String titulacion = campos[5];
                    String habilidad = campos[6];
                    String val = campos[7];
                    String empresatb = campos[8];

                    table.addRow(new Object[]{nom, salmin, salmax, parcial, completa, titulacion, habilidad, val, empresatb});
                }

            }
            br.close();
        }
    }

    public boolean revisar(String titulacion, Long salmin, Long salmax, String completa, String parcial, String habilidad, String valoracion) throws IOException {
        if (titulacion.equals(emp.titulacion) && (salmin >= emp.salmin || salmax >= emp.salmin)
                && (validarjornada(parcial, completa)) && habilidad.contains(emp.habilidad) && (this.validarval(emp.valoracion, valoracion))) {
            return true;
        } else {
            return false;
        }

    }

    public int puntua(String habilidad, String valoracion) {
        int total = 0;
        if (habilidad.contains(emp.habilidad)) {
            total++;
        }
        if (this.validarval(emp.valoracion, valoracion)) {
            total++;
        }
        return total;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame = new javax.swing.JFrame();
        aceptoeva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        empText = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        elegido = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fc2 = new javax.swing.JFileChooser();
        framesel = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        borrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        listado = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        aceptoeva.setText("Acepto");
        aceptoeva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptoevaActionPerformed(evt);
            }
        });

        jLabel2.setText("*Al aceptar se enviará la opcion obtenida y se eliminará del registro");

        jScrollPane2.setViewportView(empText);

        jScrollPane3.setViewportView(elegido);

        jLabel3.setText("Datos sumistrados para el puesto ");

        jLabel4.setText("Mejor opción");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("RESULTADOS");

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(frameLayout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameLayout.createSequentialGroup()
                                .addComponent(aceptoeva)
                                .addGap(86, 86, 86))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(frameLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(102, 102, 102))
            .addGroup(frameLayout.createSequentialGroup()
                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel4))
                    .addGroup(frameLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(aceptoeva)
                .addGap(32, 32, 32))
        );

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "e-mail", "Salario min", "Jornada completa", "Jornada parcial", "Titulaciones", "Habilidadesl", "Valoracion de Ac"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabla1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Tabla1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Tabla1PropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(Tabla1);

        borrar.setText("ACEPTAR");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        jLabel8.setText("*Al aceptar se borrará este registro del archivo de las demandas, al igual que la oferta correspondiente");

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel9.setText("LISTADO DE MEJORES OPCIONES");

        jLabel10.setText("Por favor, seleccione la fila del candidato que considere más adecuado para el trabajo.");

        javax.swing.GroupLayout frameselLayout = new javax.swing.GroupLayout(framesel.getContentPane());
        framesel.getContentPane().setLayout(frameselLayout);
        frameselLayout.setHorizontalGroup(
            frameselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameselLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameselLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(188, 188, 188))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameselLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(borrar)
                .addGap(26, 26, 26))
            .addGroup(frameselLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameselLayout.setVerticalGroup(
            frameselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameselLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(680, 397));

        jLabel1.setText("Presione sobre la linea de la cual desea saber la opción mas indicada de trabajo");

        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/volver.png"))); // NOI18N
        volver.setBorder(null);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaarchivos/iconos/candidatos.png"))); // NOI18N
        Buscar.setBorder(null);
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre/Descripción  ", "Salario Min", "Salario Max", "J. Parcial ", "J. Completa", "Titulaciones", "Habilidades", "Nivel ", "Empresa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("BIENVENIDO EVALUADOR");

        listado.setText("Mostrar Listado de opciones");
        listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoActionPerformed(evt);
            }
        });

        jLabel7.setText("Mostrar mejor opcion");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Si no muestra resultados en la mejor opcion\nes porque ninguno es 100% apto, pruebe\nentonces, que le muestre el listado de\ntodos los posibles candidatos.");
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(listado)
                        .addGap(84, 84, 84)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(volver, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addComponent(Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(listado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed

        this.dispose();
        Inicio i = new Inicio();
        i.setVisible(true);

    }//GEN-LAST:event_volverActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed

        ptr = null;
        q = null;
        emp = null;
        coemp = null;
        coele = null;
        elegido.setText("");
        empText.setText("");
        p = null;
        if (Tabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Favor seleccione una fila");
        } else {
            int f = Tabla.getSelectedRow();

            DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
            this.insertarnodoemp(table.getValueAt(f, 5).toString(), Long.parseLong(table.getValueAt(f, 1).toString()),
                    Long.parseLong(table.getValueAt(f, 2).toString()), table.getValueAt(f, 4).toString(),
                    table.getValueAt(f, 3).toString(), table.getValueAt(f, 6).toString(), table.getValueAt(f, 7).toString());
            System.out.println("empresa");
            System.out.println(emp.titulacion + emp.salmin + emp.salmax + emp.completa + emp.parcial + emp.habilidad + emp.valoracion);
            if (archdem.exists()) {
                FileReader fr = null;
                try {
                    fr = new FileReader(archdem);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedReader br = new BufferedReader(fr);
                String y;

                try {
                    while ((y = br.readLine()) != null) {

                        if (y.contains(",")) {

                            String[] campos = y.split(",");
                            String nom = campos[0];
                            String correo = campos[1];
                            Long salmin = Long.parseLong(campos[2]);
                            String completa = campos[3];
                            String parcial = campos[4];
                            String titulacion = campos[5];
                            String habilidad = campos[6];
                            String val = campos[7];
                            Long salmax = Long.parseLong("0");

                            System.out.println(" registro");
                            System.out.println(titulacion + salmin + salmax + completa + parcial + habilidad + val);
                            if (this.revisar(titulacion, salmin, salmax, completa, parcial, habilidad, val)) {
                                this.insertarNodo(titulacion, salmin, salmax, completa, parcial, habilidad, val);
                                coele = new Nodo(nom, correo);
                                coemp = new Nodo(table.getValueAt(f, 8).toString(), table.getValueAt(f, 5).toString());
                            }
                        }

                    }
                    br.close();

                    if (p == null) {
                        JOptionPane.showMessageDialog(null, "No hay opciones favorables para este trabajo");
                    } else {
                        if (frame.isVisible()) {
                            frame.dispose();
                        }
                        frame.setBounds(10, 10, 680, 397);
                        frame.setVisible(true);
                        elegido.setText("Nombre:\n" + coele.nombre + "\nCorreo:\n" + coele.correo);
                        empText.setText("Nombre:\n" + coemp.nombre + "\nTitulacion:\n " + coemp.correo);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void aceptoevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptoevaActionPerformed
        DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
        table.removeRow(Tabla.getSelectedRow());
        try (FileWriter fw = new FileWriter(arch);
                BufferedWriter bw = new BufferedWriter(fw);) {
            for (int i = 0; i < table.getRowCount(); i++) {
                Object nom = table.getValueAt(i, 0);
                Object salmin = table.getValueAt(i, 1);
                Object salmax = table.getValueAt(i, 2);
                Object parcial = table.getValueAt(i, 3);
                Object completa = table.getValueAt(i, 4);
                Object titulacion = table.getValueAt(i, 5);
                Object habilidad = table.getValueAt(i, 6);
                Object nivel = table.getValueAt(i, 7);
                Object empresatb = table.getValueAt(i, 8);
                bw.write(nom + "," + salmin + "," + salmax + "," + parcial + "," + completa + "," + titulacion + "," + habilidad + "," + nivel + "," + empresatb);
                bw.newLine();
            }
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Demanda.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Scanner leer = new Scanner(archdem);
                FileReader fr1 = new FileReader(archdem);
                BufferedReader br1 = new BufferedReader(fr1);
                FileWriter fw = new FileWriter(archdem2);
                BufferedWriter bw = new BufferedWriter(fw);) {
            String linea1;
            while ((linea1 = br1.readLine()) != null) {

                String[] Datos = linea1.split(",");
                if (Datos[0].equals(coele.nombre) && Datos[1].equals(coele.correo)) {

                } else {
                    bw.write(linea1);
                    bw.newLine();
                    
                }

            }
            br1.close();
            bw.close();

            Scanner leer2 = new Scanner(archdem2);
            FileReader fr = new FileReader(archdem2);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw2 = new FileWriter(archdem);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            
            String linea;
            if (!archdem2.exists()) {
                
            } else {
                while ((linea = br.readLine()) != null) {
                    
                    archdem.setWritable(true);
                    bw2.write(linea);
                    bw2.newLine();
                }
                bw2.close();
                br.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Demanda.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Evaluador.class.getName()).log(Level.SEVERE, null, ex);
        }

        elegido.setText("");
        empText.setText("");

        frame.setVisible(false);
    }//GEN-LAST:event_aceptoevaActionPerformed

    private void Tabla1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Tabla1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla1PropertyChange

    private void listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoActionPerformed
        // TODO add your handling code here:
        emp = null;
        ptr = null;
        int sw = 0;
        if (archdem.exists()) {
            if (Tabla.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Favor seleccione una fila");
            } else {
                int f = Tabla.getSelectedRow();
                DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
                DefaultTableModel table1 = (DefaultTableModel) Tabla1.getModel();
                table1.setRowCount(0);
                this.insertarnodoemp(table.getValueAt(f, 5).toString(), Long.parseLong(table.getValueAt(f, 1).toString()),
                        Long.parseLong(table.getValueAt(f, 2).toString()), table.getValueAt(f, 4).toString(),
                        table.getValueAt(f, 3).toString(), table.getValueAt(f, 6).toString(), table.getValueAt(f, 7).toString());
                try (Scanner leer = new Scanner(archdem)) {
                    while (leer.hasNextLine()) {

                        String linea = leer.nextLine();
                        String[] Datos = linea.split(",");
                        String nom = (Datos[0]);
                        String email = Datos[1];
                        long sal = Long.parseLong(Datos[2]);
                        String completa = (Datos[3]);
                        String parcial = Datos[4];
                        String titulaciones = (Datos[5]);
                        String habilidad = (Datos[6]);
                        String val = (Datos[7]);
                        if (this.escoger(emp.titulacion, emp.salmin, emp.salmax, emp.completa, emp.parcial, emp.habilidad, emp.valoracion, titulaciones, sal, completa, parcial, habilidad, val)) {
                            Nodo ptr = new Nodo(this.puntua(habilidad, val), nom, email, sal, completa, parcial, titulaciones, habilidad, val);
                            this.OrdenarLista(ptr);
                            this.MostrarLista(ptr);
                            sw = 1;
                        }
                    }
                    leer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Demanda.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                if (sw == 1) {
                    framesel.setVisible(true);
                    framesel.setBounds(10, 20, 800, 450);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay opciones disponibles para esta empresa");
                }

            }
        }
    }//GEN-LAST:event_listadoActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) Tabla.getModel();
        table.removeRow(Tabla.getSelectedRow());
        try (FileWriter fw = new FileWriter(arch);
                BufferedWriter bw = new BufferedWriter(fw);) {
            for (int i = 0; i < table.getRowCount(); i++) {
                Object nom = table.getValueAt(i, 0);
                Object salmin = table.getValueAt(i, 1);
                Object salmax = table.getValueAt(i, 2);
                Object parcial = table.getValueAt(i, 3);
                Object completa = table.getValueAt(i, 4);
                Object titulacion = table.getValueAt(i, 5);
                Object habilidad = table.getValueAt(i, 6);
                Object nivel = table.getValueAt(i, 7);
                Object empresatb = table.getValueAt(i, 8);
                bw.write(nom + "," + salmin + "," + salmax + "," + parcial + "," + completa + "," + titulacion + "," + habilidad + "," + nivel + "," + empresatb);
                bw.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(Demanda.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel table1 = (DefaultTableModel) Tabla1.getModel();
        if (Tabla1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Escoja una fila");
        } else {
            int f1 = Tabla1.getSelectedRow();

            try (Scanner leer = new Scanner(archdem);
                    FileReader fr1 = new FileReader(archdem);
                    BufferedReader br1 = new BufferedReader(fr1);
                    FileWriter fw = new FileWriter(archdem2);
                    BufferedWriter bw = new BufferedWriter(fw);) {
                String linea1;
                while ((linea1 = br1.readLine()) != null) {

                    String[] Datos = linea1.split(",");
                    
                    if (Datos[0].equals(table1.getValueAt(f1, 0)) && Datos[1].equals(table1.getValueAt(f1, 1)) && Datos[6].equals(table1.getValueAt(f1, 6)) && Datos[7].equals(table1.getValueAt(f1, 7))) {


                    } else {
                        bw.write(linea1);
                        bw.newLine();
                    }

                }
                framesel.dispose();
                br1.close();
                bw.close();

                Scanner leer2 = new Scanner(archdem2);
                FileReader fr = new FileReader(archdem2);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw2 = new FileWriter(archdem);
                BufferedWriter bw2 = new BufferedWriter(fw2);
                
                String linea;
                if (!archdem2.exists()) {
                } else {
                    while ((linea = br.readLine()) != null) {
                        archdem.setWritable(true);
                        bw2.write(linea);
                        bw2.newLine();
                    }
                    bw2.close();
                    br.close();
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Demanda.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Evaluador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_borrarActionPerformed

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
            java.util.logging.Logger.getLogger(Evaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Evaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Evaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Evaluador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Evaluador().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Evaluador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable Tabla1;
    private javax.swing.JButton aceptoeva;
    private javax.swing.JButton borrar;
    private javax.swing.JTextPane elegido;
    private javax.swing.JTextPane empText;
    private javax.swing.JFileChooser fc2;
    private javax.swing.JFrame frame;
    private javax.swing.JFrame framesel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton listado;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
