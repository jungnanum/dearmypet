package net.dearmypet.webapp.vo;

import java.io.Serializable;

public class LoginVO implements Serializable{
	private int lg_no;
	private String lg_id;
	private String lg_profile;
	private String lg_password;
	private String lg_email;
	private String lg_nickname;
	private int lgfb_no;
	private int lgka_no;
	private int m_no;
	private int lg_login_type;
	
	public LoginVO() {
		// TODO Auto-generated constructor stub
	}

	public LoginVO(int lg_no, String lg_id, String lg_profile, String lg_password, String lg_email, String lg_nickname,
			int lgfb_no, int lgka_no, int m_no, int lg_login_type) {
		this.lg_no = lg_no;
		this.lg_id = lg_id;
		this.lg_profile = lg_profile;
		this.lg_password = lg_password;
		this.lg_email = lg_email;
		this.lg_nickname = lg_nickname;
		this.lgfb_no = lgfb_no;
		this.lgka_no = lgka_no;
		this.m_no = m_no;
		this.lg_login_type = lg_login_type;
	}

	public int getLg_no() {
		return lg_no;
	}

	public void setLg_no(int lg_no) {
		this.lg_no = lg_no;
	}

	public String getLg_id() {
		return lg_id;
	}

	public void setLg_id(String lg_id) {
		this.lg_id = lg_id;
	}

	public String getLg_profile() {
		return lg_profile;
	}

	public void setLg_profile(String lg_profile) {
		this.lg_profile = lg_profile;
	}

	public String getLg_password() {
		return lg_password;
	}

	public void setLg_password(String lg_password) {
		this.lg_password = lg_password;
		System.out.println("setLg_password setter : "+this.lg_password);
	}

	public String getLg_email() {
		return lg_email;
	}

	public void setLg_email(String lg_email) {
		this.lg_email = lg_email;
		System.out.println("getLg_email setter : "+this.lg_email);
	}

	public String getLg_nickname() {
		return lg_nickname;
	}

	public void setLg_nickname(String lg_nickname) {
		this.lg_nickname = lg_nickname;
	}

	public int getLgfb_no() {
		return lgfb_no;
	}

	public void setLgfb_no(int lgfb_no) {
		this.lgfb_no = lgfb_no;
	}

	public int getLgka_no() {
		return lgka_no;
	}

	public void setLgka_no(int lgka_no) {
		this.lgka_no = lgka_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getLg_login_type() {
		return lg_login_type;
	}

	public void setLg_login_type(int lg_login_type) {
		this.lg_login_type = lg_login_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lg_email == null) ? 0 : lg_email.hashCode());
		result = prime * result + ((lg_id == null) ? 0 : lg_id.hashCode());
		result = prime * result + lg_login_type;
		result = prime * result + ((lg_nickname == null) ? 0 : lg_nickname.hashCode());
		result = prime * result + lg_no;
		result = prime * result + ((lg_password == null) ? 0 : lg_password.hashCode());
		result = prime * result + ((lg_profile == null) ? 0 : lg_profile.hashCode());
		result = prime * result + lgfb_no;
		result = prime * result + lgka_no;
		result = prime * result + m_no;
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
		LoginVO other = (LoginVO) obj;
		if (lg_email == null) {
			if (other.lg_email != null)
				return false;
		} else if (!lg_email.equals(other.lg_email))
			return false;
		if (lg_id == null) {
			if (other.lg_id != null)
				return false;
		} else if (!lg_id.equals(other.lg_id))
			return false;
		if (lg_login_type != other.lg_login_type)
			return false;
		if (lg_nickname == null) {
			if (other.lg_nickname != null)
				return false;
		} else if (!lg_nickname.equals(other.lg_nickname))
			return false;
		if (lg_no != other.lg_no)
			return false;
		if (lg_password == null) {
			if (other.lg_password != null)
				return false;
		} else if (!lg_password.equals(other.lg_password))
			return false;
		if (lg_profile == null) {
			if (other.lg_profile != null)
				return false;
		} else if (!lg_profile.equals(other.lg_profile))
			return false;
		if (lgfb_no != other.lgfb_no)
			return false;
		if (lgka_no != other.lgka_no)
			return false;
		if (m_no != other.m_no)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [lg_no=" + lg_no + ", lg_id=" + lg_id + ", lg_profile=" + lg_profile + ", lg_password="
				+ lg_password + ", lg_email=" + lg_email + ", lg_nickname=" + lg_nickname + ", lgfb_no=" + lgfb_no
				+ ", lgka_no=" + lgka_no + ", m_no=" + m_no + ", lg_login_type=" + lg_login_type + "]";
	}
	
}
