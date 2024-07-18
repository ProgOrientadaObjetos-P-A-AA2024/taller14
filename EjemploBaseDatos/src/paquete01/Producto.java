/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author reroes
 */
public class Producto {
    private String nombre;
    private double valor;
    private double porcentaje_iva;
    private double iva;
    private double valor_final;
    
    
    public Producto(String n, double v, double porcentaje){
        nombre = n;
        valor = v;
        porcentaje_iva = porcentaje;
                
    }
    
    // Se usa este constructor para obtener 
    // la información de la base de datos
    public Producto(String n, double v, double valor_iva, double porcentaje,
            double valor_total){
        nombre = n;
        valor = v;
        porcentaje_iva = porcentaje;
        iva = valor_iva;
        valor_final = valor_total;
                
    }
    
    public void establecerNombre(String n){
        nombre = n;
    }
    
    public void establecerValor(double n){
        valor = n;
    }
    
    public void establecerPorcentajeIva(double n){
        porcentaje_iva = n;
    }
    
    public void establecerIva(){
        iva = (porcentaje_iva*valor)/100;
    }
    
    public void establecerValorFinal(){
        valor_final = valor + iva;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    
    public double obtenerValor(){
        return valor;
    }
    
    public double obtenerPorcentajeIva(){
        return porcentaje_iva;
    }
    
    public double obtenerIva(){
        return iva;
    }
    
    public double obtenerValorFinal(){
        return valor_final;
    }
    
    @Override
    public String toString(){
        String cadena =  String.format("Producto:\n"
                + "Nombre: %s\n"
                + "Valor inicial: %.2f\n"
                + "Porcentaje IVA: %.2f %%\n"
                + "Valor IVA: %.2f\n"
                + "Valor final: %.2f\n", 
                nombre,
                valor,
                porcentaje_iva,
                iva,
                valor_final
                );
        return cadena;
    }
    
}
