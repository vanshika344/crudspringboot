package in.vanshi.crudSpringbootDemo.Service;

import in.vanshi.crudSpringbootDemo.entity.Student;
import in.vanshi.crudSpringbootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
 
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
       this.studentRepository = studentRepository;
        //buissness logic
        //store to db

    }

    public Student createStudent(Student studentReq) {

        Student studentResp=studentRepository.save(studentReq);
        return studentResp;

    }

    public Student getStudent(Long id) {
      Optional<Student> studentResp = studentRepository.findById(id);

      if(studentResp.isPresent()) {
          return studentResp.get();
      }
      return null;
    }

    public List<Student> getAllStudent() {
    List<Student> studentList=studentRepository.findAll();
    return studentList;}

    public Student updateStudent(Long id){
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isEmpty()) {
            return null;
        }
        Student studentToSave=existingStudent.get();
        studentToSave.setName(studentToSave.getName());
        studentToSave.setRollno(studentToSave.getRollno());
        studentToSave.setSubject(studentToSave.getSubject());
        studentToSave.setEmail(studentToSave.getEmail());
        studentToSave.setAge(studentToSave.getAge());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
      Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }

    // 1. endpoint listen (/app/student POST)
    //2. buissness logic
    //3. interact with db
    //4. response back to client(postman)
}
