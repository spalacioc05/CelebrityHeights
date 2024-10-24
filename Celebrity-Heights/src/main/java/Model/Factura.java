/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */

public class Factura {
    private int idFactura;
    private int idPropiedad;
    private int idPropietario;
    private String fechaExpedicion;
    private String fechaVencimiento;
    private String fechaPago;
    private String tipoFactura;
    private double monto;
    private double iva;
    private double montoTotal;
    private boolean pagado;

    public Factura() {
    }

    public Factura(int idFactura, int idPropiedad, int idPropietario, String fechaExpedicion, String fechaVencimiento, String fechaPago, String tipoFactura, double monto, double iva, double montoTotal, boolean pagado) {
        this.idFactura = idFactura;
        this.idPropiedad = idPropiedad;
        this.idPropietario = idPropietario;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPago = fechaPago;
        this.tipoFactura = tipoFactura;
        this.monto = monto;
        this.iva = iva;
        this.montoTotal = montoTotal;
        this.pagado = pagado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", idPropiedad=" + idPropiedad + ", idPropietario=" + idPropietario + ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento=" + fechaVencimiento + ", fechaPago=" + fechaPago + ", tipoFactura=" + tipoFactura + ", monto=" + monto + ", iva=" + iva + ", montoTotal=" + montoTotal + ", pagado=" + pagado + '}';
    }

}
