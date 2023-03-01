<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
String jsonBoardList = ( String ) request.getAttribute( "jsonBoardList" );
out.print( jsonBoardList );
%>