package in.vanshi.crudSpringbootDemo.controller;

import in.vanshi.crudSpringbootDemo.Service.StudentService;
import in.vanshi.crudSpringbootDemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//tells spring framework that it takes api as input format and gives output in json format//

@RequestMapping("/api/student")
public class StudentController {

    private final StudentService  studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
//sending to JSON
      Student createdStudent = studentService.createStudent(student);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    //read
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id ){
        Student studentResp = studentService.getStudent(id);

        if (studentResp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();

        if (studentList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentList);
    }


    //update

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id ){
        Student studentResp = studentService.updateStudent(id);

        if (studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }


    //delete
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteStudent(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(true);
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<Boolean> deleteStudentSoftly(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(true);
    }

}
