import java.io.Console;

public class Locadora {

    public static void main(String[] args) {
        Locadora loc = new Locadora();
            loc.menuPrincipal();
    }

    public void menuPrincipal(){
        Console cnsl = System.console();
        Integer opcao = 0;
        do {
            System.out.println("Menu principal");
            System.out.println("[1] - Gerenciar veiculos");
            System.out.println("[2] - Gerenciar Clientes PJ");
            System.out.println("[0] - Sair");
            opcao = Integer.parseInt(cnsl.readLine());

            switch(opcao){
                case 1:
                    GerenciadorClientePJ gv = new GerenciadorClientePJ();
                    gv.menu();
                break;
                case 2:
                    //GerenciarCliente gc = new GerenciarCliente();
                    GerenciadorClientePJ gcp = new GerenciadorClientePJ();
                    gcp.menu();
                break;
                case 0:
                    System.out.println("Opcao 0");
                break;
                default:
                    System.out.println("Opcao nao encontrada");
                break;
            }
        } while (opcao != 0);
        
    }

    
}
