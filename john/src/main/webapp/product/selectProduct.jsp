<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,vo.Product"%>
<%
List<Product> productList = ( List<Product> ) request.getAttribute( "productList" );

out.print( productList );
%>