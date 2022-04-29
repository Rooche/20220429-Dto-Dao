package co.micol.student.service;

import java.util.List;

import co.micol.student.dto.StudentVO;

public interface StudentService {
	//함수 원형만 들고있는것이 인터페이스
	//CRUD
	List<StudentVO> selectListStudent();
	StudentVO selectStudent(StudentVO student); // 전체학생목록
	int innsertStudent(StudentVO student); //한명 추가
	int updateStudent(StudentVO student); //한명 갱신
	int deleteStudent(StudentVO student); //한명 삭제
}
