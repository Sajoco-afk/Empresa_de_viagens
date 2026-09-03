import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // facilita a leitura de números com ponto decimal

        System.out.println("===== Cadastro de venda de pacote de viagem =====\n");

        // ---- 1. Dados do transporte ----
        System.out.println("--- Transporte ---");
        System.out.print("Tipo de transporte Aéreo, Rodoviário, Rarítimo etc...: ");
        String tipoTransporte = sc.nextLine();
        System.out.print("Valor do transporte (US$): ");
        double valorTransporte = lerDouble(sc);
        Transporte transporte = new Transporte(tipoTransporte, valorTransporte);

        // ---- 2. Dados da hospedagem ----
        System.out.println("\n--- Hospedagem ---");
        System.out.print("Descrição da hospedagem: 1 a 5 Estelas: "); 
        String descricaoHospedagem = sc.nextLine();
        System.out.print("Valor da diária (US$): ");
        double valorDiaria = lerDouble(sc);
        Hospedagem hospedagem = new Hospedagem(descricaoHospedagem, valorDiaria);

        // ---- 3. Dados do pacote de viagem ----
        System.out.println("\n--- Pacote de viagem ---");
        System.out.print("Destino: ");
        String destino = sc.nextLine();
        System.out.print("Quantidade de dias: ");
        int quantidadeDias = lerInt(sc);

        PacoteViagem pacote = new PacoteViagem(transporte, hospedagem, destino, quantidadeDias);

        // ---- 4. Exibe o pacote criado ----
        System.out.println("\n===== Pacote criado =====");
        System.out.println(pacote);

        System.out.print("\nInforme a margem de lucro desejada (%): ");
        double margemLucro = lerDouble(sc);
        System.out.print("Informe as taxas adicionais (US$): ");
        double taxasAdicionais = lerDouble(sc);

        double totalPacote = pacote.calcularTotalPacote(margemLucro, taxasAdicionais);
        System.out.printf(Locale.US, "Valor total do pacote (com margem e taxas): US$ %.2f%n", totalPacote);

        // ---- 5. Dados da venda ----
        System.out.println("\n--- Dados da venda ---");
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.print("Forma de pagamento: ");
        String formaPagamento = sc.nextLine();

        Venda venda = new Venda(nomeCliente, formaPagamento, pacote);

        System.out.print("Informe a cotação do dólar hoje (R$): ");
        double cotacaoDolar = lerDouble(sc);

        // ---- 6. Exibe as informações completas da venda ----
        System.out.println();
        venda.mostrarInformacoes(margemLucro, taxasAdicionais, cotacaoDolar);

        sc.close();
    }

    //para BR e EUA usar
    private static double lerDouble(Scanner sc) {
        String entrada = sc.nextLine().trim().replace(",", ".");
        return Double.parseDouble(entrada);
    }

   //tentativa pra ler numeros inteiros
    private static int lerInt(Scanner sc) {
        String entrada = sc.nextLine().trim();
        return Integer.parseInt(entrada);
    }
}
