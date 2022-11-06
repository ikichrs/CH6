package com.binar.challenge4.service.impl;

import com.binar.challenge4.entity.DBFile;
import com.binar.challenge4.service.FilmService;
import com.binar.challenge4.service.InvoiceService;
import com.binar.challenge4.service.UserService;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private UserService userService;

    @Autowired
    private FilmService filmService;

    @Override
    public DBFile generateInvoice(String filename) throws JRException {
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("order_id", "1");
        obj.put("film_id","1");
        obj.put("film_title","Thor : Love And Thunder");
        obj.put("user_id","1");
        obj.put("seat_number","A1");
        obj.put("studio_id","1");

        InputStream inputStream = getClass().getResourceAsStream("/Tiket.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, obj);

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
        DBFile dbFile = new DBFile();
        dbFile.setData(data);
        dbFile.setFilename(filename);
        dbFile.setFiletype("ticket/pdf");
        return dbFile;
    }
}
