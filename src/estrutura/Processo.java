/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura;

/**
 * @author Gabriela Nome do processo, tempo necessário para concluir sua
 * execução (segundos) e tamanho que ocupará em memória (em MB). Exemplo de
 * arquivo de entrada:
 */
public class Processo {

    private String nome;
    private double tempoExecucao;
    private int tamanho;
    private boolean pronto = false;
    private double tempoFinal;

    Processo(String nome, double tempoExecucao, int tamanho) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.tamanho = tamanho;
    }

    /**
     * | Somente gets e sets |
     */
    public boolean isPronto() {
        return pronto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(double tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public double getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(double tempoFinal) {
        this.tempoFinal = tempoFinal;
    }
}
