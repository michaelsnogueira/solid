package cotuba.plugin;

import cotuba.application.EbooksParaLeitura;

import java.util.ServiceLoader;

public interface AoFinalizarGeracao {

    static void gerou(EbooksParaLeitura ebook) {
        ServiceLoader.load(AoFinalizarGeracao.class)
                .forEach(aoFinalizarGeracao -> aoFinalizarGeracao.aposGeracao(ebook));
    }


    void aposGeracao(EbooksParaLeitura book);

}
