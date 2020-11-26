package com.interview.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.interview.task.model.Table2;

public interface Table2Repo extends JpaRepository<Table2, Long> {

	@Query(value = "SELECT * FROM Table2 WHERE mobile_number=:mobile", nativeQuery = true)
	public Table2 getByMobileNumber(@Param("mobile") String mobile);

	@Query(value = "SELECT * FROM Table2 WHERE email=:email", nativeQuery = true)
	public Table2 getByEmail(@Param("email") String email);

	@Query(value = "SELECT * FROM Table2 WHERE pan_number=:pan_number", nativeQuery = true)
	public Table2 getByPanNumber(@Param("pan_number") String pan_number);

	@Query(value = "SELECT * FROM Table2 WHERE email=:email and dob=:dob", nativeQuery = true)
	public Table2 getByEmailandDOB(@Param("email") String email, @Param("dob") String dob);

	@Query(value = "SELECT * FROM Table2 WHERE mobile_number=:mobile and dob=:dob", nativeQuery = true)
	public Table2 getByMobileandDOB(@Param("mobile") String email, @Param("dob") String dob);

}
