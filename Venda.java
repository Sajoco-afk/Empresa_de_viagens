import java.util.Locale;

public class Venda {

    private String nomeCliente;
    private String formaPagamento;
    private PacoteViagem pacoteViagem;

    public Venda(String nomeCliente, String formaPagamento, PacoteViagem pacoteViagem) {
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.pacoteViagem = pacoteViagem;
    }

    // ---- Getters e Setters ----

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public PacoteViagem getPacoteViagem() {
        return pacoteViagem;
    }

    public void setPacoteViagem(PacoteViagem pacoteViagem) {
        this.pacoteViagem = pacoteViagem;
    }

    // ---- Regras de negócio ----
   
    public double converterParaReais(double valorDolar, double cotacaoDolar) {
        return valorDolar * cotacaoDolar;
    }


    public void mostrarInformacoes(double margemPercentual, double taxasAdicionais, double cotacaoDolar) {
        double totalDolar = pacoteViagem.calcularTotalPacote(margemPercentual, taxasAdicionais);
        double totalReais = converterParaReais(totalDolar, cotacaoDolar);

        System.out.println("----- Dados da venda -----");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Forma de pagamento: " + formaPagamento);
        System.out.println(pacoteViagem);
        System.out.printf(Locale.US, "Total do pacote em dólar: US$ %.2f%n", totalDolar);
        System.out.printf(Locale.US, "Total do pacote em reais: R$ %.2f%n", totalReais);
    }
}
