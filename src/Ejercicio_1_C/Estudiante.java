/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 1-c | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_1_C;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String id;
    private String carrera;
    private ArrayList<Matricula> matriculas;

    public Estudiante(String nombre, String id, String carrera) {
        this.nombre = nombre;
        this.id = id;
        this.carrera = carrera;
        this.matriculas = new ArrayList<>();
    }

    public void agregarMatricula(Matricula m) {
        matriculas.add(m);
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public String getCarrera() { return carrera; }
    public ArrayList<Matricula> getMatriculas() { return matriculas; }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + carrera + ")";
    }
}
