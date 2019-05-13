package com.rameses.entity.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.camera.*;
import com.rameses.seti2.models.*;

class EntityOnlineRegistrationModel extends CrudFormModel {

    @Service("EntityOnlineRegistrationService")
    def svc;
    
    @Service("EntityProfileService")
    def profileSvc;
    
    def selectedItem;
    def regid;
    
    def matchList;
    def _matchService = null;

    void loadMatch() {
        if(!_matchService) {
            _matchService= InvokerProxy.getInstance().create("IndividualEntityNameMatchService", null, "entity");
        }
        matchList =  _matchService.getMatches(entity);
    }
    
    void afterOpen() {
        regid = entity.objid;
        loadMatch();
    }
    
    void assignPrimary() {
        if(!selectedItem) throw new Exception("Please select an item first");
        def df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        def bdate1 = null;
        def bdate2 = null;
        if(selectedItem.birthdate ) bdate1 =  df.parse(selectedItem.birthdate+"");
        if( entity.birthdate ) bdate2 = df.parse(entity.birthdate+"");
        if(bdate1!=null && bdate1 != bdate2 ) throw new Exception("Birthdate must be the same as selected");
    }
    
    def listModel = [
        fetchList: { o->
            return matchList;
        }
    ] as BasicListModel;
    
  
    def viewEntity() {
        if(!selectedItem) throw new Exception("Please select an item first");
        def op = Inv.lookupOpener("entityindividual:open", [entity:[objid:selectedItem.objid ]]);
        op.target = "popup";
        return op;
    }
    
    def addNewEntity() {
        def k = matchList.find { o->   
            return ( o.lastname == entity.lastname && o.firstname == entity.firstname && o.birthdate == entity.birthdate );
        }
        if(k) throw new Exception("An exact match already exists. Please select that instead");
        entity.address.type = ( entity.resident == 1 )?"local":"nonlocal";
        def s = { o->
            selectedItem = o;
            createProfile();
        }
        
        def op = Inv.lookupOpener("entityindividual:createFromCopy", [entity:entity, onselect: s] );
        op.target = "popup";
        return op;
    }
    
    def createProfile() {
        if(!selectedItem) throw new Exception("Please select an item first");
        
        def errs = [];
        //check firstname, lastname, middlename, birthdate
        if( entity.firstname != selectedItem.firstname ) errs << "Firstname does not match";
        if( entity.lastname != selectedItem.lastname )  errs << "Lastname does not match";
        if( entity.middlename != selectedItem.middlename ) errs << "Middlename does not match";
        if( entity.birthdate != selectedItem.birthdate ) errs << "Birthdate does not match";
        if( entity.email != selectedItem.email ) errs << "Email does not match";
        if( entity.mobileno != selectedItem.mobileno ) errs << "Mobile no does not match";

        if(errs) throw new Exception("Please correct the ff. before proceeding \n"+ errs.join("\n"));
        
        selectedItem.regid = regid;
        profileSvc.create( selectedItem );
        MsgBox.alert("Profile successfully created");
        return "_close";
    }
    
}
