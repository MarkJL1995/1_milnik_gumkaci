<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
<center><h1>MENU - ANONYMNÍ ČOKOHOLICI - GUMKÁČI</h1>
    <input type="button" class="greenbutton" value="Pridať člena" onclick="window.location.href='/addclen'">
    <br><br><input type="button" class="greenbutton" value="Zobraziť členov" onclick="window.location.href='/clen'">
    <br><br><input type="button" class="greenbutton" value="Zobraziť poskytovatelov" onclick="window.location.href='/poskytovatel'">
    <br><br><input type="button" class="greenbutton" value="Zobraziť služby" onclick="window.location.href='/sluzba'">
    <br><br><input type="button" class="greenbutton" value="Zobraziť zoznam úkonov" onclick="window.location.href='/zoznam_ukonov'">
    <br><br><input type="button" class="greenbutton" value="Pridať poskytnutú službu" onclick=" window.location.href='/addvyuzitie_sluzieb'">
    <br><br><input type="button" class="greenbutton" value="Zobraziť poskytnutú službu" onclick="window.location.href='/vyuzitie_sluzieb'">
</center>
</body>
</html>