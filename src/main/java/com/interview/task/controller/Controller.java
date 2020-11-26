package com.interview.task.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.task.model.Table2;
import com.interview.task.model.Table3;
import com.interview.task.model.Table4;
import com.interview.task.repo.Table1Repo;
import com.interview.task.repo.Table2Repo;
import com.interview.task.repo.Table3Repo;
import com.interview.task.repo.Table4Repo;
import com.interview.task.repo.Table5Repo;
import com.interview.task.utility.JWTUtility;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	Table1Repo table1Repo;

	@Autowired
	Table2Repo table2Repo;

	@Autowired
	Table3Repo table3Repo;

	@Autowired
	Table4Repo table4Repo;

	@Autowired
	Table5Repo table5Repo;

	JWTUtility jwt = new JWTUtility();

	@CrossOrigin
	@PostMapping(path = "/tokenRequest", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> generateOtp(@RequestBody Map<String, Object> payload) {

		String mobile = (String) payload.get("mobileNumber");
		long otp = Long.parseLong((String) payload.get("OTP"));

		Table2 table2 = table2Repo.getByMobileNumber(mobile);

		if (table2 != null) {

			Table4 table4 = new Table4();
			table4.setOtp(otp);
			table4.setMobileNumber(Long.parseLong((String) payload.get("mobileNumber")));
			table4.setCreateTime(new java.util.Date());
			table4.setExpireTime(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5)));

			table4Repo.save(table4);

			System.out.println("Mobile Numeber varified & data inserted to table4...!");

			String JwtToken = jwt.generateToken(mobile);
			String refreshToken = jwt.generateRefreshToken(mobile);

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1004);
			response.put("Token", JwtToken);
			response.put("refresh", refreshToken);

			return ResponseEntity.ok(response);

		} else {

			System.out.println("Wrong Mobile Number............>>>>>!");

			return new ResponseEntity<Object>(Collections.singletonMap("error", "Wrong Mobile Number"),
					HttpStatus.BAD_REQUEST);
		}

	}

	@CrossOrigin
	@PostMapping(path = "/getPolicyData", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> getData(@RequestBody Map<String, Object> payload,
			@RequestHeader(name = "Authorization") String token) {

		String policyNumber = (String) payload.get("policyNumber");

		String mobileNumber = jwt.parseToken(token);

		Table2 responseData = table2Repo.getByMobileNumber(mobileNumber);

		System.out.println(policyNumber + " " + mobileNumber);

		return ResponseEntity.ok(responseData);

	}

	@CrossOrigin
	@PostMapping(path = "/emailValidation", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> emailValidation(@RequestBody Map<String, Object> payload,
			@RequestHeader(name = "Authorization") String token) {

		String email = (String) payload.get("email");
		String dob = (String) payload.get("dob");

		System.out.println(email + "  " + dob);

		Table2 responseData = table2Repo.getByEmailandDOB(email, dob);

		System.out.println(responseData);

		if (responseData != null) {

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1005);
			response.put("Data", email);

			return ResponseEntity.ok(response);
		} else {

			return new ResponseEntity<Object>(Collections.singletonMap("error", "Email not validate."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@CrossOrigin
	@PostMapping(path = "/mobileValidation", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> mobileValidation(@RequestBody Map<String, Object> payload,
			@RequestHeader(name = "Authorization") String token) {

		String mobile = (String) payload.get("mobile");
		String dob = (String) payload.get("dob");

		System.out.println(mobile + "  " + dob);

		Table2 responseData = table2Repo.getByMobileandDOB(mobile, dob);

		System.out.println(responseData);

		if (responseData != null) {

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1005);
			response.put("Data", mobile);

			return ResponseEntity.ok(response);
		} else {

			return new ResponseEntity<Object>(Collections.singletonMap("error", "Mobile Number not validate."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@CrossOrigin
	@PostMapping(path = "/mobileUpdation", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> mobileUpdation(@RequestBody Map<String, Object> payload,
			@RequestHeader(name = "Authorization") String token) {

		String mobileNumber = (String) payload.get("mobileNumber");
		String policyNumber = (String) payload.get("policyNumber");

		Table2 table2 = table2Repo.getByMobileNumber(mobileNumber);

		if (table2 != null) {

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1004);
			response.put("Data", policyNumber);
			response.put("Message", "Service Request for Mobile Number Updation Generated");

			return ResponseEntity.ok(response);

		} else {

			return new ResponseEntity<Object>(Collections.singletonMap("error", "Mobile Number not validate."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@CrossOrigin
	@PostMapping(path = "/emailUpdation", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> emailUpdation(@RequestBody Map<String, Object> payload,
			@RequestHeader(name = "Authorization") String token) {

		String email = (String) payload.get("email");
		String policyNumber = (String) payload.get("policyNumber");

		Table2 table2 = table2Repo.getByEmail(email);

		if (table2 != null) {

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1004);
			response.put("Data", policyNumber);
			response.put("Message", "Service Request for Email Number Updation Generated");

			return ResponseEntity.ok(response);
		} else {

			return new ResponseEntity<Object>(Collections.singletonMap("error", "Mobile Number not validate."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@CrossOrigin
	@PostMapping(path = "/panCardUpdation", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> panCardUpdation(@RequestBody Map<String, Object> payload,
			@RequestHeader(name = "Authorization") String token) {

		String pan_number = (String) payload.get("pan_number");
		String policyNumber = (String) payload.get("policyNumber");

		Table2 table2 = table2Repo.getByPanNumber(pan_number);

		if (table2 != null) {

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1004);
			response.put("Data", policyNumber);
			response.put("Message", "Service Request for Card Updation Generated");

			return ResponseEntity.ok(response);
		} else {

			return new ResponseEntity<Object>(Collections.singletonMap("error", "Mobile Number not validate."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@CrossOrigin
	@PostMapping(path = "/whatsappOptIn1", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> whatsappOptIn1(@RequestBody Map<String, Object> payload) {

		String mobileNumber = (String) payload.get("mobileNumber");

		Table3 table3 = table3Repo.getByMobileNumber(mobileNumber);

		if (table3 != null) {
			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1001);
			response.put("Message", "Thank You for Optin Request Completed\"");

			return ResponseEntity.ok(response);

		} else {

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1003);
			response.put("Message", "Optin OTP Sent on the Mobile Number");

			return ResponseEntity.ok(response);
		}

	}

	@CrossOrigin
	@PostMapping(path = "/whatsappOptIn2", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> whatsappOptIn2(@RequestBody Map<String, Object> payload) {

		String mobileNumber = (String) payload.get("mobileNumber");
		String otp = (String) payload.get("otp");

		Table4 table4 = table4Repo.getByMobileNumberAndOtp(mobileNumber, otp);

		if (table4 != null) {

			Table2 table2 = table2Repo.getByMobileNumber(mobileNumber);
			Table3 table3 = new Table3();
			table3.setMobileNumber(Long.parseLong(table2.getMobileNumber()));
			table3.setPolicyNumber(table2.getPolicyNuber());

			table3Repo.save(table3);

			HashMap<String, Object> response = new HashMap<>();

			response.put("Status", 1002);
			response.put("Message", "Thank You for Optin Request Completed");

			return ResponseEntity.ok(response);
		} else {

			return new ResponseEntity<Object>(Collections.singletonMap("error", "Mobile Number not validate."),
					HttpStatus.BAD_REQUEST);
		}

	}

}
