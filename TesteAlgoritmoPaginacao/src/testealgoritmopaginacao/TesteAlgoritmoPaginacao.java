/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testealgoritmopaginacao;
import java.util.Scanner;


/**
 *
 * @author italo
 */
public class TesteAlgoritmoPaginacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variáveis
        String[] memoriaVirtual;
        String referencia;
        int nQuadros;
        Scanner scanner = new Scanner(System.in);
        
        
        //Receber a quantidade de quadros da memórioa principal
        System.out.println("Digite a quantidade de quadros da memória principal:");
        nQuadros = Integer.parseInt(scanner.nextLine());
        
        //Escolher a sequência a ser utilizada
        System.out.println("Digite uma sequência separada por vírgulas (Digite T se deseja utilizar a sequência de teste):");
        referencia = scanner.nextLine();
        
        if (referencia.equals("T")){
            referencia="1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6, 2, 4, 1, 6, 2, 2, 7, 3, 1, 3, 1, 3, 2, 4, 2, 2, 7, 4, 1, 3";
            System.out.println("Sequência de teste: ["+referencia+"]");
            memoriaVirtual = referencia.split(",");
        }
        else{
            memoriaVirtual = referencia.split(",");
        }

        //FIFO
        System.out.println("Algoritmo FIFO");
        AlgoritmoPaginacao fifo= new AlgoritmoFIFO(nQuadros);
        for (int i = 0; i < (memoriaVirtual.length); i++) {
            fifo.inserir(memoriaVirtual[i]);
        }
        System.out.println("Nº de inserções: "+fifo.nInsercao);
        
        //Segunda chance
        System.out.println("Algoritmo Segunda Chance");
        AlgoritmoPaginacao sc= new AlgoritmoSegundaChance(nQuadros);
        for (int i = 0; i < (memoriaVirtual.length); i++) {
            sc.inserir(memoriaVirtual[i]);
        }
        System.out.println("Nº de inserções: "+sc.nInsercao);
    }
    
}
