package webProgramming.recommendTravel.domain.communitypost;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import webProgramming.recommendTravel.domain.user.User;

import java.util.Date;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommunityPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "cid")
    private User user;

    @Column(nullable = false, length = 4)
//    @Column
    private String mbti_type;
    @Column(nullable = false, length = 100)
//    @Column
    private String title;
    @Column(nullable = false, length = 350)
//    @Column
    private String content;
    @Column(nullable = false)
//    @Column
    private Date timestamp;

    public CommunityPost(Long postId, Optional<User> tempuser, String mbtiType, String title, String content, Date currentDate) {
    }
}
