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
public abstract class AlgoritmoPaginacao {
    LinkedList<String> memoriaFisica;
    String[] memoriaVirtual; 
    int nQuadros;
    public int nInsercao;
    
    public AlgoritmoPaginacao(int nQuadros){
        if(nQuadros <=0)
            throw new IllegalArgumentException();
        this.nQuadros=nQuadros;
    }
    
    public abstract void inserir(String numeroPagina);
   
}
