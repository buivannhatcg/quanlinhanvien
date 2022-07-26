package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "`Account`")
@Data
@NoArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username", length = 50, nullable = false, unique = false, updatable = false)
	private String username;

	@Column(name = "`password`", length = 800, nullable = false)
	private String password;

	@Column(name = "first_name", length = 50, nullable = false, updatable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false, updatable = false)
	private String lastName;

	@Formula(" concat(first_name, ' ',last_name) ")
	private String fullName;
	
	@Column(name = "`role`", nullable = false)
	private Role role;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@PrePersist
	public void prePersist() {
		if (password == null) {
			password = "123456";
// BCryptPasswordEncoder().encode
		}
		if(role == null) {
			role = Role.EMPLOYEE;
		}
	}

	public enum Role {
		ADMIN("ADMIN"), EMPLOYEE("EMPLOYEE"), MANAGER("MANAGER");

		private String value;

		private Role(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static Role toEnum(String sqlValue) {
			for (Role role : Role.values()) {
				if (role.getValue().equals(sqlValue)) {
					return role;
				}
			}
			return null;
		}

	}

}
