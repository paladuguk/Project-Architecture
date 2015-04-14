package com.test.sdk;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.data.services.rest.IStudentService;
import com.test.businessobjects.StudentDTO;

@Component
public class StudentSDK {
	
	@Value(value="${restURL}")
	private String restURL;// = "http://localhost:8085/dataserviceapp/service/";
	
	public IStudentService getService(){
		JAXRSClientFactoryBean sf = new JAXRSClientFactoryBean();
		sf.setResourceClass(IStudentService.class);
		sf.setAddress(restURL);   //("http://localhost:8080/cxfservice/rest");
		BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
		JAXRSBindingFactory factory = new JAXRSBindingFactory();
		factory.setBus(sf.getBus());
		manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
		return sf.create(IStudentService.class);
	}
	
	public StudentDTO getStudent(int sno){
		return getService().getStudent(sno);
	}
	
	public StudentDTO saveStudent(StudentDTO student){
		return getService().saveStudent(student);
	}

}
