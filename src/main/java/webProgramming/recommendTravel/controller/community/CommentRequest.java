package webProgramming.recommendTravel.controller.community;

public class CommentRequest
{
    private Long postid;
    private String content;
    private String token;

    public CommentRequest( String token, Long postid, String content)
    {
        this.postid = postid;
        this.content = content;
        this.token = token;
    }

    public Long getPostid() { return postid; }
    public String getContent() { return content; }
    public String getToken() { return token; }
}
