<html>
<head>
    <title>Books</title>
</head>
<body>
<h1>Books</h1>

<ul>
    <#list books as book>
        <li>${book_index + 1}. ${book.name} published ${book.year}</li>
    </#list>
</ul>

</body>
</html>