package Ejercicio_3_2.Fuentes;

public class Main {
    public static void main(String[] args) {
        // 1. Uso de los Constructores
        System.out.println("--- 1. Pruebas de Constructores ---");

        // Constructor por defecto
        Cuenta cuentaA = new Cuenta();
        cuentaA.setTitular("Maria Rodriguez");
        cuentaA.setSaldo(500.0);
        System.out.println("Cuenta A (Defecto + Setters): " + cuentaA); // Salida: Titular: Maria Rodriguez, Saldo: 500.00

        // Constructor con parámetros
        Cuenta cuentaB = new Cuenta("Carlos Perez", 1200.50);
        System.out.println("Cuenta B (Parametrizado): " + cuentaB); // Salida: Titular: Carlos Perez, Saldo: 1200.50

        // Constructor copia
        Cuenta cuentaC = new Cuenta(cuentaB);
        cuentaC.setTitular("Carlos Perez (Copia)");
        System.out.println("Cuenta C (Copia de B): " + cuentaC); // Salida: Titular: Carlos Perez (Copia), Saldo: 1200.50

        System.out.println("\n--- 2. Pruebas de Métodos Funcionales ---");

        // 2. Método Ingreso
        System.out.println("\n*** Ingreso ***");
        System.out.println("Saldo de Cuenta A antes de ingreso: " + cuentaA.getSaldo()); // 500.0
        cuentaA.ingreso(250.75);
        System.out.println("Saldo de Cuenta A después de ingreso: " + cuentaA.getSaldo()); // 750.75

        // 3. Método Reintegro
        System.out.println("\n*** Reintegro ***");
        System.out.println("Saldo de Cuenta B antes de reintegro: " + cuentaB.getSaldo()); // 1200.50
        cuentaB.reintegro(300.0);
        System.out.println("Saldo de Cuenta B después de reintegro exitoso: " + cuentaB.getSaldo()); // 900.50

        // Intento de reintegro fallido (saldo insuficiente)
        System.out.print("Intento de reintegro de 1000.0 en Cuenta B: ");
        cuentaB.reintegro(1000.0);
        System.out.println("Saldo de Cuenta B después de reintegro fallido: " + cuentaB.getSaldo()); // 900.50

        // 4. Método Transferencia
        System.out.println("\n*** Transferencia ***");
        System.out.println("Cuenta A antes de transferir: " + cuentaA); // Saldo: 750.75
        System.out.println("Cuenta B antes de transferir: " + cuentaB); // Saldo: 900.50

        System.out.print("Intentando transferir 50.75 de A a B... ");
        if (cuentaA.transferencia(cuentaB, 50.75)) {
            System.out.println("Transferencia exitosa.");
        } else {
            System.out.println("Transferencia fallida.");
        }

        System.out.println("Cuenta A después de transferir: " + cuentaA); // Saldo: 700.00
        System.out.println("Cuenta B después de recibir: " + cuentaB);   // Saldo: 951.25

        // Intento de transferencia fallida (saldo insuficiente)
        System.out.print("Intentando transferir 1000.00 de A a B... ");
        if (cuentaA.transferencia(cuentaB, 1000.00)) {
            System.out.println("Transferencia exitosa.");
        } else {
            System.out.println("Transferencia fallida.");
        }
        System.out.println("Cuenta A final: " + cuentaA); // Saldo: 700.00 (no cambió)
        System.out.println("Cuenta B final: " + cuentaB); // Saldo: 951.25 (no cambió)
    }
}