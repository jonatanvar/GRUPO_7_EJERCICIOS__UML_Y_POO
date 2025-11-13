/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 2-b | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_2_B;

import java.util.List;
import java.util.ArrayList;

public class Docente {
    // Atributos de la clase
    private String nombreCompleto;
    private String numeroIdentidad;
    private String titulo;
    private String departamento;
    private String email;

    // Relación: un docente puede impartir varias clases
    private List<Clase> clasesAsignadas;

    // Constructor
    public Docente(String nombreCompleto, String numeroIdentidad, String titulo, String departamento, String email) {
        this.nombreCompleto = nombreCompleto;
        this.numeroIdentidad = numeroIdentidad;
        this.titulo = titulo;
        this.departamento = departamento;
        this.email = email;
        this.clasesAsignadas = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getNumeroIdentidad() { return numeroIdentidad; }
    public void setNumeroIdentidad(String numeroIdentidad) { this.numeroIdentidad = numeroIdentidad; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Clase> getClasesAsignadas() { return clasesAsignadas; }

    // Método para agregar clases al docente
    public void agregarClase(Clase clase) {
        clasesAsignadas.add(clase);
    }
}
