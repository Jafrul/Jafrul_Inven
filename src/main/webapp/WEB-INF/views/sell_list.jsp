<%-- 
    Document   : index
    Created on : Jan 12, 2020, 4:18:31 PM
    Author     : bitl
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        
        <h2>
            <a href="add_form">Add New Products</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Sale Products List</h2></caption>
            <tr>
                <th>ID</th>
                <th>Product Id</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>Other</th>
            </tr>
            <c:forEach var="user" items="${list}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.product_id}" /></td>
                    <td><c:out value="${user.quantity}" /></td>
                    <td><c:out value="${user.total_price}" /></td>
                    <td>
                        
                        <a href="delete?id=<c:out value='${user.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </div> 
    
    <div>
        <br/>
        <br/>
        <center>    <a href="list_product">Stock List</a></center>
        <br/>
        <br/>
        
    </div>

</body>
</html>
