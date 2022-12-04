package com.skypro.examination.service;

import com.skypro.examination.model.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}

