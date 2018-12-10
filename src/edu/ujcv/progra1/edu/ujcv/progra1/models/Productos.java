package edu.ujcv.progra1.edu.ujcv.progra1.models;

public class Productos {

    private String nombreProducto;
    private String tipoProducto;
    private String marcaProducto;
    private String precioProducto;
    private String codigoProducto;

    public Productos(String codigoProducto, String nombreProducto, String tipoProducto, String marcaProducto, String precioProducto) {
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.marcaProducto = marcaProducto;
        this.codigoProducto = codigoProducto;
        this.precioProducto = precioProducto;
    }

    public Productos(){

    }
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
}
