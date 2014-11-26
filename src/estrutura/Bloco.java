/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura;

/**
 *
 * @author José Renato
 */
public class Bloco {

    private int tamanho;
    private int indexInicioBloco;
    private boolean livre = true;
    Processo processo;

    public Bloco(Processo processo) {
        livre = false;
        this.processo = processo;
        tamanho = processo.getTamanho();
    }

    /**
     * | Somente gets e sets |
     */
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public int getIndexInicioBloco() {
        return indexInicioBloco;
    }

    public void setIndexInicioBloco(int indexInicioBloco) {
        this.indexInicioBloco = indexInicioBloco;
    }
        
}
