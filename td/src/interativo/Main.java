/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interativo;

import fonte.*;
import com.sun.org.apache.bcel.internal.generic.D2F;
import java.util.Stack;

/**
 *
 * @author ismae
 */
public class Main {

    public static int tempo;
    public static int matriz[][] = new int[4][4];
    public static No vetor[] = new No[4];
    public static void main(String[] args) {
        for (int i = 0; i < vetor.length; i++) {
            No a = new No("BRANCO");
            vetor[i] = a;
        }

        matriz[0][0] = 0;
        matriz[0][1] = 1;
        matriz[0][2] = 0;
        matriz[0][3] = 1;
        matriz[1][0] = 0;
        matriz[1][1] = 0;
        matriz[1][2] = 1;
        matriz[1][3] = 0;
        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 0;
        matriz[2][3] = 1;
        matriz[3][0] = 0;
        matriz[3][1] = 1;
        matriz[3][2] = 0;
        matriz[3][3] = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getCor() == "BRANCO") {
                DFS_VISIT(i);
            }
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(i + " I=" + vetor[i].getTemI() + " F=" + vetor[i].getTemF());
        }

    }

    public static void DFS_VISIT(int no) {
        //aqui pintava cinza
        PintaCinza(no);
        Stack<No> pilha = new Stack();
        int j = 0;
        while (j < vetor.length) {
            if (matriz[no][j] == 1) {
                if (vetor[j].getCor() == "BRANCO") {
                    No aux = new No();
                    aux.setId(no);
                    aux.setPararou(j);
                    pilha.add(aux);
                    PintaCinza(j);// aqui ele vai pintar o próximo nó 

                    //  DFS_VISIT(j);                   
                    no = j;
                    j = 0;
                }
            }
            if (j == vetor.length - 1 && pilha.empty() == false) {
                PintaPreto(no);
                No aux = pilha.pop();
                no = aux.getId();
                j = aux.getPararou();
            } else {
                j++;
            }
        }
        PintaPreto(no);

        //aqui pintava preto
    }

    public static void PintaCinza(int no) {
        vetor[no].setCor("CINZA");
        tempo++;
        vetor[no].setTemI(tempo);

    }

    public static void PintaPreto(int no) {        
        vetor[no].setCor("PRETO");
        vetor[no].setTemF(++tempo);
    }

}
