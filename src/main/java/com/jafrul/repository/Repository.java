/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafrul.repository;

import com.jafrul.model.Products;
import com.jafrul.model.Sell;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Products> getList() {
        List<Products> list;
        String sql = "SELECT * FROM Products;";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Products.class));
        return list;
    }

    public Products getSingleUser(int id) {
        Products products;

        String sql = "SELECT * FROM Products where id = " + id;
        products = (Products) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Products.class));
        return products;

    }

    public boolean addData(Products products) {
        boolean successfullyInserted;
        String Name = products.getName();
        System.out.println(Name);
        String sql = "insert into Products (name,price,quantity) values('" + products.getName() + "'," + products.getPrice() + "," + products.getQuantity() + " ) ";
        jdbcTemplate.update(sql);

        successfullyInserted = true;

        return successfullyInserted;

    }

    public void deleteData(int id) {

        String deleteQuery = "delete from Products where id = ?";
        jdbcTemplate.update(deleteQuery, id);

    }

    public boolean updateData(Sell sell) {

       
        
        
        int id = sell.getProduct_id();
        int sell_Quan = sell.getQuantity();

        Products main_products;

        String sql1 = "SELECT * FROM Products where id =" + id;
        main_products = (Products) jdbcTemplate.queryForObject(sql1, new BeanPropertyRowMapper(Products.class));

        int main_Quan = main_products.getQuantity();

        int after_quan = main_Quan - sell_Quan;
        int price = main_products.getPrice();
        int total_price = sell_Quan*price;
 
        String sqls = "insert into Sell (product_id,quantity,total_price) values('" + sell.getProduct_id() + "'," + sell.getQuantity() + "," + total_price + " ) ";
        jdbcTemplate.update(sqls);

        
        boolean rowUpdated;
        String sql = "update Products set quantity =? where id =?";
        jdbcTemplate.update(sql, after_quan, id);
        rowUpdated = true;

        return rowUpdated;
    }

    public List<Sell> getSellList() {
      List<Sell> list;
        String sql = "SELECT * FROM Sell;";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Sell.class));
        return list;

    }

}
