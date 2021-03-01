<%@page import="packone.Uses"%>
<%@page import="packone.Transactions"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp" %>


<%
String accountNumber=(String) session.getAttribute("accountNumber");
ArrayList<Transactions> list=Uses.getTransactions(accountNumber);
System.out.println(accountNumber);

%>
<div class="mt-5 pt-5 container-fluid">
  <table class="table table-responsive-md table-hover table-striped table-bordered text-justify">
    <tr class="text-center table-secondary text-black-50">
      <th>Transaction Id</th>
      <th>Date</th>
      <th>Transaction type</th>
      <th>Amount</th>
      <th>Description</th>
    </tr>
    <%
    for(Transactions transactions:list){
    	out.write("<tr><td>"+transactions.getId()+"</td><td>"+transactions.getTime()+"</td><td>"+transactions.getType()+"</td>"+
      "<td>"+transactions.getAmount()+"</td><td>"+transactions.getDescription()+"</td></tr>");
    }
    %>
  </table>
</div>
<script>
var element = document.getElementById("nav5");
element.classList.add("active");
</script>