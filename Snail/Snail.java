package Snail;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Snail {

    // Método que inicia o processamento da matriz no formato snail
    public static List<Integer> snail(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        // Verifica se a matriz é nula ou vazia
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            System.out.println("A matriz está vazia.");
            return resultado;
        }
        // Chama o método recursivo para começar a processar a matriz
        return snailRecursive(matriz, 0, matriz.length, 0, matriz[0].length, resultado);
    }

    // Método recursivo para processar a matriz em formato snail
    private static List<Integer> snailRecursive(int[][] matriz, int topo, int base, int esquerda, int direita, List<Integer> resultado) {
        // Condição de parada da recursão
        if (esquerda >= direita || topo >= base) {
            return resultado;
        }

        // Processa a linha superior da esquerda para a direita
        for (int i = esquerda; i < direita; i++) {
            resultado.add(matriz[topo][i]);
        }
        topo++; // Move o limite superior para baixo

        // Processa a coluna direita de cima para baixo
        for (int i = topo; i < base; i++) {
            resultado.add(matriz[i][direita - 1]);
        }
        direita--; // Move o limite direito para a esquerda

        // Processa a linha inferior da direita para a esquerda, se ainda houver linhas
        if (topo < base) {
            for (int i = direita - 1; i >= esquerda; i--) {
                resultado.add(matriz[base - 1][i]);
            }
            base--; // Move o limite inferior para cima
        }

        // Processa a coluna esquerda de baixo para cima, se ainda houver colunas
        if (esquerda < direita) {
            for (int i = base - 1; i >= topo; i--) {
                resultado.add(matriz[i][esquerda]);
            }
            esquerda++; // Move o limite esquerdo para a direita
        }

        // Recursão para processar a próxima camada interna
        return snailRecursive(matriz, topo, base, esquerda, direita, resultado);
    }

    // Método para imprimir a matriz de forma legível
    private static void printMatriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            System.out.println("Matriz vazia.");
            return;
        }
        System.out.println("Matriz inicial:");
        for (int[] linha : matriz) {
            System.out.println(Arrays.toString(linha));
        }
    }

    // Método principal para testar a funcionalidade com exemplos
    public static void main(String[] args) {
        int[][] matriz1 = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };

        int[][] matriz2 = {};

        System.out.println("Exemplo 1:");
        printMatriz(matriz1);
        List<Integer> ordemSnail1 = snail(matriz1);
        System.out.println("Caminho percorrido: " + ordemSnail1);

        System.out.println("\nExemplo 2:");
        printMatriz(matriz2);
        List<Integer> ordemSnail2 = snail(matriz2);
        if (ordemSnail2.isEmpty()) {
            System.out.println("A lista de resultados está vazia.");
        }
    }
}
