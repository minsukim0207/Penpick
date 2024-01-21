package com.penpick.qna.question;

import com.penpick.users.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public ResponseEntity<Page<ResQuestionList>> questionList(@PageableDefault(size = 10, sort = "questionNum", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResQuestionList> list = questionService.getAllQuestion(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/write")
    public ResponseEntity<ResCreateQuestion> writeQuestion(
            @RequestBody CreateQuestion question, Users user) {
        //Thread currentThread = Thread.currentThread();
        //log.info("Excuting thread: " + currentThread.getName());
        ResCreateQuestion saveQuestion = questionService.createQuestion(question, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveQuestion);
    }

    @GetMapping("/{questionNum}")
    public ResponseEntity<ResQuestionDetails> detailQuestion(@PathVariable("questionNum") Long questionNum) {
        ResQuestionDetails findQuestion = questionService.detailsQuestion(questionNum);
        return ResponseEntity.status(HttpStatus.OK).body(findQuestion);
    }

    @PatchMapping("/update/{questionNum}")
    public ResponseEntity<ResQuestionDetails> updateQuestion(
            @PathVariable Long questionNum,
            @RequestBody QuestionUpdate questionUpdate) {
        ResQuestionDetails updateQuestion = questionService.updateQuestion(questionNum, questionUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(updateQuestion);
    }

    @DeleteMapping("/delete/{questionNum}")
    public ResponseEntity<Long> deleteQuestion(@PathVariable Long questionNum) {
        questionService.deleteQuestion(questionNum);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
