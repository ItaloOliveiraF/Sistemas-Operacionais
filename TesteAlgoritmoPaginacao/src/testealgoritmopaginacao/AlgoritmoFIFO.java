/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testealgoritmopaginacao;
import java.util.LinkedList;


/**
 *
 * @author italo
 */
public class AlgoritmoFIFO extends AlgoritmoPaginacao {

    //O ponteiro indica a posição onde se deseja adicionar uma nova página na memória principal
    private static int ponteiro = 0;
    
    public AlgoritmoFIFO(int nQuadros) {
        super(nQuadros);
        memoriaFisica = new LinkedList<>();
        nInsercao = 0;
    }

    @Override
    public void inserir(String numeroPagina) {
        //Confere se a página já está na Memória Física
        if(!memoriaFisica.contains(numeroPagina)){
            //Se a memória física não estiver preenchida a página é adicionada numa posição vazia
            if(memoriaFisica.size()<nQuadros){
                memoriaFisica.add(numeroPagina);
                nInsercao++;
            }
            //Se a memória física já estiver preenchida, a nova página substitui a página adicionada a mais tempo
            else{
                memoriaFisica.remove(ponteiro);
                memoriaFisica.add(ponteiro, numeroPagina);
                nInsercao++;
                
                ponteiro++;
                //Se o ponteiro chegar no limite, ele volta ao início
                if(ponteiro==nQuadros){
                    ponteiro=0;
                }
            }
            System.out.println("memoriaFisica = " + memoriaFisica + ". Nova inserção.");
        }
        else{
            System.out.println("memoriaFisica = " + memoriaFisica + ". Não houve troca.");
        }
    }
}
