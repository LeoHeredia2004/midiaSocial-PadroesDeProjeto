package model;

import java.time.LocalDateTime;

public class Publicacao {
    private String id;
    private LocalDateTime data;
    private String urlPost;
    private Conteudo conteudo;

    public Publicacao(String id, LocalDateTime data, String urlPost, Conteudo conteudo){
        this.id = id;
        this.data = data;
        this.urlPost = urlPost;
        this.conteudo = conteudo;
    }

    public String getIdPost() {
        return id;
    }

    public LocalDateTime getDataPostagem() {
        return data;
    }

    public String getUrlPost() {
        return urlPost;
    }

    public Conteudo getConteudoOriginal() {
        return conteudo;
    }
}
