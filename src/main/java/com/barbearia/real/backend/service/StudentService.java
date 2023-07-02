package com.barbearia.real.backend.service;

import com.barbearia.real.backend.model.student.StudentRequest;
import com.barbearia.real.backend.model.student.StudentResponse;
import com.barbearia.real.backend.persistence.entity.Student;
import com.barbearia.real.backend.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private StudentRepository repo;
    @Override
    public StudentResponse create(StudentRequest req) {
        Student student = new Student();
        student.setName(req.getName());
        student.setBirthDate(req.getBirthDate());
        student.setDocument(req.getDocument());

        repo.save(student);

        return createResponse(student);

    }

    @Override
    public List<StudentResponse> getAll() {
        List<StudentResponse> responseList = new ArrayList<>();
        List<Student> students = repo.findAll();
        if(!students.isEmpty()){
            students.forEach(student -> responseList.add(createResponse(student)));
        }
        return responseList;
    }

    private StudentResponse createResponse(Student student){
        StudentResponse res = new StudentResponse();
        res.setId(student.getId());
        res.setName(student.getName());
        res.setBirthDate(student.getBirthDate());
        res.setDocument(student.getDocument());
        return res;
    }
}
