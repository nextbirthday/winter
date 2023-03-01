<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
String jsonEmpList = ( String ) request.getAttribute( "jsonEmpList" );

out.print( jsonEmpList );
%>