package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long>, QuerydslPredicateExecutor<EmployeeEntity>{

	public List<EmployeeEntity> findByDob(LocalDate dob);
	
	public List<EmployeeEntity> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
	//findNameByStartDateAndEndDate
	//readBY
	//countNameBy..
	//FindTopBy
	//FindDistinctTitleBy
	//FindByTitleOrderByTitleAsc

    @Query(value = "SELECT t FROM EmployeeEntity t where t.startDate = :startDate AND t.endDate =:endDate", nativeQuery = true) 
	public List<EmployeeEntity> findByStartDateAndEndDateQueryMethod(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT * FROM TBL_EMPLOYEES t where t.ST_DATE =:startDate AND t.END_DATE =:endDate",nativeQuery=true ) 
	public List<EmployeeEntity> findByStartDateAndEndDateNative(LocalDate startDate, LocalDate endDate);
    
    @Query(name = "findByNameExample")
	public List<EmployeeEntity> findByName();
	
	@Query(name = "EmployeeEntity.findByNameNative", nativeQuery = true)
	public List<EmployeeEntity> findByNameNativeExample();

}
