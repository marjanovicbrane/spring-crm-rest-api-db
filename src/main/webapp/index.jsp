<html>
<body>
<!-- ZAPRAVO OVA .JSP STRANICA NIJE POTREBNA KADA PRAVIMO rest SERVIS
ALI CE NAM SADA RECIMO OVA .JSP STRANICA DOBRO POSLUZITI DA POKRENEMO NASU APLIKACIJU
I DA VIDIMO DA LI JE SVE OK PODESENO, TJ. NASA BAZA PODATAKA, TAKO DA CMEO SAD APOKRENUTI
APLIKACIJU KADA SMO JE PODESILI U NASEIM JAVA KONFIG FAJLOVIMA 
JER PO DEFAULTU AKONISMOUKONFIG FAJLU NAVELI KOJI FAJL DA SE POKRECE
POKRETACE SE OVAJ INDEX.JSP IZ WEBAPP FOLDERA-->
<h3>Spring CRM REST Demo</h3>

<hr>

<!-- kao sto smo rekli ova .jsp stranica nam nije potrebna,kao ni ovaj link
ali smoga eto dodali da nam bude lakse da dodjemodo naseg endpointa i vidimo sve customere iz baze -->
<a href="${pageContext.request.contextPath}/api/customers">Get All Customers</a>

</body>
</html>