package com.penpick.qna.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT q FROM Question q JOIN FETCH q.user")
    Page<Question> findAllWithMemberNComments(Pageable pageable);

    @Query(value = "SELECT q FROM Question q JOIN FETCH q.user WHERE q.questionNum = :questionNum")
    Optional<Question> findByIdWithUserNComments(Long questionNum);
}
