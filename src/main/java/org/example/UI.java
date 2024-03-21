package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    ////////////////////////    ATTRIBUTI   ////////////////////////
    private static final Scanner scanner = new Scanner(System.in);

    ////////////////////////    METODI  ////////////////////////
    public static float leggiNumero(String messaggio) {
        float numero;

        while (true) {
            try {
                System.out.print(messaggio);
                numero = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Errore: Devi inserire un numero valido.");
            }
            finally {
                scanner.nextLine();
            }
        }
        return numero;
    }
    public static float leggiNumero(String messaggio,int min) {
        float numero;

        while (true) {
            try {
                System.out.print(messaggio);
                numero = scanner.nextFloat();
                if(numero < min) throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Errore: Devi inserire un numero intero valido.");
            }
            finally {
                scanner.nextLine();
            }
        }
        return numero;
    }
    public static float leggiNumero(String messaggio,int min, int max) {
        float numero;

        while (true) {
            try {
                System.out.print(messaggio);
                numero = scanner.nextFloat();
                if(numero < min || numero > max) throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Errore: Devi inserire un numero intero valido.");
            }
            finally {
                scanner.nextLine();
            }
        }
        return numero;
    }
    public static String leggiStringa(String messaggio) {
        System.out.print(messaggio);
        String risultato = scanner.nextLine();
        return risultato;
    }

}
