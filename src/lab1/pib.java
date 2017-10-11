package lab1;

import java.text.DecimalFormat;

public class pib {
    private String estado;
    private float valor;
    private double percent;

    public pib(String estado, float valor){
        this.setEstado(estado);
        this.setValor(valor);
    }

    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
    
    public void imprimir (){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(estado + " " + df.format(percent) + "%");
    }
}