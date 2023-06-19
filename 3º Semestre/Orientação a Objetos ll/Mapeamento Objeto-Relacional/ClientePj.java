public class ClientePj {
    private int codigoClientePJ;
    private String nome;
    private String cnpj;
    private EnderecoPj EnderecoPJ;

    public int getCodigoClientePJ() {
        return codigoClientePJ; 
    }
    public EnderecoPj getEnderecoPJ() {
        return EnderecoPJ;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setCodigoClientePJ(int codigoClientePJ) {
        this.codigoClientePJ = codigoClientePJ;
    }
    public void setEnderecoPJ(EnderecoPj enderecoPJ) {
        EnderecoPJ = enderecoPJ;
    }

    
}
