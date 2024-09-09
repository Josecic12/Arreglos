import java.util.HashMap;
import java.util.Map;

public class VentasAnuales {
    private Map<String, int[]> ventas;

    public VentasAnuales() {
        ventas = new HashMap<>();
        ventas.put("ropa", new int[12]);
        ventas.put("deportes", new int[12]);
        ventas.put("jugueteria", new int[12]);
    }

    public void insertarMetas(String departamento, int[] metas) {
        if (ventas.containsKey(departamento) && metas.length == 12) {
            ventas.put(departamento, metas);
            System.out.println("Metas insertadas para " + departamento + ".");
        } else {
            System.out.println("Departamento no encontrado o el número de metas no es correcto.");
        }
    }

    public int buscarVenta(String departamento, int mes) {
        if (ventas.containsKey(departamento) && mes >= 1 && mes <= 12) {
            return ventas.get(departamento)[mes - 1];
        } else {
            System.out.println("Departamento o mes no válido.");
            return -1; // Devolvemos -1 si no es válido
        }
    }

    public void eliminarVentas(String departamento) {
        if (ventas.containsKey(departamento)) {
            ventas.put(departamento, new int[12]);
            System.out.println("Ventas eliminadas para " + departamento + ".");
        } else {
            System.out.println("Departamento no encontrado.");
        }
    }

    public void eliminarVentaMes(String departamento, int mes) {
        if (ventas.containsKey(departamento) && mes >= 1 && mes <= 12) {
            ventas.get(departamento)[mes - 1] = 0;
            System.out.println("Venta del mes " + mes + " eliminada para " + departamento + ".");
        } else {
            System.out.println("Departamento o mes no válido.");
        }
    }

    public void mostrarVentas() {
        for (Map.Entry<String, int[]> entry : ventas.entrySet()) {
            System.out.print("Ventas para " + capitalize(entry.getKey()) + ": ");
            for (int venta : entry.getValue()) {
                System.out.print(venta + " ");
            }
            System.out.println();
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void main(String[] args) {
        VentasAnuales ventasAnuales = new VentasAnuales();

        ventasAnuales.insertarMetas("ropa", new int[]{2000, 3000, 5000, 600, 1650, 1890, 2000, 3000, 4500, 900, 7500, 1070});
        ventasAnuales.insertarMetas("deportes", new int[]{900, 950, 2500, 7800, 6000, 700, 1350, 6090, 1700, 680, 1550, 5000});
        ventasAnuales.insertarMetas("jugueteria", new int[]{800, 850, 9000, 6800, 4500, 4000, 5500, 3500, 4690, 4999, 9000, 900});

        ventasAnuales.mostrarVentas();

        int ventaMes5Ropa = ventasAnuales.buscarVenta("ropa", 7);
        System.out.println("Venta del mes 5 en Ropa: " + ventaMes5Ropa);

        ventasAnuales.eliminarVentaMes("deportes", 10);

        ventasAnuales.mostrarVentas();
    }
}
