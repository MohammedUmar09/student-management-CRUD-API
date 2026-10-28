package com.example.student_management_app;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDb = new HashMap<>();
    Map<Integer, Teacher> teacherDb = new HashMap<>();
    Map<Integer, List<Integer>> studentTeacherDb = new HashMap<>();

    public Student getStudent(int admno){
        return studentDb.get(admno);
    }

    public String addStudent(Student student){
        studentDb.put(student.getAdmno(), student);
        return "Student added successfully";
    }

    public Teacher getTeacher(String name){
        for(Integer teacherId: teacherDb.keySet()){
            if(teacherDb.get(teacherId).getName().equals(name)){
                return teacherDb.get(teacherId);
            }
        }
        return null;
    }

    public String addTeacher(Teacher teacher){
        teacherDb.put(teacher.getId(), teacher);
        return "Teacher added successfully";
    }

    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();
        for(Integer studentId: studentDb.keySet()){
            students.add(studentDb.get(studentId).getName());
        }
        return students;
    }

    public String deleteTeacher(String name){
        for(Integer teacherId: teacherDb.keySet()){
            if(teacherDb.get(teacherId).getName().equals(name)){
                teacherDb.remove(teacherId);
                return "Teacher revomed successfully";
            }
        }
        return "Teacher not Found";
    }

    public String putStudentTeacher(Integer studentId, Integer teacherId){
        if(studentDb.containsKey(studentId) && teacherDb.containsKey(teacherId)){
            if(!studentTeacherDb.containsKey(teacherId)){
                studentTeacherDb.put(teacherId, new ArrayList<>());
            }
            studentTeacherDb.get(teacherId).add(studentId);

            return "student has been added to teacher successfully";
        }
        return "not FOund";
    }

    public List<String> getStudentsByTeacherId(Integer teacherId){
        List<String> studentsList = new ArrayList<>();
        List<Integer> students = studentTeacherDb.get(teacherId);
        if(students != null){
            for(Integer studentId: students){
                studentsList.add(studentDb.get(studentId).getName());
            }
        }
        return studentsList;
    }
}
