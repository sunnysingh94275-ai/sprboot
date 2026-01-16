package com.wip.sprbootdemo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wip.sprbootdemo.entity.SEmployee;

@Repository
public interface SEmployeeRepository extends JpaRepository<SEmployee, Long> {
     	public SEmployee findByEname(String name);
     	
     	public List<SEmployee> findByEnameContaining(String name);
     	
     	
}
