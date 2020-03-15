package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployeeEntity is a Querydsl query type for EmployeeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployeeEntity extends EntityPathBase<EmployeeEntity> {

    private static final long serialVersionUID = -537289086L;

    public static final QEmployeeEntity employeeEntity = new QEmployeeEntity("employeeEntity");

    public final DatePath<java.time.LocalDate> dob = createDate("dob", java.time.LocalDate.class);

    public final NumberPath<Long> empId = createNumber("empId", Long.class);

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> salary = createNumber("salary", Double.class);

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public QEmployeeEntity(String variable) {
        super(EmployeeEntity.class, forVariable(variable));
    }

    public QEmployeeEntity(Path<? extends EmployeeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeEntity(PathMetadata metadata) {
        super(EmployeeEntity.class, metadata);
    }

}

