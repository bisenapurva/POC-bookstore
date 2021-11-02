package com.bookstore.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.order.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer>{
	@Query(value="SELECT * FROM (SELECT B.id,B.order_id,B.order_status,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty,STUFF((SELECT ',' + convert(varchar,A.Product_id) FROM order_item A WHERE A.order_id = B.order_id ORDER BY product_id FOR XML PATH('')), 1, 1, '') [product_id],row_number() OVER(Partition by order_id ORDER BY order_id ) as rownum FROM order_item B GROUP BY B.id, B.product_id, B.order_id,B.order_status ,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty) TT WHERE rownum=1 AND user_id=?",nativeQuery = true)
	List<OrderDetails> getOrdersByuserId(Long userId);
}
