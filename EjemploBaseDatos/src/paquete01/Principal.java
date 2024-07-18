package paquete01;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author reroes
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Producto p = new Producto("celular", 100, 12);
        p.establecerIva();
        p.establecerValorFinal();
        Enlace enlace = new Enlace();
        enlace.insertarCiudad(p);
     
        // presentar los valores de tabla de la base de datos
        for (int i = 0; i < enlace.obtenerData().size(); i++) {
            System.out.println(enlace.obtenerData().get(i));
        }
        
    }
    
}
