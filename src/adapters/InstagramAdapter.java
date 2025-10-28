package adapters;

import simulacoes_api.ApiInstagram;
import simulacoes_api.IgMedia;
import simulacoes_api.IgPostReceipt;
import simulacoes_api.InstagramAnalytics;

import model.Conteudo;
import model.Estatisticas;
import model.Publicacao;
import port.InterfaceMidiaSocial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import core.RespostaApi;

public class InstagramAdapter implements InterfaceMidiaSocial{
    private ApiInstagram instagramApi;

    public InstagramAdapter(ApiInstagram instagramApi){
        this.instagramApi = instagramApi;
        this.instagramApi.connect("meu-auth-token-secreto");
    }

    @Override
    public RespostaApi<Publicacao> postar(Conteudo conteudo){
        String url = conteudo.getUrlMidia();
        String legenda = conteudo.getTitulo();

        if (url == null || url.isEmpty()) {
                    return RespostaApi.comFalha("URL da mídia não pode ser nula ou vazia para o Instagram.");
                }


        IgMedia igMedia = new IgMedia(url, legenda);

        IgPostReceipt recibo = instagramApi.publishMedia(igMedia);
        long idDoInsta = recibo.getId();

        String idFinal = String.valueOf(recibo.getId());
        
        LocalDateTime dataFinal = LocalDateTime.parse(recibo.getTimestamp());
        
        String urlDoPost = "https://instagram.com/p/" + idFinal;

        Publicacao publicacaoFinal = new Publicacao(
            idFinal,          
            dataFinal,        
            urlDoPost,        
            conteudo          
        );

        return RespostaApi.comSucesso(publicacaoFinal);
    }


    @Override
    public RespostaApi<Estatisticas> obterEstatisticas(String idPost){
        long mediaId = Long.parseLong(idPost);
        InstagramAnalytics analyticsDoInsta = instagramApi.fetchAnalytics(mediaId);

        int curtidas = analyticsDoInsta.getLikes();
        int comentarios = analyticsDoInsta.getCommentsCount();
        
        int compartilhamentos = 0; 

        Estatisticas estatisticasFinais = new Estatisticas(
            curtidas,
            compartilhamentos,
            comentarios
        );

        return RespostaApi.comSucesso(estatisticasFinais);
    }

}
