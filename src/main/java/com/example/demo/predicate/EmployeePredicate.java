package com.example.demo.predicate;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.example.demo.entity.QEmployeeEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@Service
public class EmployeePredicate {

	

	public Predicate buildEmployeePredicate(HashMap<String, String> map) {
		
		final BooleanBuilder predicateBuilder = new BooleanBuilder();
		
		if(null != map.get("empid")) {
			BooleanBuilder subPredicate = new BooleanBuilder();
			subPredicate.and(QEmployeeEntity.employeeEntity.empId.eq(Long.valueOf(map.get("empid"))));
			predicateBuilder.and(subPredicate);
		}
		
		if(null != map.get("name")) {
			BooleanBuilder subPredicate = new BooleanBuilder();
			subPredicate.and(QEmployeeEntity.employeeEntity.name.stringValue().eq(map.get("name")));
			predicateBuilder.and(subPredicate);
		}
		
		if(null != map.get("salary")) {
			BooleanBuilder subPredicate = new BooleanBuilder();
			subPredicate.and(QEmployeeEntity.employeeEntity.salary.eq(Double.valueOf(map.get("salary"))));
			predicateBuilder.and(subPredicate);
		}
		
		return predicateBuilder.getValue();
	}
	
}