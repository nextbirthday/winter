<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
String jsonDeptList = ( String ) request.getAttribute( "jsonDeptList" );

out.print( jsonDeptList );
%>