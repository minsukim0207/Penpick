package com.penpick.qna.answer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnswerDto {

    private String content;

    @Builder
    public AnswerDto(String content) {
        this.content = content;
    }

    public static Answer ofEntity(AnswerDto answerDto) {
        return Answer.builder()
                .content(answerDto.getContent())
                .build();
    }
}
