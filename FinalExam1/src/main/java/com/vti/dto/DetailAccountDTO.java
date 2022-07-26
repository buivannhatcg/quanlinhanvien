package com.vti.dto;

import com.vti.entity.Account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class DetailAccountDTO {
	
	@NonNull
	private int id;
	@NonNull
	private String username;
	@NonNull
	private String fullName;
	@NonNull
	private Account.Role role;
	@NonNull
	private String password;
	
}
