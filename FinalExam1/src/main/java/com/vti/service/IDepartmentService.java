package com.vti.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.DepartmentFormForUpdating;

public interface IDepartmentService {

	public Page<Department> getAllDepartments(Pageable pageable, String search,DepartmentFilterForm filterform);
	
	public void createDeparment(CreatingDepartmentForm form);

	public Department getDepartmentByID(int id);

	void updateDepartment(int id, DepartmentFormForUpdating form);

	void deleteDepartment(int id);

	boolean isDepartmentExistsByName(String name);


	


}
