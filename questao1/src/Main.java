public final class Main {
    public static void main(String[] args) throws InterruptedException {

        FabricaNuvem aws = new FabricaAws();
        FabricaNuvem azure = new FabricaAzure();
        Provisionador pAws = new Provisionador(aws);
        Provisionador pAzure = new Provisionador(azure);

        Thread t1 = new Thread(() -> pAws.provisionar(new Solicitacao("site-aws", "Aws", 1, 50)));
        Thread t2 = new Thread(() -> pAzure.provisionar(new Solicitacao("api-azure", "Azure", 1, 100)));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        pAws.provisionar(new Solicitacao("dados-aws", "Aws", 2, 100));
        pAws.provisionar(new Solicitacao("grande-demais", "Aws", 3, 100));
        Auditoria.getInstancia().imprimirHistorico();
    }
}
