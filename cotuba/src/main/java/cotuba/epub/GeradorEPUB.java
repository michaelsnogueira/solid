package cotuba.epub;

import cotuba.application.GeradorEbook;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;

@Component
public class GeradorEPUB implements GeradorEbook {

    @Override
    public void gera(Ebook ebook) {
        var epub = new Book();

        for (Capitulo capitulo : ebook.getCapitulos()) {
            String html = capitulo.getConteudoHTML();
            String titulo = capitulo.getTitulo();
            epub.addSection("Capítulo",
                    new Resource(html.getBytes(),
                            MediatypeService.XHTML));    //	error:	cannot	find	symbol
        }

        var epubWriter = new EpubWriter();
        try {
            epubWriter.write(epub,
                    Files.newOutputStream(ebook.getArquivoDeSaida()));
        } catch (IOException ex) {
            throw new IllegalStateException(
                    "Erro	ao	criar	arquivo	EPUB:	"
                            + ebook.getArquivoDeSaida().toAbsolutePath(), ex);
        }

    }
}

