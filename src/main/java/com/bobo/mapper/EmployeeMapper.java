package com.bobo.mapper;

import com.bobo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// mybatis mapper类
@Mapper
@Repository
public interface EmployeeMapper {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
