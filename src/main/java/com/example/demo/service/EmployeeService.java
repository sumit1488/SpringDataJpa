package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.QEmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.querydsl.core.types.Predicate;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public List<EmployeeEntity> getEmployeeDetails(LocalDate dob) {
		List<EmployeeEntity> empEntityList = empRepo.findByDob(dob);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDate(LocalDate startDate, LocalDate endDate) {
		List<EmployeeEntity> empEntityList = empRepo.findByStartDateAndEndDate(startDate, endDate);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateQueryMethod(LocalDate startDate, LocalDate endDate) {
		List<EmployeeEntity> empEntityList = empRepo.findByStartDateAndEndDateQueryMethod(startDate, endDate);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateNative(LocalDate startDate, LocalDate endDate) {
		List<EmployeeEntity> empEntityList = empRepo.findByStartDateAndEndDateNative(startDate, endDate);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateNamedQuery() {
		List<EmployeeEntity> empEntityList = empRepo.findByName();

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateNamedNativeQuery() {
		List<EmployeeEntity> empEntityList = empRepo.findByNameNativeExample();

		return empEntityList;
	}

	public long getEmployeesBySQueryDsl() {

		Predicate pred = hasSalary(20000.00);
		long count = empRepo.count(pred);

		return count;
	}

	static Predicate hasSalary(Double salary) {
		return (Predicate) QEmployeeEntity.employeeEntity.salary.gt(salary);
	}
}
