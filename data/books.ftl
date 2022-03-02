<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Books</title>
</head>
<body>
<div class="container">

    <ul>
        <#list bookList as book>
            <li><a href="http://localhost:8080/book?id=${book.id}">${book.title}</a></li>
        </#list>
    </ul>
</div>
</body>
</html>