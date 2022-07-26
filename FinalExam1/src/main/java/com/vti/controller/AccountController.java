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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.dto.account.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.Account.AccountFilterForm;
import com.vti.form.Account.AccountFormForUpdating;
import com.vti.form.Account.CreatingAccountForm;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {

	@Autowired
	private IAccountService service;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping()
	public Page<AccountDTO> getAllAccounts(Pageable pageable, String search, AccountFilterForm filterForm) {

		Page<Account> entitiesPage = service.getAllAccounts(pageable, search, filterForm);

		//
		List<AccountDTO> dtos = modelMapper.map(entitiesPage.getContent(), new TypeToken<List<AccountDTO>>() {
		}.getType());
		Page<AccountDTO> dtoPage = new PageImpl<>(dtos, pageable, entitiesPage.getTotalElements());
		return dtoPage;
	}
	@GetMapping("/departments")
	public Page<DepartmentDTO> getAllDepartmentsForSearch(Pageable pageable,
			@RequestParam(value = "search", required = false) String search) {

		Page<Department> entityPages = service.getAllDepartmentsForSearch(pageable, search);

		// convert entities --> dtos
		List<DepartmentDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<DepartmentDTO>>() {
		}.getType());

		Page<DepartmentDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;

	}


	@GetMapping(value = "/{id}")
	public AccountDTO getAccountByID(@PathVariable(name = "id") int id) {

		Account entity = service.getAccountByID(id);

		// convert entity to dto
		AccountDTO dto = modelMapper.map(entity, AccountDTO.class);

		return dto;
	}

	@PostMapping()
	public void createAccount(@RequestBody CreatingAccountForm form) {
		service.createAccount(form);
	}

	@PutMapping(value = "/{id}")
	public void updateAccount(@PathVariable(name = "id") int id, @RequestBody AccountFormForUpdating form) {
		form.setId(id);
		service.updateAccount(id, form);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") int id) {
		service.deleteAccount(id);
	}
	@GetMapping(value = "/username/{username}/exists")
	public boolean existsByName(@PathVariable(name = "username") String username) {
		return service.isAccountExistsByUserName(username);
	}

}
