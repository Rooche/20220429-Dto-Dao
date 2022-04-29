package co.micol.student.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class StudentVO { //Dto
	// 멤버변수와 getter setter로만 구성되어있는게 VO
	private String studentId;
	private String name;
	private Date birthday; // 지금은 sql데이터를 쓰지만 몇초가 중요하면 utill쓰는게 좋음
	private String major;
	private String address;
	private String tel;

	
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
