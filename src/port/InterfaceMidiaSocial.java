package port;

import core.RespostaApi;
import model.*;

public interface InterfaceMidiaSocial {
    RespostaApi<Publicacao> postar(Conteudo conteudo);
    RespostaApi<Estatisticas> obterEstatisticas(String idPost);
}
