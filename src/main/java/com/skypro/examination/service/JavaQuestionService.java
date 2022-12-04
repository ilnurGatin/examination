package com.skypro.examination.service;

import com.skypro.examination.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        this.questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        Question newQuestion = new Question(question.getQuestion(), question.getAnswer());
        this.questions.add(newQuestion);
        return null;
    }


    @Override
    public Question removeQuestion(Question question) {
        this.questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size() + 1);
        Question[] question = questions.toArray(new Question[questions.size()]);
        return question[index];
    }
}
