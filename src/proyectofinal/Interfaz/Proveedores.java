/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Interfaz;

import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.INITIALIZE;
import proyectofinal.DAO.ClienteDAO;
import proyectofinal.DAO.ProveedoresDAO;
import proyectofinal.Modelo.ClienteModelo;
import proyectofinal.Modelo.ProductosModelo;
import proyectofinal.Modelo.ProveedoresModelo;

/**
 *
 * @author USUARIO
 */
public class Proveedores extends javax.swing.JInternalFrame {
int id;

DefaultTableModel model;
    Object columnas[]={"ID", "Nombre de Compañia", "Nombre de Contacto", "Cargo de Contacto", "Dirección", "Ciudad", "Teléfono"};
    Object[] obj;
    
    ProveedoresDAO dao ;    
    List<ProveedoresModelo> datos=new ArrayList<>();
    ProveedoresModelo usuario;
    Integer idUsuario;
    /**
     * Creates new form Proveedores
     */
    public Proveedores() {
        initComponents();
        
        dao=new ProveedoresDAO();
        datos =dao.Lista();
        obj=new Object[datos.size()];
        model = new DefaultTableModel(columnas,0);
        for (int i = 0; i < datos.size(); i++) {
            
            model.addRow(obj);
            model.setValueAt(datos.get(i).getIdProveedores(), i, 0);
            model.setValueAt(datos.get(i).getNombreCompañia(), i, 1);
            model.setValueAt(datos.get(i).getNombreContacto(), i, 2);
            model.setValueAt(datos.get(i).getCargoContacto(), i, 3);
            model.setValueAt(datos.get(i).getDireccion(), i, 4);
            model.setValueAt(datos.get(i).getCiudad(), i, 5);
            model.setValueAt(datos.get(i).getTelefono(), i, 6);
            
            System.out.println("idUsuario: "+datos.get(i).getIdProveedores());
            System.out.println("Nombre: "+datos.get(i).getNombreCompañia());
            System.out.println("Descripcion: "+datos.get(i).getNombreContacto());
        }
        
        tablaProveedores.setModel(model);
        //tablaUsuarios.enable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();

        setClosable(true);
        setTitle("Maestro de Proveedores");

        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btnModificar)
                        .addComponent(btnEliminar)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        MaestroProveedores c = new MaestroProveedores("m",id);
        Menu.desktopPane.add(c);
        c.toFront();
        c.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
         MaestroProveedores c = new MaestroProveedores("c",id);
        Menu.desktopPane.add(c);
        c.toFront();
        c.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextPane1KeyPressed

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaProveedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tablaProveedores;
    // End of variables declaration//GEN-END:variables
}
