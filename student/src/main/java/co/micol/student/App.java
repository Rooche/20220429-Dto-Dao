package co.micol.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class App {
	public static void main(String[] args) {
		StudentService dao = new StudentServiceImpl();
     List<StudentVO> list = new ArrayList<StudentVO>();
     list = dao.selectListStudent();
      
      for(StudentVO vo : list) {
    	  vo.toString();
      }
//      System.out.println("========================================================================");
//      StudentVO student = new StudentVO();
//      student.setStudentId("parkk@abc.com");
//      student = dao.selectStudent(student);
//      student.toString();

      	//한명추가
		//한번 실행하면 자동으로 커밋이 되기에 같은 정보를 입력할수없음(에러가뜸)
		//함수는 기본적으로 2가지 타입을 가지고있다
		//procedure타입 , function타입
		//function은 return value가 있다
		//procedure타입은 void가 있다
//		StudentVO vo = new StudentVO();
//		vo.setStudentId("leeto@abc.com");
//		vo.setName("이멍청이");
//		vo.setBirthday(Date.valueOf("2000-01-01"));
//		vo.setMajor("경영학과");
//		vo.setAddress("경기도 오산시");
//		vo.setTel("010-1234-5453");
//		int n = dao.innsertStudent(vo);
//		if (n != 0) {
//			System.out.println("정상적으로 입력되었습니다.");
//		} else {
//			System.out.println("입력에 실패했습니다.");
//		}

	}
}
