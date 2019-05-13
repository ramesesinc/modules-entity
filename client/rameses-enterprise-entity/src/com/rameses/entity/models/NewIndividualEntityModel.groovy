package com.rameses.entity.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import java.rmi.server.UID;
import com.rameses.seti2.models.*;

class NewIndividualEntityModel  {
    
    @Service("PersistenceService")
    def persistenceService;
    
    @Binding
    def binding;

    String title = "Add New Individual Entity";
    
    boolean allowSelect = false;
    boolean saveAllowed = true;
    def entity;
    def mode = "create";
    
    void create() {
        entity = [:];
        entity.objid = 'IND'+new UID();
        entity.address = [:];
    }

     def formatAddress = { x->
        def txt1 = [x.unitno, x.bldgno, x.bldgname].findAll{ (it? true: false) }.join(" ").trim(); 
        def txt2 = [x.street, x.subdivision].findAll{ (it? true: false) }.join(" ").trim(); 
        def txt3 = [x.barangay?.name, x.city, x.municipality, x.province].findAll{ (it? true: false) }.join(", ").trim(); 
        return [txt1, txt2, txt3].findAll{ (it? true: false) }.join( "\n" ).trim();  
    }        

    def createFromCopy() {
        entity.objid = 'IND'+new UID();
        if(entity.address && !entity.address.text) {
            entity.address.text = formatAddress(entity.address);
        }
        return "entry";
    }
    
    def oncreate = { o->
        binding.fireNavigation("entry");
    }
    
    def onselect;

    def save() {
        entity._schemaname = 'entityindividual';
        entity = persistenceService.create( entity );
        if( onselect ) {
            onselect(entity);
        }    
        MsgBox.alert("Record successfully saved. Entity No is " + entity.entityno );
        return "_close";
    }

    
}
