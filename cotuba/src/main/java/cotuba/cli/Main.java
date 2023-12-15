package cotuba.cli;

import cotuba.application.Cotuba;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        boolean modoVerboso = false;
        try {
            var opcoesCLI = new LeitorOpcoesCLI(args);
            Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();
            String formato = opcoesCLI.getFormato();
            Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
            modoVerboso = opcoesCLI.isModoVerboso();
            var cotuba = new Cotuba();
            cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);
            System.out.println("Arquivo	gerado	com	sucesso:	"
                    + arquivoDeSaida);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (modoVerboso) {
                ex.printStackTrace();
            }
        }
        System.exit(1);
    }


}
