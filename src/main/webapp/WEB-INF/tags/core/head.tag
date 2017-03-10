<%@tag language="java" description="head" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name='title' required='true' type='java.lang.String'%>
<%@attribute name='bodyId' required='false' type='java.lang.String'%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="<c:url value='/assets/media/favicon.png' />">

<link rel="stylesheet" href="<c:url value='/assets/css/reset.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/screen.css'/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<title>${title}</title>
</head>
<body<c:if test="${not empty bodyId}"> id="${bodyId}"</c:if>>