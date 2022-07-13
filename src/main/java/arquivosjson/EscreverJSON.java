package arquivosjson;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreverJSON {
    public static void main(String[] args) throws IOException {

        Usuario usuario1= new Usuario();
        usuario1.setCpf("123456789-899");
        usuario1.setNome("João da Silva");
        usuario1.setLogin("joao");
        usuario1.setSenha("123456");

        Usuario usuario2= new Usuario();
        usuario2.setCpf("999999999-55");
        usuario2.setNome("Mariana Silveira");
        usuario2.setLogin("mariana");
        usuario2.setSenha("654321");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        /*Escrevendo o arquivo json*/
        /*ele apenas organia o código*/
        Gson gson=new GsonBuilder().setPrettyPrinting().create();

        String jsonUser = gson.toJson(usuarios);
        System.out.println(jsonUser);


        FileWriter fileWriter=new FileWriter("D:\\Projetos Intelljei\\curso-java-jdev\\src\\main\\java\\arquivosjson\\filejson.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();

        /*Lendo o arquivo json*/

        FileReader fileReader = new FileReader("D:\\Projetos Intelljei\\curso-java-jdev\\src\\main\\java\\arquivosjson\\filejson.json");

        /*separa o json em posições*/
        JsonArray jsonArray= (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> liUsuarios=new ArrayList<>();

        for (JsonElement jsonElement:jsonArray
             ) {
                Usuario usuario= new Gson().fromJson(jsonElement,Usuario.class);
                liUsuarios.add(usuario);
        }

        System.out.println("Leitura do arquivo json"+ liUsuarios);

    }
}
