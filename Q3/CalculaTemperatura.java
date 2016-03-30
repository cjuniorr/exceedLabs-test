package iFactory;

import java.awt.List;

public class CalculaTemperatura {

    public double closestToZero(double[] b) {
        double vlrPos = 0;
        double vlrNeg = 0;
        double valor = 0;
        int qtdZero = 0;
        int tamanhoVetor = 0;

        for (int i = 0; i <= b.length - 1; i++) { // 0 1 2 3 4 5 6
            if (b[i] == 0) {
                qtdZero++;
            }
        }

        if (qtdZero == b.length) { // se qtdZero for o tamanho do vetor, então
                                    // vetor é vazio; retorna 0;
            return 0;
        } else {

            for (int y = 0; y <= b.length - 1; y++) {
                if (b[y] >= 0 && b[y] <= 5526) {
                    tamanhoVetor++;
                }
            }

            double vetPos[] = new double[tamanhoVetor];

            tamanhoVetor = 0;

            for (int y = 0; y <= b.length - 1; y++) {
                if (b[y] <= 0 && b[y] >= -273) {
                    tamanhoVetor++;
                }
            }

            double vetNeg[] = new double[tamanhoVetor];

            int w = 0;
            int t = 0;

            for (int x = 0; x <= b.length - 1; x++) { // preenche o vetor
                                                        // positivos somente com
                                                        // valores positivos
                if (b[x] >= 0 && b[x] < 5526) {
                    vetPos[w] = b[x];
                    w++;
                }
                if (b[x] < 0 && b[x] >= -273) { // preenche o vetor negativo
                                                // somente com valores negativos
                    vetNeg[t] = b[x];
                    t++;
                }
            }

            double menorPositivo = vetPos[0];

            for (int i = 0; i <= vetPos.length - 1; i++) {
                if (vetPos[i] < menorPositivo) {
                    menorPositivo = vetPos[i];
                }
            }

            double maiorNegativo = vetNeg[0];

            for (int i = 0; i <= vetNeg.length - 1; i++) {
                if (vetNeg[i] > maiorNegativo) {
                    maiorNegativo = vetNeg[i];
                }
            }

            System.out.println(maiorNegativo);
            System.out.println(menorPositivo);

            if((menorPositivo + maiorNegativo ) == 0){ //verifica se o valor positivo e o valor negativo são opostos
                return menorPositivo;
            }else{

                valor = Math.min(menorPositivo,maiorNegativo );
            }

            return valor;
        }
    }
}
