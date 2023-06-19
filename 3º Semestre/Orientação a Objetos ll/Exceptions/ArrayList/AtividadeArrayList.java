package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class AtividadeArrayList {
    public static void main(String[] args) throws Exception{

        Scanner leitor = new Scanner(System.in);
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        int opcao;

        do{
            
            opcao = 0;
            System.out.println("Escolha a opção");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Listar Clientes");
            System.out.println("3- Cadastrar Orçamento para cliente");
            System.out.println("4- Listar orçamentos de um cliente");
            System.out.println("9 - Sair");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    System.out.println(cadastraCliente(lista));
                break;

                case 2:
                    ListarClientes(lista);
                break;

                case 3:
                    CadastrarOrcamento(lista);
                break;

                case 4:
                    listarOrcamentosCliente(lista);
                break;

                case 9:
                    System.out.println("Até mais tarde :)");
                break;

                default:
                    System.out.println("Opcão não encontrada");
                break;
            }

        }while(opcao != 9);

        /*for (Cliente cliente : lista) {
            System.out.println("Nome Cliente: "+cliente.getNome()+"");
            System.out.println("CPF Cliente: "+cliente.getCpf()+"\n");
        }*/
        //leitor.close();
    }

    public static String cadastraCliente(ArrayList<Cliente> lista_clientes){
        Scanner leitor = new Scanner(System.in);

        String nomeCliente;
        String cpfCliente;
        int resposta;
        do{
            Cliente cli = new Cliente();

            System.out.println("Entre com o nome do cliente");
            nomeCliente = leitor.next();
            cli.setNome(nomeCliente);

            System.out.println("Entre com o CPF do cliente");
            cpfCliente = leitor.next();
            cli.setCpf(cpfCliente);
            
            lista_clientes.add(cli);
            System.out.println("Deseja cadastrar mais um cliente?");
            System.out.println("1 - Sim");
            System.out.println("0 - Não");
            resposta = leitor.nextInt();

        }while(resposta != 0);

        
        return "Cliente Cadastrado com sucesso";
    }

    public static void ListarClientes(ArrayList<Cliente> lista_clientes){
        
        
        for (Cliente cliente : lista_clientes) {
            System.out.println("Nome Cliente: "+cliente.getNome()+"");
            System.out.println("CPF Cliente: "+cliente.getCpf()+"\n");
        } 
        
    }

    public static void CadastrarOrcamento(ArrayList<Cliente> lista_clientes){
        Scanner leitor = new Scanner(System.in);
        String cpfCliente;
        System.out.println("Por favor entre com o cpf do cliente");
        cpfCliente = leitor.next();

        for (Cliente cliente : lista_clientes) {
            if(cliente.getCpf().equals(cpfCliente)){
                System.out.println("Cliente "+cliente.getNome()+" Encontrado");
                
                cliente.cadastrarOrcamento();
                break;
            }
        }
    }
    public static void listarOrcamentosCliente(ArrayList<Cliente> lista_clientes){
        Scanner leitor = new Scanner(System.in);
        String cpfCliente;
        System.out.println("Por favor entre com o cpf do cliente");
        cpfCliente = leitor.next();

        for (Cliente cliente : lista_clientes) {
            if(cliente.getCpf().equals(cpfCliente)){
                System.out.println("Cliente "+cliente.getNome()+" Encontrado");
                cliente.listarOrcamentos();
                break;
            }
        }
    }
}
