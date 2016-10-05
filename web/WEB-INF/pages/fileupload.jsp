<%--
  Created by IntelliJ IDEA.
  User: yjh
  Date: 16/10/5
  Time: 下午3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:head />
</head>

<body>
<h1>Struts 2 file upload example</h1>
    <s:form action="resultAction" namespace="/"
            method="POST" enctype="multipart/form-data">

        <s:file name="fileUpload" label="Select a File to upload" size="40" />

        <s:submit value="submit" name="submit" />

    </s:form>

    </body>
</html>
