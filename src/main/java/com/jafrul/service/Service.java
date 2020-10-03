/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafrul.service;

import com.jafrul.model.Products;
import com.jafrul.model.Sell;
import com.jafrul.repository.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repo;

    public boolean addClient(Products products) {
        boolean status = repo.addData(products);
        return status;
    }

    public List<Products> getUserList() {
        return repo.getList();
    }

    public void delete(int id1) {
        repo.deleteData(id1);
    }

    public Products selectUser(int id1) {
        return repo.getSingleUser(id1);
    }

    public void updateUser(Sell sell) {
        repo.updateData(sell);
    }

    public List<Sell> getSellList() {
return repo.getSellList();
    }

}
