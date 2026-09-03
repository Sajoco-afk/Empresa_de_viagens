import java.util.Locale;

public class Hospedagem {

    private String descricao;    // ex: "Hotel 4 estrelas", "Pousada"
    private double valorDiaria;  // valor em dólar

    public Hospedagem(String descricao, double valorDiaria) {
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Hospedagem: " + descricao + " (US$ " + String.format(Locale.US, "%.2f", valorDiaria) + "/diária)";
    }
}
