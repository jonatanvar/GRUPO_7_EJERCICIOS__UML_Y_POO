/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 1-c | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_1_C;

import java.time.LocalDate;

public class Matricula {
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fecha;

    public Matricula(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fecha = LocalDate.now();
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Curso getCurso() { return curso; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return estudiante.getNombre() + " matriculado en " + curso.getNombre() + " el " + fecha;
    }
}
