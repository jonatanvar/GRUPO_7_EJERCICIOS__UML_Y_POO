/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 1-c | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_1_C;

import java.util.ArrayList;

public class Profesor {
    private String nombre;
    private String id;
    private ArrayList<Curso> cursos;

    public Profesor(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public ArrayList<Curso> getCursos() { return cursos; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}
