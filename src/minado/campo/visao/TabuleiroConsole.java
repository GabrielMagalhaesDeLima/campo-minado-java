package minado.campo.visao;

import java.util.Scanner;

import minado.campo.excecao.ExplosaoException;
import minado.campo.excecao.SairException;
import minado.campo.modelo.Tabuleiro;

public class TabuleiroConsole {

    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;

            while (continuar) {
                cicloDoJogo();

                System.out.println("Outra partida? (S/n) ");
                String resposta = entrada.nextLine();

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (SairException e) {
            System.out.println("Tchau!");
        } finally {
            entrada.close();
        }
    }

    private void cicloDoJogo() {
        try {
            while (!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro);

                
                int x = -1, y = -1;
                while (true) {
                    String digitado = capturarValorDigitado("Digite (x,y): ");
                    String[] partes = digitado.split(",");

                    if (partes.length == 2) {
                        try {
                            x = Integer.parseInt(partes[0].trim());
                            y = Integer.parseInt(partes[1].trim());

                            if (x >= 0 && x < tabuleiro.getLinhas() &&
                                y >= 0 && y < tabuleiro.getColunas()) {
                                break; 
                            } else {
                                System.out.println("Coordenadas fora do tabuleiro!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas números!");
                        }
                    } else {
                        System.out.println("Formato inválido! Use x,y");
                    }
                }

               
                int acao = -1;
                while (true) {
                    String digitado = capturarValorDigitado("1 - abrir ou 2 - (des)marcar: ");
                    if ("1".equals(digitado) || "2".equals(digitado)) {
                        acao = Integer.parseInt(digitado);
                        break;
                    }
                    System.out.println("Opção inválida! Digite 1 ou 2.");
                }

               
                if (acao == 1) {
                    tabuleiro.abrir(x, y);
                } else {
                    tabuleiro.alternarMarcacao(x, y);
                }
            }

            System.out.println(tabuleiro);
            System.out.println("Você ganhou!!!!");

        } catch (ExplosaoException e) {
            System.out.println(tabuleiro);
            System.out.println("Você perdeu!");
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.print(texto);
        String digitado = entrada.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException();
        }

        return digitado;
    }
}