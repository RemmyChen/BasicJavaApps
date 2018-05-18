<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<meta http-equiv="Cache-Control" content="no-cache"/>
<!DOCTYPE html>
<html>
<head>
    <title>Topics</title>
</head>
<body>
<p>Topics</p>
<form action="topic" method="post">
    <div>
        <p>Post a topic:</p>
        <input id="input" placeholder="请输入" autocomplete="off" maxlength="6" value="" type="text" >
    </div>
    <div>
        <div style="margin-top: 20px;"><input class="submit-btn" type="submit" value="Post"></div>
    </div>
</form>
</body>
</html>
