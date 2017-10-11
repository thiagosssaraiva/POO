package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class util {
    List<pib> lista = new ArrayList<pib>();
    float valor = 0;
    
    public void readFile(){
        lista.clear();
        
        String nameFile = "pib.txt";
        try {         
            BufferedReader br = new BufferedReader(new FileReader(nameFile));
            valor = 0;
            while(br.ready()){
                String linha = br.readLine();
                String registro [] = linha.split(";");
                pib objPIB = new pib(registro[0], Float.parseFloat(registro[1]));
                
                valor += Float.parseFloat(registro[1]);
                
                lista.add(objPIB);                       
            }
            br.close();
        }catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nameFile + "'");                
        }
        catch(IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nameFile + "'");                  
        }
    
    }

    public void writeFile(){
        /*      ------------------------------------- */
        /*      Exemplo de escrita em arquivo         */
        /*      ------------------------------------- */
        String localFile = "saida.txt";

        try {

            FileWriter fileWriter = new FileWriter(localFile);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("pib da regiao X = $$$$");
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao Y = $$$$");

            // feche o arquivo
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro de escrita em '" + localFile + "'");
        } 
    
    }

    public void calcularPercent(List<pib> lista, float valor){
        
        float percent = 0;
        for (int i = 0; i < lista.size(); i++) {
            percent = (lista.get(i).getValor() / valor * 100) ;
            
            lista.get(i).setPercent(percent);
        } 
        imprimirPercent(lista);
    }
    
    public void imprimirPercent(List<pib> lista){
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).imprimir();
        }
    }
    
    public void menu(){
        Scanner input = new Scanner(System.in);
        int opt;
        while (true) {
            System.out.println("| ---------------------------|\n"
                    + "1 - Ler arquivo\n"
                    + "2 - Calcular e Listar % PIB\n"
                    + "3 - Gerar arquivo de Saida\n"
                    + "4 - Sair\n"
                    + "| ---------------------------|\n");

            opt = input.nextInt();
            switch (opt) {
                case 1:
                    readFile();
                    break;
                case 2:
                    calcularPercent(lista, valor);
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Digite uma opção valida:");
            }
        }
    
    }
}