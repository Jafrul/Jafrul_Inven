<%-- 
    Document   : index
    Created on : Jan 12, 2020, 4:18:31 PM
    Author     : bitl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>Inventory Management</div>
    
   

      
    <form method="post" name="emp" action="sell_list">
        
        
         
        
            <input type="number" name="total_price" value="00" hidden="true">
            <input type="number" name="product_id" value="${user.id}" hidden="true">
            <br><br>
            Name:<br>
            <input type="text"  value="${user.name}" readonly>
            <br><br>
            
            
            Price:<br>
            <input type="text"   value="${user.price}" readonly>
            <br><br>

            Stock Quantity:<br>
            <input type="text"  value="${user.quantity}" readonly>
            <br><br>
            
            Sell Quantity:<br>
            <input type="text" name="quantity"  placeholder="Sell Quantity">
            <br><br>

          

            <input type="submit" value="Submit">
        </form> 

        <div>
            
            
          <a href="list_product" >Product List</a>
        </div>
    </body>
</html>
