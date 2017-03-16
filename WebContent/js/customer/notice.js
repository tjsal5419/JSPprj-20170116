/**
 * 
 */
	window.addEventListener ("load",function(){
		var btnResult = document.getElementById("btn-result");
		btnResult.onclick = printResult;
		
		function printResult(){
			var x,y;
			x = prompt("x 값을 입력하세요",0);
			y = prompt("y 값을 입력하세요",0);
			x = parseInt(x);
			y = parseInt(y);
			btnResult.value = x+y;
		}
	});

	window.addEventListener("load" , function(){
		
		var btnSum = document.getElementById("btn-sum");
		var txtX = document.getElementById("txt-x");
		var txtY = document.getElementById("txt-y");
		var txtSum = document.getElementById("txt-sum");

		btnSum.onclick = function(){
			txtSum.value = parseInt(txtX.value) + parseInt(txtY.value);
		};
	});