package com.invoice.api.util.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.invoice.api.util.dao.beans.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
	@Query(value = "select * from employee where id = :id", nativeQuery = true)
	Optional<Employee> findById(Long id);
}
