package com.alura.comex;

import java.math.BigDecimal;
import java.util.List;

public class InformeSintetico {
    private int totalDeProductosVendidos;
    private int totalDePedidosRealizados;
    private int totalDeCategorias;
    private BigDecimal montoDeVentas;
    private Pedido pedidoMasBarato;
    private Pedido pedidoMasCaro;

    public InformeSintetico(List<Pedido> pedidos) {
        montoDeVentas = BigDecimal.ZERO;
        CategoriasProcesadas categoriasProcesadas = new CategoriasProcesadas();

        for (Pedido pedidoActual : pedidos) {
            if (pedidoMasBarato == null || pedidoActual.getPrecio().multiply(new BigDecimal(pedidoActual.getCantidad())).compareTo(pedidoMasBarato.getPrecio().multiply(new BigDecimal(pedidoMasBarato.getCantidad()))) < 0) {
                pedidoMasBarato = pedidoActual;
            }

            if (pedidoMasCaro == null || pedidoActual.getPrecio().multiply(new BigDecimal(pedidoActual.getCantidad())).compareTo(pedidoMasCaro.getPrecio().multiply(new BigDecimal(pedidoMasCaro.getCantidad()))) > 0) {
                pedidoMasCaro = pedidoActual;
            }

            montoDeVentas = montoDeVentas.add(pedidoActual.getPrecio().multiply(new BigDecimal(pedidoActual.getCantidad())));
            totalDeProductosVendidos += pedidoActual.getCantidad();
            totalDePedidosRealizados++;

            if (!categoriasProcesadas.contains(pedidoActual.getCategoria())) {
                totalDeCategorias++;
                categoriasProcesadas.add(pedidoActual.getCategoria());
            }
        }
    }

    public int getTotalDeProductosVendidos() {
        return totalDeProductosVendidos;
    }

    public int getTotalDePedidosRealizados() {
        return totalDePedidosRealizados;
    }

    public int getTotalDeCategorias() {
        return totalDeCategorias;
    }

    public BigDecimal getMontoDeVentas() {
        return montoDeVentas;
    }

    public BigDecimal getMontoPedidoMasBarato() {
        return pedidoMasBarato.getPrecio().multiply(new BigDecimal(pedidoMasBarato.getCantidad()));
    }

    public String getProductoPedidoMasBarato() {
        return pedidoMasBarato.getProducto();
    }

    public BigDecimal getMontoPedidoMasCaro() {
        return pedidoMasCaro.getPrecio().multiply(new BigDecimal(pedidoMasCaro.getCantidad()));
    }

    public String getProductoPedidoMasCaro() {
        return pedidoMasCaro.getProducto();
    }
}
