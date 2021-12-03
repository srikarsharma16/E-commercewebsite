package com.sboot.Ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sboot.Ecom.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
