package com.sboot.Ecom.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sboot.Ecom.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	List<Cart> findProductByCustId(long custId);

	@Transactional
	@Modifying
	@Query("Delete from Cart c where c.custId=:custId and c.prodId=:prodId")
	void deleteByCustAndProdId(@Param("custId") long custId,@Param("prodId") long prodId);

	@Transactional
	@Modifying
	@Query("Delete from Cart c where c.custId=:custId")
	void delByCustId(@Param("custId") long id);
 
}
