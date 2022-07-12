package arquivostxt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LearArquivoTxt {
    public static void main(String[] args) throws FileNotFoundException {

        //entrada de dados
        FileInputStream entradaArquivo =
                new FileInputStream(new File("D:\\Projetos Intelljei\\curso-java-jdev\\src\\main\\java\\arquivos\\arquivo.txt"));

        Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

        List<Pessoa> pessoas=new ArrayList<>();

        while (lerArquivo.hasNext()){
            String linha = lerArquivo.nextLine();

            if(linha !=null && !linha.isEmpty()){


                    String[] dados=linha.split("\\|");

                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome(dados[0]);
                    pessoa.setEmail(dados[1]);
                    pessoa.setIdade(dados[2]);



            System.out.println(linha);
        }}

        /*poderia gravar no banco de dados ou enviar email*/

        for (Pessoa p:pessoas
             ) {
            System.out.println(p);
        }

        System.out.println(pessoas);
    }
}
