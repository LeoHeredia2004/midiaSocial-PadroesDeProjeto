package simulacoes_api;

public class TwitterMetrics{
    private int retweets;
    private int favorites; //no twitter nao é likes, se chama favorties

    public TwitterMetrics(int retweets, int favorites) {
        this.retweets = retweets;
        this.favorites = favorites;
    }
    
    public int getRetweets() { return retweets; }
    public int getFavorites() { return favorites; }
}
