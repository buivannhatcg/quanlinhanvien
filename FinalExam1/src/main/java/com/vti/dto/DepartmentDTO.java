package com.vti.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class DepartmentDTO {
	
	
	private int id;
	
	private String name;
	
	private int totalMenber;
	
	private Department.Type type;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

//	private List<AccountDTO> accounts;

//	@Data
//	@NoArgsConstructor
//	static class AccountDTO {
//
//		@JsonProperty("accountId")
//		private int id;
//
//		private String username;
//	}
}
