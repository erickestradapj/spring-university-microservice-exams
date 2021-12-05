package com.dev.microservices.app.exams.services.impl;

import com.dev.microservices.app.exams.repository.ExamRepository;
import com.dev.microservices.app.exams.repository.SubjectRepository;
import com.dev.microservices.app.exams.services.ExamService;
import com.dev.microservices.commons.exams.models.entity.Exam;
import com.dev.microservices.commons.exams.models.entity.Subject;
import com.dev.microservices.commons.services.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamServiceImpl extends CommonServiceImpl<Exam, ExamRepository> implements ExamService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Exam> findByName(String term) {
        return repository.findByName(term);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }
}
