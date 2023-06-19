public class ExEstatico {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setNome("Adriana");
        System.out.println("Qtd de clientes = "+ c1.getQtdClientes());

        Cliente c2 = new Cliente();
        c2.setNome("Pedro");
        System.out.println("Qtd de clientes = " + c2.getQtdClientes());
    }
}
