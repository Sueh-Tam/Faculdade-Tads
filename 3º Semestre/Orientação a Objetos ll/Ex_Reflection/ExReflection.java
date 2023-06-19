import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ExReflection{
    public static void main(String[] args) {
        try {
            Class c = Class.forName("Veiculo"); // Usado em casos em que você sabe o nome da Classe
            Veiculo v =  new Veiculo();
            Class c2 = v.getClass(); // Se recebo um objeto como para e não sei o tipo
            System.out.println(c.getName());
            System.out.println("--> Atribute");
            Field fields[]  = c.getDeclaredFields();
            for(Field f : fields){
                System.out.println(f.toString());
                System.out.println(f.getName() + " - " + f.getType());
            }
            System.out.println("--> Métodos: ");
            Method methods[] = c.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
                Parameter parameters[] = method.getParameters();
                System.out.println("-->Parametros");
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.toString());
                    System.out.println(parameter.getName());
                }
                if(method.getName().toString().equals("setAno")){
                    method.invoke(c.newInstance(), 2020)
                }
            }
        } catch (Throwable e) {
            // Throwable inclui Erros e Exception
            System.err.println(e);
        }
    }
}