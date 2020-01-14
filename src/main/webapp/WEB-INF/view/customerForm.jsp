<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Form</title>
    <style>
        .error {color:orangered}
    </style>
</head>
<body>
    <form:form action="processForm" modelAttribute="theCustomer">
        First name: <form:input path="firstName"/>
        <br><br>
        Last name (*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        <br><br>
        Pass numbers: <form:input path="passNum"/>
        <form:errors path="passNum" cssClass="error"/>
        <br><br>
        Post code: <form:input path="post"/>
        <form:errors path="post" cssClass="error"/>
        <br><br>
        Course code: <form:input path="courseCode"/>
        <form:errors path="courseCode" cssClass="error"/>
        <br><br>
        <input type="submit" value="Submit">
    </form:form>
    
</body>
</html>