/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 1-c | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_1_C;

import java.util.ArrayList;

public class Universidad {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;

    public Universidad() {
        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) { estudiantes.add(e); }
    public void agregarProfesor(Profesor p) { profesores.add(p); }
    public void agregarCurso(Curso c) { cursos.add(c); }

    public Estudiante buscarEstudiante(String id) {
        return estudiantes.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public Profesor buscarProfesor(String id) {
        return profesores.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Curso buscarCurso(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public void listarEstudiantes() {
        System.out.println("\n--- Lista de Estudiantes ---");
        if(estudiantes.isEmpty()) System.out.println("No hay estudiantes registrados.");
        else estudiantes.forEach(System.out::println);
    }

    public void listarCursos() {
        System.out.println("\n--- Lista de Cursos ---");
        if(cursos.isEmpty()) System.out.println("No hay cursos registrados.");
        else cursos.forEach(System.out::println);
    }

    public void reportePorEstudiante() {
        System.out.println("\n--- Reporte por Estudiante ---");
        for(Estudiante e : estudiantes) {
            System.out.println(e);
            if(e.getMatriculas().isEmpty()) {
                System.out.println("  Sin matrículas.");
            } else {
                for(Matricula m : e.getMatriculas()) {
                    System.out.println("  " + m.getCurso().getNombre() + " - Fecha: " + m.getFecha());
                }
            }
        }
    }

    public void reportePorCurso() {
        System.out.println("\n--- Reporte por Curso ---");
        for(Curso c : cursos) {
            System.out.println(c);
            if(c.getMatriculas().isEmpty()) {
                System.out.println("  Sin estudiantes matriculados.");
            } else {
                for(Matricula m : c.getMatriculas()) {
                    System.out.println("  " + m.getEstudiante().getNombre() + " - Fecha: " + m.getFecha());
                }
            }
        }
    }
}
