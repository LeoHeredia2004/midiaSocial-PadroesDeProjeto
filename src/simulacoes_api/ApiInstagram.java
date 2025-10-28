package simulacoes_api;
import java.time.LocalDateTime;

public class ApiInstagram {
    public boolean connect(String authToken) {
        System.out.println("Instagram: Conectado com token " + authToken.substring(0, 5) + "...");
        return true;
    }

    public IgPostReceipt publishMedia(IgMedia media) {
        if (media.getMediaUrl() == null || media.getMediaUrl().isEmpty()) {
            System.err.println("Instagram ERRO: Mídia é obrigatória!");
            return null; 
        }
        
        System.out.println("Instagram: Publicando...");
        System.out.println("-> Mídia: " + media.getMediaUrl());
        System.out.println("-> Legenda: " + media.getCaption());

        long generatedId = Math.abs(media.getMediaUrl().hashCode() * 1000L);
        String timestamp = LocalDateTime.now().toString();
        
        System.out.println("Instagram: Publicado com ID: " + generatedId);
        return new IgPostReceipt(generatedId, timestamp);
    }

    public InstagramAnalytics fetchAnalytics(long mediaId) {
        System.out.println("Instagram: Buscando analytics para " + mediaId);
        int fakeLikes = (int) (mediaId % 1000) * 10;
        int fakeComments = (int) (mediaId % 100) / 2;
        return new InstagramAnalytics(fakeLikes, fakeComments);
    }
}
