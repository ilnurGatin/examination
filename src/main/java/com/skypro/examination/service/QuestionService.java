package com.skypro.examination.service;

import com.skypro.examination.model.Question;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;




public interface QuestionService {
    public Question addQuestion(String questiom, String ansewr);
    public Question add(Question question);
    public Question removeQuestion(Question question);
    public Collection<Question> getAll();
    public Question getRandomQuestion();
}
