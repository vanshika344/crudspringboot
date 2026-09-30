package in.vanshi.crudSpringbootDemo.repository;

import in.vanshi.crudSpringbootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
