package webProgramming.recommendTravel.repository.communitypost;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;

import webProgramming.recommendTravel.domain.user.User;

import java.util.List;

public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
    List<CommunityPost> findByUser(User user);

    void deleteByUser(User user);

    CommunityPost findBypostId(Long postId);
}
