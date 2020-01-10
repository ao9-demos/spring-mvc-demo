<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Form</title>
</head>
<body>
    <form:form action="processStudentForm" modelAttribute="student">
        Firt name: <form:input path="firstName"/>
        <br><br>
        Last name: <form:input path="lastName"/>
        <br><br>
        <form:select path="country">
            <form:options items="${countryOptions}" />
        </form:select>
        <br><br>
        Choose faverite language:
        <br>
        <form:radiobuttons path="favLang" items="${favoriteLanguages}"/>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>