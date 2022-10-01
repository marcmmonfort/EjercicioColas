import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> COLA = new QueueImplemenation<Integer>(5); // Creamos una cola con 5 posiciones.

        // --------------------------------------------------------------------------------

        try {

            // --------------------------------------------------------------------------------

            // TEST 1: PEDIR (POP) UN ELEMENTO CUANDO LA COLA ESTÁ VACÍA Y, PUES, RECIBIR LA CORRESPONDIENTE EXCEPCIÓN.

            /*
            int Ejemplo;
            Ejemplo = COLA.pop();
            */

            // --------------------------------------------------------------------------------

            // TEST 2: AÑADIR CORRECTAMENTE ELEMENTOS A LA COLA.

            COLA.push(1);
            System.out.println(COLA.size());
            COLA.push(2);
            System.out.println(COLA.size());
            COLA.push(3);
            System.out.println(COLA.size());
            COLA.push(4);
            System.out.println(COLA.size());
            COLA.push(5);
            System.out.println(COLA.size());

            // --------------------------------------------------------------------------------

            // TEST 3: AÑADIR (PUSH) UN ELEMENTO CUANDO LA COLA ESTÁ LLENA Y, PUES, RECIBIR LA CORRESPONDIENTE EXCEPCIÓN.

            /*
            COLA.push(6);
            */

            // --------------------------------------------------------------------------------

            // TEST 4: QUITAR (POP) UN ELEMENTO DE LA COLA.

            int Elemento;
            Elemento = COLA.pop();
            System.out.println("Ha salido de la cola ---> " + Elemento);

            // --------------------------------------------------------------------------------

            Class theClass = COLA.getClass();
            Method[] llistaMetodes = theClass.getDeclaredMethods();
            System.out.println(Arrays.asList(llistaMetodes));
            Field[] llistaAttr = theClass.getDeclaredFields();
            System.out.println(Arrays.asList(llistaAttr));

        }

        // --------------------------------------------------------------------------------

        // QUE PASA CUANDO SALTA LA EXCEPCIÓN DE QUE LA COLA ESTÁ LLENA.

        catch (FullQueueException fullExp) {
            System.out.println("¡OJO! >> LA COLA ESTÁ LLENA.");
            fullExp.printStackTrace();
        }

        // --------------------------------------------------------------------------------

        // QUE PASA CUANDO SALTA LA EXCEPCIÓN DE QUE LA COLA ESTÁ VACÍA.

        catch (EmptyQueueException empty) {
            System.out.println("¡OJO! >> LA COLA ESTÁ VACIA.");
            empty.printStackTrace();
        }

        // --------------------------------------------------------------------------------

    }
}
