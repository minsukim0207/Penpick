package com.penpick.qna.question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionUpdate {
    private String title;
    private String content;

    @Builder
    public QuestionUpdate(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
