<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
String jsonProduct = ( String ) request.getAttribute( "jsonProduct" );
out.print( jsonProduct );
%>