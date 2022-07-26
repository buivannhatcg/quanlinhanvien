package com.vti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.form.Account.CreatingAccountForm;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.DepartmentFormForUpdating;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.department.DepartmentSpecification;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterform) {

		Specification<Department> where = DepartmentSpecification.buildWhere(search, filterform);
		return repository.findAll(where, pageable);
	}

	@Override
	public Department getDepartmentByID(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void createDeparment(CreatingDepartmentForm form) {

		// omit id field
		TypeMap<CreatingDepartmentForm, Department> typeMap = modelMapper.getTypeMap(CreatingDepartmentForm.class,
				Department.class);

		if (typeMap == null) { // if not already added
			// skip field
			modelMapper.addMappings(new PropertyMap<CreatingDepartmentForm, Department>() {
				@Override
				protected void configure() {
					skip(destination.getId());
				}
			});
		}
		Department department = modelMapper.map(form, Department.class);
		repository.save(department);

	}
	@Override
	public void updateDepartment(int id, DepartmentFormForUpdating form) {

		Department department = getDepartmentByID(id);

		Department newDepartment = modelMapper.map(form, Department.class);
		newDepartment.setName(department.getName());
		newDepartment.setTotalMenber(department.getTotalMenber());

		repository.save(newDepartment);

	}
	@Override
	public void deleteDepartment(int id) {
		repository.deleteById(id);
	}
	@Override
	public boolean isDepartmentExistsByName(String name) {
		return repository.existsByName(name);
	}

}
