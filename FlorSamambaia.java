public class FlorSamambaia {
    public static String tentativaDesenhar(int r1, int x1,int y1,int r2,int x2,int y2) {
        // calcula o quadrado da distância entre os centros dos círculos
        int dx = x2 - x1;
        int dy = y2 - y1;
        int distSquared = dx * dx + dy * dy;

        // calcula o quadrado da soma dos raios
        int raioSoma = r1 + r2;
        int raioSumSquared = raioSoma * raioSoma;

        // verifica se o caçador pode alcançar a flor
        if (distSquared <= raioSumSquared) {
            return "RICO";
        } else {
            return "MORTO";
        }
    }

    public static void main(String[] args) {
        // teste
        System.out.println(tentativaDesenhar(0, 0, 1, 3, 3, 1));  // RICO
        System.out.println(tentativaDesenhar(0, 0, 5, 4, 4, 2));  // MORTO
    }
}
