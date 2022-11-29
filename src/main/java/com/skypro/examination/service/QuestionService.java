package com.skypro.examination.service;

import com.skypro.examination.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
public class QuestionService {

    private final Collection<Question> questions = new ArrayList<Question>();

    public Question addQuesstion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        this.questions.add(newQuestion);
        return newQuestion;
    }

    public Question addQuestion(Question question) {
        this.questions.add(question);
        return null;
    }

    public Question removeQuestion(Question question) {
        this.questions.remove(question);
        return question;
    }

    public Collection<Question> getAll() {
        return questions;
    }
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size() + 1);
        Question question = questions[index];
        return question;
    }

}
