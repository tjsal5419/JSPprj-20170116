<%
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(_x!=null && !_x.equals(""))
			x = Integer.parseInt(_x);
		
		if(_y!=null && !_y.equals(""))
			y = Integer.parseInt(_y);
	
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>helllo JSP</title>
</head>
<body>
	<hr />
	
	<form action = "calc" method="post">
	<p>
		<label>x:</label>
		<input type="text" name="x"  id="txt-x" />
		 <label>y:</label>
		 <input type="text" name="y" id="txt-y" />		
	</p>
	<p>
		sum = <input type="text" id="txt-sum" value="<% out.print(3+4); %>"/>
	</p>
	<p>
		<input id="sum" type="submit" value="Sum" />
	</p>
</form>
</body>
</html>