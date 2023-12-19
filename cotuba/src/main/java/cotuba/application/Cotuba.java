package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cotuba {

    private final RenderizadorMDParaHTML renderizador;
    private final GeradorEPUB geradorEPUB;
    private final GeradorPDF geradorPDF;

    public Cotuba(RenderizadorMDParaHTML renderizador, GeradorEPUB geradorEPUB, GeradorPDF geradorPDF) {
        this.renderizador = renderizador;
        this.geradorEPUB = geradorEPUB;
        this.geradorPDF = geradorPDF;
    }

    public void executa(ParametrosCotuba parametros) {
        List<Capitulo> capitulos =
                renderizador.renderiza(parametros.getDiretorioDosMD());
        Ebook ebook = new Ebook();
        ebook.setFormato(parametros.getFormato());
        ebook.setArquivoDeSaida(parametros.getArquivoDeSaida());
        ebook.setCapitulos(capitulos);
        if ("pdf".equals(parametros.getFormato())) {
            geradorPDF.gera(ebook);
        } else if ("epub".equals(parametros.getFormato())) {
            geradorEPUB.gera(ebook);
        } else {
            throw new IllegalArgumentException(
                    "Formato	do	ebook	inválido:	" + parametros.getFormato());
        }
    }
}
