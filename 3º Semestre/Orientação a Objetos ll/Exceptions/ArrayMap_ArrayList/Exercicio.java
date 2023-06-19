

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;

public class Exercicio {
    public static HashMap<String,ArrayList<Usuario>> usuarios = new HashMap<String,ArrayList<Usuario>>();
    public static Console cnsl = System.console();
    public static void main(String[] args) {
        
        Integer opcao;
        do{
            
            System.out.println("Entre com o Nº da opção");
            System.out.println("1 - Adicionar aniversariante");
            System.out.println("2 - Listar datas com os aniversariantes");
            System.out.println("3 - Consultar aniversariantes por data");
            System.out.println("0 - Sair");
            opcao = Integer.parseInt(cnsl.readLine());
            
            switch (opcao) {
                case 1:
                    cadastrar_aniversariante(usuarios);
                    break;
                case 2:
                    mostrarUsuarios(usuarios);
                break;
                case 3:
                    
                break;
                case 4:
                    
                break;
                default:
                    System.out.println("Opcao não encontrada");
                break;
            }
        }while (opcao !=0);

        
    }

    public static void cadastrar_aniversariante(HashMap<String,ArrayList<Usuario>> usuarios_ani){
        
        Integer opcao;
        do{
            String nome;
            String aniversario;
            
            ArrayList<Usuario> inserir = new ArrayList<Usuario>();
            

            Usuario User = new Usuario();
            
            System.out.println("Entre com o nome do cliente");
            nome = cnsl.readLine();
            User.setNome(nome);
            System.out.println("Entre com a data do aniversariante no seguinte formato: DIA/Nº MES");
            aniversario = cnsl.readLine();
            User.setData_nasc(aniversario);

            inserir.add(User);
            /*if(usuarios_ani.get("19/19")){
                System.out.println("Já existe aniversario cadastrado");
            }*/
            usuarios_ani.put(aniversario,inserir);

            System.out.println("Deseja cadastrar mais um ususario?");
            System.out.println("1 - Sim");
            System.out.println("0 - Não");

            opcao = Integer.parseInt(cnsl.readLine());
        }while(opcao != 0);
    }
    public static void mostrarUsuarios(HashMap<String,ArrayList<Usuario>> usuarios_ani){

        for (String item : usuarios_ani.keySet()) {
            System.out.println(item);
            
        }
        /*for (ArrayList<Usuario> elemento : usuarios_ani.values()) {
            System.out.println(elemento.size());
        }*/
    }
}
