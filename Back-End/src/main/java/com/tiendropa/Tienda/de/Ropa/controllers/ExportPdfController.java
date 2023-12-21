package com.tiendropa.Tienda.de.Ropa.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tiendropa.Tienda.de.Ropa.models.Orden;
import com.tiendropa.Tienda.de.Ropa.models.OrdenDetalle;
import com.tiendropa.Tienda.de.Ropa.models.Usuario;
import com.tiendropa.Tienda.de.Ropa.services.OrdenDetalleService;
import com.tiendropa.Tienda.de.Ropa.services.OrdenService;
import com.tiendropa.Tienda.de.Ropa.services.ProductoService;
import com.tiendropa.Tienda.de.Ropa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/ticket")
public class ExportPdfController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private OrdenDetalleService ordenDetalleService;
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/export")
    @Secured("CLIENTE")
    public ResponseEntity<Object> exportPdf(@RequestParam long ordenId, Authentication auth) throws IOException, DocumentException {
        Usuario usuario = usuarioService.findByEmail(auth.getName());
        if (ordenId <= 0 || !ordenService.existsByIdAndUsuario(ordenId, usuario)) {
            return new ResponseEntity<>("El id de la orden es incorrecto", HttpStatus.BAD_REQUEST);
        }
        Orden orden = ordenService.findByIdAndUsuario(ordenId, usuario);

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

        return new ResponseEntity<>(content,headers,HttpStatus.OK);
    }
}
