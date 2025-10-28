package factory;
import port.InterfaceMidiaSocial;


import adapters.TwitterAdapter;
import adapters.InstagramAdapter;

import simulacoes_api.*;

public class SocialMediaFactory {
    public static InterfaceMidiaSocial criarPlataforma(String tipoPlataforma) {
  
        if("twitter".equalsIgnoreCase(tipoPlataforma)) {
            
            ApiTwitter api = new ApiTwitter();
            InterfaceMidiaSocial adaptador = new TwitterAdapter(api);
            
            return adaptador;
        } else if("instagram".equalsIgnoreCase(tipoPlataforma)) {
            
            ApiInstagram api = new ApiInstagram();
            InterfaceMidiaSocial adaptador = new InstagramAdapter(api);
            
            return adaptador;
        } else {
            throw new IllegalArgumentException("Plataforma nao suportada: " + tipoPlataforma);
        }

    }
}
