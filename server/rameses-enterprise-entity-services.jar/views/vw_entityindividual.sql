drop view if exists vw_entityindividual;
create view vw_entityindividual 
as 
select ei.*, 
	e.entityno, e.type, e.name, e.entityname, e.mobileno, e.phoneno,e.email, 
	e.address_objid, e.address_text,
	ea.addresstype AS address_addresstype,
	ea.barangay_name AS address_barangay_name,
	ea.barangay_objid AS address_barangay_objid,
	ea.city AS address_city,
	ea.province AS address_province,
	ea.municipality AS address_municipality,
	ea.bldgno AS address_bldgno,
	ea.bldgname AS address_bldgname,
	ea.unitno AS address_unitno,
	ea.street AS address_street,
	ea.subdivision AS address_subdivision

from entityindividual ei 
inner join entity e on e.objid=ei.objid 
left join entity_address ea ON e.address_objid = ea.objid;
