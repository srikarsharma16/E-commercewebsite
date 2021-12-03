package com.sboot.Ecom.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sboot.Ecom.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Transactional
	@Modifying
	@Query("Update Customer c set c.custName=:custName,c.custEmail=:custEmail,c.custMobile=:custMobile,c.custAddress=:custAddress where c.custId=:custId")
	void doupdate(@Param("custId") long cust_id,@Param("custName") String name,@Param("custEmail") String email,@Param("custMobile") String mobile,@Param("custAddress") String address);

	@Transactional
	@Modifying
	@Query("Update Customer c set c.custName=:custName,c.custEmail=:custEmail,c.custMobile=:custMobile,c.custAddress=:custAddress where c.custId=:custId")
	void adminCustEdit(@Param("custId") long cust_id,@Param("custName") String name, @Param("custEmail") String email, @Param("custMobile") String mobile, @Param("custAddress") String address);

	@Transactional
	@Modifying
	@Query("Delete from Customer c where c.custId=:custId")
	void delByCustId(@Param("custId") long id);

	
	
}
