package cotuba.domain;

import cotuba.application.CapitulosSoParaLeitura;

public class Capitulo implements CapitulosSoParaLeitura {
    private String titulo;

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getConteudoHtml() {
        return null;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudoHTML() {
        return conteudoHTML;
    }

    private String conteudoHTML;

    public void setConteudoHTML(String conteudoHTML) {
        this.conteudoHTML = conteudoHTML;
    }
//	getters	e	setters...
}
