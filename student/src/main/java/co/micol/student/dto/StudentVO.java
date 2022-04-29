package co.micol.student.dto;

import java.sql.Date;

public class StudentVO { //Dto
	// 멤버변수와 getter setter로만 구성되어있는게 VO
	private String studentId;
	private String name;
	private Date birthday; // 지금은 sql데이터를 쓰지만 몇초가 중요하면 utill쓰는게 좋음
	private String major;
	private String address;
	private String tel;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		System.out.print(studentId + " : ");
		System.out.print(name + " : ");
		System.out.print(birthday + " : ");
		System.out.print(major + " : ");
		System.out.print(address + " : ");
		System.out.println(tel);
		
		return null;
	}
}
