

package com.binar.challenge4.controller;

import com.binar.challenge4.entity.DBFile;
import com.binar.challenge4.service.InvoiceService;
import com.lowagie.text.DocumentException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@Slf4j
@Tag(name = "Invoice")
@RestController
@RequestMapping("/invoice")

public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Operation(summary="Download File Invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil didownload"),
            @ApiResponse(responseCode = "204", description = "Not Found",
                    content = {@Content(mediaType = "ticket/pdf",
                            schema = @Schema(implementation = Response.class))})})
  
    @GetMapping(value = "/download")
    public ResponseEntity<Object> downloadInvoice(@RequestParam(required = false,value = "filename") String filename) throws JRException {
        try {
            DBFile dbFile = invoiceService.generateInvoice(filename);
            log.info(dbFile + "File Ditemukan");
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFiletype()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + filename + "\"")
                    .body(new ByteArrayResource(dbFile.getData()));
        } catch (JRException | FileNotFoundException e) {
            log.info("file not found: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}