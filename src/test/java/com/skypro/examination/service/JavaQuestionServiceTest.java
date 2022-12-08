package com.skypro.examination.service;

import com.skypro.examination.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;
    private List<Question> questions = List.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4"),
            new Question("q5", "a5")
    );


    @BeforeEach
    void setUp() {
        this.javaQuestionService = new JavaQuestionService();
        questions.forEach(javaQuestionService :: add);
    }

    @Test
    void addQuestionTest() {
        Question expected = new Question("qTest", "aTest");
        Question actual = this.javaQuestionService.add(expected);
        assertThat(actual).isEqualTo(expected);
        assertThat(this.javaQuestionService.getAll()).hasSize(6).contains(expected);
    }
    
    @Test
    void removeQuestionTest() {
        Question expected = this.questions.get(0);
        Question actual = this.javaQuestionService.removeQuestion(expected);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getRandomQuestionTest() {
        Question actual = this.javaQuestionService.getRandomQuestion();
        assertThat(actual).isIn(questions);
    }

    @Test
    void getAllTest() {
        assertThat(this.javaQuestionService.getAll())
                .hasSize(5)
                .containsAll(this.questions);
    }

    @Test
    void getRandomQuestionWhenSetIsEmptyTest() {
        this.javaQuestionService = new JavaQuestionService();
        assertThat(javaQuestionService.getAll()).hasSize(0);
        assertThatThrownBy(() -> javaQuestionService.getRandomQuestion()).isInstanceOf(NoSuchElementException.class);

    }
}
