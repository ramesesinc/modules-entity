/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.entity.components;

import com.rameses.rcp.control.XComponentPanel;
import com.rameses.rcp.ui.annotations.ComponentBean;

/**
 *
 * @author dell
 */
@ComponentBean("com.rameses.entity.components.EntityTypeLookupModel")
public class EntityTypeLookup extends XComponentPanel {

    /**
     * Creates new form EntityTypeLookup
     */
    public EntityTypeLookup() {
        initComponents();
    }

    
    public void setEditable(boolean b) {
        component.setEditable(b);
    }
    
    public boolean isEditable() {
        return component.isEditable();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        component.setEnabled(enabled);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        component = new com.rameses.rcp.control.XComboBox();

        setLayout(new java.awt.BorderLayout());

        component.setCaption("Type");
        component.setCaptionWidth(50);
        component.setEmptyText("- - All Types - -");
        component.setItems("entityTypes");
        component.setName("selectedType"); // NOI18N
        add(component, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XComboBox component;
    // End of variables declaration//GEN-END:variables
}
