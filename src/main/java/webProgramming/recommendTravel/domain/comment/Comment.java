package webProgramming.recommendTravel.domain.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;
import webProgramming.recommendTravel.domain.user.User;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "postId")
    private CommunityPost communityPost;
    @ManyToOne
    @JoinColumn(name = "cid")
    private User user;

    @Column(nullable = false, length = 200)
//    @Column
    private String content;
    @Column(nullable = false)
//    @Column
    private Date timestamp;
}