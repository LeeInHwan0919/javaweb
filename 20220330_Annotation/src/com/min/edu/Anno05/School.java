package com.min.edu.Anno05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
  
	
//  @Autowired(required = false) //required는 true인 경우 주입되는 객체가 null이라면 오류 발생 false라면 그냥 null로 표기 (예외처리기능이라고 볼수 있다.)
// 오토와이어드는 생성된 bean중에서 단일의 타입을 자동으로 주입해줌, 여러개라면 사용할 수가 없다.

	
//  @Autowired
//  @Qualifier("stu02") // 생성된 여러개의 빈 중에서 특정 빈의 id를 통해서 사용할 수 있도록 함
	
//  @Autowired
//  @Qualifier("student") //단일로 있을경우 불러올 수 있지만, 여러개 있을때는 불러올 수가 없음 > student가 아이디라면 그 아이디의 내용이 적용되고, 아니라면 클래스의 형식으로 값을 매핑한다.
	
//	@Resource(name="stu03") //없으면 절대 사용할 수가 없음. 객체가 미리 만들어져있을 때 사용하는 부분
  @Autowired(required = true) 
  @Qualifier("stu02")
  private Student student;
  
  private int grade;
  
  public School() {
	  
}

public School(Student student, int grade) {
	this.student = student;
	this.grade = grade;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

public int getGrade() {
	return grade;
}

public void setGrade(int grade) {
	this.grade = grade;
}

@Override
public String toString() {
	return "School [student=" + student + ", grade=" + grade + "]";
}
 
  
  
}

