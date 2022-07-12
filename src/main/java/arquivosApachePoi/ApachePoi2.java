package arquivosApachePoi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*leitura da planilha de excel*/
public class ApachePoi2 {
    public static void main(String[] args) throws Exception{
        FileInputStream entrada =
                new FileInputStream(new File("D:\\Projetos Intelljei\\curso-java-jdev\\src\\main\\java\\arquivosApachePoi\\arquivo_xls.xls"));

        HSSFWorkbook hssfWorkbook=new HSSFWorkbook(entrada);/*preapara a entrada do arquivo excel para ler*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);/*pega a primeira planilha do nosso arquivo excel*/

        /*percorrer as linhas*/

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas=new ArrayList<>();

        while(linhaIterator.hasNext()){/*enquanto tiver linha*/

            Row linha = linhaIterator.next();/*dados da pessoa na linha*/

            Iterator<Cell> celula = linha.iterator();

            Pessoa pessoa= new Pessoa();

            while ((celula.hasNext())){/*enquanto tiver celulas perccorrer as celulas*/

                Cell cell= celula.next();
                switch (cell.getColumnIndex()){

                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade(cell.getStringCellValue());
                        break;

                }
        } /*im das celulas da linha*/
            pessoas.add(pessoa);

        }

        entrada.close();/*terminou de ler o arquivo excel*/

        for (Pessoa p:pessoas
             ) {/*poderia gravas no banco de dados, enviar email*/
            System.out.println(p);
        }

    }
}
