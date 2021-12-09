package com.sboot.Ecom.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.sboot.Ecom.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Integer> {

   /* @Transactional
	@Modifying
	@Query("select a from Address a where a.customerId=?1")
    List<Address> fetchByCustomerId(int attribute);
   */

    /*@Transactional
	@Modifying
	@Query("select a from Address a where a.customerId=:customerId")
    List<Address> fetchByCustomerId(@Param("customerId") int attribute);
*/


}
