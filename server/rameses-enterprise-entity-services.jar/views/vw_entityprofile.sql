drop view if exists vw_entityprofile;
create view vw_entityprofile 
as 
select ep.objid,
ep.idno,
ei.entityno,
ep.primaryentityid, 
ei.lastname,
ei.firstname,
ei.middlename,
ei.birthdate,
ei.gender,
ei.entityname as name,
ei.mobileno,
ei.phoneno,
ei.email,
ei.address_objid,
ei.address_text,
ei.address_addresstype,
ei.address_barangay_name,
ei.address_barangay_objid,
ei.address_city,
ei.address_province,
ei.address_municipality,
ei.address_bldgno,
ei.address_bldgname,
ei.address_unitno,
ei.address_street,
ei.address_subdivision   
from entityprofile ep 
inner join vw_entityindividual ei
on ep.primaryentityid = ei.objid;


