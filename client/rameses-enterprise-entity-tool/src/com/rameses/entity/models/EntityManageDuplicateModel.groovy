package com.rameses.entity.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;

class EntityRemoveDuplicateModel {
    @Binding
    def binding;
    
    @Service('PersistenceService')
    def persistence;
    
    @Service('QueryService')
    def qrySvc 
    
    String title = 'Manage Duplicate Entity';
    
    def items = [];
    def searchtext;
    def selectedItem;
    def showActiveOnly = true;

    @PropertyChangeListener
    def listener = [
        'showActiveOnly' : { refresh(); }
    ]
    
    void refresh() {
        search();
    }
    
    void search() {
        items = []
        if (searchtext) {
            def param = [_schemaname: 'entity'];
            param.select = 'objid, state, name, entityno, address_text, type, _isbpls';

            def whereParam = [name: searchtext+'%']
            if (showActiveOnly) {
                whereParam.state = 'ACTIVE';
                param.where = ['state = :state and name like :name', whereParam];    
            } else {
                param.where = ['name like :name', whereParam];    
            }
            
            param.orderBy = 'name';
            items = qrySvc.getList(param);
        }
        listHandler.reload();
        binding.refresh('count');
    }
    
    void deleteEntity(entity) {
        try {
            def e = [_schemaname: 'entity' + entity.type.toLowerCase(), objid: entity.objid];
            persistence.removeEntity(e);
            items.remove(entity);
        } catch (e) {
            MsgBox.alert('Unable to delete ' + entity.name + '.\nIt is currently referenced by a transaction.');
        }
    }
    
    void delete() {
        def selecteditems = listHandler.selectedValue;
        if (!selecteditems) return;
        if (MsgBox.confirm('Delete selected items?')) {
            selecteditems.each {
                deleteEntity(it);
            }
            listHandler.reload();
            binding.refresh('count');
        }
    }

    void activateEntity(entity) {
        def state = 'ACTIVE';
        def e = [_schemaname: 'entity' + entity.type.toLowerCase(), objid: entity.objid, state: state];
        persistence.update(e);
        entity.state = state;
        listHandler.refreshSelectedItem();
    }

    void activate() {
        def selecteditems = listHandler.selectedValue;
        if (!selecteditems) return;
        if (MsgBox.confirm('Activate selected items?')) {
            selecteditems.each {
                activateEntity(it);
            }
            listHandler.reload();
            binding.refresh('count');
        }
    }
    
    void deactivateEntity(entity) {
        def e = [_schemaname: 'entity' + entity.type.toLowerCase(), objid: entity.objid, state:'INACTIVE'];
        persistence.update(e);
        if (showActiveOnly) {
            items.remove(entity);
        }
    }
    
    void deactivate() {
        def selecteditems = listHandler.selectedValue;
        if (!selecteditems) return;
        if (MsgBox.confirm('Deactivate selected items?')) {
            selecteditems.each {
                deactivateEntity(it);
            }
            listHandler.reload();
            binding.refresh('count');
        }
    }

    def listHandler = [
        getRows : { items.size() },
        fetchList: { items },
        isMultiSelect: { true },
        onOpenItem: {item, col ->
            def opener = 'entity' + item.type.toLowerCase() + ':open';
            def inv = Inv.lookupOpener(opener, [entity: item]);
            inv.target = 'popup';
            return inv;
        },
        afterSelectionChange: {
            binding?.refresh('selectedcount');
        }
    ] as BasicListModel;
 
    def getCount() {
        return items.size();
    }
    
    def getSelectedcount() {
        if (listHandler.selectedValue) {
            return listHandler.selectedValue.size();
        }
        return 0;
    }
    
}