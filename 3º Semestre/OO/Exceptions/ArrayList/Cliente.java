package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    ArrayList<OrcamentoCliente> listaOrcamentos = new ArrayList<OrcamentoCliente>();

    public String getNome() {
        return nome;
    }   
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void cadastrarOrcamento(){
        
        int opcao;
        String tipoOrcamento;
        Float valorOrcamento;
        do {
            Scanner leitor = new Scanner(System.in);
            OrcamentoCliente orcamento = new OrcamentoCliente();

            System.out.println("Qual o tipo do orçamento?");
            tipoOrcamento = leitor.nextLine();
            orcamento.setTipoOrcamento(tipoOrcamento);

            System.out.println("Entre com o valor do orçamento");
            valorOrcamento = leitor.nextFloat();
            orcamento.setValorOrcamento(valorOrcamento);

            listaOrcamentos.add(orcamento);
            System.out.println("Deseja cadastrar mais um oprçamento?");
            System.out.println("1 - Sim");
            System.out.println("0 - Não");
            opcao = leitor.nextInt();

        } while (opcao != 0);
        
    }

    public void listarOrcamentos(){

        for (OrcamentoCliente orcamentoCliente : listaOrcamentos) {
            System.out.println("Tipo do orçamento: "+ orcamentoCliente.getTipoOrcamento());
            System.out.println("Valor do orçamento: "+ orcamentoCliente.getValorOrcamento());
        }

    }
}
