package com.rameses.entity.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.camera.*;
import com.rameses.seti2.models.*;

class EntitySectionFormModel extends CrudFormModel {

     void afterCreate() {
        entity.entity = caller?.masterEntity;
        entity.entityid = caller?.masterEntity?.objid;
    }
    
}