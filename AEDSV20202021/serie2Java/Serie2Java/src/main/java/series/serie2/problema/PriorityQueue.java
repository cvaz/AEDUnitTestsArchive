package series.serie2.problema;

interface PriorityQueue<E, P> {
    void add(E elem, P prio);
    E peek();
    E poll();
    void update(int key, P prio);
    void remove(int key);
    boolean empty();
}