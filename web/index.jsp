<%--
  Created by IntelliJ IDEA.
  User: yjh
  Date: 16/9/25
  Time: 下午8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
    </script>
    <script type="application/javascript">
      $(document).ready(function(){
        $("#b01").click(function(){
        $.ajax({ url: "showUser.do?id=1", dataType:"json",context: document.body, success: function(data, textStatus){
          alert("--success--status:"+textStatus+"---data:"+data);
//          var dataJson = JSON.parse(data);
//var a = 1;
//          var name = dataJson.name;
        },error:function(data, textStatus){
          alert("--error--status:"+textStatus+"---data:"+data);
        }});
      })});
    </script>
  </head>

  <body>
  $END$
  <button id="b01">button ajax</button>

  </body>
</html>
