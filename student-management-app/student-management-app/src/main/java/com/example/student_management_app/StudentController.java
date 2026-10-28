package com.example.student_management_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;//bean

    @GetMapping("get-student")//annotation for calling endpoint
    public ResponseEntity getStudent(@RequestParam("id") int admno){
       Student student = studentService.getStudent(admno);
       return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/get-by-path/{id}")
    public ResponseEntity getStudentByPath(@PathVariable("id") int admno){

        Student student =  studentService.getStudent(admno);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @PostMapping("/postStudent")
    public ResponseEntity postStudent(@RequestBody Student student){

        String str = studentService.addStudent(student);
        return new ResponseEntity(str, HttpStatus.CREATED);
    }
//TeacherTeacher

    @GetMapping("/get-teacher")
    public Teacher getTeacher(@RequestParam("name") String name){
        return studentService.getTeacher(name);
    }


    @PostMapping("/post-teacher")
    public String postTeacher(@RequestBody Teacher teacher){
        return studentService.addTeacher(teacher);
    }

    //Assignment
    @GetMapping("/get-all-students")
    public List<String> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete-teacher")
    public ResponseEntity deleteTeacher(@RequestParam String name){
        String str = studentService.deleteTeacher(name);
        return new ResponseEntity(str, HttpStatus.OK);
    }

    @PutMapping("/put-student-teacher")
    public ResponseEntity putStudentTeacher(@RequestParam Integer studentId,
                                            @RequestParam Integer teacherId){
        String str = studentService.putStudentTeacher(studentId, teacherId);
        return new ResponseEntity(str, HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacherId")
    public ResponseEntity getStudentsByTeacherId(@RequestParam Integer teacherId){
        List<String> studentsList = studentService.getStudentsByTeacherId(teacherId);
        return new ResponseEntity(studentsList, HttpStatus.OK);
    }
}
