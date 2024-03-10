/**
 * 
 */

	/*	function validate(frm){
		let pName = frm.personName.value;
		let pAge = frm.personAge.value;
		let pAddrs =frm.personAdd.value;
		let flag = true;
		
		if(pName==""){
			alert("Person name is required!")
			frm.personName.focus();
			flag = false;
		}
		if(pAge==""){
			alert("Person age is required!");
			frm.personName.focus();
			flag = false;
		}
		
		else if(isNaN(pAge)){
			alert("Person age is must be numeric value ");
			frm.personAge.focus();
			flag = false;
		}
		else if(pAge<0 || pAge>125){
			alert("Person age is must be in range (1-124) ");
			frm.personAge.focus();
			flag = false;
		}
		
		if(pAddrs.length<10){
			alert("Person address must have minimum 10 character!");
		frm.personAdd.focus();
		flag = false;
		}
		
		return flag;
		
		}
	*/
	
		function validate(frm){
			
			//document.getElementById("pNameErr").innerHTML =" ";
			//document.getElementById("pAgeErr").innerHTML =" ";
			//document.getElementById("pAddErr").innerHTML =" ";
			
		let pName = frm.personName.value;
		let pAge = frm.personAge.value;
		let pAddrs =frm.personAdd.value;
		let flag = true;
		
		if(pName=="" || pName.length==0 || pName == null){
			document.getElementById("pNameErr").innerHTML = " Person name is required! ";
			frm.personName.focus();
			flag = false;
		}
		
		if(pAge==""){
			document.getElementById("pAgeErr").innerHTML = "Person age is required!";
			frm.personAge.focus();
			flag = false;
		}
		
		else if(isNaN(pAge)){
			document.getElementById("pAgeErr").innerHTML = "Person age is must be numeric value ";
			frm.personAge.focus();
			flag = false;
		}
		else if(pAge<0 || pAge>125){
			document.getElementById("pAgeErr").innerHTML = "Person age is must be in range (1-124)";
			frm.personAge.focus();
			flag = false;
		}
		/*
		
		if(pAddrs.length<10){
			document.getElementById("pAddErr").innerHTML = "Person address must have minimum 10 character!";
		frm.personAdd.focus();
		flag = false;
		}
		*/
		return false;
		}