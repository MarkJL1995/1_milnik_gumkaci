<html>
<head>
    <title>Členovia - Anonymní Čokoholici - Gumkáči</title>
</head>
<script>
    function openWin1()
    {
        window.location.href="/";
    }
</script>
<body>
<h1>Členovia - Anonymní Čokoholici - Gumkáči</h1>
<p>&emsp;&emsp;&thinsp;----------------------------------------------------</p>
<ul>
    <#list clenovia as clen>
            <li><b>Poradové číslo:</b> &emsp;&emsp;&thinsp;${clen_index + 1}.
            <br><b>Meno: &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b>${clen.meno_clena}
            <br><b>Číslo: &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b> ${clen.cislo_clena}
            <br><b>Ulica: &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b>  ${clen.ulica_clena}
            <br><b>PSČ:  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;</b>${clen.psc_clena}
            <br><b>Mesto:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</b>${clen.mesto_clena}
            <br><b>Členský poplatok:&emsp;</b>${clen.clensky_poplatok} €
            <br> ----------------------------------------------------<br>
        </li>
    </#list>
</ul>

<input type="button" value="<< Návrat" onclick="openWin1()">
</body>
</html>