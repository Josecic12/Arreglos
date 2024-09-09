#Hacer un arreglo bidimencional y en pythonque me muestre las ventas del todo el año, mensuales, del departamento de ropa, deportes, jugueteria\n
#Crea metodos para insertar las metas por departamento, aparte para buscar un elemento particular y un metodo para eliminar las ventas de un departamento en particular
class VentasAnuales:
    def __init__(self):
        self.ventas = {
            'ropa': [0] * 12,
            'deportes': [0] * 12,
            'jugueteria': [0] * 12
        }

    def insertar_metas(self, departamento, metas):
        if departamento in self.ventas and len(metas) == 12:
            self.ventas[departamento] = metas
            print(f"Metas insertadas para {departamento}.")
        else:
            print("Departamento no encontrado o el número de metas no es correcto.")

    def buscar_venta(self, departamento, mes):
        if departamento in self.ventas and 1 <= mes <= 12:
            return self.ventas[departamento][mes - 1]
        else:
            return "Departamento o mes no válido."

    def eliminar_ventas(self, departamento):
        if departamento in self.ventas:
            self.ventas[departamento] = [0] * 12
            print(f"Ventas eliminadas para {departamento}.")
        else:
            print("Departamento no encontrado.")

    # Nueva función para eliminar solo un mes específico
    def eliminar_venta_mes(self, departamento, mes):
        if departamento in self.ventas and 1 <= mes <= 12:
            self.ventas[departamento][mes - 1] = 0
            print(f"Venta del mes {mes} eliminada para {departamento}.")
        else:
            print("Departamento o mes no válido.")

    def mostrar_ventas(self):
        for departamento, ventas in self.ventas.items():
            print(f"Ventas para {departamento.capitalize()}: {ventas}")


# Uso del código
ventas_anuales = VentasAnuales()

ventas_anuales.insertar_metas('ropa', [2000, 3000, 5000, 600, 1650, 1890, 2000, 3000, 4500, 900, 7500, 1070])
ventas_anuales.insertar_metas('deportes', [900, 950, 2500, 7800, 6000, 700, 1350, 6090, 1700, 680, 1550, 5000])
ventas_anuales.insertar_metas('jugueteria', [800, 850, 9000, 6800, 4500, 4000, 5500, 3500, 4690, 4999, 9000, 900])

ventas_anuales.mostrar_ventas()

venta_mes_5_ropa = ventas_anuales.buscar_venta('ropa', 5)
print(f"Venta del mes 5 en Ropa: {venta_mes_5_ropa}")

# Eliminamos solo el mes 5 de deportes
ventas_anuales.eliminar_venta_mes('deportes', 5)

ventas_anuales.mostrar_ventas()
