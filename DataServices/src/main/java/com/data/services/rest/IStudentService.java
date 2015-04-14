package com.data.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.test.businessobjects.StudentDTO;

@Path("/student/")
@Produces({"application/xml","application/json"})
public interface IStudentService {
	@GET
	@Path("/getStudent/{sno}")
	// http://localhost:8080/cxfservice/rest/stuservice/getStudent/101
	public StudentDTO getStudent(@PathParam("sno") Integer sno);

	@POST
	@Path("/saveStudent")
	// http://localhost:8080/cxfservice/rest/stuservice/saveStudent
	public StudentDTO saveStudent(StudentDTO student);		
}

//http://localhost:8085/dataserviceapp/service/student/getStudent/777