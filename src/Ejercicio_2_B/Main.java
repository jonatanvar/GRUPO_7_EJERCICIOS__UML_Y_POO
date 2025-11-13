/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 2-b | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_2_B;

public class Main {
    public static void main(String[] args) {
        // Crear un docente
        Docente docente1 = new Docente("Juan Pérez", "0801199001234", "Licenciado en Matemáticas", "Ciencias Exactas", "juan.perez@unah.hn");

        // Crear clases
        Clase clase1 = new Clase("Matemáticas I", "MAT101", "Lunes 8:00-10:00", "Aula 5", 4);
        Clase clase2 = new Clase("Álgebra Lineal", "MAT102", "Miércoles 10:00-12:00", "Aula 6", 3);

        // Asignar clases al docente
        docente1.agregarClase(clase1);
        docente1.agregarClase(clase2);

        // Mostrar información del docente y sus clases
        System.out.println("Docente: " + docente1.getNombreCompleto());
        System.out.println("Clases asignadas:");
        for (Clase c : docente1.getClasesAsignadas()) {
            System.out.println("- " + c.getNombreClase() + " (" + c.getCodigoClase() + ")");
        }
    }
}
