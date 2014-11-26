/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura;

import java.util.ArrayList;

/**
 *
 * @author gabriela
 */
public class Memoria {

    ArrayList<Bloco> memoria = new ArrayList<>();
    int indiceBlocos;

    /**
     * Este metodo adiciona o bloco na memoria caso ela esteja vazia. Adiciona
     * de forma que empurre todos os outros blocos para as posicoes posteriores.
     *
     * @param indice
     * @param bloco, este bloco sera adicionado a memoria
     * @return true caso de pra adicionar, false caso contrario.
     */
    public boolean adicionarNaMemoria(int indice, Bloco bloco) {
        if (!isMemoriaCheia(bloco)) {
            bloco.setIndexInicioBloco(indiceBlocos);
            memoria.add(indice, bloco);
            indiceBlocos++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Este metodo verifica se a memoria ja esta cheia, ou seja, se ja temos
     * 1024 na memoria. Isso eh verificado fazendo um somatorio do tamanho de
     * todos os processos.
     *
     * @param bloco
     * @return true caso a memoria esteja cheia, false caso contrario.
     */
    public boolean isMemoriaCheia(Bloco bloco) {

        int tamanhoTotalMemoria = 0;

        for (Bloco b : memoria) {
            tamanhoTotalMemoria += b.getTamanho();
        }

        if ((tamanhoTotalMemoria + bloco.getTamanho()) > 1024) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Este metodo percorre memoria e pega os blocos que estao livres.
     *
     * @return blocosVazios.
     */
    public ArrayList<Bloco> getBlocosLivres() {
        ArrayList<Bloco> blocosVazios = new ArrayList<>();

        for (int i = 0; i < memoria.size(); i++) {
            if (memoria.get(i).isLivre()) {
                memoria.get(i).setIndexInicioBloco(i);
                blocosVazios.add(memoria.get(i));
            }
        }

        return blocosVazios;
    }

    /**
     * Este metodo percorre memoria atualiza todos os indices dos blocos.
     */
    public void atualizarIndicesMemoria() {
        for (int i = 0; i < memoria.size(); i++) {
            memoria.get(i).setIndexInicioBloco(i);
        }
    }

    public ArrayList<Bloco> getMemoria() {
        return memoria;
    }

    public void setMemoria(ArrayList<Bloco> memoria) {
        this.memoria = memoria;
    }

}
