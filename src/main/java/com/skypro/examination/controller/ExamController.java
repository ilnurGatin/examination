package com.skypro.examination.controller;

import com.skypro.examination.model.Question;
import com.skypro.examination.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerService;


    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/getQuestions")
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return this.examinerService.getQuestions(amount);
    }
}
