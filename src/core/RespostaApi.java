package core;

public class RespostaApi<T> {
    private final boolean sucesso;
    private final T dados;
    private final String mensagemErro;

    private RespostaApi(boolean sucesso, T dados, String mensagemErro) {
        this.sucesso = sucesso;
        this.dados = dados;
        this.mensagemErro = mensagemErro;
    }

    public static <T> RespostaApi<T> comSucesso(T dados) {
        return new RespostaApi<>(true, dados, null);
    }

    public static <T> RespostaApi<T> comFalha(String mensagemErro) {
        return new RespostaApi<>(false, null, mensagemErro);
    }
    
    public boolean isSucesso() {
        return sucesso;
    }

    public boolean isFalha() {
        return !sucesso;
    }

    public T getDados() {
        return dados;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
    
}
