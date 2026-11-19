public final class Main {
    public static void main(String[] args) {
        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        AuditorLances auditor = new AuditorLances();

        Lote quadro = new Lote("Quadro", "Arte", 1000, 1150, new ComissaoArte());
        Lote notebook = new Lote("Notebook", "Eletronicos", 2000, 5000, new ComissaoEletronicos());
        for (Lote lote : new Lote[]{quadro, notebook}) {
            lote.acompanhar(ana);
            lote.acompanhar(bruno);
            lote.acompanhar(carla);
            lote.acompanhar(painel);
            lote.acompanhar(auditor);
        }

        quadro.darLance(ana, 1020);   
        quadro.darLance(ana, 1100);  
        quadro.darLance(bruno, 1200); 
        quadro.deixarDeAcompanhar(carla);
        System.out.println("Carla deixou de acompanhar Quadro.");
        quadro.darLance(carla, 1300); 
        quadro.trocarRegraComissao(new ComissaoEletronicos());
        System.out.println("Campanha: Quadro passa a usar comissao de Eletronicos.");
        quadro.encerrar();
        quadro.darLance(ana, 1400); 

        notebook.darLance(bruno, 2100); 
        notebook.darLance(carla, 2150); 
        notebook.encerrar();

        
        Fatura fatura = new FaturaBasica(quadro);
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura.imprimir();
        auditor.imprimirRegistros();
    }
}
