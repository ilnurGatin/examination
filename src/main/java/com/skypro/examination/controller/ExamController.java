package com.skypro.examination.controller;

import com.skypro.examination.exception.IllegalRequestException;
import com.skypro.examination.model.Question;
import com.skypro.examination.service.ExaminerServiceImpl;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    @ExceptionHandler(IllegalRequestException.class)
    public ResponseEntity<String> handlerException() {
        return ResponseEntity
                .badRequest()
                .body("Недостаточно вопросов");
    }

    public ExamController(ExaminerServiceImpl examinerService) {

        this.examinerService = examinerService;
    }

    @GetMapping("/exam/getQuestions/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return this.examinerService.getQuestions(amount);
    }
}
