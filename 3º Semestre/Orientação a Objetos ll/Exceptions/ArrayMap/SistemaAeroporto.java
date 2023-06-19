import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class SistemaAeroporto {
    public static void main(String[] args) {
        
        HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();
        Console cnsl = System.console();
        int opcao;
        if(cnsl == null){
            System.out.println("Console N/D");
        }
/* 
        String teste = cnsl.readLine("Enter String");
        System.out.println("Voce escreveu: "+ teste);
 */
        Aeroporto a1 = new Aeroporto();
        a1.setNome("Congonhas");
        a1.setCidade("Foz");
        a1.setAltitude(750.9);

        aeroportos.put("CF",a1);
        
        do{

            System.out.println("Entre com a opção desejada");
            System.out.println("1 - CAdastrar aeroporto");
            System.out.println("2 - Listar aeroportos cadastrados");
            System.out.println("3 - REmover aeroporto");
            System.out.println("4 - Consultar aeroporto");
            System.out.println("9 - Sair");
            opcao = Integer.parseInt(cnsl.readLine());
            switch (opcao) {
                case 1:
                    cadastrarAeroporto(aeroportos);
                    break;
                case 2:
                    listarAeroportos(aeroportos);
                    break;
                case 3: 
                    removerAeroporto(aeroportos);
                    break;
                case 4:
                    consultarAeroporto(aeroportos);
                    break;
                case 5:
                    break;
                case 9:
                    System.out.println("Adeus");
                    break;
                default:
                    break;
            }
        }while(opcao != 9);
            

    }
    public static void cadastrarAeroporto(HashMap<String,Aeroporto> lista_aeroporto){
        Console cnsl = System.console();
        int opcao;
        do{
            Aeroporto aero = new Aeroporto();
            String nomeAeroporto;
            String nomeCidade;
            Double altitude;
            String sigla;

            System.out.println("Entre com o nome do aeroporto");
            nomeAeroporto = cnsl.readLine();
            aero.setNome(nomeAeroporto);
            System.out.println("Entre com o nome da cidade");
            nomeCidade = cnsl.readLine();
            aero.setCidade(nomeCidade);
            System.out.println("Entre com a altitude");
            altitude = Double.parseDouble(cnsl.readLine());
            aero.setAltitude(altitude);
            System.out.println("Entre com a sigla do aeroporto");
            sigla = cnsl.readLine();

            System.out.println("");
            System.out.println("Deseja cadastrar mais um aeroporto?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            opcao = Integer.parseInt(cnsl.readLine());
            if(opcao == 2){
                System.out.println("Até breve :)");
            }
            lista_aeroporto.put(sigla, aero);
        }while(opcao != 2);
    }

    public static void listarAeroportos(HashMap<String,Aeroporto> lista_aeroporto){
        for (Aeroporto aero : lista_aeroporto.values()) {
            System.out.println(aero.getNome());
        }
    }

    public static void removerAeroporto(HashMap<String,Aeroporto> lista_aeroporto){
        
        int opcao;
        Console cnsl = System.console();
        String sigla;

        do{
            System.out.println("Entre com a sigla do aeroporto apra remover");
            sigla = cnsl.readLine();
            if(lista_aeroporto.containsKey(sigla)){
                //System.out.println("Aeroporto: " + lista_aeroporto.get(sigla).getNome());
                lista_aeroporto.remove(sigla);
            }else{
                System.out.println("Aeroporto não encontrado");
            }

            System.out.println("Deseja remover outro aeroporto? ");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            opcao = Integer.parseInt(cnsl.readLine());
            
        }while(opcao != 2);
    }

    public static void consultarAeroporto(HashMap<String,Aeroporto> lista_aeroporto){
        int opcao;
        Console cnsl = System.console();
        String sigla;

        do{
            System.out.println("Entre com a sigla do aeroporto");
            sigla = cnsl.readLine();
            if(lista_aeroporto.containsKey(sigla)){
                System.out.println("Nome aeroporto: "+ lista_aeroporto.get(sigla).getNome());
                System.out.println("Cidade do aeroporto: "+ lista_aeroporto.get(sigla).getCidade());
                System.out.println("Altitude do aeroporto: "+ lista_aeroporto.get(sigla).getAltitude());
                //System.out.println("Sigla aeroporto: "lista_aeroporto.get(sigla));
            }
            System.out.println("Deseja consultar outro aeroporto? ");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            opcao = Integer.parseInt(cnsl.readLine());
        }while(opcao != 2);
    }
}
