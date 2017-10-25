package net.dearmypet.webapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class FacebookSigninVO implements Serializable{
	
	private static final long serialVersionUID = 1L; // 객체 직렬화/역직렬화 대비
	
	private int lgfb_no;
	private String lgfb_id;
	private String lgfb_picture;
	private String lgfb_name;
	private String lgfb_age_range;
	private String lgfb_gender;
	private String lgfb_email;
	private String lgfb_birthday;
	private Boolean lgfb_verified;
	private Date lgfb_joindatetime;
	
	public FacebookSigninVO() {}

	public FacebookSigninVO(int lgfb_no, String lgfb_id, String lgfb_picture, String lgfb_name, String lgfb_age_range,
			String lgfb_gender, String lgfb_email, String lgfb_birthday, Boolean lgfb_verified,
			Date lgfb_joindatetime) {
		this.lgfb_no = lgfb_no;
		this.lgfb_id = lgfb_id;
		this.lgfb_picture = lgfb_picture;
		this.lgfb_name = lgfb_name;
		this.lgfb_age_range = lgfb_age_range;
		this.lgfb_gender = lgfb_gender;
		this.lgfb_email = lgfb_email;
		this.lgfb_birthday = lgfb_birthday;
		this.lgfb_verified = lgfb_verified;
		this.lgfb_joindatetime = lgfb_joindatetime;
	}

	public int getLgfb_no() {
		return lgfb_no;
	}

	public void setLgfb_no(int lgfb_no) {
		this.lgfb_no = lgfb_no;
	}

	public String getLgfb_id() {
		return lgfb_id;
	}

	public void setLgfb_id(String lgfb_id) {
		this.lgfb_id = lgfb_id;
	}

	public String getLgfb_picture() {
		return lgfb_picture;
	}

	public void setLgfb_picture(String lgfb_picture) {
		this.lgfb_picture = lgfb_picture;
	}

	public String getLgfb_name() {
		return lgfb_name;
	}

	public void setLgfb_name(String lgfb_name) {
		this.lgfb_name = lgfb_name;
	}

	public String getLgfb_age_range() {
		return lgfb_age_range;
	}

	public void setLgfb_age_range(String lgfb_age_range) {
		this.lgfb_age_range = lgfb_age_range;
	}

	public String getLgfb_gender() {
		return lgfb_gender;
	}

	public void setLgfb_gender(String lgfb_gender) {
		this.lgfb_gender = lgfb_gender;
	}

	public String getLgfb_email() {
		return lgfb_email;
	}

	public void setLgfb_email(String lgfb_email) {
		this.lgfb_email = lgfb_email;
	}

	public String getLgfb_birthday() {
		return lgfb_birthday;
	}

	public void setLgfb_birthday(String lgfb_birthday) {
		this.lgfb_birthday = lgfb_birthday;
	}

	public Boolean getLgfb_verified() {
		return lgfb_verified;
	}

	public void setLgfb_verified(Boolean lgfb_verified) {
		this.lgfb_verified = lgfb_verified;
	}

	public Date getLgfb_joindatetime() {
		return lgfb_joindatetime;
	}

	public void setLgfb_joindatetime(Date lgfb_joindatetime) {
		this.lgfb_joindatetime = lgfb_joindatetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lgfb_age_range == null) ? 0 : lgfb_age_range.hashCode());
		result = prime * result + ((lgfb_birthday == null) ? 0 : lgfb_birthday.hashCode());
		result = prime * result + ((lgfb_email == null) ? 0 : lgfb_email.hashCode());
		result = prime * result + ((lgfb_gender == null) ? 0 : lgfb_gender.hashCode());
		result = prime * result + ((lgfb_id == null) ? 0 : lgfb_id.hashCode());
		result = prime * result + ((lgfb_joindatetime == null) ? 0 : lgfb_joindatetime.hashCode());
		result = prime * result + ((lgfb_name == null) ? 0 : lgfb_name.hashCode());
		result = prime * result + lgfb_no;
		result = prime * result + ((lgfb_picture == null) ? 0 : lgfb_picture.hashCode());
		result = prime * result + ((lgfb_verified == null) ? 0 : lgfb_verified.hashCode());
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
		FacebookSigninVO other = (FacebookSigninVO) obj;
		if (lgfb_age_range == null) {
			if (other.lgfb_age_range != null)
				return false;
		} else if (!lgfb_age_range.equals(other.lgfb_age_range))
			return false;
		if (lgfb_birthday == null) {
			if (other.lgfb_birthday != null)
				return false;
		} else if (!lgfb_birthday.equals(other.lgfb_birthday))
			return false;
		if (lgfb_email == null) {
			if (other.lgfb_email != null)
				return false;
		} else if (!lgfb_email.equals(other.lgfb_email))
			return false;
		if (lgfb_gender == null) {
			if (other.lgfb_gender != null)
				return false;
		} else if (!lgfb_gender.equals(other.lgfb_gender))
			return false;
		if (lgfb_id == null) {
			if (other.lgfb_id != null)
				return false;
		} else if (!lgfb_id.equals(other.lgfb_id))
			return false;
		if (lgfb_joindatetime == null) {
			if (other.lgfb_joindatetime != null)
				return false;
		} else if (!lgfb_joindatetime.equals(other.lgfb_joindatetime))
			return false;
		if (lgfb_name == null) {
			if (other.lgfb_name != null)
				return false;
		} else if (!lgfb_name.equals(other.lgfb_name))
			return false;
		if (lgfb_no != other.lgfb_no)
			return false;
		if (lgfb_picture == null) {
			if (other.lgfb_picture != null)
				return false;
		} else if (!lgfb_picture.equals(other.lgfb_picture))
			return false;
		if (lgfb_verified == null) {
			if (other.lgfb_verified != null)
				return false;
		} else if (!lgfb_verified.equals(other.lgfb_verified))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacebookSigninVO [lgfb_no=" + lgfb_no + ", lgfb_id=" + lgfb_id + ", lgfb_picture=" + lgfb_picture
				+ ", lgfb_name=" + lgfb_name + ", lgfb_age_range=" + lgfb_age_range + ", lgfb_gender=" + lgfb_gender
				+ ", lgfb_email=" + lgfb_email + ", lgfb_birthday=" + lgfb_birthday + ", lgfb_verified=" + lgfb_verified
				+ ", lgfb_joindatetime=" + lgfb_joindatetime + "]";
	}
	

	
}
