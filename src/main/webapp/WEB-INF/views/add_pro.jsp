<%-- 
    Document   : llist_emp
    Created on : Jan 12, 2020, 3:25:40 PM
    Author     : bitl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
         <h:outputStylesheet name="/bootstrap.min.css"/>
         
    </head>
    <body>
        <div>
         <a href="list_product" >Product List  </a>
        <h2>Add Product Form</h2>

        <form method="post" action="add_product">

            Name:<br>
                <input type="text" name="name" placeholder="Name">
            <br><br>

            Price:<br>
            <input type="number" name="price" placeholder="Price">
            <br><br>

            Quantity:<br>
            <input type="number" name="quantity" placeholder="Quantity">
            <br><br>


            <input type="submit" value="Submit">
        </form> 

        </div>
        
    </body>
</html>
