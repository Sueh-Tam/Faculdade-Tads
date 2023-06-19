public class Cliente {
    private String nome;
    private String email;
    private static int qtdClientes;
    public Cliente(){
        this.qtdClientes++;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public int getQtdClientes() {
        return qtdClientes;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
