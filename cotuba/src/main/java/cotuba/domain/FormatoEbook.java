package cotuba.domain;

import cotuba.application.GeradorEbook;
import cotuba.epub.GeradorEPUB;
import cotuba.html.GeradorHTML;
import cotuba.pdf.GeradorPDF;

public enum FormatoEbook {
    EPUB(new GeradorEPUB()), PDF(new GeradorPDF()), HTML(new GeradorHTML());

    private final GeradorEbook gerador;

    FormatoEbook(GeradorEbook gerador) {
        this.gerador = gerador;
    }

    public GeradorEbook getGerador() {
        return gerador;
    }
}
