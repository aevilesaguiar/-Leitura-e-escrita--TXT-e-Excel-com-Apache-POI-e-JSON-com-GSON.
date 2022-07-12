package arquivosApachePoi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Iterator;

/*editar o arquivo*/
public class ApachePoiEditando {
    public static void main(String[] args) throws Exception {

        File file = new File("D:\\Projetos Intelljei\\curso-java-jdev\\src\\main\\java\\arquivosApachePoi\\arquivo_xls.xls");

        FileInputStream entrada = new FileInputStream(file);

        HSSFWorkbook hssfWorkbook=new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo xls do excel*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);/*pegando a planilha*/

        /*pegando as linhas*/
        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext())/*Enquanto tiver linha */
        {
            Row linha = linhaIterator.next();/*Dados da pessoa na linha*/

            /*numero de celulas que tem essa linha*/
            int numeroCelulas= linha.getPhysicalNumberOfCells();/*quantidade de celulas*/

            Cell cell= linha.createCell(numeroCelulas);/*cria nova celula na linha*/
            cell.setCellValue("5.487,20");
        }

        entrada.close();

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);

        saida.flush();
        saida.close();
        System.out.println("Planilha atualizada!");
    }
}
