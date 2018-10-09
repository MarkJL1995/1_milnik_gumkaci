<html>
<head>
    <title>Pridať člena</title>
</head>
<script>
    function openWin1()
    {
        window.location.href="/";
    }
</script>
<body>
<h1>Pridať člena</h1>

<form action="/addclen" method="post">
    <b> Meno: </b>&emsp;&emsp;&emsp;&emsp;&emsp; <input name="meno_clena" value="">
    <br><b>Číslo: </b>&thinsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input name="cislo_clena" value="">
    <br><b>Ulica: </b>&thinsp;&emsp;&emsp;&emsp;&emsp;&emsp;  <input name="ulica_clena" value="">
    <br><b>Mesto:</b>&emsp;&emsp;&emsp;&emsp;&emsp; <input name="mesto_clena" value="">
    <br><b>PSČ:</b>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input name="psc_clena" value="">
    <br><b>Členský poplatok:</b>&ensp;<input name="clensky_poplatok" value="">
    <br><br><input type="submit" name="Pridať" value="Pridať člena">
    <br><br><input type="button" value="<< Návrat" onclick="openWin1()">

</body>
</html>

