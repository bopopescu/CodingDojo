<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Welcome to the Great Number Game!</h1>
    <p>I am thinking of a number between 1 and 100</p>
    <p>Take a guess!</p>
    <button><a href="Number">Play Again</a></button>
    <p>${ say }</p>
    <p>Guess: ${ guess }</p>
    <p>This is actual number: ${ getrandomnumber }</p>
    <form action="GuessTheNumber" method="POST">
        <input type="text" name="guess">
        <input type="submit" name="submit">
    </form>
</body>
</html>