public class OperacoesMatematicas {
    public int somar(int num1, int num2){
        return num1 + num2;
    }
    public int sub(int num1, int num2){
        return num1 - num2;
    }
    public int multiplicar(int num1, int num2){
        return num1 * num2;
    }
    public float dividir(float num1, float num2) throws DivisaoPorZeroException{
        if(num1 == 0 || num2 == 0){
            throw new DivisaoPorZeroException();
        }
        return num1 / num2;
    }
}
