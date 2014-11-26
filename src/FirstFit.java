import estrutura.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author José Renato
 */
public class FirstFit {

Memoria memoria = new Memoria();
    RoundRobin round = new RoundRobin();

   
    public void executarFirstFit() {
        Bloco bloco;
        while (true) {
            round.realocaCPU();
//                Thread.sleep(5 * 1000);
            bloco = new Bloco(round.cpu.get(0));

            ArrayList<Bloco> blocosVazios = new ArrayList<>();

            if (memoria.isMemoriaCheia(bloco)) {

                blocosVazios = memoria.getBlocosLivres(); 
                AQUI È AH TRETA, tem que setar o campo do bloco isLivre como true quando o processo sair da cpu!
                do jeito que ta o array blocosVazio nao tem nada

                for (Bloco blocoLivre : blocosVazios) {
                    int indiceNovoBloco;

                    if (blocoLivre.getTamanho() >= bloco.getTamanho()) {
                        blocoLivre.setTamanho(this.divideBloco(blocoLivre, bloco));

                        //if para saber qual posicao inserir na memoria
                        if (blocoLivre.getIndexInicioBloco() == 0) {
                            indiceNovoBloco = 0;
                        } else {
                            indiceNovoBloco = blocoLivre.getIndexInicioBloco();
                        }

                        blocoLivre.setIndexInicioBloco(indiceNovoBloco + 1);
                        blocoLivre.setLivre(true);

                        memoria.adicionarNaMemoria(indiceNovoBloco, bloco);
                        memoria.atualizarIndicesMemoria();
                        break;
                    }
                }
            }else{
                memoria.adicionarNaMemoria(memoria.getMemoria().size(), bloco);
            }
             if(round.cpu.isEmpty()){
                 break;
             }
        }
    }

    /**
     * Este metodo eh responsavel por quebrar o bloco em duas partes.
     *
     * Como o bloco a ser inserido é menor do que o bloco de destino, ele
     * ocupara os primeiros espacos com o arquivo, sequencialmente, ate que todo
     * o bloco seja inserido. Assim teremos o bloco dividido em duas partes: uma
     * com o tamanho do bloco inserido, e a outra com o restante do espaco.
     *
     *
     * @param blocoVazio
     * @param blocoParaAlocar
     *
     * @return o numero do novo tamanho do bloco vazio.
     */
    public int divideBloco(Bloco blocoVazio, Bloco blocoParaAlocar) {

        int tamanhoBlocoVazio = 0;

        tamanhoBlocoVazio = blocoVazio.getTamanho() - blocoParaAlocar.getTamanho();
        return tamanhoBlocoVazio;
    }
    
        public void setRound(RoundRobin round) {
        this.round = round;
    }
    
    
}
