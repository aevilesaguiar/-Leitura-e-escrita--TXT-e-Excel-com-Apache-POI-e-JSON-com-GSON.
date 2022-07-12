package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1=new Pessoa();
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(36);
        pessoa1.setNome("Francisco");

        Pessoa pessoa2=new Pessoa();
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(46);
        pessoa2.setNome("Flávio");
        Pessoa pessoa3=new Pessoa();
        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(16);
        pessoa3.setNome("Fernanda");

        List<Pessoa> pessoas=new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);



        File arquivo = new File("D:\\Projetos Intelljei\\curso-java-jdev\\src\\main\\java\\arquivos\\arquivo.txt");

        if(!arquivo.exists()){
            arquivo.createNewFile();

        }

        FileWriter escrever_no_arquivo= new FileWriter(arquivo);


        for (Pessoa p:pessoas
             ) {
            escrever_no_arquivo.write(p.getNome()+"; " + p.getEmail() + " ;" +p.getIdade()+ " ; \n");
            System.out.println(p);

        }


        for (int i = 0; i <10 ; i++) {
            escrever_no_arquivo.write("Texto da minha linha "+i+"\n");
        }


        escrever_no_arquivo.flush();
        escrever_no_arquivo.close();

    }
}
