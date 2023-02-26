<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, productbbs.dto.Product,com.google.gson.Gson"%>
<%
List<Product> productList = ( List<Product> ) request.getAttribute( "productList" );
Gson gson = new Gson();
String temp = gson.toJson(productList);
out.print( temp );
%>
