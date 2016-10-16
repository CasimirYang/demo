<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Student Enrollment Form</title>
    <%--<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>--%>
    <%--<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>--%>
</head>

<body>
<h1>-- enroll --</h1>
<h1>${greeting}</h1>
<h2>${sessionScope.greeting}</h2>
<h3>${sections}</h3>

<div class="form-container">
    <h1>Enrollment Form</h1>
    <form:form method="POST" action="test.do" modelAttribute="student" class="form-horizontal">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="section">Section</label>
                <div class="col-md-7" class="form-control input-sm">
                    <form:radiobuttons path="section" items="${sections}" />
                    <div class="has-error">
                        <form:errors path="section" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>