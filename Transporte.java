import java.util.Locale;


public class Transporte {

    private String tipo;   // Tipo de transporte
    private double valor;  // valor em dólar

    public Transporte(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transporte: " + tipo + " (US$ " + String.format(Locale.US, "%.2f", valor) + ")";
    }
}
