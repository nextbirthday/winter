<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
String customerList = ( String ) request.getAttribute( "customerList" );
out.print( customerList );
%>
