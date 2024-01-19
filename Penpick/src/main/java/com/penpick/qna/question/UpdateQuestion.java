package com.penpick.qna.question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateQuestion {

    private String title;
    private String content;

    @Builder
    public UpdateQuestion(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
