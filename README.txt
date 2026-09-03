Como compilar e executar:

1. Abra um terminal na pasta "src".
2. Compile todas as classes:
   javac *.java
3. Execute a classe principal:
   java Main
4. Responda às perguntas no console (tipo de transporte, valores, destino,
   dias, margem de lucro, taxas adicionais, dados do cliente e cotação do dólar).

Estrutura:
- Transporte.java     -> tipo e valor do transporte
- Hospedagem.java      -> descrição e valor da diária
- PacoteViagem.java    -> transporte + hospedagem + destino + dias
                          (calcula total de hospedagem, valor com margem e total do pacote)
- Venda.java           -> cliente + forma de pagamento + pacote
                          (converte para reais e mostra o resumo da venda)
- Main.java            -> interação com o usuário via console

para mais informações: https://github.com/Sajoco-afk/Empresa_de_viagens