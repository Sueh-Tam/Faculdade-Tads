import java.io.Console;
import java.util.ArrayList;

public class GerenciadorClientePJ {
    Console cnsl;
    DaoClientePJ daoClientePJ;

    public GerenciadorClientePJ() {
        daoClientePJ = new DaoClientePJ();
    }

    public void menu() {
        int opcao = -1;
        Console cnsl = System.console();
        do {
            System.out.println("GERENCIADOR DE CLIENTES PJ");
            System.out.println("[1] - Cadastrar");
            System.out.println("[2] - Consultar");
            System.out.println("[3] - Alterar");
            System.out.println("[4] - Excluir");
            System.out.println("[5] - Listar todos");
            System.out.println("[0] - Voltar ao menu anterior");
            opcao = Integer.parseInt(cnsl.readLine());
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                  //  exluir();
                    break;
                case 5:
                   // listarTodos();
                    break; 
                case 0:

                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void cadastrar() {
        Console cnsl = System.console();
        ClientePj cliPj = new ClientePj();
        // Inserir no banco

        System.out.println("-----------------");
        System.out.println("[Cadastro de Clientes]");
        System.out.println("Nome:");
        cliPj.setNome(cnsl.readLine());
        System.out.println("CNPJ");
        cliPj.setCnpj(cnsl.readLine());

        EnderecoPj enderePJ = new EnderecoPj();
        System.out.println("[ENDERECO]");
        System.out.println("Rua");
        enderePJ.setRua(cnsl.readLine());
        System.out.println("Número");
        enderePJ.setNumero(Integer.parseInt(cnsl.readLine()));
        System.out.println("bairro:");
        enderePJ.setBairro(cnsl.readLine());
        System.out.println("CEP");
        enderePJ.setCep(cnsl.readLine());
        // Passa o objeto para a camada model
        cliPj.setEnderecoPJ(enderePJ);
        boolean inserido = daoClientePJ.inserir(cliPj);
        if (inserido) {
            System.out.println("Inserido com sucesso");
        } else {
            System.out.println("Deu erro");
        }
    }

    private void consultar(){

        Console cnsl = System.console();
        System.out.println("---------------");
        System.out.println("[Consulta de cliente pj]");
        System.out.println("Entre com o codigo");
        int codigo = Integer.parseInt(cnsl.readLine());

        ClientePj cli = daoClientePJ.consultar(codigo);
        if(cli != null){
            System.out.println("Cliente Encontrado");
            System.out.println("Codigo: "+ cli.getCodigoClientePJ());
            System.out.println("Nome: "+ cli.getNome());
            System.out.println("CNPJ: "+cli.getCnpj());
            System.out.println("[ENDERECO]");
            System.out.println("Rua: "+cli.getEnderecoPJ().getRua());
            System.out.println("Bairro: "+cli.getEnderecoPJ().getBairro());
            System.out.println("CEP: "+cli.getEnderecoPJ().getCep());
            System.out.println("Numero: "+ cli.getEnderecoPJ().getNumero());
        }else{
            System.out.println("Cliente NÃO encontrado");
        }
    }

    public void alterar(){
        Console cnsl = System.console();
        System.out.println("----------------");
        System.out.println("[Alteração de Clientes PJ]");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(cnsl.readLine());

        ClientePj cli = daoClientePJ.consultar(codigo);
        if(cli != null){
            System.out.println("[Codigo: "+cli.getCodigoClientePJ()+" ]");
            System.out.println("[Nome: "+cli.getNome()+"]");
            String nome = cnsl.readLine();
            if(!nome.isEmpty()){
                cli.setNome(nome);
            }
            System.out.println("[CNPJ: "+cli.getCnpj()+"]");
            String cnpj = cnsl.readLine();
            if(!cnpj.isEmpty()){
                cli.setCnpj(cnpj);
            }
            System.out.println("[ENDERECO]");
            System.out.println("[Rua: "+cli.getEnderecoPJ().getRua()+"]");
            String rua = cnsl.readLine();
            if(!rua.isEmpty()){
                cli.getEnderecoPJ().setRua(rua);;
            }
            System.out.println("[Número: "+ cli.getEnderecoPJ().getNumero()+"]");
            String numero = cnsl.readLine();
            if(!numero.isEmpty()){
                cli.getEnderecoPJ().setNumero(codigo);
            }
            System.out.println("[Bairro: "+cli.getEnderecoPJ().getBairro());
            String bairro = cnsl.readLine();
            if(!bairro.isEmpty()){
                cli.getEnderecoPJ().setBairro(bairro);
            }
            System.out.println("[CEP: "+ cli.getEnderecoPJ().getCep()+"]");
            String cep = cnsl.readLine();
            if(!cep.isEmpty()){
                cli.getEnderecoPJ().setCep(cep);
            }
            daoClientePJ.alterar(cli);
        }

    }
   /* 

    public void exluir() {
        Console cnsl = System.console();
        System.out.println("============================");
        System.out.println("exclusão de cliente");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(cnsl.readLine());
        int qtde = daoVeiculo.excluir(codigo);
        if (qtde > 0) {
            System.out.println("Excluido com sucesso");
        } else {
            System.out.println("Não foi possível excluir o regristro");
        }
    }

    public void consultarUnicoRegistro() {
        Console cnsl = System.console();
        Veiculo v;
        int codigo;
        System.out.println("============================");
        System.out.println("Entre com o codigo do cliente a ser procurado");
        codigo = Integer.parseInt(cnsl.readLine());

        v = daoVeiculo.consultar(codigo);

        System.out.println("Codigo:" + v.getCodigo());
        System.out.println("Marca:" + v.getMarca());
        System.out.println("Modelo:" + v.getModelo());
        System.out.println("Chassi:" + v.getChassi());
        System.out.println("Ano: " + v.getAno());
    }

    public void alterar() {
        Console cnsl = System.console();
        System.out.println("=========================");
        System.out.println("[Alteração de veículo]");
        System.out.println("Código");
        int codigo = Integer.parseInt(cnsl.readLine());
        Veiculo v = daoVeiculo.consultar(codigo);
        if (v != null) {
            System.out.println("Dados do veículo");
            System.out.println("[Código: " + v.getCodigo() + "]");
            System.out.println("");
            System.out.println("[Modelo " + v.getModelo() + "]");
            String modelo = cnsl.readLine();
            if (!modelo.isEmpty()) {
                v.setModelo(modelo);
            }

            System.out.println("[Marca " + v.getMarca() + "]");
            String marca = cnsl.readLine();
            if (!marca.isEmpty()) {
                v.setMarca(marca);
            }

            System.out.println("[Chassi " + v.getChassi() + "]");
            String chassi = cnsl.readLine();
            if (!chassi.isEmpty()) {
                v.setChassi(chassi);
            }

            System.out.println("[Ano " + v.getAno() + "]");
            String ano = cnsl.readLine();
            if (!ano.isEmpty()) {
                v.setAno(Integer.parseInt(ano));
            }

            int qtdeAlterado = daoVeiculo.atualizarVeiculo(v);

            if (qtdeAlterado > 0) {
                System.out.println("Registro alturado com sucesso");
            } else {
                System.out.println("Não foi possível atualizar o registro");
            }
        }
    }*/
}
