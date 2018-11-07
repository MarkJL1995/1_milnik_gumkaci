<html>
<head>
    <title>Využitie služieb čokoholikmi</title>
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
<h1>Využitie služieb čokoholikmi</h1>

<table>
    <tr>
        <th>Prijatie služby</th>
        <th>Poskytnutie služby</th>
        <th>Číslo člena</th>
        <th>Meno člena</th>
        <th>Číslo poskytovateľa</th>
        <th>Meno poskytovateľa</th>
        <th>Kód služby</th>
        <th>Názov služby</th>
        <th>Poplatok</th>
        <th>Komentár</th>
    </tr>
    <tr><td colspan="10"><center>---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</center></td></tr>
        <#list vyuzitie as coko>
            <tr>
                <td>${coko.aktualny_datum_format}</td>
                <td>${coko.datum_poskytnutia_sluzby_format}</td>
                <td>${coko.cislo_clena_posk}</td>
                <td>${coko.meno_clen}</td>
                <td>${coko.cislo_poskytovatela_posk}</td>
                <td>${coko.meno_poskytovatel}</td>
                <td>${coko.kod_sluzby_posk}</td>
                <td>${coko.nazov_sluzba}</td>
                <td>${coko.poplatok} €</td>
                <td>${coko.komentar}</td>
            </tr>
        </#list>

<#list vyuzitie as coko>
    <#assign pocet>${coko_index + 1 }</#assign>
</#list>
   <#assign total = 0>
<#list vyuzitie as coko>
    <#assign total = total + coko.poplatok>
</#list>
    <tr><td colspan="10"><center>---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</center></td></tr>
    <tr><td colspan="3"><b>Celkový počet konzultácií:</b></td>
        <td colspan="2">${pocet}</td>
        <td colspan="3"><b>Celková suma za poskytnuté služby: </b></td>
        <td colspan="2">${total} €</td>
    </tr>
        </table>

<br><br><input type="button" class="greenbutton" value="<< Návrat" onclick="window.location.href='/'">
</body>
</html>