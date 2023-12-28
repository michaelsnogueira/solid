package cotuba.plugin;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.util.ServiceLoader;

public interface AoRedenrizarHtml {

    static void renderizou(Capitulo capitulo) {
        ServiceLoader.load(AoRedenrizarHtml.class)
                .forEach(plugin -> {
                    String html = capitulo.getConteudoHTML();
                    String htmlModificado = plugin.aposRenderizacao(html);
                    capitulo.setConteudoHTML(htmlModificado);
                });
    }

    String aposRenderizacao(String html);


}
