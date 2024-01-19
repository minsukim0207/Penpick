package com.penpick.qna.answer;

import com.penpick.qna.common.BaseTime;
import com.penpick.qna.question.Question;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Answer extends BaseTime {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="comment_seq")
    @SequenceGenerator(name="comment_seq", sequenceName="comment_seq", allocationSize=1)
    private Long answerNum;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_NUM")
    public Question question;

    @Builder
    public Answer(Long answerNum, String content, Question question) {
        this.answerNum = answerNum;
        this.content = content;
        this.question = question;
    }

    public void setQuestion(Question question) {
        this.question = question;
        question.getAnswers().add(this);
    }

    public void updateAnswer(String content) {
        this.content = content;
    }
}
