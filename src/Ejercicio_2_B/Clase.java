/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 2-b | 2025-11-12
* ---------------------------------------------------------
 */

package Ejercicio_2_B;

public class Clase {
    // Atributos de la clase
    private String nombreClase;
    private String codigoClase;
    private String horario;
    private String aula;
    private int creditos;

    // Constructor
    public Clase(String nombreClase, String codigoClase, String horario, String aula, int creditos) {
        this.nombreClase = nombreClase;
        this.codigoClase = codigoClase;
        this.horario = horario;
        this.aula = aula;
        this.creditos = creditos;
    }

    // Getters y Setters
    public String getNombreClase() { return nombreClase; }
    public void setNombreClase(String nombreClase) { this.nombreClase = nombreClase; }

    public String getCodigoClase() { return codigoClase; }
    public void setCodigoClase(String codigoClase) { this.codigoClase = codigoClase; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
}
