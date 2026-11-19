import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;


public final class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();
    private final String regiao;
    private final double orcamentoMaximo;

    private Configuracao() {
        Properties propriedades = new Properties();
        Path caminho = Path.of("config.properties");
        if (!Files.exists(caminho)) {
            caminho = Path.of("questao1", "config.properties");
        }
        try (InputStream entrada = Files.newInputStream(caminho)) {
            propriedades.load(entrada);
        } catch (IOException e) {
            throw new IllegalStateException("Nao foi possivel ler config.properties", e);
        }
        regiao = propriedades.getProperty("regiao");
        if (regiao == null || regiao.isBlank()) {
            throw new IllegalStateException("Regiao nao configurada");
        }
        try {
            orcamentoMaximo = Double.parseDouble(propriedades.getProperty("orcamento.maximo"));
        } catch (RuntimeException e) {
            throw new IllegalStateException("Orcamento invalido no config.properties", e);
        }
        if (!Double.isFinite(orcamentoMaximo) || orcamentoMaximo < 0) {
            throw new IllegalStateException("Orcamento deve ser positivo ou zero");
        }
    }
    public static Configuracao getInstancia() { return INSTANCIA; }
    public String getRegiao() { return regiao; }
    public double getOrcamentoMaximo() { return orcamentoMaximo; }
}
