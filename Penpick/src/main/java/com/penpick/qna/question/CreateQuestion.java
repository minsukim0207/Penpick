package com.penpick.qna.question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateQuestion {

    private String title;
    private String content;

    public CreateQuestion(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public static Question ofEntity(CreateQuestion question) {
        return Question.builder()
                .title(question.title)
                .content(question.content)
                .build();
    }
}
