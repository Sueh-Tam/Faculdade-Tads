import java.io.Console;
import java.util.ArrayList;

public class GerenciarPneu {
    Console cnsl = System.console();
    DaoPneu daoPneu;
    public GerenciarPneu(){
        daoPneu = new DaoPneu();
    }
    public void menuPneu(){
        int opcao = 0;
        do{
            System.out.println("------------");
            System.out.println("Gerenciador de Pneus");
            System.out.println("[1] - Cadastrar Pneu");
            System.out.println("[2] - Consultar todos os pneus cadastrados");
            System.out.println("[3] - Consultar um Pneu");
            System.out.println("[4] - Editar Pneu");
            System.out.println("[5] - Excluir Pneu");
            /*System.out.println("[ 8 ] - Testes");*/
            System.out.println("[9] - Sair");
            opcao = Integer.parseInt(cnsl.readLine());
            switch (opcao) {
                case 1:
                    CadastrarPneu();
                    break;
                case 2:
                    ConsultarTodosPneus();
                    break;
                case 3:
                    ConsultarPneu();
                    break;
                case 4:
                    EditarPneu();
                    break;
                case 5:
                    deletarPneu();
                    break;
                default:
                    break;
            }
        }while(opcao != 9 );
       
    }
    public void CadastrarPneu(){
        Pneu p = new Pneu();
        
        System.out.println("Entre com a serie do pneu");
        p.setSeriePneu(cnsl.readLine());
        System.out.println("Entre com a cor do pneu");
        p.setCorPneu(cnsl.readLine());
        System.out.println("Entre com o codigo numérico do pneu");
        p.setCodPneu(Integer.parseInt(cnsl.readLine()));
        System.out.println("Entre com o estado do pneu");
        System.out.println("[Novo]");
        System.out.println("[Seminovo]");
        System.out.println("[Usado]");
        System.out.println("[Descarte]");
        p.setEstadoPneu(cnsl.readLine());
        System.out.println("Entre com o preço do pneu");
        p.setPreco(Float.parseFloat(cnsl.readLine()));
        p.todosOsDados();

        Boolean resultado = daoPneu.inserir(p);
        if(resultado){
            System.out.println("Pneu inserido com sucesso");
        }else{
            System.out.println("Não foi possível inserir o pneu");
        }

    }
    public void ConsultarTodosPneus(){
        ArrayList<Pneu> pneus = daoPneu.buscarTodosPneus();

        System.out.println("========================");
        System.out.println("========================");
        System.out.println("| Pneus cadastrados |");
        for (Pneu pneu : pneus) {
            System.out.println("[ID: "+ pneu.getId() +"]");
            System.out.println("[Serie do Pneu: "+ pneu.getSeriePneu() +"]");
            System.out.println("[Cor do pneu: "+ pneu.getCorPneu() +"]");
            System.out.println("[Codigo do pneu: "+ pneu.getCodPneu() +"]");
            System.out.println("[Estado do pneu: "+ pneu.getEstadoPneu() +"]");
            System.out.println("[data da locação:"+ pneu.getDataLocacao() +"]");
            System.out.println("[preço: "+ pneu.getPreco() +"]");
        }
    }

    public void ConsultarPneu(){

        System.out.println("====================");
        System.out.println("Entre com o código do Pneu");
        Pneu pneu = daoPneu.buscarPneu(Integer.parseInt(cnsl.readLine()));
        System.out.println("[ID: "+ pneu.getId() +"]");
        System.out.println("[Serie do Pneu: "+ pneu.getSeriePneu() +"]");
        System.out.println("[Cor do pneu: "+ pneu.getCorPneu() +"]");
        System.out.println("[Codigo do pneu: "+ pneu.getCodPneu() +"]");
        System.out.println("[Estado do pneu: "+ pneu.getEstadoPneu() +"]");
        System.out.println("[data da locação:"+ pneu.getDataLocacao() +"]");
        System.out.println("[preço: "+ pneu.getPreco() +"]");
    }

    public void EditarPneu(){
        Integer codigo;
        System.out.println("======================");
        System.out.println("Entre com o código do pneu para editar");
        codigo = Integer.parseInt(cnsl.readLine());
        Integer qtde;

        Pneu pneu = daoPneu.buscarPneu(codigo);

        if(pneu != null){
            System.out.println("[ID: "+ pneu.getId() +"]");
            System.out.println("[Serie do Pneu: "+ pneu.getSeriePneu() +"]");
            System.out.println("[Cor do pneu: "+ pneu.getCorPneu() +"]");
            String corPneu = cnsl.readLine();
            if(!corPneu.isEmpty()){
                pneu.setCorPneu(corPneu);
            }
            System.out.println("[Codigo do pneu: "+ pneu.getCodPneu() +"]");
            String codigoPneu = cnsl.readLine();
            if(!codigoPneu.isEmpty()){
                pneu.setCodPneu(Integer.parseInt(codigoPneu));
            }
            System.out.println("[Estado do pneu: "+ pneu.getEstadoPneu() +"]");
            String estadoPneu = cnsl.readLine();
            if(!estadoPneu.isEmpty()){
                pneu.setEstadoPneu(estadoPneu);
            }
            System.out.println("[data da locação:"+ pneu.getDataLocacao() +"]");
            String dataLocacao = cnsl.readLine();
            if(!dataLocacao.isEmpty()){
                pneu.setDataLocacao(dataLocacao);
            }
            System.out.println("[preço: "+ pneu.getPreco() +"]");
            String precoPneu = cnsl.readLine();
            if(!precoPneu.isEmpty()){
                pneu.setPreco(Float.parseFloat(precoPneu));
            }

            qtde = daoPneu.atualziarPneu(pneu);
            System.out.println("Total de registros atualizados: "+qtde);
        }

    }

    public void deletarPneu(){
        Integer codigo;
        int qtde = 0;
        System.out.println("============");
        System.out.println("Entre com o código para deletar o Pneu");
        codigo = Integer.parseInt(cnsl.readLine());
        qtde = daoPneu.deletarPneu(codigo);

        if(qtde == 0){
            System.out.println("Nenhum registro deletado");
        }else{
            System.out.println("Total de registros deletados: "+ qtde);
        }
    
    }
}
