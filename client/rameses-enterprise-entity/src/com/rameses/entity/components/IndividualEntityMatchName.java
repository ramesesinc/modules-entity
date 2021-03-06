/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.entity.components;

import com.rameses.rcp.common.ComponentBean;
import com.rameses.rcp.control.XComponentPanel;



/**
 *
 * @author dell
 */
@com.rameses.rcp.ui.annotations.ComponentBean("com.rameses.entity.components.IndividualEntityMatchNameModel")
public class IndividualEntityMatchName extends XComponentPanel {

    private String onselect;
    private String oncreate;
    private boolean allowSelect;
    
    /**
     * Creates new form IndividualEntityMatchNamePage
     */
    public IndividualEntityMatchName() {
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

        xPanel3 = new com.rameses.rcp.control.XPanel();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        jPanel1 = new javax.swing.JPanel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xTextField5 = new com.rameses.rcp.control.XTextField();
        xButton3 = new com.rameses.rcp.control.XButton();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        jPanel3 = new javax.swing.JPanel();
        xLabel6 = new com.rameses.rcp.control.XLabel();
        jPanel4 = new javax.swing.JPanel();
        xButton4 = new com.rameses.rcp.control.XButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        xButton2 = new com.rameses.rcp.control.XButton();
        jPanel2 = new javax.swing.JPanel();
        xPhoto1 = new com.rameses.rcp.control.XPhoto();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();

        setLayout(new java.awt.BorderLayout());

        xPanel3.setName("mode"); // NOI18N
        xPanel3.setLayout(new java.awt.CardLayout());

        xPanel1.setVisibleWhen("#{mode=='ask-name'}");

        jPanel1.setLayout(new java.awt.BorderLayout());

        xLabel7.setFontStyle("font-weight: bold;");
        xLabel7.setPadding(new java.awt.Insets(0, 0, 10, 0));
        xLabel7.setText("Enter Name");
        jPanel1.add(xLabel7, java.awt.BorderLayout.NORTH);

        xFormPanel1.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        xFormPanel1.setCaptionWidth(100);
        xFormPanel1.setPadding(new java.awt.Insets(0, 0, 0, 0));

        xTextField3.setCaption("Last Name");
        xTextField3.setName("entity.lastname"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField3.setRequired(true);
        xFormPanel1.add(xTextField3);

        xTextField2.setCaption("First Name");
        xTextField2.setName("entity.firstname"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField2.setRequired(true);
        xFormPanel1.add(xTextField2);

        xTextField5.setCaption("Middle Name");
        xTextField5.setName("entity.middlename"); // NOI18N
        xTextField5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField5);

        xButton3.setName("verifyName"); // NOI18N
        xButton3.setCellPadding(new java.awt.Insets(20, 100, 0, 0));
        xButton3.setMargin(new java.awt.Insets(3, 14, 3, 14));
        xButton3.setShowCaption(false);
        xButton3.setText("  Next  ");
        xFormPanel1.add(xButton3);

        jPanel1.add(xFormPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout xPanel1Layout = new javax.swing.GroupLayout(xPanel1);
        xPanel1.setLayout(xPanel1Layout);
        xPanel1Layout.setHorizontalGroup(
            xPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(516, Short.MAX_VALUE))
        );
        xPanel1Layout.setVerticalGroup(
            xPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        xPanel3.add(xPanel1, "card2");

        xPanel2.setVisibleWhen("#{mode=='show-list'}");

        jPanel3.setLayout(new java.awt.BorderLayout());

        xLabel6.setExpression("<html>The system has found potential matches for <b>#{entity.lastname}</b>, <b>#{entity.firstname}</b>   <b>#{entity.middlename!=null? info.middlename : '' }</b>. <br>  If the person is not on this list, click <b>Proceed</b>. </html>");
        xLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        xLabel6.setUseHtml(true);
        jPanel3.add(xLabel6, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        xButton4.setName("back"); // NOI18N
        xButton4.setMargin(new java.awt.Insets(4, 14, 4, 14));
        xButton4.setText("  Retry  ");
        jPanel4.add(xButton4);
        jPanel4.add(filler1);

        xButton2.setMnemonic('P');
        xButton2.setName("add"); // NOI18N
        xButton2.setAccelerator("ctrl P");
        xButton2.setMargin(new java.awt.Insets(4, 14, 4, 14));
        xButton2.setText(" Proceed ");
        jPanel4.add(xButton2);

        jPanel3.add(jPanel4, java.awt.BorderLayout.SOUTH);

        xPhoto1.setDepends(new String[] {"selectedItem"});
        xPhoto1.setName("selectedPhoto"); // NOI18N
        xPhoto1.setText("xPhoto1");

        xFormPanel2.setPadding(new java.awt.Insets(0, 0, 0, 0));

        xLabel1.setCaption("Lastname");
        xLabel1.setDepends(new String[] {"selectedItem"});
        xLabel1.setExpression("#{selectedItem.lastname}");
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel1);

        xLabel2.setCaption("First Name");
        xLabel2.setDepends(new String[] {"selectedItem"});
        xLabel2.setExpression("#{selectedItem.firstname}");
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel2);

        xLabel3.setCaption("Middle Name");
        xLabel3.setDepends(new String[] {"selectedItem"});
        xLabel3.setExpression("#{selectedItem.middlename}");
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel3);

        xLabel4.setCaption("Birthdate");
        xLabel4.setDepends(new String[] {"selectedItem"});
        xLabel4.setExpression("#{selectedItem.birthdate}");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel4);

        xLabel5.setCaption("Age");
        xLabel5.setDepends(new String[] {"selectedItem"});
        xLabel5.setExpression("#{selectedItem.age}");
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel5);

        xButton1.setMnemonic('S');
        xButton1.setName("select"); // NOI18N
        xButton1.setVisibleWhen("#{allowSelect == true}");
        xButton1.setAccelerator("ctrl S");
        xButton1.setText("Select");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(xPhoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(xButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(xPhoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(xButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        xDataTable1.setHandler("listModel");
        xDataTable1.setName("selectedItem"); // NOI18N
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "entityno"}
                , new Object[]{"caption", "Entity No"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 100}
                , new Object[]{"maxWidth", 100}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "lastname"}
                , new Object[]{"caption", "Last Name"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "firstname"}
                , new Object[]{"caption", "First Name"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "middlename"}
                , new Object[]{"caption", "Middlename"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "gender"}
                , new Object[]{"caption", "Gender"}
                , new Object[]{"width", 50}
                , new Object[]{"minWidth", 50}
                , new Object[]{"maxWidth", 50}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "match"}
                , new Object[]{"caption", "% Match"}
                , new Object[]{"width", 80}
                , new Object[]{"minWidth", 80}
                , new Object[]{"maxWidth", 80}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DecimalColumnHandler("#,##0.00", -1.0, -1.0, false, 2)}
            })
        });
        xDataTable1.setDynamic(true);

        javax.swing.GroupLayout xPanel2Layout = new javax.swing.GroupLayout(xPanel2);
        xPanel2.setLayout(xPanel2Layout);
        xPanel2Layout.setHorizontalGroup(
            xPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(xPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(xPanel2Layout.createSequentialGroup()
                        .addComponent(xDataTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        xPanel2Layout.setVerticalGroup(
            xPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(xPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xDataTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        xPanel3.add(xPanel2, "card3");

        add(xPanel3, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XButton xButton4;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel6;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XPhoto xPhoto1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void afterLoad() {
        super.afterLoad();
        ComponentBean bean = (ComponentBean)getComponentBean();
        bean.setProperty( "caller", new BeanCaller() {
            public Object getEntity() {
                return getProperty(getName());
            };
        });
        bean.setProperty("onselect", getProperty(getOnselect()));
        bean.setProperty("oncreate", getProperty(getOncreate()));
        Object s = getProperty("allowSelect");
        if(s!=null) {
            bean.setProperty("allowSelect", Boolean.valueOf(s+""));
        }
        else {
            bean.setProperty("allowSelect", isAllowSelect());
        }
    }

    public String getOncreate() {
        return oncreate;
    }

    public void setOncreate(String oncreate) {
        this.oncreate = oncreate;
    }

    public boolean isAllowSelect() {
        return allowSelect;
    }

    public void setAllowSelect(boolean allowSelect) {
        this.allowSelect = allowSelect;
    }
    
    public static interface BeanCaller {
        Object getEntity();
    }

    public String getOnselect() {
        return onselect;
    }

    public void setOnselect(String onselect) {
        this.onselect = onselect;
    }

    

}
