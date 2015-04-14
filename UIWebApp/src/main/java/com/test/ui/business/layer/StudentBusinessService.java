package com.test.ui.business.layer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.businessobjects.StudentDTO;
import com.test.model.StudentModel;
import com.test.sdk.StudentSDK;

@Component
public class StudentBusinessService {

	@Autowired
	StudentSDK studentSDK;
	
	public StudentModel getStudent(int sno){
		StudentDTO studentDTO = studentSDK.getStudent(sno);
		
		return  new StudentModel(studentDTO.getSno(),studentDTO.getSname(),studentDTO.getCourse(),studentDTO.getAge());
	}
	
	
}
