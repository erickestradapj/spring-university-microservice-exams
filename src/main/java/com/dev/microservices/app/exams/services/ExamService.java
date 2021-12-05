package com.dev.microservices.app.exams.services;

import com.dev.microservices.commons.exams.models.entity.Exam;
import com.dev.microservices.commons.exams.models.entity.Subject;
import com.dev.microservices.commons.services.CommonService;

import java.util.List;

public interface ExamService extends CommonService<Exam> {

    List<Exam> findByName(String term);

    Iterable<Subject> findAllSubjects();
}
