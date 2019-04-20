<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Test</title>
    <script>
      function retrieveTime() {
        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
          if (request.readyState === 4) {
            var result = JSON.parse(request.response);
            var resultString = result.method + "\n" + result.date + "\n" + result.url + "\n" + result.protocol + "\nAddress: " + result.remoteAddress + "\nUser agent: " + result.userAgent;
            alert(resultString);
          }
        };
        request.open("GET", "getTime");
        request.send();
      }
    </script>
  </head>
  <body>
  <button onclick="retrieveTime()">Current time and other data</button>
  </body>
</html>
