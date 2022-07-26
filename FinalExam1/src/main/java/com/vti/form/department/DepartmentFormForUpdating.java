package com.vti.form.department;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFormForUpdating {

	private int id;

	private Department.Type type;
}
