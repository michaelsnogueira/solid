package cotuba.application;

import cotuba.domain.FormatoEbook;

import java.nio.file.Path;
import java.util.List;

public interface EbooksParaLeitura {

    FormatoEbook getFormato();

    Path getArquivoSaida();

    List<? extends CapitulosSoParaLeitura> getCapitulos();

}
