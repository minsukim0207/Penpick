package com.penpick.qna.question;

import com.penpick.qna.common.ResourceNotFoundException;
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
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UsersRepository usersRepository;

    public Page<ResQuestionList> getAllQuestion(Pageable pageable) {
        Page<Question> questions = questionRepository.findAllWithMemberNComments(pageable);
        List<ResQuestionList> list = questions.getContent().stream()
                .map(ResQuestionList::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, questions.getTotalElements());
    }

    public ResCreateQuestion createQuestion(CreateQuestion createQuestion, Users user) {
        Question question = CreateQuestion.ofEntity(createQuestion);
        Users createUser = usersRepository.findById(user.getUserNum()).orElseThrow(
                () -> new ResourceNotFoundException("User", "User Number", user.getUserNickname())
        );
        question.setMappingUser(createUser);
        Question saveQuestion = questionRepository.save(question);
        return ResCreateQuestion.fromEntity(saveQuestion, createUser.getUserNickname());
    }

    public ResQuestionDetails detailsQuestion(Long questionNum) {
        Question question = questionRepository.findByIdWithUserNComments(questionNum).orElseThrow(
                () -> new ResourceNotFoundException("Question", "Question Number", String.valueOf(questionNum))
        );
        question.increaseViewCount();
        return ResQuestionDetails.fromEntity(question);
    }

    public ResQuestionDetails updateQuestion(Long questionNum, QuestionUpdate question) {
        Question updateQuestion = questionRepository.findByIdWithUserNComments(questionNum).orElseThrow(
                () -> new ResourceNotFoundException("Question", "Question Number", String.valueOf(questionNum))
        );
        updateQuestion.updateCheck(question.getTitle(), question.getContent());
        return ResQuestionDetails.fromEntity(updateQuestion);
    }

    public void deleteQuestion(Long questionNum) {
        questionRepository.deleteById(questionNum);
    }
}
