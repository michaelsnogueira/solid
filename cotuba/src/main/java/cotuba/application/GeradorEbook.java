package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

import java.util.HashMap;
import java.util.Map;

public interface GeradorEbook {
    void gera(Ebook ebook);

}
