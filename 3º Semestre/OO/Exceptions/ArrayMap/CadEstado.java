import java.util.HashMap;

public class CadEstado {
    public static void main(String[] args) {

        HashMap <String, Estado> estados = new HashMap<String, Estado>();

        Estado e1 = new Estado();

        e1.setNome("São Paulo");
        e1.setRegiao("Sudeste");
        estados.put("SP", e1);

        Estado e2 = new Estado();

        e2.setNome("Paraná");
        e2.setRegiao("Sul");
        estados.put("PR", e2);

        Estado e3 = new Estado();
        
        e3.setNome("Rio de janeioro");
        e3.setRegiao("Nordeste");
        estados.put("RJ", e3);

        System.out.println("Estados armazenados: "+estados);

        System.out.println("erificando se um estado existe");
        String pesquisado = "SP";

        if(estados.containsKey(pesquisado)){
            System.out.println(pesquisado + "Existe um hashMap");
            System.out.println("Buscando a região de estado de: "+ pesquisado);

            System.out.println(estados.get(pesquisado).getNome());
        }

        
    }
}
