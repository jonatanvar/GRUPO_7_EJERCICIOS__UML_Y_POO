package Ejercicio_3_2.Fuentes;

/**
 * Clase que representa una Cuenta bancaria con operaciones básicas.
 */
public class Cuenta {
    // Atributos de la clase
    private String titular;
    private double saldo;

    // --- Constructores ---

    /**
     * Constructor por defecto.
     * Inicializa el titular a cadena vacía y el saldo a 0.0.
     */
    public Cuenta() {
        this.titular = "";
        this.saldo = 0.0;
    }

    /**
     * Constructor con parámetros.
     * @param titular Nombre del titular de la cuenta.
     * @param saldo Saldo inicial de la cuenta.
     */
    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        // El saldo no debe ser negativo
        this.saldo = Math.max(0.0, saldo);
    }

    /**
     * Constructor copia.
     * Crea una nueva cuenta con los mismos valores de otra cuenta.
     * @param c Objeto Cuenta a copiar.
     */
    public Cuenta(Cuenta c) {
        this.titular = c.titular;
        this.saldo = c.saldo;
    }

    // --- Getters y Setters ---

    /**
     * Obtiene el titular de la cuenta.
     * @return El nombre del titular.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Establece el titular de la cuenta.
     * @param titular El nuevo nombre del titular.
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Obtiene el saldo de la cuenta.
     * @return El saldo actual.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta. Útil para inicialización,
     * pero las operaciones deben usar ingreso/reintegro.
     * @param saldo El nuevo saldo. Debe ser mayor o igual a cero.
     */
    public void setSaldo(double saldo) {
        this.saldo = Math.max(0.0, saldo);
    }

    // --- Métodos Funcionales ---

    /**
     * Realiza un ingreso (depósito) a la cuenta.
     * @param cantidad Cantidad a ingresar. Debe ser positiva.
     * @return true si el ingreso fue exitoso, false en caso contrario.
     */
    public boolean ingreso(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            return true;
        }
        System.out.println("Error: La cantidad a ingresar debe ser positiva.");
        return false;
    }

    /**
     * Realiza un reintegro (retiro) de la cuenta.
     * @param cantidad Cantidad a retirar. Debe ser positiva y menor o igual al saldo.
     * @return true si el reintegro fue exitoso, false en caso contrario.
     */
    public boolean reintegro(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser positiva.");
            return false;
        }

        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente. Saldo actual: " + this.saldo);
            return false;
        }
    }

    /**
     * Realiza una transferencia a otra cuenta.
     * @param destino Objeto Cuenta al que se transfiere el dinero.
     * @param cantidad Cantidad a transferir.
     * @return true si la transferencia fue exitosa, false en caso contrario.
     */
    public boolean transferencia(Cuenta destino, double cantidad) {
        if (destino == null) {
            System.out.println("Error: La cuenta de destino no es válida.");
            return false;
        }

        // Primero intentamos hacer el reintegro de esta cuenta
        if (this.reintegro(cantidad)) {
            // Si el reintegro es exitoso, hacemos el ingreso en la cuenta destino
            // El ingreso siempre será exitoso si la cantidad es positiva (ya validado en reintegro)
            destino.ingreso(cantidad);
            return true;
        }
        // Si el reintegro falla (por saldo insuficiente o cantidad no válida), devuelve false
        return false;
    }

    /**
     * Sobreescribe el método toString para una representación legible de la cuenta.
     * @return Una cadena con el estado de la cuenta.
     */
    @Override
    public String toString() {
        return "Cuenta [Titular: " + titular + ", Saldo: " + String.format("%.2f", saldo) + "]";
    }
}