import java.io.Console;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GerenciarCliente {
    Console cnsl;
    DaoCliente daoCliente;

    public GerenciarCliente(){
        daoCliente = new DaoCliente();
    }

    public void menuCliente(){
        int opcao = -1;
        Console cnsl = System.console();
        do{
            System.out.println("GERENCIADOR DE CLIENTES");
            System.out.println("[1] - Cadastrar");
            System.out.println("[2] - Consultar");
            System.out.println("[3] - Alterar");
            System.out.println("[4] - Excluir");
            System.out.println("[5] - Listar todos");
            System.out.println("[0] - Voltar ao menu anterior");
            opcao = Integer.parseInt(cnsl.readLine());
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    editarCadastroCliente();
                    break;
                case 4:
                    deletarCliente();
                    break;
                case 5:
                    buscarTodosClientes();
                    break;
                case 0:
                    
                    break;
                default:
                    break;
            }
        } while (opcao !=0);
    }
    public void cadastrarCliente(){
        Console cnsl = System.console();
        Cliente c = new Cliente();

        System.out.println("---------------");
        System.out.println("Entre com o nome do cliente");
        c.setNome(cnsl.readLine());
        System.out.println("Entre com o endereço do cliente");
        c.setEndereco(cnsl.readLine());
        System.out.println("Entre com  a data de aniversário");
        c.setData_aniversaio(cnsl.readLine());
        
        boolean inserido = daoCliente.InserirCliente(c);
        if(inserido){
            System.out.println("Cliente inserido com sucesso");
        }else{
            System.out.println("Algo de errado não está certo");
        }
    }
    public void consultarCliente(){
        Console cnsl = System.console();
        Integer codigo;
        System.out.println("-----------------");
        System.out.println("BUSCA DE CLIENTE");
        System.out.println("Entre com o codigo do cliente");
        codigo = Integer.parseInt(cnsl.readLine());

        Cliente cliente = daoCliente.consultarCliente(codigo);

        System.out.println("Nome cliente: "+ cliente.getNome());
        System.out.println("Código do cliente: "+cliente.getCodigo());
        System.out.println("Data de aniversário: "+cliente.getData_aniversaio());
        System.out.println("Endereço do cliente: "+cliente.getEndereco());
        System.out.println("Data de inserção do cliente: "+ cliente.getData_insercao());
        System.out.println("Data de atualização do cliente: "+cliente.getData_atualizacao());
        System.out.println("-----------------");

    }
    public void buscarTodosClientes(){
        System.out.println("---------------------------");
        System.out.println("Clientes cadastrados no sistema");
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        clientes = daoCliente.buscarTodos();

        for (Cliente cliente : clientes) {
            System.out.println("Nome cliente: "+ cliente.getNome());
            System.out.println("Código do cliente: "+cliente.getCodigo());
            System.out.println("Data de aniversário: "+cliente.getData_aniversaio());
            System.out.println("Endereço do cliente: "+cliente.getEndereco());
            System.out.println("Data de inserção do cliente: "+ cliente.getData_insercao());
            System.out.println("Data de atualização do cliente: "+cliente.getData_atualizacao());
            System.out.println("-----------------");
        }
    }

    public void editarCadastroCliente(){
        Console cnsl = System.console();
        Integer codigo;
        System.out.println("Entre com o codigo do cliente: ");
        codigo = Integer.parseInt(cnsl.readLine());
        Cliente c = daoCliente.consultarCliente(codigo);
        if(c != null){
            System.out.println("------------------");
            System.out.println("ALTERAÇÃO DE DADOS DO CLIENTE");
            System.out.println("[Codigo: "+ c.getCodigo()+"]");
            System.out.println("[Nome: "+ c.getNome()+"]");
            String nome = cnsl.readLine();
            if(!nome.isEmpty()){
                c.setNome(nome);
            } 
            System.out.println("[Data de aniversário: "+c.getData_aniversaio()+"]");
            String data_aniversario = cnsl.readLine();
            if(!data_aniversario.isEmpty()){
                c.setData_aniversaio(data_aniversario);
            }
            System.out.println("[Endereco: "+c.getEndereco()+"]");
            String endereco = cnsl.readLine();
            if(!endereco.isEmpty()){
                c.setEndereco(endereco);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date data_atual = new Date();  
            
            c.setData_atualizacao(formatter.format(data_atual));
            Integer qtde = daoCliente.alterarCadastroCliente(c);
            System.out.println("Clientes alterados: "+ qtde);
        }else{
            System.out.println("Cliente não encontrado");
        }

    }

    public void deletarCliente(){
        Console cnsl = System.console();
        System.out.println("---------------");
        System.out.println("Deletar cliente");
        System.out.println("Entre com o codigo do cliente a ser deletado");
        Integer codigo = Integer.parseInt(cnsl.readLine());
        Integer qtde = daoCliente.deletarCliente(codigo);
        System.out.println("Total de clientes deletados: "+qtde);

        
        
    }
}
