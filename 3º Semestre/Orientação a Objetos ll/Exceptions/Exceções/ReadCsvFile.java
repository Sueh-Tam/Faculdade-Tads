import java.util.Scanner;
import java.io.FileNotFoundException;
public class ReadCsvFile {
    public static void main(String[] args) {
        ReadCsvFile rcf = new ReadCsvFile();

        rcf.lerArquivo();
    }
    public void lerArquivo(){
        String arquivo_e_delimitador;
        String nome_arquivo;
        String delimitador;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor entre com o nome do arquivo(com a extensao excemplo: nomeArquivo.csv) e o delimitador, exemplo: ; ou ,\n");
        arquivo_e_delimitador = scanner.nextLine();
        String[] dados_input = arquivo_e_delimitador.split(" ");

        if(dados_input.length > 2){
            System.out.println("Número de dados excedido ");
            System.exit(0);
        } else if( dados_input.length < 2){
            
        }

        nome_arquivo = dados_input[0];
        delimitador = dados_input[1];
        System.out.println(dados_input.length);
        //System.out.println("Nome inserido: "+ nomeArquivo+"\n");

        /* 
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String line = "";
            while ((line = br.readLine()) != null) {

                String[] csvFields = line.split(delimitador);

                for (String field : csvFields) {
                    System.out.print(field + " ");
                }

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
