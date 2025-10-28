package simulacoes_api;

public class InstagramAnalytics {
    private int likes;
    private int commentsCount;

    public InstagramAnalytics(int likes, int commentsCount) {
        this.likes = likes;
        this.commentsCount = commentsCount;
    }

    public int getLikes() { return likes; }
    public int getCommentsCount() { return commentsCount; }
}
