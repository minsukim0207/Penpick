package com.penpick.qna.answer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT a FROM Answer a JOIN FETCH a.user JOIN FETCH a.question q WHERE q.questionNum = :questionNum")
    Page<Answer> findAllWithUserNQuestion(Pageable pageable, Long questionNum);

    @Query(value = "SELECT a FROM Answer a JOIN FETCH a.user JOIN FETCH a.question q WHERE a.answerNum = :answerNum")
    Optional<Answer> findByIdWithUserNQuestion(Long answerNum);
}
