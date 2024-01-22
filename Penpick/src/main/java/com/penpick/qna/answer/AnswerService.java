package com.penpick.qna.answer;

import com.penpick.qna.common.ResourceNotFoundException;
import com.penpick.qna.question.Question;
import com.penpick.qna.question.QuestionRepository;
import com.penpick.users.Users;
import com.penpick.users.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Page<ResAnswer> getAllAnswers(Pageable pageable, Long questionNum) {
        Page<Answer> answers = answerRepository.findAllWithUserNQuestion(pageable, questionNum);
        List<ResAnswer> answerList = answers.getContent().stream()
                .map(ResAnswer::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(answerList, pageable, answers.getTotalElements());
    }
}
