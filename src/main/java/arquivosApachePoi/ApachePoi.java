package arquivosApachePoi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/*geração da planilha de excel*/
public class ApachePoi {
    public static void main(String[] args) throws Exception{

        //criar arquivo
        File file =
                new File("D:\\Projetos Intelljei\\curso-java-jdev\\src\\main\\java\\arquivosApachePoi\\arquivo_xls.xls");

        if(file.exists()){
            file.createNewFile();
        }

        Pessoa pessoa1=new Pessoa();
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade("36");
        pessoa1.setNome("Francisco");

        Pessoa pessoa2=new Pessoa();
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade("46");
        pessoa2.setNome("Flávio");


        Pessoa pessoa3=new Pessoa();
        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade("16");
        pessoa3.setNome("Fernanda");

        Pessoa pessoa4=new Pessoa();
        pessoa4.setEmail("pessoa4@gmail.com");
        pessoa4.setIdade("99");
        pessoa4.setNome("Fernando da Silva");

        /*pode vir do banco de dados ou qualquer fonte de dados*/
        List<Pessoa> pessoas=new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);

        HSSFWorkbook hssfWorkbook= new HSSFWorkbook(); /*vai se usado para escrever a planilha*/
        HSSFSheet linhasPessoa =hssfWorkbook.createSheet("Planilha de Treinamento");/*Criar a planilha*/

        int numeroLinha=0;
        for (Pessoa p: pessoas
             ) {
            System.out.println(p);
            Row linha=linhasPessoa.createRow(numeroLinha ++);/*criando a linha na planilha*/

            int celula=0;

            Cell celNome=linha.createCell(celula++);/*celula 1*/
            celNome.setCellValue(p.getNome());

            Cell celEmail=linha.createCell(celula++);/*celula 2*/
            celEmail.setCellValue(p.getEmail());

            Cell celIdade=linha.createCell(celula++);/*celula 3*/
            celIdade.setCellValue(p.getIdade());

        }/*teminou de montar a planilha*/

        FileOutputStream saida = new FileOutputStream(file);

        hssfWorkbook.write(saida);/*escreve a planilha em arquivo*/

        saida.flush();
        saida.close();

        System.out.println("Planilha foi criada");

    }
}
