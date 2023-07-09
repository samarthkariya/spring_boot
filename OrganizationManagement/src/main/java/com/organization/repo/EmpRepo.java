package com.organization.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.organization.entity.Department;
import com.organization.entity.Employee;

@EnableJpaRepositories
@Repository

public interface EmpRepo extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee where organization_id in(select o_id from organization where o_name =:name);", nativeQuery = true)
	public List<Employee> findAllEmpByOrgName(@Param("name") String name);

	@Query(value = "select * from employee where department_id in(select d_id from department where d_name =:name);", nativeQuery = true)
	public List<Employee> findbyDept(@Param("name") String name);

	@Query(value = "select * from employee where department_id in (select d_id from department where d_name =:dname) and organization_id in (select o_id from organization where o_name =:oname);", nativeQuery = true)
	public List<Employee> findBydeptandorg(@Param("dname") String dname, @Param("oname") String oname);

	@Query(value = "SELECT * FROM department;", nativeQuery = true)
	public List<Department> findDeptName();

}
