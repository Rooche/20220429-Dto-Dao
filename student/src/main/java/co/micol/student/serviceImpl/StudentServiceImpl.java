package co.micol.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dao.DataSource;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnction(); // connection
	private PreparedStatement psmt; // sql명령문을 실행
	private ResultSet rs; // select결과물을 담음

	@Override
	public List<StudentVO> selectListStudent() {
		// 전체 학생 목록 가져오기
		
		List<StudentVO> students = new ArrayList<StudentVO>(); // 자기자신을 초기화하지 못하기에 ArrayList로 초기화한다
		StudentVO student;
		String sql = "SELECT * FROM STUDENT"; // 대문자로 바꾸는법 컨트롤 + 쉬프트 + x
		try {
			psmt = conn.prepareStatement(sql); // 커넥션객체를 통해서 sql을 보내고 명령실행을 해줄수있도록
			rs = psmt.executeQuery(); // sql을 실행하고 결과를 담음
			while (rs.next()) { // 아무것도 읽을게 없으면 빠져나간다 읽을게 있으면
				student = new StudentVO(); //인스턴스를 깨끗하게 비운다(초기화)
				student.setStudentId(rs.getString("studentid"));
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				// 다 읽었으면
				students.add(student); //리스트 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentVO selectStudent(StudentVO student) {
		// 한명조회
		StudentVO vo = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentid"));
				vo.setName(rs.getString("name"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setMajor(rs.getString("major"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int innsertStudent(StudentVO student) {
		//한명추가
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareCall(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int updateStudent(StudentVO student) {
		//한명 정보 변경
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?, ADDRESS = ?, "
				+ "TEL = ? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int deleteStudent(StudentVO student) {
		//한명 삭제
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

}
