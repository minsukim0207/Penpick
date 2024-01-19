package com.penpick.qna.question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDetails {

    private Long questionNum;
    private String title;
    private String content;
    private int viewCount;
    private String writerNickname;
    private String createdDate;
    private String modifiedDate;

    @Builder
    public QuestionDetails(Long questionNum, String title, String content, int viewCount, String writerNickname, String createdDate, String modifiedDate) {
        this.questionNum = questionNum;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.writerNickname = writerNickname;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static QuestionDetails fromEntity(Question question) {
        return QuestionDetails.builder()
                .questionNum(question.getQuestionNum())
                .title(question.getTitle())
                .content(question.getContent())
                .viewCount(question.getViewCount())
                .writerNickname(question.getUser().getUserNickname())
                .createdDate(question.getCreatedDate())
                .modifiedDate(question.getModifiedDate())
                .build();
    }
}
