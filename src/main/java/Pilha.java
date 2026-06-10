public class Pilha {
    
    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == this.pilha.length - 1;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull()){
            throw new RuntimeException("Pilha cheia");
        }
        topo++;
        pilha[topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("Pilha vazia");
        }
        int valorRemovido = pilha[topo];
        topo--;
        return valorRemovido;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Pilha vazia");
        }
        int valor = pilha[topo];
        return valor;
    }


    public int top(){
        if(isEmpty()){
            throw new RuntimeException("Pilha vazia");
        }
        return pilha[topo];
    }

    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        Pilha auxiliar = new Pilha(size());
        String resultado = "";
        while (!isEmpty()) {
            auxiliar.push(pop());

        }
        while (!auxiliar.isEmpty()) {
            int elemento = auxiliar.pop();
            push(elemento);
            resultado = resultado + elemento;
            if (!auxiliar.isEmpty()){
                resultado = resultado + ", ";
            } 
        }
        return resultado;
    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha auxiliar = new Pilha(this.size());
        int indice = this.size() - 1;
        int result = -1;

        while (!isEmpty()) {
            int elemento = pop();
            auxiliar.push(elemento);

            if(elemento == valor && result == -1){
                result = indice;
            }

            indice--;
        }

        while (!auxiliar.isEmpty()) {
            push(auxiliar.pop());
        }


        return result;
    }

    
    // public int lastIndexOf(int valor) {
    //     Pilha auxiliar = new Pilha(this.size()) ;
    //     int indice = this.size() - 1;
    //     int result = -1;

    //     while (!isEmpty() && peek() != -1) {
    //         int elemento = pop();
    //         auxiliar.push(elemento);

    //         if(elemento == valor && result == -1){
    //             result = indice;
    //         }

    //         indice--;
    //     }

    //     while (!auxiliar.isEmpty()) {
    //         push(auxiliar.pop());
    //     }


    //     return result;
    // }

    public int size() {
        return this.topo + 1;
    }

}
