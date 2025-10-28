package simulacoes_api;

import java.time.LocalDateTime;



public class ApiTwitter {
    public void authenticate(String apiKey, String apiSecret) {
        System.out.println("Twitter: Autenticado com " + apiKey);
    }

    public String sendTweet(Tweet tweet) {
        System.out.println("Twitter: Postando...");
        System.out.println("-> " + tweet.getConteudo());
        
        String idDoTweet = "tw_" + Math.abs(tweet.getConteudo().hashCode());
        System.out.println("Twitter: Postado com ID: " + idDoTweet);
        return idDoTweet;
    }

    public TwitterMetrics getTweetStats(String tweetId) {
        System.out.println("Twitter: Buscando métricas para " + tweetId);
        int fakesRT = tweetId.length() * 3;
        int fakesFav = tweetId.length() * 5;
        return new TwitterMetrics(fakesRT, fakesFav);
    }
}
