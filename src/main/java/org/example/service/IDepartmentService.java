package org.example.service;

import org.example.model.Department;
import java.util.List;

public interface IDepartmentService {
    void addDepartment(Department department);
    void updateDepartment(Department department);
    String removeDepartment(Department department);
    List<Department> getAllDepartments();
}
