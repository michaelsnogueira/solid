package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.md.RenderizadorMDParaHTML;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cotuba {

    private final RenderizadorMDParaHTML renderizador;
//    private final GeradorEbook geradorEbook;

    public Cotuba(RenderizadorMDParaHTML renderizador) {
        this.renderizador = renderizador;
    }

    public void executa(ParametrosCotuba parametros) {
        List<Capitulo> capitulos =
                renderizador.renderiza(parametros.getDiretorioDosMD());
        Ebook ebook = new Ebook();
        ebook.setFormato(parametros.getFormato());
        ebook.setArquivoDeSaida(parametros.getArquivoDeSaida());
        ebook.setCapitulos(capitulos);
        var gerador = GeradorEbook.cria(parametros.getFormato());
        gerador.gera(ebook);

    }
}
