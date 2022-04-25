/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

/**
 *
 * @author pikac
 */
public class Trebol extends CartaPoker {
    
    protected String id;

    public Trebol(int numero) {

        super(numero);
        this.id = "P" + numero;

    }

    public Trebol() {

        super();
        this.id = "P" + numero;

    }

    public void mostrarCarta() {

        switch (numero) {

            case 1:
                System.out.println("As de Tréboles");
                break;

            case 11:
                System.out.println("J de Tréboles");
                break;

            case 12:
                System.out.println("Q de Tréboles");
                break;

            case 13:
                System.out.println("K de Tréboles");
                break;

            default:
                System.out.println(numero + " de Tréboles");
                break;

        }

    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
