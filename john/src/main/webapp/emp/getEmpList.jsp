<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, vo.Emp"%>
<%
List<Emp> empList = ( List<Emp> ) request.getAttribute( "empList" );

out.print( empList );
%>