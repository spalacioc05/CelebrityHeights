/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */
public class Multa {
    private String idMulta;
    private String idPropiedad;
    private String idPropietario;
    private String fechaExpedicion;
    private String fechaVencimiento;
    private String fechaPago;
    private String motivo;
    private int monto;
    private int iva;
    private int montoTotal;
    private boolean pagado;

    public Multa() {
    }

    public Multa(String idMulta, String idPropiedad, String idPropietario, String fechaExpedicion, String fechaVencimiento, String fechaPago, String motivo, int monto, int iva, int montoTotal, boolean pagado) {
        this.idMulta = idMulta;
        this.idPropiedad = idPropiedad;
        this.idPropietario = idPropietario;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPago = fechaPago;
        this.motivo = motivo;
        this.monto = monto;
        this.iva = iva;
        this.montoTotal = montoTotal;
        this.pagado = pagado;
    }

    public String getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(String idMulta) {
        this.idMulta = idMulta;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
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
        return "Multa{" + "idMulta=" + idMulta + ", idPropiedad=" + idPropiedad + ", idPropietario=" + idPropietario + ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento=" + fechaVencimiento + ", fechaPago=" + fechaPago + ", motivo=" + motivo + ", monto=" + monto + ", iva=" + iva + ", montoTotal=" + montoTotal + ", pagado=" + pagado + '}';
    }
    
    
    
}
