import java.util.ArrayList;
import java.util.Iterator;

public class CadCliente {
    public static void main(String[] args) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        Cliente c1 = new Cliente();

        c1.setNome("Matheus");
        c1.setEmail("matheus@papa");
        c1.setCpf("123456789");
        lista.add(c1);

        Cliente c2 = new Cliente();

        c2.setNome("pedro");
        c2.setEmail("pedro@papa");
        c2.setCpf("987654321");
        lista.add(c2);

        Cliente c3 = new Cliente();

        c3.setNome("Cadu");
        c3.setEmail("mcadu@pa");
        c3.setCpf("1597563");
        lista.add(c3);

        Cliente c4 = new Cliente();

        c4.setNome("sapo");
        c4.setEmail("sapo@a");
        c4.setCpf("456789123");
        lista.add(c4);

        System.out.println("Percorrendo a lista: ");

        Iterator<Cliente> it = lista.iterator();

        while(it.hasNext()){
            Cliente cli =  it.next();
            System.out.println("Cliente: " +cli.getNome() + "\n cpf: "+ cli.getCpf() + "\n Email: " + cli.getEmail());
        }

        //remover item da lista

        Cliente cliRemover = new Cliente();
        cliRemover.setCpf("123456789");
        
        Iterator<Cliente> itRemover = lista.iterator();

        while(itRemover.hasNext()){
            if(itRemover.next().getCpf().equals(cliRemover.getCpf())){
                System.out.println("Removedo cliente");
                itRemover.remove();

            }
        }
        //percorrendo com foreach
        for (Cliente cli : lista) {
            System.out.println(cli.getNome() + "\n");
        }


    }
}
