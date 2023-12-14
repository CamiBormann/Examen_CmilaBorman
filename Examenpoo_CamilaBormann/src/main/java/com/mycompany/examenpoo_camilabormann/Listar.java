/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examenpoo_camilabormann;

/**
 *
 * @author camil
 * /
 * 
public class LISTAR extends javax.swing.JFrame {

    //listado de arreglo de mecanicos
    ArrayList<Modelo> ListaMecanicos = new ArrayList<Modelo>();
    //modelo por para manejar una jTable(tabla de java)
    DefaultTableModel tabla = new DefaultTableModel();

    
    public LISTAR() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Listar Mecanicos");
        
        obtenerDatos();
        llenarTabla();
    }

    private void obtenerDatos() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("modelo.CUE"));
            ListaMecanicos = (ArrayList<Modelo>) entrada.readObject();
            entrada.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex.getMessage() + ":" + ex.getLocalizedMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarTabla() {
        tabla.addColumn("Folio");
        tabla.addColumn("Nombre y  Apellido");
        tabla.addColumn("Edad");
        tabla.addColumn("Direccion");
        tabla.addColumn("Titulo Profesional");
        tabla.addColumn("Especialidad");
        tabla.addColumn("Sueldo Bruto");
        tabla.addColumn("Gratificacion");
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
        btnVolver = new javax.swing.JButton();

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>                        

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }                                         

  
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LISTAR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMecanicos;
    // End of variables declaration                   
}

  
    @SuppressWarnings("unchecked")
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
