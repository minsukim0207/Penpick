package com.penpick.qna.question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResCreateQuestion {
    private Long questionNum;
    private String title;
    private String content;
    private String writerNickname;
    private String createdDate;

    @Builder
    public ResCreateQuestion(Long questionNum, String title, String content, String writerNickname, String createdDate) {
        this.questionNum = questionNum;
        this.title = title;
        this.content = content;
        this.writerNickname = writerNickname;
        this.createdDate = createdDate;
    }

    public static ResCreateQuestion fromEntity(Question question, String writerNickname) {
        return ResCreateQuestion.builder()
                .questionNum(question.getQuestionNum())
                .title(question.getTitle())
                .content(question.getContent())
                .writerNickname(question.getUser().getUserNickname())
                .createdDate(question.getCreatedDate())
                .build();
    }
}
