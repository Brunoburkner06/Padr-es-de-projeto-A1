public interface FabricaNuvem {
    String getProvedor();
    double estimarCustoMensal(int quantidadeMaquinas, int gbArmazenamento);
    MaquinaVirtual criarMaquinaVirtual();
    Armazenamento criarArmazenamento();
    FilaMensagens criarFila();
}
