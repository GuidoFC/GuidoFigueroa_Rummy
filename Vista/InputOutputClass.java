package Vista;

import java.util.Scanner;

public class InputOutputClass {
    /*
    sirve para que crear un scaner que lo puedan utilizar todas las clases
va en el package de logica
y luego en las clases que necesites el scaner pones lo siguiente:
private InputOutputClass inputOutput = new InputOutputClass();
    * */
    private Scanner sc;
    public InputOutputClass() {
        this.sc = new Scanner(System.in);
    }
    public int llegirInt() {
        return sc.nextInt();
    }
}
