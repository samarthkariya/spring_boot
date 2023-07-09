package com.organization.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.organization.entity.Department;

@Repository
public interface DeptRepo extends JpaRepository<Department, Integer> {

	@Query(value = "select * from department where department.d_name =:name;", nativeQuery = true)
	public Department findByDeptName(@Param("name") String name);
}
