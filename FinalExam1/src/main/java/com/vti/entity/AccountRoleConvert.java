package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Account.Role;

@Converter(autoApply = true)
public class AccountRoleConvert implements AttributeConverter<Account.Role, String>{

	@Override
	public String convertToDatabaseColumn(Account.Role role) {
		if (role == null) {
			return null;
		}

		return role.getValue();
	}

	@Override
	public Account.Role convertToEntityAttribute(String sqlValue) {
		if (sqlValue == null) {
			return null;
		}

		return Account.Role.toEnum(sqlValue);
	}
}
