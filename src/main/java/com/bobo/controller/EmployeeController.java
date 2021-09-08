package com.bobo.controller;

import com.bobo.mapper.DepartmentMapper;
import com.bobo.mapper.EmployeeMapper;
import com.bobo.pojo.Department;
import com.bobo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeMapper.getAllEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model) {

        // 查出所有部门的信息
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments", departments);

        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //System.out.println("save==>" + employee);
        employeeMapper.addEmployee(employee);//调用底层业务保存员工信息
        return "redirect:/emps";
    }

    // 去员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model) {

        // 查出原来的数据
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("emp", employee);

        // 查出所有部门的信息
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments", departments);

        return "emp/update";
    }

    // 员工修改
    @PostMapping ("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return "redirect:/emps";
    }

    // 员工删除
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id) {
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}
