package webProgramming.recommendTravel.controller.community;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webProgramming.recommendTravel.domain.comment.Comment;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;
import webProgramming.recommendTravel.service.community.CommunityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequestMapping("/recommend-travel")
public class CommunityController
{
    public CommunityService communityService;
    @Autowired
    public void CommunityService(CommunityService communityService)
    {
        this.communityService = communityService;
    }

    @PostMapping("/create-post")
    public CommunityPost createPost(@RequestBody PostRequest postRequest)
    {
        CommunityPost newPost = communityService.makePost(postRequest.getToken(), postRequest.gettitle(), postRequest.getContent());

        return newPost;
    }

    @PostMapping("/add-comment")
    public Comment addComment(@RequestBody CommentRequest commentRequest)
    {
        Comment newComment = communityService.addComment(commentRequest.getToken(), commentRequest.getPostid(), commentRequest.getContent());

        return newComment;
    }

    @GetMapping("/posts")
    public List<CommunityPost> getPosts()
    {
        return communityService.getPosts();
    }

    @GetMapping("/getpostinfo")
    public Map<String,Object> getPostInfo(@RequestParam Long postid) {
        Map<String,Object> result = new HashMap<>();

        List<Comment> comments = communityService.getPostCommentInfo(postid);
        CommunityPost communityPost = communityService.getPostInfo(postid);

        result.put("PostInfo", communityPost);
        result.put("commentsInfo", comments);

        return result;
    }
}
