package com.skypro.examination.service;

import com.skypro.examination.exception.IllegalRequestException;
import com.skypro.examination.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void amountOfRequestedQuestionsIsSufficientToReturnResult() {
        List<Question> questionList = List.of(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3"),
                new Question("q4", "a4")
        );
        when(javaQuestionService.getAll()).thenReturn(questionList);
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(questionList.get(0), questionList.get(1));

        assertThat(examinerService.getQuestions(2))
                .hasSize(2)
                .containsOnly(questionList.get(0), questionList.get(1));
    }

    @Test
    void amountOfRequestedQuestionsIsUnSufficientAndTHroeException() {
        when(javaQuestionService.getAll()).thenReturn(Collections.emptyList());
        assertThatThrownBy(() -> examinerService.getQuestions(2)).isInstanceOf(IllegalRequestException.class);
    }
}
