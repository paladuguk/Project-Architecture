package com.test.services.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.test.businessobjects.StudentDTO;
import com.test.pojo.Student;


/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.pojo.Student
 * @author MyEclipse Persistence Tools
 */

public class StudentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);

	protected void initDao() {
		// do nothing
	}
	
	public void save(StudentDTO studentDTO) {
		Student student = new Student(studentDTO.getSno(),studentDTO.getSname(),studentDTO.getAge(),studentDTO.getCourse());
		save(student);
	}

	private void save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentDTO findById(java.lang.Integer id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getHibernateTemplate().get(
					"com.test.pojo.Student", id);
			return map(instance);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public StudentDTO map(Student student){
		if(student != null)
			return new StudentDTO(student.getSno(), student.getSname(),student.getCourse(), student.getAge());
		return null;
	}

	
	public List<StudentDTO>  findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<StudentDTO> findByEname(Object ename) {
		return findByProperty("Sname", ename);
	}

	public List<StudentDTO>  findByAge(Object age) {
		return findByProperty("Age", age);
	}

	public List<StudentDTO>  findBycourse(Object course) {
		return findByProperty("Course", course);
	}

	public List<StudentDTO>  findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}