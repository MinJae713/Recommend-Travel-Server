package webProgramming.recommendTravel.service.community;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.common.TokenParser;
import webProgramming.recommendTravel.domain.comment.Comment;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.repository.comment.CommentRepository;
import webProgramming.recommendTravel.repository.communitypost.CommunityPostRepository;
import webProgramming.recommendTravel.repository.user.UserRepository;

import java.util.*;

@Service
@Slf4j
public class CommunityService
{
    private CommunityPostRepository communityPostRepository;
    private UserRepository userRepository;

    private CommentRepository commentRepository;

    @Autowired
    public void CommunityPostRepository(CommunityPostRepository communityPostRepository) {this.communityPostRepository = communityPostRepository;}
    @Autowired
    public void UserRepository(UserRepository userRepository) {this.userRepository = userRepository;}
    @Autowired
    public void CommentRepository(CommentRepository commentRepository) {this.commentRepository = commentRepository;}

    public CommunityPost makePost(String token, String title, String content)
    {
        String userid = TokenParser.extractUserIdFromToken(token);

        Optional<User> tempuser = userRepository.findByUserid(userid);

        Date currentDate = new Date();

        if (tempuser == null) {
            throw new RuntimeException("User not found");
        }

        CommunityPost newPost = new CommunityPost(null, tempuser, tempuser.orElse(null).getMbti_type(), title, content, currentDate);
        communityPostRepository.save(newPost);
        return newPost;
}

    public Comment addComment(String token, Long postId, String content)
    {
        String userid = TokenParser.extractUserIdFromToken(token);
        boolean checkUser = false;

        for(User u : userRepository.findAll())
        {
            if(u.getUserid().equals(userid));
            {
                checkUser = true;
            }
        }
        if(checkUser)
        {
            Optional<User> user = userRepository.findByUserid(userid);
            CommunityPost checkPost = communityPostRepository.findBypostId(postId);
            Date currentDate = new Date();;
            if (checkPost == null) { throw new RuntimeException("null Post"); }
            Comment newComment = new Comment(null, checkPost, user, content, currentDate);
            commentRepository.save(newComment);
            return newComment;
        }
        return null;
    }

    public List<CommunityPost> getPosts()
    {
        return new ArrayList<>(communityPostRepository.findAll());
    }
    public CommunityPost getPostInfo(Long postid)
    {
        return communityPostRepository.findBypostId(postid);
    }

    public List<Comment> getPostCommentInfo(Long postid)
    {
        List<Comment> retList = new ArrayList<>();

        for (Comment c : commentRepository.findAll())
        {
            if (c.getCommunityPost().getPostId().equals(postid)) { retList.add(c); }
        }

        return retList;
    }
}
