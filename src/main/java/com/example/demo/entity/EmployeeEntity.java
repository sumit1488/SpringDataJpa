package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMPLOYEES")
@NamedQuery(name = "findByyy", query = "SELECT t FROM EmployeeEntity t WHERE t.name = 'Ajay'")
@NamedNativeQuery(name = "EmployeeEntity.findByNameNative", query = "SELECT * FROM TBL_EMPLOYEES t WHERE t.NAME = 'Priya'", resultClass = EmployeeEntity.class)
public class EmployeeEntity {

	@Id
	@Column(name = "EMPID")
	private Long empId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DOB")
	private LocalDate dob;

	@Column(name = "SALARY")
	private Double salary;

	@Column(name = "ST_DATE")
	private LocalDate startDate;

	@Column(name = "END_DATE")
	private LocalDate endDate;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}