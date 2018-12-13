package edu.ujcv.progra1.edu.ujcv.progra1.models;

public class Reportes {
    private String nombre;
    private String rtn;
    private String cantidadProductos;
    private String total;

    public Reportes(String nombre, String rtn, String cantidadProductos, String total){
        this.nombre = nombre;
        this.rtn = rtn;
        this.cantidadProductos = cantidadProductos;
        this.total = total;
    }

    public Reportes(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn;
    }


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(String cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
}
