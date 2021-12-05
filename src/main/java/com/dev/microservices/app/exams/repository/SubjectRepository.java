package com.dev.microservices.app.exams.repository;

import com.dev.microservices.commons.exams.models.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
