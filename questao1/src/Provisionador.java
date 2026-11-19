import java.util.ArrayList;
import java.util.List;

public final class Provisionador {
    private final FabricaNuvem fabrica;
    public Provisionador(FabricaNuvem fabrica) { this.fabrica = fabrica; }

    public Ambiente provisionar(Solicitacao solicitacao) {
        String provedor = fabrica.getProvedor();
        if (!provedor.equals(solicitacao.getProvedor())) {
            String motivo = "Provedor da solicitacao difere da fabrica recebida";
            Auditoria.getInstancia().registrar(solicitacao.getNome(), solicitacao.getProvedor(), "RECUSADO", motivo);
            System.out.println("Solicitacao recusada: " + solicitacao.getNome() + " | " + motivo);
            return null;
        }

        double custo = fabrica.estimarCustoMensal(solicitacao.getQuantidadeMaquinas(),
                solicitacao.getGbArmazenamento());
        if (custo > Configuracao.getInstancia().getOrcamentoMaximo()) {
            String motivo = String.format("Orcamento excedido: R$ %.2f > R$ %.2f", custo,
                    Configuracao.getInstancia().getOrcamentoMaximo());
            Auditoria.getInstancia().registrar(solicitacao.getNome(), provedor, "RECUSADO", motivo);
            System.out.println("Solicitacao recusada: " + solicitacao.getNome() + " | " + motivo);
            return null;
        }
        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < solicitacao.getQuantidadeMaquinas(); i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento();
        FilaMensagens fila = fabrica.criarFila();
        Ambiente ambiente = new Ambiente(solicitacao.getNome(), provedor,
                Configuracao.getInstancia().getRegiao(), maquinas, armazenamento, fila, custo);
        Auditoria.getInstancia().registrar(solicitacao.getNome(), provedor, "ACEITO", "");
        ambiente.imprimirResumo();
        return ambiente;
    }
}
