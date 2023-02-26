
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
String jsonList = ( String ) request.getAttribute( "jsonList" );
out.print( jsonList );
%>
