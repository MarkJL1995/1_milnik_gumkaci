<html>
<head>
    <title>Pridanie poskytnutej služby</title>
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
<h1>Pridanie poskytnutej služby</h1>
<ul>
    <form action="/addvyuzitie_sluzieb" method="post">
        <font color="red"><b>${chyba}</b></font>
        <br><br><b>Číslo člena:&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;</b>
        <select id="cislo_clena_posk" name="cislo_clena_posk">
            <option value="">---Vyberte číslo člena---</option>
    <#list vypis_clenov as vypis>
        <option value="${vypis.cislo_clena}">${vypis.cislo_clena} - ${vypis.meno_clena}</option>
    </#list>
        </select><font color="red"> *</font>
        <br><br><b>Číslo poskytovateľa:&nbsp;&nbsp;&nbsp;</b>
        <select id="cislo_poskytovatela_posk" name="cislo_poskytovatela_posk">
            <option value="">---Vyberte číslo poskytovateľa---</option>
    <#list vypis_poskytovatelov as vypis1>
        <option value="${vypis1.cislo_poskytovatela}">${vypis1.cislo_poskytovatela} - ${vypis1.meno_poskytovatela}</option>
    </#list>
        </select><font color="red"> *</font>
        <br><br><b>Kód služby:&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp; </b>
        <select id="kod_sluzby_posk" name="kod_sluzby_posk">
            <option value="">---Vyberte kód služby---</option>
    <#list vypis_sluzieb as vypis2>
        <option value="${vypis2.kod_sluzby}">${vypis2.kod_sluzby} - ${vypis2.nazov_sluzby}</option>
    </#list>
        </select><font color="red"> *</font>
        <br><br><b>Dátum:</b>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp; <input name="datum_format" value=""><font color="red"> *</font>
        <br><br><b>Komentár:</b>&emsp;&emsp;&emsp;&emsp;&emsp; <input name="komentar" value="">
        <br><br><input type="submit" class="greenbutton" name="Potvrdiť" value="Potvrdiť">
    </form>
</ul>

<br><br><input type="button" class="greenbutton" value="<< Návrat" onclick="window.location.href='/'">

</body>
</html>