package org.example.service.impl;

import org.example.model.Department;
import org.example.service.IDepartmentService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    private List<Department> departmentList = new ArrayList<>();

    @Override
    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    @Override
    public void updateDepartment(Department department) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentId().equals(department.getDepartmentId())) {
                departmentList.set(i, department);
                break;
            }
        }
    }

    @Override
    public String removeDepartment(Department department) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentId().equals(department.getDepartmentId())) {
                departmentList.remove(i);
                return "Successfully removed";
            }
        }
        return "Error: Department not found";
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentList;
    }
}
