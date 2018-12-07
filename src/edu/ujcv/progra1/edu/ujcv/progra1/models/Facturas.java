package edu.ujcv.progra1.edu.ujcv.progra1.models;

public class Facturas {
    private String codigoFactura;
    private String RTN;
    private String clientes;
    private String saldoTotalFactura;

    public Facturas(String codigoFactura, String clientes, String RTN, String saldoTotalFactura){
        this.codigoFactura = codigoFactura;
        this.RTN = RTN;
        this.clientes = clientes;
        this.saldoTotalFactura = saldoTotalFactura;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getRTN() {
        return RTN;
    }

    public void setRTN(String RTN) {
        this.RTN = RTN;
    }

    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getSaldoTotalFactura() {
        return saldoTotalFactura;
    }

    public void setSaldoTotalFactura(String saldoTotalFactura) {
        this.saldoTotalFactura = saldoTotalFactura;
    }
}
