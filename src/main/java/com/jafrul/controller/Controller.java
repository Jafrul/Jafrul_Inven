/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafrul.controller;

import com.jafrul.model.Products;
import com.jafrul.model.Sell;
import com.jafrul.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Service service;

    @RequestMapping("/")
    public String index(ModelMap model) throws Exception {
        List<Products> usersList = service.getUserList();
        System.out.println("Size:" + usersList.size());
        model.addAttribute("list", usersList);
        return "index";
    }

    @RequestMapping(value = "/list_product")
    public String listUser(ModelMap model) throws Exception {

        List<Products> usersList = service.getUserList();
        System.out.println("Size:" + usersList.size());
        model.addAttribute("list", usersList);
        return "index";
    }

    @RequestMapping(value = "/add_form", method = RequestMethod.GET)
    public String add_from(ModelMap model) throws Exception {

        return "add_pro";
    }

    @RequestMapping(value = "/add_product", method = RequestMethod.POST)
    public String addUser(ModelMap model, @ModelAttribute("emp") Products products) throws Exception {
        //Employee emp=new Employee();
        // System.out.println(employee);

        boolean status = service.addClient(products);

        List<Products> usersList = service.getUserList();

        model.addAttribute("list", usersList);

        return "index";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(ModelMap model, HttpServletRequest rq) throws Exception {

        String id = rq.getParameter("id");
        int id1 = Integer.parseInt(id);

        service.delete(id1);
        List<Products> usersList = service.getUserList();
        System.out.println("Size:" + usersList.size());
        model.addAttribute("list", usersList);

        return "index";
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public String showEditForm(ModelMap model, HttpServletRequest rq) throws Exception {
//
//        int id1 = Integer.parseInt(rq.getParameter("id"));
//        Products existingUser = service.selectUser(id1);
//        // RequestDispatcher dispatcher = rq.getRequestDispatcher("index.jsp");
//
//        //List<Client> usersList = clientService.getUserList();
//        // System.out.println("Size:" + usersList.size());
//        model.addAttribute("user", existingUser);
//
//        return "edit_emp";
//    }

    
    
    @RequestMapping(value = "/sell", method = RequestMethod.GET)
    public String showSellForm(ModelMap model, HttpServletRequest rq) throws Exception {

        int id1 = Integer.parseInt(rq.getParameter("id"));
        Products existingUser = service.selectUser(id1);
        // RequestDispatcher dispatcher = rq.getRequestDispatcher("index.jsp");

        //List<Client> usersList = clientService.getUserList();
        // System.out.println("Size:" + usersList.size());
        model.addAttribute("user", existingUser);

        return "sell_pro";
    }

    
    
    
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateUser(ModelMap model, @ModelAttribute("emp") Products products) throws Exception {
//
//        service.updateUser(products);
//        List<Products> usersList = service.getUserList();
//        model.addAttribute("list", usersList);
//
//        return "index";
//    }
    
      @RequestMapping(value = "/sell_list", method = RequestMethod.POST)
    public String updateUser(ModelMap model, @ModelAttribute("emp") Sell sell) throws Exception {

        service.updateUser(sell);
        List<Sell> usersList = service.getSellList();
        model.addAttribute("list", usersList);

        return "sell_list";
    }

}
