package teste1;

public class Lists {

    static class Node<E>{
        private E value;
        private Node<E> next;
        private Node<E> previous;
        Node(){
            this.next=this;
            this.previous=this;
        }
    }

    public static void reSort(Node<Integer> list){
            Node<Integer> curr = list.next;
            // Percorrer a lista
            while(curr != list) {
                // Se o elemento for negativo, tem de ser movido para a cabeça
                if(curr.value< 0) {
                   Node<Integer> toMove=curr;
                   curr=curr.next;
                   //desligar o nó da sua posição atual
                   toMove.previous.next=toMove.next;
                   toMove.next.previous=toMove.previous;
                   //ligar a seguir à sentinela
                   toMove.next=list.next;
                   toMove.previous=list;
                   list.next.previous=toMove;
                   list.next=toMove;
                }
                curr = curr.next;
            }
        }

    public static void insert(Node<Integer> list, Integer e) {
        Node<Integer> x = new Node<Integer>();
        x.value = e;
        x.next = list.next;
        list.next.previous = x;
        list.next = x;
        x.previous = list;
    }
    public static void print(Node<Integer> list){
        Node<Integer> current=list.next;
        while(current!=list){
            System.out.print(current.value + " ");
            current=current.next;
        }
        System.out.println();
    }

    public static void  main(String[] args){
        Node<Integer> list1=new Node<>();
        insert(list1,21);
        insert(list1,-20);
        insert(list1, 15);
        insert(list1,15);
        insert(list1,-14);
        insert(list1,12);
        insert(list1,10);
        insert(list1,7);
        insert(list1,-6);
        insert(list1,3);
        print(list1);
        reSort(list1);
        print(list1);
    }
}
