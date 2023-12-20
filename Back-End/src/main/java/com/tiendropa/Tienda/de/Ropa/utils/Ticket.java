package com.tiendropa.Tienda.de.Ropa.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tiendropa.Tienda.de.Ropa.models.Orden;
import com.tiendropa.Tienda.de.Ropa.models.OrdenDetalle;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Ticket {

    public static ByteArrayResource generarTicket(Orden orden) throws IOException, DocumentException {

        Document ticket = new Document(PageSize.A4, 50, 50, 50, 50);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(ticket, byteArrayOutputStream);


        //Abrir el documento
        ticket.open();
        Font tituloFuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD);
        Paragraph titulo = new Paragraph("Tienda de Ropa", tituloFuente);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        ticket.add(titulo);

        //Crear la Tabla
        PdfPTable tabla = new PdfPTable(3);

        //Agregar columnas
        tabla.addCell("Nombre");
        tabla.addCell("Cantidad");
        tabla.addCell("Precio");
        tabla.addCell("Total");

        //Agrego espacio entre tabla y datos
        Paragraph space= new Paragraph(" ");
        ticket.add(space);

        //Agregar datos de la orden
        double total = 0;

        for (OrdenDetalle detalle : orden.getDetalles()) {
            tabla.addCell(detalle.getProducto().getNombre());
            tabla.addCell(String.valueOf(detalle.getCantidad()));
            tabla.addCell(String.valueOf(detalle.getPrecioTotal()));
            tabla.addCell("");
            total= total+detalle.getPrecioTotal();
        }
        tabla.addCell(String.valueOf(Math.round(total)));

        //Añadir la tabla al documento
        ticket.add(tabla);

        //Cerrar el documento
        ticket.close();

        //Convertir el contenido del PDF a un array de bytes
        byte[] content = byteArrayOutputStream.toByteArray();

        // Crear la respuesta con el PDF como contenido
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Ticket N°="+String.valueOf(orden.getId())+".pdf");
        headers.setContentLength(content.length);

        return new ByteArrayResource(content);
    }
}
