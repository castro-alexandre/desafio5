
public class App {
    
    public static void main(String[] args) throws Exception {

        ListaLigada ll = new ListaLigada();
        ll.add("USD - AUD", 1.44);
        ll.add("USD - BRL", 5.15);
        ll.add("BRL - EUR", 0.18);
        ll.add("EUR - GBP", 0.86);
    
        double resultado = ll.convert("GBP - USD");

        System.out.printf("%3.2f\n", resultado);
    }
}
