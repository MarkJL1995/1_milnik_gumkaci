<html>
<head>
    <title>Poskytovatelia - Anonymní Čokoholici - Gumkáči</title>
</head>
<style>/*CSS document*/
h1
{
    color: #379683;
    text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
}
html
{
    background-image: linear-gradient(#8EE4AF, #05386B);
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;

}
th {
    background-color: #05386B;
    color: #EDF5E1;
}
tr{
    background-color:white;
}
tr:nth-child(even) {background-color: #c7eae6;}

.greenbutton
{
    background-image: linear-gradient(#05386B, #379683);
    background-color: #05386B;
    border-radius: 10px;
    cursor: pointer;
    text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
    color: #EDF5E1;
    font-weight: bold;
    padding: 7px;
    box-shadow: 6px 6px 4px black;
    position: center;
}
.greenbutton:hover
{
    background-image: linear-gradient(#05386B, #379683);
    background-color: #05386B;
    color: #EDF5E1;
    text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
    font-style: italic;
    position: center;
}

.greenbutton:active {
    background-color: #379683;
    box-shadow: 0 4px #666;
    transform: translateY(3px);
    position: center;
}
</style>

<body>
<h1>Poskytovatelia - Anonymní Čokoholici - Gumkáči</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Číslo</th>
        <th>Meno</th>
        <th>Ulica</th>
        <th>PSČ</th>
        <th>Mesto</th>
    </tr>
         <#list poskytovatelia as poskytovatel>
            <tr>
                <td>${poskytovatel_index + 1}.</td>
                <td>${poskytovatel.cislo_poskytovatela}</td>
                <td>${poskytovatel.meno_poskytovatela}</td>
                <td>${poskytovatel.ulica_poskytovatela}</td>
                <td>${poskytovatel.psc_poskytovatela}</td>
                <td>${poskytovatel.mesto_poskytovatela}</td>
            </tr>
        </#list>
</table>

<br><br><input type="button" class="greenbutton" value="<< Návrat" onclick="window.location.href='/'">
</body>
</html>