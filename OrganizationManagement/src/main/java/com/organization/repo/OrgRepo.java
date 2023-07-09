package com.organization.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.organization.entity.Organization;

@Repository
public interface OrgRepo extends JpaRepository<Organization, Integer> {

	@Query(value = "select * from organization where organization.o_name=:name;", nativeQuery = true)
	public Organization findByName(@Param("name") String name);
}
