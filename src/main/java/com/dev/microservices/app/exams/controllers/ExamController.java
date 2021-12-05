package com.dev.microservices.app.exams.controllers;

import com.dev.microservices.app.exams.services.ExamService;
import com.dev.microservices.commons.controllers.CommonController;
import com.dev.microservices.commons.exams.models.entity.Exam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ExamController extends CommonController<Exam, ExamService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Exam exam, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return this.validate(result);
        }

        Optional<Exam> o = service.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Exam examDB = o.get();
        examDB.setName(exam.getName());

        examDB.getQuestions()
                .stream()
                .filter(question -> !exam.getQuestions().contains(question))
                .forEach(examDB::removeQuestion);

        examDB.setQuestions(exam.getQuestions());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examDB));
    }

    @GetMapping("/filter/{term}")
    public ResponseEntity<?> filter(@PathVariable String term) {
        return ResponseEntity.ok(service.findByName(term));
    }

    @GetMapping("/subjects")
    public ResponseEntity<?> listSubjects() {
        return ResponseEntity.ok(service.findAllSubjects());
    }
}
