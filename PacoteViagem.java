import java.util.Locale;

public class PacoteViagem {

    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantidadeDias;

    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, int quantidadeDias) {
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
    }

    // ---- Getters e Setters ----

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    // ---- Regras de negócio ----

        public double calcularTotalHospedagem() {
        return hospedagem.getValorDiaria() * quantidadeDias;
    }

  
    public double calcularValorComMargem(double valor, double margemPercentual) {
        return valor + (valor * margemPercentual / 100.0);
    }

   
    public double calcularTotalPacote(double margemPercentual, double taxasAdicionais) {
        double somaBase = transporte.getValor() + calcularTotalHospedagem() + taxasAdicionais;
        return calcularValorComMargem(somaBase, margemPercentual);
    }

    @Override
    public String toString() {
        return "Pacote de viagem para " + destino + " (" + quantidadeDias + " dias)\n" +
                "  " + transporte + "\n" +
                "  " + hospedagem + "\n" +
                "  Total de hospedagem: US$ " + String.format(Locale.US, "%.2f", calcularTotalHospedagem());
    }
}
