package net.dearmypet.webapp.vo;

import java.io.Serializable;

public class LoginDataVO implements Serializable {
	private String lg_password;
	private String lg_email;
	
	public LoginDataVO() {}

	public LoginDataVO(String lg_password, String lg_email) {
		this.lg_password = lg_password;
		this.lg_email = lg_email;
	}

	public String getLg_password() {
		return lg_password;
	}

	public void setLg_password(String lg_password) {
		this.lg_password = lg_password;
	}

	public String getLg_email() {
		return lg_email;
	}

	public void setLg_email(String lg_email) {
		this.lg_email = lg_email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lg_email == null) ? 0 : lg_email.hashCode());
		result = prime * result + ((lg_password == null) ? 0 : lg_password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDataVO other = (LoginDataVO) obj;
		if (lg_email == null) {
			if (other.lg_email != null)
				return false;
		} else if (!lg_email.equals(other.lg_email))
			return false;
		if (lg_password == null) {
			if (other.lg_password != null)
				return false;
		} else if (!lg_password.equals(other.lg_password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginDataVO [lg_password=" + lg_password + ", lg_email=" + lg_email + "]";
	}

	

}
