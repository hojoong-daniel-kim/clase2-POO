public class Vuelo implements Deal {

    private int identificador;
    private String pais;
    private String tipoItinerario;
    private String tipoRuta;
    private String tipoMoneda;
    private double precioNormal;
    private double precioOferta;
    private int asientosDisponibles;
    private String ciudadOrigen;
    private String ciudadDestino;

    public boolean isValid() {
        if (this.disponible() && this.dealAtractivo() && this.ivaExento()) {
            return true;
        }
        return false;
    }

    private boolean disponible() {
        if(asientosDisponibles > 15) {
            return true;
        }
        return false;
    }

    private boolean dealAtractivo() {
        if(precioOferta / precioNormal < 0.95) {
            return true;
        }
        return false;
    }

    private boolean ivaExento() {
        if(this.pais.equals("Argentina") || this.pais.equals("Colombia")) {
            if(tipoRuta.equals("Nacional")) {
                return false;
            }
        }
        return true;
    }

    public double dcPorcentaje() {
        double ahorro;
        ahorro = 100 - this.precioOferta / this.precioNormal * 100;
        return ahorro;
    }

    public void notificar() {
        if(this.isValid()) {
            System.out.println(this.identificador + " es valido con un descuento de " + this.dcPorcentaje());
        } else {
            System.out.println("El deal " + this.identificador + " no es valido.");
        }
    }


}