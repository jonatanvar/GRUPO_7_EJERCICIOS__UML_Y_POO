/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 1-c | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_1_C;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in, "UTF-8");
    private static Universidad universidad = new Universidad();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");
            salir = ejecutarOpcion(opcion);
        }
        System.out.println("Gracias por usar el sistema de matrícula universitaria.");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Matrícula Universitaria ---");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Registrar profesor");
        System.out.println("3. Registrar curso");
        System.out.println("4. Matricular estudiante en curso");
        System.out.println("5. Listar estudiantes");
        System.out.println("6. Listar cursos");
        System.out.println("7. Reporte por estudiante");
        System.out.println("8. Reporte por curso");
        System.out.println("9. Salir");
    }

    private static boolean ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarEstudiante();
            case 2 -> registrarProfesor();
            case 3 -> registrarCurso();
            case 4 -> matricularEstudiante();
            case 5 -> universidad.listarEstudiantes();
            case 6 -> universidad.listarCursos();
            case 7 -> universidad.reportePorEstudiante();
            case 8 -> universidad.reportePorCurso();
            case 9 -> { return true; }
            default -> System.out.println("Opción inválida. Intente nuevamente.");
        }
        return false;
    }

    private static void registrarEstudiante() {
        String nombre = leerTexto("Nombre del estudiante: ");
        String id = leerTexto("ID del estudiante: ");
        String carrera = leerTexto("Carrera: ");
        if(universidad.buscarEstudiante(id) != null) {
            System.out.println("Error: Ya existe un estudiante con ese ID.");
            return;
        }
        universidad.agregarEstudiante(new Estudiante(nombre, id, carrera));
        System.out.println("Estudiante registrado correctamente.");
    }

    private static void registrarProfesor() {
        String nombre = leerTexto("Nombre del profesor: ");
        String id = leerTexto("ID del profesor: ");
        if(universidad.buscarProfesor(id) != null) {
            System.out.println("Error: Ya existe un profesor con ese ID.");
            return;
        }
        universidad.agregarProfesor(new Profesor(nombre, id));
        System.out.println("Profesor registrado correctamente.");
    }

    private static void registrarCurso() {
        String codigo = leerTexto("Código del curso: ");
        String nombre = leerTexto("Nombre del curso: ");
        int creditos = leerEntero("Créditos: ");
        String idProfesor = leerTexto("ID del profesor: ");
        Profesor prof = universidad.buscarProfesor(idProfesor);
        if (prof != null) {
            if(universidad.buscarCurso(codigo) != null) {
                System.out.println("Error: Ya existe un curso con ese código.");
                return;
            }
            Curso curso = new Curso(codigo, nombre, creditos, prof);
            universidad.agregarCurso(curso);
            prof.agregarCurso(curso);
            System.out.println("Curso registrado correctamente.");
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private static void matricularEstudiante() {
        String idEst = leerTexto("ID del estudiante: ");
        Estudiante est = universidad.buscarEstudiante(idEst);
        if (est != null) {
            String codCurso = leerTexto("Código del curso: ");
            Curso curso = universidad.buscarCurso(codCurso);
            if (curso != null) {
                Matricula matricula = new Matricula(est, curso);
                est.agregarMatricula(matricula);
                curso.agregarMatricula(matricula);
                System.out.println("Matrícula realizada correctamente.");
            } else {
                System.out.println("Curso no encontrado.");
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    // Métodos de validación
    private static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: Entrada vacía. Intente nuevamente.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static int leerEntero(String mensaje) {
        int numero = -1;
        while (numero < 0) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                if (numero < 0) System.out.println("Error: Número inválido.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero.");
            }
        }
        return numero;
    }
}
