<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="util.StringUtils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>

<link rel="stylesheet" href="../pages/aboutus.css">
<style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }
    .container {
      width: 80%;
      margin: auto;
      padding: 20px;
    }
    h1 {
      text-align: center;
    }
    p {
      text-align: justify;
    }
    .contact-form {
      margin-top: 50px;
      background-color: #f9f9f9;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .form-group {
      margin-bottom: 20px;
    }
    label {
      font-weight: bold;
    }
    input[type="text"], input[type="email"], textarea {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-sizing: border-box;
    }
    textarea {
      height: 100px;
    }
    input[type="submit"] {
      background-color: #007bff;
      color: white;
      border: none;
      padding: 10px 20px;
      cursor: pointer;
      border-radius: 5px;
    }
    input[type="submit"]:hover {
      background-color: #0056b3;
    }
</style>
</head>
<body>
</head>
<body>

<div class="container">
  <h1>About Us</h1>
  <p>
		
		<p>Welcome to Time Keepers, your go-to destination for
			high-quality timepieces. Our passion for watches drives us to curate
			a collection that caters to every taste and style.</p>
		<p>At Time Keepers, we believe in providing exceptional customer
			service. Whether you're a watch enthusiast or a casual buyer, we're
			here to assist you every step of the way.</p>
		<p>Feel free to reach out to us with any questions, comments, or
			feedback. We value your input and strive to make your shopping
			experience memorable.</p>

  
  <div class="contact-form">
    <h2>Contact Us</h2>
    <form action="#" method="post">
      <div class="form-group">
        <label for="name">Your Name:</label>
        <input type="text" id="name" name="name" required>
      </div>
      <div class="form-group">
        <label for="email">Your Email:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="message">Message:</label>
        <textarea id="message" name="message" required></textarea>
      </div>
      <input type="submit" value="Send">
    </form>
  </div>
  
  <div class="contact-info">
    <h2>Contact Information</h2>
    <p>Email: timekeepers@gamil.com</p>
    <p>Phone: +1 234 567 890</p>
  </div>
</div>

</body>
</html>



</body>
</html>