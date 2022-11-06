package com.binar.challenge4.service;

import com.binar.challenge4.entity.DBFile;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface InvoiceService {
    DBFile generateInvoice (String FileName) throws FileNotFoundException,JRException;
}
