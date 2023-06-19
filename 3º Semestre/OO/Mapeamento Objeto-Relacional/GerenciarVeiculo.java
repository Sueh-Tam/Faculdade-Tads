import java.io.Console;
import java.util.ArrayList;

public class GerenciarVeiculo {
    Console cnsl;
    DaoVeiculo daoVeiculo;
    
    public GerenciarVeiculo(){
        daoVeiculo = new DaoVeiculo();
    }

    public void menu(){
        int opcao = -1;
        Console cnsl = System.console();
        do{
            System.out.println("GERENCIADOR DE VEICULOS");
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
                    consultarUnicoRegistro();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    exluir();
                    break;
                case 5:
                    listarTodos();
                    break;
                case 0:
                    
                    break;
                default:
                    break;
            }
        } while (opcao !=0);
    }

    public void cadastrar(){
        Console cnsl = System.console();
        Veiculo v = new Veiculo();
        //Inserir no banco


        System.out.println("-----------------");
        System.out.println("[Cadastro de veículos]");
        System.out.println("Marca:");
        v.setMarca(cnsl.readLine());
        System.out.println("Modelo");
        v.setModelo(cnsl.readLine());
        System.out.println("Chassi");
        v.setChassi(cnsl.readLine());
        System.out.println("Ano:");
        v.setAno(Integer.parseInt(cnsl.readLine()));

        //Passa o objeto para a camada model
        boolean inserido = daoVeiculo.inserir(v);
        if(inserido){
            System.out.println("Inserido com sucesso");
        }else{
            System.out.println("Deu erro");
        }
    }
    public void listarTodos(){
        ArrayList<Veiculo> veiculos = daoVeiculo.buscarTodos();

        System.out.println("============================");
        System.out.println("Veiculos cadastrados");

        for(Veiculo v : veiculos){
            System.out.println("============================");
            System.out.println("Codigo: " + v.getCodigo());
            System.out.println("Modelo: "+ v.getModelo());
            System.out.println("Marca: "+ v.getMarca());
            System.out.println("Chassi: "+ v.getChassi());
            System.out.println("Ano: "+ v.getAno());
            System.out.println("============================");
        }
    }

    public void exluir(){
        Console cnsl = System.console();
        System.out.println("============================");
        System.out.println("exclusão de veículo");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(cnsl.readLine());
        int qtde = daoVeiculo.excluir(codigo);
        if(qtde > 0){
            System.out.println("Excluido com sucesso");
        }else{
            System.out.println("Não foi possível excluir o regristro");
        }
    }

    public void consultarUnicoRegistro(){
        Console cnsl = System.console();
        Veiculo v;
        int codigo;
        System.out.println("============================");
        System.out.println("Entre com o codigo do veiculo a ser procurado");
        codigo = Integer.parseInt(cnsl.readLine());

        v = daoVeiculo.consultar(codigo);
        
        System.out.println("Codigo:"+ v.getCodigo());
        System.out.println("Marca:"+ v.getMarca());
        System.out.println("Modelo:"+ v.getModelo());
        System.out.println("Chassi:"+ v.getChassi());
        System.out.println("Ano: "+ v.getAno());
    }

    public void alterar(){
        Console cnsl = System.console();
        System.out.println("=========================");
        System.out.println("[Alteração de veículo]");
        System.out.println("Código");
        int codigo = Integer.parseInt(cnsl.readLine());
        Veiculo v = daoVeiculo.consultar(codigo);
        if(v!=null){
            System.out.println("Dados do veículo");
            System.out.println("[Código: "+v.getCodigo()+"]");
            System.out.println("");
            System.out.println("[Modelo "+v.getModelo()+"]");
            String modelo = cnsl.readLine();
            if(!modelo.isEmpty()){
                v.setModelo(modelo);
            }

            System.out.println("[Marca "+v.getMarca()+"]");
            String marca = cnsl.readLine();
            if(!marca.isEmpty()){
                v.setMarca(marca);
            }

            System.out.println("[Chassi "+v.getChassi()+"]");
            String chassi = cnsl.readLine();
            if(!chassi.isEmpty()){
                v.setChassi(chassi);
            }

            System.out.println("[Ano "+v.getAno()+"]");
            String ano = cnsl.readLine();
            if(!ano.isEmpty()){
                v.setAno(Integer.parseInt(ano));
            }

            int qtdeAlterado = daoVeiculo.atualizarVeiculo(v);

            if(qtdeAlterado > 0){
                System.out.println("Registro alturado com sucesso");
            }else{
                System.out.println("Não foi possível atualizar o registro");
            }
        }
    }
}
