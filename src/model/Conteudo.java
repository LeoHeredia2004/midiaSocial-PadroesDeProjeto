package model;

public class Conteudo{
    private String titulo;
    private String urlMidia;

    public Conteudo(String titulo, String urlMidia){
        this.titulo = titulo;
        this.urlMidia = urlMidia;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getUrlMidia(){
        return urlMidia;
    }
}