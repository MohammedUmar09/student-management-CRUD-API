package com.example.student_management_app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public Student getStudent(int admno){
        return studentRepository.getStudent(admno);
    }

    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public Teacher getTeacher(String name){
        return studentRepository.getTeacher(name);
    }

    public String addTeacher(Teacher teacher){
        return studentRepository.addTeacher(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public String deleteTeacher(String name){
        return studentRepository.deleteTeacher(name);
    }

    public String putStudentTeacher(Integer studentId, Integer teacherId){
        return studentRepository.putStudentTeacher(studentId, teacherId);
    }

    public List<String> getStudentsByTeacherId(Integer teacherId){
        return studentRepository.getStudentsByTeacherId(teacherId);
    }

}
