
import model.Conteudo;
import model.Estatisticas;
import model.Publicacao;

import port.InterfaceMidiaSocial;

import core.RespostaApi;

import factory.SocialMediaFactory;


public class MainApp {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Teste do Sistema de Midia Social ---");

        try {
            
            System.out.println("-> Fabrica criando plataforma 'twitter'...");
            InterfaceMidiaSocial plataformaTwitter = SocialMediaFactory.criarPlataforma("twitter");

            System.out.println("-> Fabrica criando plataforma 'instagram'...");
            InterfaceMidiaSocial plataformaInsta = SocialMediaFactory.criarPlataforma("instagram");


            System.out.println("\n[TESTE 1: Plataforma = Twitter]");
            
            Conteudo meuPostTwitter = new Conteudo(
                "Postando com a FACTORY! Muito mais limpo! #designpatterns", 
                "http://link.com/factory.png"
            );

            System.out.println("-> Tentando postar no Twitter...");
            RespostaApi<Publicacao> respostaPost = plataformaTwitter.postar(meuPostTwitter);

            if (respostaPost.isSucesso()) {
                Publicacao pubTwitter = respostaPost.getDados();
                System.out.println("-> Postagem do Twitter criada com sucesso!");
                System.out.println("   ID da Publicacao: " + pubTwitter.getIdPost());

                System.out.println("\n-> Buscando estatisticas do Twitter...");
                RespostaApi<Estatisticas> respostaStats = plataformaTwitter.obterEstatisticas(pubTwitter.getIdPost());

                if (respostaStats.isSucesso()) {
                    System.out.println("-> Estatisticas recebidas:");
                    System.out.println("   " + respostaStats.getDados().toString());
                } else {
                    System.err.println("   FALHA AO BUSCAR ESTATISTICAS: " + respostaStats.getMensagemErro());
                }
            } else {
                System.err.println("   FALHA AO POSTAR NO TWITTER: " + respostaPost.getMensagemErro());
            }
            System.out.println("\n--- Teste do Twitter Finalizado ---");


            System.out.println("\n[TESTE 2: Plataforma = Instagram]");
            
            Conteudo postDoInsta = new Conteudo(
                "Postando no Insta com a Factory! #java", 
                "http://servidor-de-imagens.com/factory-pic.jpg"
            );

            System.out.println("-> Tentando postar no Instagram...");
            RespostaApi<Publicacao> respostaPostInsta = plataformaInsta.postar(postDoInsta);

            if (respostaPostInsta.isSucesso()) {
                Publicacao pubInsta = respostaPostInsta.getDados();
                System.out.println("-> Postagem do Instagram criada com sucesso!");
                System.out.println("   ID da Publicacao: " + pubInsta.getIdPost());

                System.out.println("\n-> Buscando estatisticas do Instagram...");
                RespostaApi<Estatisticas> respostaStatsInsta = plataformaInsta.obterEstatisticas(pubInsta.getIdPost());

                if (respostaStatsInsta.isSucesso()) {
                    System.out.println("-> Estatisticas recebidas:");
                    System.out.println("   " + respostaStatsInsta.getDados().toString());
                } else {
                    System.err.println("   FALHA AO BUSCAR ESTATISTICAS: " + respostaStatsInsta.getMensagemErro());
                }
            } else {
                System.err.println("   FALHA AO POSTAR NO INSTAGRAM: " + respostaPostInsta.getMensagemErro());
            }
            System.out.println("\n--- Teste do Instagram Finalizado ---");

            System.out.println("\n[TESTE 3: Postagem Falha no Instagram (Esperado)]");
            
            Conteudo postFalhoInsta = new Conteudo("Este post vai falhar.", null);

            System.out.println("-> Tentando postar conteudo invalido no Instagram...");
            RespostaApi<Publicacao> respostaFalha = plataformaInsta.postar(postFalhoInsta);

            if (respostaFalha.isSucesso()) {
                System.err.println("   ERRO NO TESTE: A postagem deveria ter falhado.");
            } else {
                System.out.println("-> Falha controlada recebida com sucesso!");
                System.out.println("   Mensagem de Erro: " + respostaFalha.getMensagemErro());
            }
            System.out.println("\n--- Teste de Falha Finalizado ---");

        
        } catch (IllegalArgumentException e) {

            System.err.println("\n--- ERRO FATAL NA CONFIGURACAO ---");
            System.err.println("Erro ao inicializar plataforma: " + e.getMessage());
        }
    }
}