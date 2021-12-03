package com.sboot.Ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.sboot.Ecom.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    @Transactional
	@Modifying
	@Query("Update Product p set p.prodName=:prodName,p.prodDesc=:prodDesc,p.prodPrice=:prodPrice,p.prodDiscount=:prodDiscount where p.prodId=:prodId")
	void doupdate(@Param("prodId") long prodId,@Param("prodName") String prodName,@Param("prodDesc") String prodDesc,@Param("prodPrice") Double prodPrice,@Param("prodDiscount") Double prodDiscount);

    
	@Transactional
	@Modifying
	@Query("Update Product p set p.prodName=:prodName,p.prodDesc=:prodDesc,p.prodPrice=:prodPrice,p.prodDiscount=:prodDiscount where p.prodId=:prodId")
	void adminProdEdit(@Param("prodId") long prodId,@Param("prodName") String prodName,@Param("prodDesc") String prodDesc,@Param("prodPrice") Double prodPrice,@Param("prodDiscount") Double prodDiscount);

	@Transactional
	@Modifying
	@Query("Delete from Product p where p.prodId=:prodId")
	void delByProdId(@Param("prodId") long id);

}
