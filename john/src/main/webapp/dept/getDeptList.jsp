<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, vo.Dept"%>
<%
List<Dept> deptList = ( List<Dept> ) request.getAttribute( "deptList" );
out.print( deptList );
%>