public class Paquete implements Deal {

    private int identificador;
    private String pais;
    private String tipoRuta;
    private String tipoMoneda;
    private double precioTotal;
    private double precioAdulto;
    private double porcentajeAhorro;
    private int cantidadPasajeros;
    private int asientosDisponibles;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String nombreHotel;
    private int calificacionHotel;

    public boolean isValid() {
        if (this.disponible() && this.dealAtractivo() && this.ivaExento()) {
            return true;
        }
        return false;
    }

    private boolean disponible() {
        if(asientosDisponibles > 10) {
            return true;
        }
        return false;
    }

    private boolean dealAtractivo() {
        if(calificacionHotel == 5 && porcentajeAhorro < 15) {
            return false;
        }
        return true;
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
        return porcentajeAhorro;
    }

    public void notificar() {
        if(this.isValid()) {
            System.out.println(identificador + " es valido con un porcentaje de descuento de " + this.dcPorcentaje());
        } else {
            System.out.println("El deal " + identificador + " no es valido.");
        }
    }

}