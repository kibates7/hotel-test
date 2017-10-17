<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Sample Hotel</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
    </head>
    <body>

                
               <div class="topnav">
                <a href="homepage.html" title="Home">Home</a>
                <a href="reservation.html" title="Res">Reservation</a>	
  				<a href="login.html" title="Res">Login</a>		
  					
				</div>    
    
            
            
     
            
            <div class="Content">
              
                <div class="slideshow-container">

<div class="mySlides fade">
  <img src="1.jpeg" style="width:1333px;height:350px;">
  
</div>

<div class="mySlides fade">
  <img src="2.jpeg" style="width:1333px;height:350px;">
 
</div>

<div class="mySlides fade">
  <img src="3.jpeg" style="width:1333px;height:350px;">
 
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>


<!DOCTYPE html>
<html>
<style>
form {
    
    text-align: center;
    }
    
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
   
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 25%;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn,.signupbtn {
    
    width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 50%;
    }
}
</style>
<body>

<center><h2>User Info</h2></center>


  <div class="container">
    <h1>Guest Info</h1>
    <table>
    <tr>
    <td>
    <%=request.getAttribute("result") %>    </td>
    </tr>
    </table>
  </div>




            <div class="footer">
            <br><br><br><br><br><br>
            <h4>Website developed by Wipro LTD.</h4>
            </div>
      
    </body>
