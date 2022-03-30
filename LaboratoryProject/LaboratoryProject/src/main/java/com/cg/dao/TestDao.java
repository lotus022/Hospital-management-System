package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Tests;

@Repository("testdao")
public interface TestDao extends JpaRepository<Tests, Integer> {

}
