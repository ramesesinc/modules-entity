package com.rameses.entity.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.camera.*;
import com.rameses.seti2.models.*;
        
class EntityIndividualRelationListModel extends CrudListModel {

    @Caller
    def caller;

    def getMasterEntity() {
        return caller?.entity;
    }

    def getCustomFilter() {
        return ["ownerid=:ownerid", [ownerid:caller.entity.objid]];
    }

    def open() {
        def op = Inv.lookupOpener( "entityindividual:open", [ entity: [objid: selectedItem.entityid] ] );
        op.target = "popup";
        return op;
    }

    void removeEntity() {
        if(!selectedItem) throw new Exception("Please select an item");
        if( !MsgBox.confirm('You are about to delete this record. Proceed?')) return;
        def m = [_schemaname: 'entity_relation' ];
        m.objid = selectedItem.objid;
        persistenceService.removeEntity( m );
        listHandler.reload();
    }

}