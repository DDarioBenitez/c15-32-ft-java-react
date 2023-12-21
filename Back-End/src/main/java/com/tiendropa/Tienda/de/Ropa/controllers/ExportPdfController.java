package com.tiendropa.Tienda.de.Ropa.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
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
import java.text.NumberFormat;
import java.util.Locale;

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
        System.out.println(usuario);
        if (ordenId <= 0 || !ordenService.existsByIdAndUsuario(ordenId, usuario)) {
            return new ResponseEntity<>("El id de la orden es incorrecto", HttpStatus.BAD_REQUEST);
        }
        Orden orden = ordenService.findByIdAndUsuario(ordenId, usuario);

        Document ticket = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(ticket, byteArrayOutputStream);

        // Abrir el documento
        ticket.open();

        // Estilos para el título y subtítulo
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);

        // Título y subtítulo
        Paragraph title = new Paragraph("Ticket de Compra", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(10);
        ticket.add(title);

        // Subtítulo con detalles del cliente y la tienda
        Paragraph subtitle = new Paragraph();
        subtitle.add(new Chunk("Cliente: " + usuario.getNombre() + " " + usuario.getApellido(), subtitleFont));
        subtitle.add(Chunk.NEWLINE);
        subtitle.add(new Chunk("Email: " + usuario.getEmail(), subtitleFont));
        subtitle.add(Chunk.NEWLINE);
        subtitle.add(new Chunk("Tienda: Opal", subtitleFont));
        subtitle.add(Chunk.NEWLINE);
        subtitle.add(new Chunk("Ticket: " + orden.getId(), subtitleFont));
        subtitle.setAlignment(Element.ALIGN_LEFT);
        subtitle.setSpacingAfter(20);
        ticket.add(subtitle);

        // Crear la tabla
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{3, 2, 2});

        // Encabezados de la tabla
        table.addCell(getCell("Nombre", true));
        table.addCell(getCell("Cantidad", true));
        table.addCell(getCell("Precio", true));

        // Agregar datos de la orden
        double total = 0;
        // Crear un formateador de moneda para la localización deseada (en este caso, Locale.US)
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        for (OrdenDetalle detalle : orden.getDetalles()) {
            PdfPCell cellNombre = getCell(detalle.getProducto().getNombre(), false);
            cellNombre.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellNombre.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellCantidad = getCell(String.valueOf(detalle.getCantidad()), false);
            cellCantidad.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellCantidad.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellPrecio = getCell(currencyFormat.format(detalle.getPrecioTotal()), false);
            cellPrecio.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellPrecio.setVerticalAlignment(Element.ALIGN_MIDDLE);


            table.addCell(cellNombre);
            table.addCell(cellCantidad);
            table.addCell(cellPrecio);

            total += detalle.getPrecioTotal();
        }

        // Celda para el total que ocupa 2 columnas
        PdfPCell totalCell = getCell("Total", true);
        totalCell.setColspan(2); // Ocupa 2 columnas
        totalCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        totalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(totalCell);

        // Celda con el total de la suma de precios debajo de la tercera columna
        NumberFormat currencyFormat1 = NumberFormat.getCurrencyInstance();
        String formattedTotal = currencyFormat1.format(Math.round(total));

        PdfPCell sumCell = getCell(formattedTotal, true);
        sumCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        sumCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(sumCell);

        // Añadir la tabla al documento
        ticket.add(table);

        // Cerrar el documento
        ticket.close();

        // Convertir el contenido del PDF a un array de bytes
        byte[] content = byteArrayOutputStream.toByteArray();

        // Crear la respuesta con el PDF como contenido
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Ticket_N°=" + String.valueOf(orden.getId()) + ".pdf");
        headers.setContentLength(content.length);

        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }

    // Método para obtener una celda de la tabla con estilo
    private PdfPCell getCell(String content, boolean header) {
        PdfPCell cell = new PdfPCell(new Phrase(content));
        cell.setPadding(5);
        if (header) {
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        }
        return cell;
    }
}
