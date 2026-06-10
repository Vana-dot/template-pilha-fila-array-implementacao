public class Fila {
    
    private int[] fila;
    private int head;
    private int tail;
    private int tamanho;  // quantos elementos tem agora
    
    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        fila = new int[capacidade];
        head = -1;
        tail = -1;
        tamanho = 0;

    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public boolean isFull() {
        return this.tamanho == this.fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if(isFull()){
            throw new RuntimeException("Fila cheia!");
        }
        if(head == -1){
            head = 0;
            tail = 0;
        }else{
            tail = (tail + 1) % fila.length;
        }
        
        fila[tail] = valor;
        tamanho++;
        
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()){
            throw new RuntimeException("Fila vazia");
        }

        int valor = fila[head];
        if(tamanho == 1){
            head = -1;
            tail = -1;
        }else{
            head = (head + 1) % fila.length;
        }
        tamanho--;
        
        return valor;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if(isEmpty()){
            throw new RuntimeException("Fila vazia");
        }
        int primeiroValor = fila[head];
        return primeiroValor;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {

        if(isEmpty()){
            throw new RuntimeException("Fila vazia");
        }
        int ultimoValor = fila[tail];
        return ultimoValor;
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        Fila auxiliar = new Fila(size());
        String resultado = "";
        while (!isEmpty()) {
            auxiliar.addLast(removeFirst());

        }
        while (!auxiliar.isEmpty()) {
            int elemento = auxiliar.removeFirst();
            addLast(elemento);
            resultado = resultado + elemento;
            if (!auxiliar.isEmpty()){
                resultado = resultado + ", ";
            } 
        }
        return resultado;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        Fila auxiliar = new Fila(size());
        int indice = 0;
        int result = -1;
        
        while(!isEmpty()){
            int elemento = removeFirst();
            auxiliar.addLast(elemento);

            if(elemento == valor && result == -1){
                result = indice;
            }
            indice++;
        }

        while (!auxiliar.isEmpty()) {
            addLast(auxiliar.removeFirst());
        }
        return result;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Fila auxiliar = new Fila(size());
        int indice = 0;
        int result = -1;
        
        while(!isEmpty()){
            int elemento = removeFirst();
            auxiliar.addLast(elemento);

            if(elemento == valor){
                result = indice;
            }
            indice++;
        }

        while (!auxiliar.isEmpty()) {
            addLast(auxiliar.removeFirst());
        }
        return result;
    }
    
    public int size() {
        return this.tamanho;
    }

}
