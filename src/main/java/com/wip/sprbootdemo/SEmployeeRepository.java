package com.wip.sprbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wip.sprbootdemo.entity.SEmployee;

@Repository
public interface SEmployeeRepository extends JpaRepository<SEmployee, Long> {

}
