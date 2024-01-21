package com.penpick.qna.answer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResAnswer {
    private Long answerNum;
    private String content;
    private String createdDate;
    private String modifiedDate;
    private String answerNickname;

    @Builder
    public ResAnswer(Long answerNum, String content, String createdDate, String modifiedDate, String answerNickname) {
        this.answerNum = answerNum;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.answerNickname = answerNickname;
    }

    public static ResAnswer fromEntity(Answer answer) {
        return ResAnswer.builder()
                .answerNum(answer.getAnswerNum())
                .content(answer.getContent())
                .createdDate(answer.getCreatedDate())
                .modifiedDate(answer.getModifiedDate())
                .answerNickname(answer.getUser().getUserNickname())
                .build();
    }
}
