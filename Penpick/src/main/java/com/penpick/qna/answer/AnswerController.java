package com.penpick.qna.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question/{questionNum}/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/list")
    public ResponseEntity<Page<ResAnswer>>  answerList(
            @PathVariable Long questionNum,
            @PageableDefault(size = 10, sort = "questionNum", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResAnswer> answerList = answerService.getAllAnswers(pageable, questionNum);
        return ResponseEntity.status(HttpStatus.OK).body(answerList);
    }
}
