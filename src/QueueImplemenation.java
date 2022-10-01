public class QueueImplemenation<E> implements Queue<E>{

    int pointer; // Puntero que nos indica la siguiente posición libre de la cola.
    int limit; // Tamaño máximo de la cola.
    E[] vector; // Cola en forma de vector.

    // --------------------------------------------------------------------------------

    // INICIALIZADOR DE LA COLA.

    public QueueImplemenation(int limit) { // "public" porque es una función llamada desde "Queue".
        this.pointer = 0; // Ponemos el índice (puntero) de plazas del vector a 0.
        this.limit = limit; // Se declara la longitud que le hemos dicho al vector.
        this.vector = (E[]) new Object[limit]; // Se define el vector, ahora con la longitud deseada.
    }

    // --------------------------------------------------------------------------------

    // FUNCIÓN QUE NOS DEVUELVE TRUE (COLA LLENA) O FALSE (COLA NO LLENA).

    private boolean fullQueue(){ // "private" porque solo se usa en esta clase "QueueImplementation".
        boolean FULL;
        if (this.pointer == this.limit){
            FULL = true;
        }
        else {
            FULL = false;
        }
        return FULL;
    }

    // --------------------------------------------------------------------------------

    // FUNCIÓN QUE NOS DEVUELVE TRUE (COLA VACÍA) O FALSE (COLA NO VACÍA).

    private boolean emptyQueue(){ // "private" porque solo se usa en esta clase "QueueImplementation".
        boolean EMPTY;
        if (this.pointer == 0){
            EMPTY = true;
        }
        else {
            EMPTY = false;
        }
        return EMPTY;
    }

    // --------------------------------------------------------------------------------

    // AÑADIR UN NUEVO ELEMENTO A LA COLA.

    public void push(E e) throws FullQueueException { // "public" porque es una función llamada desde "Queue".
        // Si la cola está llena ...
        if (fullQueue()) {
            throw new FullQueueException();
        }
        // Si la cola no está llena ...
        this.vector[this.pointer] = e;
        pointer = pointer + 1; // Desplazamos la siguiente posición libre del vector.
    }

    // --------------------------------------------------------------------------------

    // QUITAR UN ELEMENTO DE LA COLA Y OBTENERLO.

    public E pop() throws EmptyQueueException { // "public" porque es una función llamada desde "Queue".
        // Si la cola está vacía ...
        if (emptyQueue()) {
            throw new EmptyQueueException();
        }
        // Si la cola no está vacía ...
        E element = this.vector[0]; // Sacamos el elemento que se quita de la cola.
        actualizar(); // Función que nos desplaza todos los elementos hacia la izquierda (incluyendo el puntero).
        return element; // Devolvemos este elemento.
    }

    // --------------------------------------------------------------------------------

    // DESPLAZAR TODOS LOS ELEMENTOS DE LA COLA HACIA LA IZQUIERDA (TAMBIÉN EL POINTER).

    private void actualizar() { // "private" porque solo se usa en esta clase "QueueImplementation".
        int ID;
        for (ID=1; ID<this.pointer; ID=ID+1){
            vector[ID-1] = vector[ID]; // Se desplazan los elementos hacia la izquierda.
        }
        this.pointer = this.pointer - 1; // El puntero se reduce en una posición.
    }

    // --------------------------------------------------------------------------------

    // DEVUELVE EL TAMAÑO DEL VECTOR EN EL MOMENTO QUE SE SOLICITA.

    public int size(){ // "public" porque es una función llamada desde "Queue".
        return this.pointer; // EJEMPLO: Si tiene 1 elemento, este estará en la posición 0 y el puntero en 1.
    }

    // --------------------------------------------------------------------------------

}
