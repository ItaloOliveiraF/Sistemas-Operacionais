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
public class AlgoritmoSegundaChance extends AlgoritmoPaginacao{
    //A lista bitDeUso guarda os bits que dizem se a página em determinada posição da memória principal está sendo utilizada com frequência ou não
    LinkedList<Integer> bitDeUso;
    //O ponteiro indica a posição onde se deseja adicionar uma nova página na memória principal
    private static int ponteiro = 0;
    
    public AlgoritmoSegundaChance(int nQuadros) {
        super(nQuadros);
        memoriaFisica = new LinkedList<>();
        bitDeUso = new LinkedList<>();
        nInsercao = 0;
        
    }

    @Override
    public void inserir(String numeroPagina) {
        //Guarda o índice em que o número da página se encontra na memória física, se a página não estiver alocada, então tmp=-1
        int tmp = memoriaFisica.indexOf(numeroPagina);
        
        //A página não está na memória física
        if(tmp==-1){
            if(memoriaFisica.size()<nQuadros){
                memoriaFisica.add(numeroPagina);
                bitDeUso.add(0);
            }
            else{
                //Percorre a lista bitDeUso até encontrar uma posição com a página mais antiga e que não está sendo utilizada com frequência
                while(bitDeUso.get(ponteiro) == 1){
                    bitDeUso.set(ponteiro, 0);
                    ponteiro++;
                     //Se o ponteiro chegar no limite, ele volta ao início
                    if(ponteiro==nQuadros){
                        ponteiro=0;
                    }
                }
                
                memoriaFisica.remove(ponteiro);
                memoriaFisica.add(ponteiro, numeroPagina);
                bitDeUso.remove(ponteiro);
                bitDeUso.add(ponteiro, 0);
                ponteiro++;
                
                //Se o ponteiro chegar no limite, ele volta ao início   
                if(ponteiro==nQuadros){
                    ponteiro=0;
                } 
            }
            nInsercao++;
            System.out.println("memoriaFisica = " + memoriaFisica + ". Nova inserção.");
        }
        //A está na memória física
        else{
            bitDeUso.set(tmp,1);
            System.out.println("memoriaFisica = " + memoriaFisica + ". Não houve troca.");
        }
    }
    
}
