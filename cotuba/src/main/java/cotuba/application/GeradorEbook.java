package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

import java.util.HashMap;
import java.util.Map;

public interface GeradorEbook {

    Map<String, GeradorEbook> geradores = new HashMap<>() {{
        put("pdf", new GeradorPDF());
        put("epub", new GeradorEPUB());
    }};

    void gera(Ebook ebook);

    static GeradorEbook cria(FormatoEbook formato) {
        var gerador = geradores.get(formato.name().toLowerCase());
        if (gerador == null) {
            throw new IllegalArgumentException(
                    "Formato	do	ebook	inválido:	" + formato);
        }
        return gerador;
    }
}
