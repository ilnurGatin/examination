package com.skypro.examination.model;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        questionAndAnswerCheck(question, answer);
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    private void questionAndAnswerCheck(String question, String answer) {
        if (question == null || answer == null) {
            throw new IllegalArgumentException("Question and answer can  not be null");
        }
        if (question.isBlank() || answer.isBlank()) {
            throw new IllegalArgumentException("Question or answer is illegal");
        }
    }

}
