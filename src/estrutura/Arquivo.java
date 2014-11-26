/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estrutura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author Gabriela
 */
public class Arquivo {
    
   
    private String caminho;
    


     public ArrayList<Processo> lerArquivo() throws IOException {

        ArrayList<Processo> entrada = new ArrayList<Processo>();
        File file = new File("entrada.txt");
        String linha;
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            while ((linha = input.readLine()) != null) {
                String processo[] = linha.split(", ");
                entrada.add(new Processo(processo[0], Double.parseDouble(processo[1]), Integer.parseInt(processo[2])));

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao ler arquivo!");
        }

        return entrada;
    }

    public void escreverArquivo(String nomeProcesso, String tempo,String escalonador) {
        try {
            FileWriter arq = new FileWriter("Saida"+escalonador+".txt", true);
            PrintWriter output = new PrintWriter(arq);
            output.println(nomeProcesso + ", " + tempo);
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public String format(double x) {
        return String.format("%.2f", x);
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
}
