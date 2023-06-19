public class ExemploExcecao {
    public static void main(String[] args){
        ExemploExcecao ee = new ExemploExcecao();
        ee.calcular();
    }
    public void calcular(){
        try{
            float res;
            OperacoesMatematicas op = new OperacoesMatematicas();
            res = op.dividir(0, 1);
            System.out.println(res + "\n");
            
            res = op.somar(5, 9);
            System.out.println(res + "\n");

            res = op.sub(10, 20);
            System.out.println(res + "\n");

            res = op.multiplicar(5, 9);
            System.out.println(res + "\n");

        }catch(DivisaoPorZeroException e){
            System.out.println("Descericao do erro: " + e.getMessage());
        }
    }
}
