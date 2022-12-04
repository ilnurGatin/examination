package com.skypro.examination.controller;

import com.skypro.examination.model.Question;
import com.skypro.examination.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return this.javaQuestionService.addQuestion(question, answer);
    }

    @PostMapping("/add/question")
    public Question add(@RequestBody Question question) {
        return this.javaQuestionService.add(question);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestBody Question question) {
        return this.javaQuestionService.removeQuestion(question);
    }

    @GetMapping("/")
    public Collection<Question> getAllQuestions() {
        return this.javaQuestionService.getAll();
    }
}
