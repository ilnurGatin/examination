package com.skypro.examination.service;

import com.skypro.examination.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        return question;
    }


    @Override
    public Question removeQuestion(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NoSuchElementException();
        }
        Random random = new Random();
        int number = random.nextInt(questions.size());
        return questions
                .stream()
                .skip(number)
                .findFirst()
                .orElseThrow();
    }
}
