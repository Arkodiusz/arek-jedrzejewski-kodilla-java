package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product bread = new Product("Bread");
        Product milk = new Product("Milk");
        Product egg = new Product("Egg");

        Item itemMilk = new Item(milk, BigDecimal.valueOf(2.60), 4);
        Item itemEgg = new Item(egg, BigDecimal.valueOf(0.80), 40);
        Item itemRyeBread = new Item(bread, BigDecimal.valueOf(4.0), 2);
        Item itemWheatBread = new Item(bread, BigDecimal.valueOf(3.1), 5);

        Invoice invoice01 = new Invoice("21/01/08/01");
        invoice01.getItems().add(itemEgg);
        invoice01.getItems().add(itemMilk);
        invoice01.getItems().add(itemRyeBread);
        invoice01.getItems().add(itemWheatBread);

        Invoice invoice02 = new Invoice("21/01/08/02");
        invoice02.getItems().add(itemEgg);
        invoice02.getItems().add(itemRyeBread);

        //When
        productDao.save(bread);
        productDao.save(milk);
        productDao.save(egg);

        itemDao.save(itemMilk);
        itemDao.save(itemEgg);
        itemDao.save(itemRyeBread);
        itemDao.save(itemWheatBread);

        invoiceDao.save(invoice01);
        invoiceDao.save(invoice02);

        int invoice01Id = invoice01.getId();
        int invoice02Id = invoice02.getId();

        //Then
        assertNotEquals(0, invoice01Id);
        assertNotEquals(0, invoice02Id);

        //CleanUp
        invoiceDao.deleteById(invoice01Id);
        invoiceDao.deleteById(invoice02Id);
    }
}
