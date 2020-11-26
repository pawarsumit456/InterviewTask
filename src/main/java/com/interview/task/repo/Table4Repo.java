package com.interview.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.interview.task.model.Table4;

public interface Table4Repo extends JpaRepository<Table4, Long> {
	
	@Query(value = "SELECT * FROM Table4 WHERE mobile_number=:mobile and otp=:otp", nativeQuery = true)
	public Table4 getByMobileNumberAndOtp(@Param("mobile") String mobile,@Param("otp") String otp);

}
