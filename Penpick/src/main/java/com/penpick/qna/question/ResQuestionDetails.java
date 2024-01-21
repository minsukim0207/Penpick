package com.penpick.qna.question;

import com.penpick.qna.answer.ResAnswer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ResQuestionDetails {

    private Long questionNum;
    private String title;
    private String content;
    private int viewCount;
    private String writerNickname;
    private String createdDate;
    private String modifiedDate;
    private List<ResAnswer> answers;

    @Builder
    public ResQuestionDetails(Long questionNum, String title, String content, int viewCount, String writerNickname, String createdDate, String modifiedDate, List<ResAnswer> answers) {
        this.questionNum = questionNum;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.writerNickname = writerNickname;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.answers= answers;
    }

    public static ResQuestionDetails fromEntity(Question question) {
        return ResQuestionDetails.builder()
                .questionNum(question.getQuestionNum())
                .title(question.getTitle())
                .content(question.getContent())
                .viewCount(question.getViewCount())
                .writerNickname(question.getUser().getUserNickname())
                .createdDate(question.getCreatedDate())
                .modifiedDate(question.getModifiedDate())
                .answers(question.getAnswers().stream()
                        .map(ResAnswer::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}


