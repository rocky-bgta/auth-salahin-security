package com.auth.security.entites;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue
	@Column(name = "role_id", unique = true, nullable = false)
	private Integer roleId;

	@Column(name = "role_name")
	private String rolesName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

}
