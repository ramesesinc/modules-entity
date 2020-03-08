/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.entity.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.Template;

@Template(FormPage.class)
public class EntityManageDuplicatePage extends javax.swing.JPanel {

    /**
     * Creates new form EntityManageDuplicatePage2
     */
    public EntityManageDuplicatePage() {
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

        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xActionTextField1 = new com.rameses.rcp.control.XActionTextField();
        xCheckBox1 = new com.rameses.rcp.control.XCheckBox();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();
        xButton1 = new com.rameses.rcp.control.XButton();
        xButton2 = new com.rameses.rcp.control.XButton();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xIntegerField1 = new com.rameses.rcp.control.XIntegerField();
        xIntegerField2 = new com.rameses.rcp.control.XIntegerField();
        xButton3 = new com.rameses.rcp.control.XButton();

        xFormPanel1.setOrientation(com.rameses.rcp.constant.UIConstants.HORIZONTAL);

        xActionTextField1.setActionName("search");
        xActionTextField1.setCaption("Search");
        xActionTextField1.setName("searchtext"); // NOI18N
        xActionTextField1.setPreferredSize(new java.awt.Dimension(300, 20));
        xFormPanel1.add(xActionTextField1);

        xCheckBox1.setName("showActiveOnly"); // NOI18N
        xCheckBox1.setCellPadding(new java.awt.Insets(0, 20, 0, 0));
        xCheckBox1.setShowCaption(false);
        xCheckBox1.setText("Show Active records only?");
        xFormPanel1.add(xCheckBox1);

        xDataTable1.setHandler("listHandler");
        xDataTable1.setName("selectedItem"); // NOI18N
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "state"}
                , new Object[]{"caption", "State"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 90}
                , new Object[]{"maxWidth", 120}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "entityno"}
                , new Object[]{"caption", "Entity No."}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 100}
                , new Object[]{"maxWidth", 100}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "name"}
                , new Object[]{"caption", "Name"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "address.text"}
                , new Object[]{"caption", "Address"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "type"}
                , new Object[]{"caption", "Type"}
                , new Object[]{"width", 150}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 150}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            })
        });

        xButton1.setName("delete"); // NOI18N
        xButton1.setText("Delete");

        xButton2.setDepends(new String[] {"selectedItem"});
        xButton2.setDisableWhen("#{!selectedItem || selectedItem.state == 'INACTIVE'}");
        xButton2.setName("deactivate"); // NOI18N
        xButton2.setText("Deactivate");

        xFormPanel2.setCaptionBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        xFormPanel2.setCaptionPadding(new java.awt.Insets(3, 1, 0, 5));
        xFormPanel2.setOrientation(com.rameses.rcp.constant.UIConstants.HORIZONTAL);

        xIntegerField1.setCaption("Selected Count");
        xIntegerField1.setDepends(new String[] {"selectedItem"});
        xIntegerField1.setName("selectedcount"); // NOI18N
        xIntegerField1.setCaptionWidth(105);
        xIntegerField1.setCellPadding(new java.awt.Insets(0, 0, 0, 20));
        xIntegerField1.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        xIntegerField1.setEnabled(false);
        xIntegerField1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        xIntegerField1.setForeground(new java.awt.Color(255, 0, 0));
        xIntegerField1.setPreferredSize(new java.awt.Dimension(80, 20));
        xFormPanel2.add(xIntegerField1);

        xIntegerField2.setCaption("Record Count");
        xIntegerField2.setName("count"); // NOI18N
        xIntegerField2.setCaptionWidth(95);
        xIntegerField2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        xIntegerField2.setEnabled(false);
        xIntegerField2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        xIntegerField2.setPreferredSize(new java.awt.Dimension(80, 20));
        xFormPanel2.add(xIntegerField2);

        xButton3.setDepends(new String[] {"selectedItem"});
        xButton3.setDisableWhen("#{!selectedItem || selectedItem.state == 'ACTIVE'}");
        xButton3.setName("activate"); // NOI18N
        xButton3.setText("Activate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(xDataTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xDataTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(xButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XActionTextField xActionTextField1;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XCheckBox xCheckBox1;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XIntegerField xIntegerField1;
    private com.rameses.rcp.control.XIntegerField xIntegerField2;
    // End of variables declaration//GEN-END:variables
}
