package simulacoes_api;

public class IgPostReceipt {
    private long id;
    private String timestamp;

    public IgPostReceipt(long id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
    
    public long getId() { return id; }
    public String getTimestamp() { return timestamp; }
}
