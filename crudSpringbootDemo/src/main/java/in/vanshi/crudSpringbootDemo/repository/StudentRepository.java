package in.vanshi.crudSpringbootDemo.repository;

import in.vanshi.crudSpringbootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedIsFalse(long id);

    List<Student> findByDeletedIsFalse();


    //findby + fieldName + condition
}
