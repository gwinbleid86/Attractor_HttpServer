<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Book info</title>
</head>
<body>

<div class="container">
    <h1>${title}</h1>
    <p><b>Author:</b> ${author}</p>
    <p><b>Description:</b> ${description}</p>

    <#if available>
        <form action="/book" method="post">
            <input type="number" name="id" value="${id}" hidden>
            <input type="text" name="email" value="qwe@qwe.qwe" hidden>
            <input type="submit" value="Take">
        </form>
    </#if>
</div>

</body>
</html>