public class Notificador {

    public void notificar (Deal deal) {
        deal.notificar();
    }

    public void descuento (Deal deal) {
        System.out.println("El descuento es " + deal.dcPorcentaje() + "%");
    }

    public static void main(String[] args) {

        Notificador notificador = new Notificador();
        Vuelo vuelo1 = new Vuelo();
        Paquete paquete1 = new Paquete();

        notificador.notificar(vuelo1);
        notificador.notificar(paquete1);
        notificador.descuento(vuelo1);
        notificador.descuento(paquete1);

    }
}