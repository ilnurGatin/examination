package com.skypro.examination.service;

import com.skypro.examination.exception.IllegalRequestException;
import com.skypro.examination.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new IllegalRequestException();
        }
        Set<Question> newSet = new HashSet<>();
        while (newSet.size() < amount) {
            newSet.add(javaQuestionService.getRandomQuestion());
        }
        return newSet;
    }
}
