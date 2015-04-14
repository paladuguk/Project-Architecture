package com.data.services.rest.impl;

import com.data.services.rest.IStudentService;
import com.test.businessobjects.StudentDTO;
import com.test.pojo.Student;
import com.test.services.dao.StudentDAO;

public class StudentService  implements IStudentService{
	/*@Autowired
	@Qualifier(value="studentDAO")*/
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public StudentDTO getStudent(Integer sno) {
		//DAO 
		//return new Student(sno,"Rama",30,"MS");
		StudentDTO studentDTO =null;
		try{
			studentDTO = studentDAO.findById(sno);
			if(studentDTO == null){
				studentDTO = createFaultObject("stu:404","Student Not Found " + sno);
			}
		}catch (Exception e) {
			e.printStackTrace();
			studentDTO = createFaultObject("stu:500","We are unable to process your request ::::: Please try again !!!!!!");
		}
		
		
		return studentDTO;
	}

	public StudentDTO saveStudent(StudentDTO studentDTO) {
		System.out.println("Saving Student Object in the DB " + studentDTO);
		try{
			studentDAO.save(studentDTO);
		}catch (Exception e) {
			e.printStackTrace();
			studentDTO = createFaultObject("stu:500","We are unable to process your request ::::: Please try again !!!!!!");
		}
		return studentDTO;
	}
	
	public StudentDTO createFaultObject(String code,String msg){
		StudentDTO studentDTO = new StudentDTO();
		/*Student.setCode(code);
		Student.setMessage(msg);*/
		return studentDTO;
	}
}
