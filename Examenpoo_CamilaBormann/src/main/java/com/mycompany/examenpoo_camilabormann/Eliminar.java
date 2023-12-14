/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examenpoo_camilabormann;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class ELIMINAR extends javax.swing.JFrame {

    ArrayList<Modelo> ListaMecanicos = new ArrayList<Modelo>();

    DefaultTableModel tabla = new DefaultTableModel();

    /**
     * 
     */
    public ELIMINAR() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Eliminar Profesional");
        obtenerDatos();
        llenarTabla();
    }

    //metodo privado 
    private void obtenerDatos() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("modelo.CUE"));
            ListaMecanicos = (ArrayList<Modelo>) entrada.readObject();
            entrada.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //metodo privado para guardar los datos en un archivo
    private void guardarDatos(ArrayList<Modelo> modelo) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("modelo.CUE"));
            salida.writeObject(modelo);
            salida.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex.getMessage() + "_:_" + ex.getLocalizedMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void llenarTabla() {
        tabla.addColumn("Folio");
        tabla.addColumn("Nombre y Apellido");
        tabla.addColumn("Edad");
        tabla.addColumn("Direccion");
        tabla.addColumn("Titulo Profesional");
        tabla.addColumn("Especialidad");
        tabla.addColumn("Sueldo Bruto");
        tabla.addColumn("Gratificacion Legal");
        tabla.addColumn("Sueldo Neto");
        tablaMecanicos.setModel(tabla);
        for (int i = 0; i < ListaMecanicos.size(); i++) {
            Object[] fila = {
                ListaMecanicos.get(i).getFolioMecanico(), ListaMecanicos.get(i).getNombreApellido(), ListaMecanicos.get(i).getEdad(),
                ListaMecanicos.get(i).getDomicilio(), ListaMecanicos.get(i).getTitulo(), ListaMecanicos.get(i).getEspecialidad(),
                ListaMecanicos.get(i).getSueldoBase(), ListaMecanicos.get(i).getGratTitulo(), ListaMecanicos.get(i).getSueldoTotal()
            };
            tabla.addRow(fila);
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMecanicos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaMecanicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaMecanicos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Eliminar Mecanicos");

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>                        

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //se obtiene la fila seleccionada
        int index = tablaMecanicos.getSelectedRow();
        //consulto si he seleccionado una fila
        if (index >= 0) {
            //mensaje de confirmacion
            int showConfirmDialog = JOptionPane.showConfirmDialog(rootPane, "Desea Eliminar a este mecanico?", "Atención", JOptionPane.OK_CANCEL_OPTION);
            //si usuario presiona ok
            if (showConfirmDialog == JOptionPane.OK_OPTION) {
                //elimino el dato de la lista
                ListaMecanicos.remove(index);
                //lo elimino el dato de la tabla
                tabla.removeRow(index);
                
                guardarDatos(ListaMecanicos);
            }
        }
    }                                           

    /**
     *  args 
     */
    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ELIMINAR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMecanicos;
    // End of variables declaration                   
}



GUARDAR:

   public GUARDAR() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void guardarDatos(ArrayList<Modelo> modelo) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("modelo.CUE"));
            salida.writeObject(modelo);
            salida.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
  
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jEdad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDomicilio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTitulo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jEspecialidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSueldo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jGratificacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCorregir = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Mecanico");
        setMaximumSize(new java.awt.Dimension(214, 214));

        jLabel1.setText("IdMecanico:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Edad:");

        jLabel4.setText("Domicilio:");

        jLabel5.setText("Titulo:");

        jTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INGENIERO MECANICO", "MECANICO INDUSTRIAL" }));

        jLabel6.setText("Especialidad:");

        jLabel7.setText("Sueldo Base:");

        jLabel8.setText("Gratificación Titulo:");

        jLabel9.setText("Sueldo Total:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Crear Nuevo Mecanico");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCorregir.setText("CORREGIR");
        btnCorregir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregirActionPerformed(evt);
            }
        });

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jGratificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCorregir)
                                .addGap(18, 18, 18)
                                .addComponent(btnVolver))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(33, 33, 33)
                                .addComponent(jTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTitulo, 0, 193, Short.MAX_VALUE)
                                    .addComponent(jNombre)
                                    .addComponent(jEdad)
                                    .addComponent(jDomicilio)
                                    .addComponent(jId)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(jEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(34, 34, 34)
                                .addComponent(jSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jGratificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCorregir)
                    .addComponent(btnVolver))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }                                         

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //obtener los datos del nuevo mecanico.
        int IdMecanico = Integer.parseInt(jId.getText());
        String Nombre = jNombre.getText();
        int Edad = Integer.parseInt(jEdad.getText());
        String Domicilio = jDomicilio.getText();
        String Titulo = jTitulo.getSelectedItem().toString();
        String Especialidad = jEspecialidad.getText();
        int SueldoBase = Integer.parseInt(jSueldo.getText());
        int GratTitulo = Integer.parseInt(jGratificacion.getText());
        int SueldoTotal = SueldoBase + GratTitulo;
        Modelo mecanico = new Modelo(IdMecanico, Nombre, Edad, Domicilio, Titulo, Especialidad, SueldoBase, GratTitulo, SueldoTotal);
        ListaMecanicos.add(mecanico);
        guardarDatos(ListaMecanicos);
        //mostrar mensaje
        JOptionPane.showMessageDialog(rootPane, mecanico.toString(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }                                          

    private void btnCorregirActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // limpiar los campos
        //limpiar los campos
        jId.setText("");
        jEdad.setText("");
        jNombre.setText("");
        jDomicilio.setText("");
        jTitulo.setSelectedIndex(1);
        jEspecialidad.setText("");
        jSueldo.setText("");
        jGratificacion.setText("");
        jTotal.setText("");
    }                                           

    /**
     * 
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUARDAR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCorregir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField jDomicilio;
    private javax.swing.JTextField jEdad;
    private javax.swing.JTextField jEspecialidad;
    private javax.swing.JTextField jGratificacion;
    private javax.swing.JTextField jId;
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
    private javax.swing.JTextField jNombre;
    private javax.swing.JTextField jSueldo;
    private javax.swing.JComboBox<String> jTitulo;
    private javax.swing.JTextField jTotal;
    // End of variables declaration                   
}
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
