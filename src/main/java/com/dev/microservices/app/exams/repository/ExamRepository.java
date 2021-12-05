package com.dev.microservices.app.exams.repository;

import com.dev.microservices.commons.exams.models.entity.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ExamRepository extends PagingAndSortingRepository<Exam, Long> {

    @Query("SELECT e FROM Exam e WHERE e.name like %?1%")
    List<Exam> findByName(String term);

}
