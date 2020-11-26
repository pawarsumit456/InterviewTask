package com.interview.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.interview.task.model.Table3;

public interface Table3Repo  extends JpaRepository<Table3, Long> {

	
	@Query(value = "SELECT * FROM Table3 WHERE mobile_number=:mobile", nativeQuery = true)
	public Table3 getByMobileNumber(@Param("mobile") String mobile);
}
