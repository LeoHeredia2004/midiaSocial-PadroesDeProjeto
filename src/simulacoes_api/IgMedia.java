package simulacoes_api;

public class IgMedia{
    private String mediaUrl;
    private String caption;

    public IgMedia(String mediaUrl, String caption) {
        this.mediaUrl = mediaUrl;
        this.caption = caption;
    }

    public String getMediaUrl() { return mediaUrl; }
    public String getCaption() { return caption; }

}