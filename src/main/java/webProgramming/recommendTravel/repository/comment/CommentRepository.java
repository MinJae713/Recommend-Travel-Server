package webProgramming.recommendTravel.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.comment.Comment;

import webProgramming.recommendTravel.domain.communitypost.CommunityPost;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteByCommunityPost(CommunityPost post);
}
