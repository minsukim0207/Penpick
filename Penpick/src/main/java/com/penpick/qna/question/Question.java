package com.penpick.qna.question;

import com.penpick.qna.answer.Answer;
import com.penpick.qna.common.BaseTime;
import com.penpick.users.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
@Entity
public class Question extends BaseTime {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE/*, generator="board_seq"*/)
    //@SequenceGenerator(name="board_seq", sequenceName="board_seq", allocationSize=1)
    private Long questionNum;

    @Column(nullable = false)
    private String title;

    private String content;

    private int viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Users user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Answer> answers = new ArrayList<>();

    @Builder
    public Question(Long questionNum, String title, String content, int viewCount, Users user) {
        this.questionNum = questionNum;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.user = user;
    }

    public void increaseViewCount() {
        this.viewCount++;
    }

    public void updateCheck(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setMappingUser(Users user) {
        this.user = user;
    }
}
