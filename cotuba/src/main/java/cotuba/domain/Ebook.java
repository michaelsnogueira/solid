package cotuba.domain;

import cotuba.application.EbooksParaLeitura;

import java.nio.file.Path;
import java.util.List;

public class Ebook implements EbooksParaLeitura {
    private FormatoEbook formato;
    private Path arquivoDeSaida;


    public boolean isUltimoCapitulo(Capitulo capitulo) {
        return this.capitulos.get(this.capitulos.size() - 1)
                .equals(capitulo);
    }

    public FormatoEbook getFormato() {
        return formato;
    }

    @Override
    public Path getArquivoSaida() {
        return null;
    }

    public void setFormato(FormatoEbook formato) {
        this.formato = formato;
    }

    public Path getArquivoDeSaida() {
        return arquivoDeSaida;
    }

    public void setArquivoDeSaida(Path arquivoDeSaida) {
        this.arquivoDeSaida = arquivoDeSaida;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    private List<Capitulo> capitulos;
}
