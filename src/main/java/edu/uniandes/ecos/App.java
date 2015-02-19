package edu.uniandes.ecos;

import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    private static LinkedList<Double> listaDatos = new LinkedList<Double>();
    private static Double avg = 0.0;
    private static Double var2 = 0.0;
    private static Double var = 0.0;
    private static Double vs = 0.0;
    private static Double s = 0.0;
    private static Double m = 0.0;
    private static Double l = 0.0;
    private static Double vl = 0.0;
    
    public static void main( String[] args )
    {
        
//        llenarDatos();
        calcularPromedio();
        calcularVariance();
        caluclarDesviacionEstandar();
        calcularMidPoints();
    }
    
    public static void calcularMidPoints(){
        Double vsTemp = 0.0;
        vsTemp = avg - (2*var);
        vs = Math.pow(Math.E,vsTemp);
        
        Double sTemp = 0.0;
        sTemp = avg - (var);
        s = Math.pow(Math.E,sTemp);
        
        Double mTemp = 0.0;
        mTemp = avg;
        m = Math.pow(Math.E,mTemp);
        
        Double lTemp = 0.0;
        lTemp = avg + (var);
        l = Math.pow(Math.E,lTemp);
        
        Double vlTemp = 0.0;
        vlTemp = avg + (2 * var);
        vl = Math.pow(Math.E,vlTemp);
    }
    
    public static void caluclarDesviacionEstandar(){
        var = Math.sqrt(var2);
    }
    
    public static void calcularVariance(){
        Double sumatoria = 0.0;
        Double calculo = 0.0;
        for (Double listaDato : listaDatos) {
            calculo = new Double(0.0);
            calculo = Math.log(listaDato) - avg;
            sumatoria += Math.pow(calculo, 2);
        }  
        var2 = sumatoria / (listaDatos.size()-1);
    }
    
    public static void calcularPromedio(){
        Double sumatoria = 0.0;
        for (Double listaDato : listaDatos) {            
            sumatoria += Math.log(listaDato);
        }        
        avg = sumatoria/listaDatos.size();        
    }
    
    public static void llenarDatos(String lista){
        
        String[] datos = lista.split(",");
        for (String dato : datos) {
            listaDatos.add(Double.parseDouble(dato));
        } 
        calcularPromedio();
        calcularVariance();
        caluclarDesviacionEstandar();
        calcularMidPoints();
        
//       listaDatos.add(6.0);
//       listaDatos.add(6.0);
//       listaDatos.add(8.33);
//       listaDatos.add(10.33);
//       listaDatos.add(12.33);
//       listaDatos.add(16.4);
//       listaDatos.add(20.5);
//       listaDatos.add(21.75);
//       listaDatos.add(22.25);
//       listaDatos.add(23.0);
//       listaDatos.add(28.33);
//       listaDatos.add(29.0);
//       listaDatos.add(55.8);
    }

    public static LinkedList<Double> getListaDatos() {
        return listaDatos;
    }

    public static void setListaDatos(LinkedList<Double> listaDatos) {
        App.listaDatos = listaDatos;
    }

    public static Double getAvg() {
        return avg;
    }

    public static void setAvg(Double avg) {
        App.avg = avg;
    }

    public static Double getVar2() {
        return var2;
    }

    public static void setVar2(Double var2) {
        App.var2 = var2;
    }

    public static Double getVar() {
        return var;
    }

    public static void setVar(Double var) {
        App.var = var;
    }

    public static Double getVs() {
        return vs;
    }

    public static void setVs(Double vs) {
        App.vs = vs;
    }

    public static Double getS() {
        return s;
    }

    public static void setS(Double s) {
        App.s = s;
    }

    public static Double getM() {
        return m;
    }

    public static void setM(Double m) {
        App.m = m;
    }

    public static Double getL() {
        return l;
    }

    public static void setL(Double l) {
        App.l = l;
    }

    public static Double getVl() {
        return vl;
    }

    public static void setVl(Double vl) {
        App.vl = vl;
    }
    
    
}
