/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 1-c | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_1_C;

import java.util.ArrayList;

public class Curso {
    private String codigo;
    private String nombre;
    private int creditos;
    private Profesor profesor;
    private ArrayList<Matricula> matriculas;

    public Curso(String codigo, String nombre, int creditos, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.profesor = profesor;
        this.matriculas = new ArrayList<>();
    }

    public void agregarMatricula(Matricula m) {
        matriculas.add(m);
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }
    public ArrayList<Matricula> getMatriculas() { return matriculas; }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " (Prof: " + profesor.getNombre() + ")";
    }
}
