package com.vti.form.Account;

import com.vti.entity.Account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountFormForUpdating {

	private int id;
	
	private Account.Role role;
	
	private String departmentId;
}
