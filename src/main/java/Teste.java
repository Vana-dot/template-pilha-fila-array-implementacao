public class Teste {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(10);
        System.out.println("indexOf(10) = " + pilha.indexOf(10));
        System.out.println("esperado = 3");
       // System.out.println("lastIndexOf(10) = " + pilha.lastIndexOf(10));
        System.out.println("esperado = 0");
    }
}
