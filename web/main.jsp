<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <LINK REL=StyleSheet HREF="style.css" TYPE="text/css" />
    <script src="scripts.js"></script>
    <title>Ajax Poets</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css"></style>
    <%
        String userName = null;
        String getName = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name"))
                    userName = cookie.getValue();
            }
        }
        if (userName == null)
            response.sendRedirect("index.jsp");
    %>
</head>
<body bgcolor="#ffffff">
<table width="1150" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td><img src="images/spacer.gif" width="431" height="1" border="0" alt="" /></td>
        <td><img src="images/spacer.gif" width="341" height="1" border="0" alt="" /></td>
        <td><img src="images/spacer.gif" width="378" height="1" border="0" alt="" /></td>
        <td><img src="images/spacer.gif" width="1" height="1" border="0" alt="" /></td>
    </tr>

    <tr>
        <td colspan="3"><img name="header" src="images/header.png" width="1150" height="91" border="0" id="header" alt="" /></td>
        <td><img src="images/spacer.gif" width="1" height="91" border="0" alt="" /></td>
    </tr>
    <tr>
        <td rowspan="2"><img name="left" src="images/left.png" width="431" height="559" border="0" id="left" alt="" /></td>
      <td valign="top" background="images/login.png">
            <table width="333" border="0">
              <tr>
                <td width="111"><span class="loggedintext">Logged in as: <br />
                </span></td>
                <td width="128"> <p><span class="loggedintext" id="loggedin"></span></p></td>

                  <script>
                  var cookieName = document.cookie;
                  var getName = cookieName.match(/[A-Z][a-z]+|[0-9]+/g).join(" ");
                  document.getElementById("loggedin").innerHTML = getName;

              </script>
              <form action="Logout" method="post">
                <td width="80"><button class="button" style="vertical-align:middle"><span>Logout </span></button></td>
              </form>
              </tr>
            </table>
            <td rowspan="2"><img name="right" src="images/right.png" width="378" height="559" border="0" id="right" alt="" /></td>
        <td><img src="images/spacer.gif" width="1" height="61" border="0" alt="" /></td>
    </tr>
    <tr>
        <td><img name="mid" src="images/mid.png" width="341" height="498" border="0" id="mid" alt="" /></td>
        <td><img src="images/spacer.gif" width="1" height="498" border="0" alt="" /></td>
    </tr>
</table>

<div class="welcometext">
    <img src="images/click.png" id="poems" class="click">

    <div id="getpoems"></div>
</div>
<div class="clipboard">
    <div id="poemContent"></div>
</div>
<script src="./poems/poems.js"></script>
</body>

</html>



