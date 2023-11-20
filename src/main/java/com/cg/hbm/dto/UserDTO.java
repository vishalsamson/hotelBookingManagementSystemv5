package com.cg.hbm.dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cg.hbm.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private int id;

	@NotEmpty
	@Size(min = 4, message = "user email must be of minimum 4 characters")
	private String username;

	@Email(message = "Email address is not valid")
	private String email;

	@NotNull
	@Size(min = 3, max = 10, message = "Password must be minimum of 3 chars and maximum of 10")
	private String password;

	@NotNull
	private long mobile;
	
	@NotNull @NotEmpty
	private String address;
	
	private Set<Role> roles;
	

}
