<html>
<head>
    <title>Pridať člena</title>
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
<h1>Pridať člena</h1>

<ul>
<form action="/addclen" method="post">
    <font color="red"><b>${chyba}</b></font>
    <br><br><b>Číslo: </b>&thinsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input name="cislo_clena" value=""><font color="red"> *</font>
    <br><br><b> Meno: </b>&emsp;&emsp;&emsp;&emsp;&emsp; <input name="meno_clena" value=""><font color="red"> *</font>
    <br><br><b>Ulica: </b>&thinsp;&emsp;&emsp;&emsp;&emsp;&emsp;  <input name="ulica_clena" value=""><font color="red"> *</font>
    <br><br><b>PSČ:</b>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input name="psc_clena" value=""><font color="red"> *</font>
    <br><br><b>Mesto:</b>&emsp;&emsp;&emsp;&emsp;&emsp; <input name="mesto_clena" value=""><font color="red"> *</font>
    <br><br><input type="submit" class="greenbutton" name="Potvrdiť" value="Potvrdiť">

</form>
</ul>

    <br><br><input type="button" class="greenbutton" value="<< Návrat" onclick="window.location.href='/'">

</body>
</html>