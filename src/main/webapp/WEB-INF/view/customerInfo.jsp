<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Information</title>
</head>
<body>
    Customer name: ${theCustomer.firstName} ${theCustomer.lastName}
    <br><br>
    Number of passes: ${theCustomer.passNum}
    <br><br>
    Post code: ${theCustomer.post}
    <br><br>
    Course code: ${theCustomer.courseCode}
</body>
</html>