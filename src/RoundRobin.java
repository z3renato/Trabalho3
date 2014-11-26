/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import estrutura.Arquivo;
import estrutura.Bloco;
import estrutura.Memoria;
import estrutura.Processo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Renato
 */
public class RoundRobin {

    private Arquivo arquivo = new Arquivo();
    ArrayList<Processo> listaProcesso = new ArrayList<>();
    ArrayList<Processo> cpu = new ArrayList<>();
    double quantum = 100.0;
    int tempoTotal = 0;
    int indiceAtual = 0;

    public RoundRobin() {
        try {
            this.listaProcesso = arquivo.lerArquivo();
        } catch (IOException ex) {
            Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Processo> carregaCPU(ArrayList<Processo> cpu) {
        int cont = 0;

        while (cont < 10 && listaProcesso.iterator().hasNext() && cpu.size() < 10) {
            cont++;
            cpu.add(listaProcesso.get(indiceAtual));
            indiceAtual++;
        }
        return cpu;
    }

    public void escalona() {

        tempoTotal += 5;
        if (cpu.get(0).getTempoExecucao() <= quantum) {
            cpu.get(0).setPronto(true);
            cpu.get(0).setTempoFinal(tempoTotal);

        } else {
            cpu.get(0).setPronto(false);
            cpu.get(0).setTempoExecucao(cpu.get(0).getTempoExecucao() - quantum);
        }

    }

    public void realocaCPU() {
        if (indiceAtual != listaProcesso.size()) {
            carregaCPU(cpu);
        }

        System.out.println("");
        for (int j = 0; j < cpu.size(); j++) {
            System.out.print(cpu.get(j).getNome());
            if (j < 9) {
                System.out.print(", ");
            }

        }
        System.out.print(" Escalonando o Processo: " + cpu.get(0).getNome());

        escalona();
        if (cpu.get(0).isPronto()) {
            cpu.remove(0);
        } else {
            cpu.add(cpu.get(0));
            cpu.remove(0);
        }
    }

    /**
     * | Somente gets e sets |
     */
    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

}
