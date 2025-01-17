package com.alura.comex;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ProcesadorDeCsv procesadorDeCsv = new ProcesadorDeCsv();
        // ArrayList<Pedido> pedidos = new ArrayList<>();
        List<Pedido> pedidos = procesadorDeCsv.procesarArchivo("pedidos.csv");

        InformeSintetico informe = new InformeSintetico(pedidos);


        System.out.println("#### INFORME DE VALORES TOTALES");
        System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", informe.getTotalDePedidosRealizados());
        System.out.printf("- TOTAL DE PRODUCTOS VENDIDOS: %s\n", informe.getTotalDeProductosVendidos());
        System.out.printf("- TOTAL DE CATEGORIAS: %s\n", informe.getTotalDeCategorias());
        System.out.printf("- MONTO DE VENTAS: %s\n", NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(informe.getMontoDeVentas().setScale(2, RoundingMode.HALF_DOWN)));
        System.out.printf("- PEDIDO MAS BARATO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(informe.getMontoPedidoMasBarato().setScale(2, RoundingMode.HALF_DOWN)), informe.getProductoPedidoMasBarato());
        System.out.printf("- PEDIDO MAS CARO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(informe.getMontoPedidoMasCaro().setScale(2, RoundingMode.HALF_DOWN)), informe.getProductoPedidoMasCaro());


    }
    }
}
