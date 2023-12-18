package webProgramming.recommendTravel.controller.community;

public class PostRequest
{
    public String content;
    public String title;
    public String token;

    public PostRequest(String token, String title, String content)
    {
        this.title = title;
        this.content = content;
        this.token = token;
    }

    public String getContent() { return content; }
    public String gettitle() { return title; }
    public String getToken() { return token; }
}

