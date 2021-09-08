package com.bobo.mapper;

import com.bobo.pojo.Department;
import com.bobo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> getDepartments();

    String getDepartmentById(int id);
}
