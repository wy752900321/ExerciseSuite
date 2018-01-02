select *, sum(di.product_num ) num 
from d_product dp 
	join d_category_product dcp on (dp.id = dcp.product_id) 
	join d_book db on (dp.id = db.id) 
	left outer join d_item di on (dp.id = di.product_id)
where db.id = ? and dp.has_deleted=0 
group by db.id;