package com.rameses.entity.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class EntityTypeLookupModel extends ComponentBean {

    @Binding
    def binding;
    
    def _listSvc = null;
    def getListSvc() {
        if(!_listSvc) {
            _listSvc= InvokerProxy.getInstance().create("ListService", null, "entity");
        }
        return _listSvc;
    }
    
    public def getSelectedType() {
        return getValue();
    }
    
    public void setSelectedType(def t) {
        setValue(t);
    }

    def _entityTypes;
    
    public def getEntityTypes() {
        if(!_entityTypes) {
            _entityTypes = listSvc.getList([name:'entitytype'])
        }
        return _entityTypes;
    }

    
}
