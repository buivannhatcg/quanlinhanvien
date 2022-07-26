package com.vti.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
	
	@NonNull
	private int id;
	@NonNull
	private String username;
	@NonNull
	private String fullName;
	@NonNull
	private String role;
//	@NonNull
	private String departmentName;
	

}
