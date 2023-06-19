import java.io.Console;

public class AluguelDePneus {
    public static void main(String[] args) {
        AluguelDePneus aluguel = new AluguelDePneus();

        aluguel.menuPrincipal();
    }
    public void menuPrincipal(){
        Console cnsl = System.console();

        int opcao = 0;
        do{
            System.out.println("-----------");
            System.out.println("Entre com a opção desejada");
            System.out.println("[1] - Gerenciar Pneus");
            System.out.println("[2] - Gerenciar cliente");
            System.out.println("[9] - Sair");
            opcao = Integer.parseInt(cnsl.readLine());
            switch (opcao) {
                case 1:
                    GerenciarPneu gp = new GerenciarPneu();
                    gp.menuPneu();
                    break;
                default:
                    break;
            }

        }while(opcao != 9);
    }
}
