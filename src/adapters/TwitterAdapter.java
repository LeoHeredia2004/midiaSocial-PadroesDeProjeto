package adapters;

import simulacoes_api.ApiTwitter;
import simulacoes_api.Tweet;
import simulacoes_api.TwitterMetrics;

import port.InterfaceMidiaSocial;

import model.*;

import java.time.LocalDateTime;

import core.RespostaApi;

public class TwitterAdapter implements InterfaceMidiaSocial {
    private final ApiTwitter twitter;

    public TwitterAdapter(ApiTwitter twitter){
        this.twitter = twitter;

        this.twitter.authenticate("API_KEY_EXAMPLE", "API_SECRET_EXAMPLE");
    }

    @Override
    public RespostaApi<Publicacao> postar(Conteudo conteudo){
        String textoPraTweet = conteudo.getTitulo();
        if(conteudo.getUrlMidia() != null && !conteudo.getUrlMidia().isEmpty()){
            textoPraTweet += " " + conteudo.getUrlMidia();
        }

        Tweet tweetPronto = new Tweet(textoPraTweet);

        String idTweet = twitter.sendTweet(tweetPronto);

        Publicacao publicacao = new Publicacao(
            idTweet,
            LocalDateTime.now(),
            conteudo.getUrlMidia(),
            conteudo
        );

        return RespostaApi.comSucesso(publicacao);
    }

    @Override
    public RespostaApi<Estatisticas> obterEstatisticas(String idPost){
        TwitterMetrics statsTwitter = twitter.getTweetStats(idPost);

        Estatisticas estatisticas = new Estatisticas(
            statsTwitter.getFavorites(),
            statsTwitter.getRetweets(),
            0
        );

        return RespostaApi.comSucesso(estatisticas);

    }
}
