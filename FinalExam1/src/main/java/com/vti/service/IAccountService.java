package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.dto.account.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.Account.AccountFilterForm;
import com.vti.form.Account.AccountFormForUpdating;
import com.vti.form.Account.CreatingAccountForm;

public interface IAccountService extends UserDetailsService{

	public Page<Account> getAllAccounts(Pageable pageable,String seach,AccountFilterForm filterForm);

	public Account getAccountByID(int id);
	
	public void createAccount(CreatingAccountForm form);

	public void updateAccount(int id,AccountFormForUpdating form);

	public void deleteAccount(int id);

	boolean isAccountExistsByUserName(String username);

	public Account getAccountByUsername(String username);

	public Page<Department> getAllDepartmentsForSearch(Pageable pageable, String search);

	
}
