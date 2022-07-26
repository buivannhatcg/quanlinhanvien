package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.dto.account.AccountDTO;
import com.vti.entity.Department;
import com.vti.form.Account.CreatingAccountForm;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.DepartmentFormForUpdating;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IDepartmentService service;

	@GetMapping
	public Page<DepartmentDTO> getAllDepartments(Pageable pageable, String search,DepartmentFilterForm filterform) {

		
		Page<Department> entityPage = service.getAllDepartments(pageable, search, filterform);

		List<DepartmentDTO> dtos = modelMapper.map(entityPage.getContent(), new TypeToken<List<DepartmentDTO>>() {
		}.getType());
		Page<DepartmentDTO> dtoPage = new PageImpl<>(dtos, pageable, entityPage.getTotalElements());

		return dtoPage;
	}
	
	@GetMapping(value = "/{id}")
	public DepartmentDTO getDepartmentDTO(@PathVariable(name = "id") int id) {
		
		Department entity = service.getDepartmentByID(id);
		
		// convert entity to dto
		DepartmentDTO dto = modelMapper.map(entity, DepartmentDTO.class);
		
		return dto;
	}

	@PostMapping()
	public void createDepartment(@RequestBody CreatingDepartmentForm form) {
		service.createDeparment(form);
	}
	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") int id,@RequestBody DepartmentFormForUpdating form) {
		form.setId(id);
		service.updateDepartment(id, form);
	}
	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id")int id) {
		service.deleteDepartment(id);
	}
	@GetMapping(value = "/name/{name}/exists")
	public boolean existsByName(@PathVariable(name = "name") String name) {
		return service.isDepartmentExistsByName(name);
	}

	

}
