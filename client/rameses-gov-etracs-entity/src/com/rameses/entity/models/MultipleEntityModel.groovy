package com.rameses.entity.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;
import java.rmi.server.*;

class MultipleEntityModel extends CrudFormModel {
    
    @SubWindow 
    def window;

    def fromMultiple = false;

    @FormId
    @FormTitle
    public String getFormId(){
        if (mode == 'create' && fromMultiple) {
            return 'Multiple Entity (New)'
        } else if (mode == 'create') {
             return 'Multiple Entity'
        }
        return 'Realty Tax Ledger : ' + entity.tdno 
    }



    def getLookupMember() {
        return InvokerUtil.lookupOpener('entity:lookup', ['query.type': 'INDIVIDUAL,JURIDICAL']); 
    }             

    void afterCreate() {
        entity.members = [];
        if ( listHandler ) {
            listHandler.reload(); 
        } 
        if ( window ) 
            window.title = getTitle(); 
    }
    
    void afterSave() {
        if ( window ) { 
            window.update(); 
        }
    }
    
    String getTitle() {
        return (mode=='create'? 'New Multiple Entity': super.getTitle()); 
    }
    
    def selectedEntity;    
            
    def listHandler = [
        fetchList:{o-> 
            if (!entity) return null; 
            if (!entity.members) entity.members = [];
            return entity.members; 
        },

        onColumnUpdate: {item,colname-> 
            if (colname == 'member') { 
                def o = entity.members.find{ 
                    it.member.objid == item.member.objid && it.objid != item.objid
                } 
                if (o) throw new Exception('This member already exist in the list. Please select another one.'); 
            } 
        },

        onCommitItem: {item-> 
            rebuildNames();
        }, 

        onAddItem: {item-> 
            item.objid = 'MEM'+new UID();
            item.entityid = entity.objid; 
            entity.members.add(item); 
            rebuildNames();
        }, 

        validate: {li -> 
            def item = li.item;
            if (!item.member || !item.member.objid) {
                throw new Exception('Member must be specified.');
            }
        },

        onRemoveItem: {item-> 
            if (!MsgBox.confirm('Are you sure you want to remove this item?')) return false;

            entity.members.remove(item); 
            def deletedKey = 'members::deleted';
            if (!entity[deletedKey]) {
                entity[deletedKey] = [];
            }
            entity[deletedKey] << item;
            rebuildNames(); 
            return true;
        }
    ] as EditorListModel;             

    void rebuildNames() {
        def buffer = new StringBuffer();
        def indexno = 0;
        entity.members.each{
            if (buffer.length() > 0) buffer.append(' ');                         
            if (it.prefix) buffer.append(it.prefix + ' ');

            buffer.append(it.member.name); 

            if (it.suffix) buffer.append(' ' + it.suffix); 

            indexno++;
            it.itemno = indexno;
        }
        def oldfullname = entity.fullname; 
        entity.fullname = buffer.toString();
        if (entity.name == oldfullname) entity.name = entity.fullname;  
        binding.refresh('entity.name');
        binding.requestFocus('selectedEntity');
    } 


    void copyFullName(){
        entity.name = entity.fullname
        rebuildNames();
        binding.refresh('entity.name')
    }
    
    def viewEntity() {
        if( !selectedEntity ) throw new Exception("Please select an member entity");
        String s = "entity" + selectedEntity.member.type.toLowerCase() + ":open";
        def op = Inv.lookupOpener( s, [entity:selectedEntity.member ]);
        op.target = "popup";
        return op;
    }

    def addMember = {newMember -> 
        def member = [:]
        member.objid = 'ME' + new java.rmi.server.UID();
        member.entityid = newMember.objid;
        member.itemno = entity.members.size() + 1;
        member.prefix = '';
        member.member = newMember;
        member.suffix = '';
        entity.members << member;
        rebuildNames();
        listHandler.reload();
    }

    def addIndividual() {
        return Inv.lookupOpener('entityindividual:create', [onselect: addMember]);
    }


    def inv; 
    def addMultiple() {
        inv = Inv.lookupOpener('entitymultiple:create', [fromMultiple: true]);
        inv.target = "popup";
        return inv;
    }

    void refresh() {
        addMember(inv.handle.entity);
    }
}
