
import java.util.HashMap;
import java.util.Map;

public class ListaLigada {
    
    Node head, tail;
    Map<String, Integer> index;

    public boolean add(String key, double value) {
        
        String[] dados = key.split("\s-\s");
        String name1 = dados[0];
        String name2 = dados[1];

        if (this.head == null) {
            this.head = new Node();
            this.head.setName(name1);
            this.head.setNextConversor(value);
            this.head.setNext(new Node());
            this.head.getNext().setName(name2);
            this.head.getNext().setPrev(head);
            this.tail = this.head.getNext();
            this.list();
            return true;
        }
        
        for (int i = 0; i < dados.length; i++) {
            if (this.head.getName().equals(dados[i])) {
                Node temp = this.head;
                Node temp2 = new Node();
                temp2.setNext(temp);
                if (i == 0) {
                    temp2.setName(dados[1]);
                    temp2.setNextConversor(1.0/value);
                } else {
                    temp2.setName(dados[0]);
                    temp2.setNextConversor(value);
                }
                temp.setPrev(temp2);
                this.head = temp2;
                this.list();
                return true;
            }
            if (this.tail.getName().equals(dados[i])) {
                Node temp = this.tail;
                Node temp2 = new Node();
                temp2.setPrev(temp);
                if (i == 0) {
                    temp2.setName(dados[1]);
                    temp.setNextConversor(value);
                } else {
                    temp2.setName(dados[0]);
                    temp.setNextConversor(1.0/value);
                }
                temp.setNext(temp2);
                this.tail = temp2;
                this.list();
                return true;
            }
        }
        return false;
    }

    public void list() {

        Node atual = this.head;
        this.index = new HashMap<>();
        
        int ind = 0;
        while (atual != null) {
            this.index.put(atual.getName(), ind);
            atual = atual.getNext();
            ind++;
        }
    }

    public Integer getIndex(String key) {
        return this.index.get(key);
    }

    public double convert(String key) {
        Node atual = this.head;
        String[] dados = key.split("\s-\s");
        int indice1 = this.getIndex(dados[0]);
        int indice2 = this.getIndex(dados[1]);
        int ciclos = indice1 - indice2;
        double resultado = 1;
        if (ciclos < 0) {
            for (int i = 0; i < indice1; i++) {
                atual = atual.getNext();
            }
            for (int i = 0; i < -ciclos; i++) {
                resultado *= atual.getNextConversor();
                atual = atual.getNext();
            }
        } else {
            for (int i = 0; i < indice2; i++) {
                atual = atual.getNext();
            }
            for (int i = 0; i < ciclos; i++) {
                resultado *= atual.getNextConversor();
                atual = atual.getNext();
            }
            resultado = 1.0 / resultado;
        }
        return resultado;
    }
}
