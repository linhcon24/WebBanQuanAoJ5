package com.spring.bean;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ChangeForm {
	
	@NotBlank(message = "{NotBlank.change.passwordcu}")
	@Length(min = 6 , message = "{Length.change.passwordcuMin}")
	@Length(max = 12 , message = "{Length.change.passwordcuMax}")
	private String passcu;
	@NotBlank(message = "{NotBlank.change.passwordmoi}")
	@Length(min = 6 , message = "{Length.change.passwordmoiMin}")
	@Length(max = 12 , message = "{Length.change.passwordmoiMax}")
	private String passmoi;
	@NotBlank(message = "{NotBlank.change.repasswordmoi}")
	@Length(min = 6 , message = "{Length.change.repasswordmoiMin}")
	@Length(max = 12 , message = "{Length.change.repasswordmoiMax}")
	private String repassmoi;
	

	public String getPasscu() {
		return passcu;
	}

	public void setPasscu(String passcu) {
		this.passcu = passcu;
	}

	public String getPassmoi() {
		return passmoi;
	}

	public void setPassmoi(String passmoi) {
		this.passmoi = passmoi;
	}

	public String getRepassmoi() {
		return repassmoi;
	}

	public void setRepassmoi(String repassmoi) {
		this.repassmoi = repassmoi;
	}

}
