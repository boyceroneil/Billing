package com.example.demo.rest;

import com.example.demo.crud.CRUD;
import com.example.demo.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class BillController {
    private final CRUD crud;
    @Autowired
    public BillController( CRUD crud){
        this.crud = crud;
    }
    @GetMapping("/receiveBill")
    public List<Object> searchAll(){
        return crud.searchAll();
    }

    @PostMapping("/addBill")
    public Bill addVehicle(@RequestBody Bill bill){
        bill.setId(0);
        crud.saveUpdate(bill);
        return bill;
    }

    @PutMapping("/updateBill")
    public Bill updateVehicle(@RequestBody Bill bill){
        crud.saveUpdate(bill);
        return bill;
    }
    @DeleteMapping("/deleteBill/{bill}")
    public String deleteVehicles(@PathVariable int bill){
        Bill temp = (Bill) crud.searchId(bill);
        if(temp == null){
            throw new RuntimeException("Vehicle is not here" + bill);
        }
        crud.deleteId(bill);
        return "removed bill id: " + bill;
    }
}
