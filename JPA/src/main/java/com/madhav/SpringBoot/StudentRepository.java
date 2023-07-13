package com.madhav.SpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
//	@PersistenceContext(unitName = "mysql")
//	private EntityManager entity;
//	
//	@Transactional
//	public void saveStudent(Student student) {
//		//Insert a record into the database
//		entity.persist(student);
//		System.out.println("saving student records");
//	}
//	
//	@Transactional
//	public List<Student> findAllStudents() {
//		//for createQuery always pass on the class name for hibernate to identify which entity it is
//		TypedQuery<Student> query = entity.createQuery("from Student", Student.class);
//		return query.getResultList();
//	}
}
