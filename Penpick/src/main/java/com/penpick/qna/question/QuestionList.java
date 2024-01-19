package com.penpick.qna.question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionList {

    private Long questionNum;
    private String title;
    private String content;
    private int viewCount;
    private String createdDate;
    private String modifiedDate;
    private String writerNickname;

    @Builder
    public QuestionList(Long questionNum, String title, String content, int viewCount, String createdDate, String modifiedDate, String writerNickname) {
        this.questionNum = questionNum;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.writerNickname = writerNickname;
    }

    public static QuestionList fromEntity(Question question) {
        return QuestionList.builder()
                .questionNum(question.getQuestionNum())
                .title(question.getTitle())
                .content(question.getContent())
                .viewCount(question.getViewCount())
                .createdDate(question.getCreatedDate())
                .modifiedDate(question.getModifiedDate())
                .writerNickname(question.getModifiedDate())
                .build();
    }
}
