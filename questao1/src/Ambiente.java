import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final FilaMensagens fila;
    private final double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, FilaMensagens fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = Collections.unmodifiableList(new ArrayList<>(maquinas));
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }
    public void imprimirResumo() {
        System.out.println("\n=== AMBIENTE ACEITO ===");
        System.out.println("Nome: " + nome + " | Provedor: " + provedor + " | Regiao: " + regiao);
        for (MaquinaVirtual maquina : maquinas) {
            System.out.println("Maquina virtual: " + maquina.getIdentificador());
        }
        System.out.println("Armazenamento: " + armazenamento.getIdentificador());
        System.out.println("Fila: " + fila.getIdentificador());
        System.out.printf("Custo mensal estimado: R$ %.2f%n", custoMensal);
    }
}
