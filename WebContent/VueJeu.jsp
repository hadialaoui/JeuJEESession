    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title>Jeu</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
 <div class="container">
 <p></p>
     <div class="panel panel-primary inverse">
	   <div class="panel-heading center" style="font-size: 30px">Veuillez choisir un nombre entre 0 et 100 !</div>
	   <div class="panel-body">
	      <form action="jouer.php" method="post">
	     <label>Diviner ce nombre : </label>
	     <input type="text" name="nombre" id="nbre">
	     <button class="btn btn-primary" type="submit" name="jouer" id="jouer" value="essaie">Essaie</button>
	      <c:if test="${fin==false || fin==null}">
	        <button class="btn btn-success" type="submit"  name="jouer" value="rejouer" disabled>Rejouer</button>
	     </c:if>
	     <c:if test="${fin==true}">
	        <button class="btn btn-success" type="submit" name="jouer" value="rejouer" >Rejouer</button>
	     </c:if>
	     <br/>
	     <p></p>
	     <div id="message"></div>
	    <br/><br/>
	     <label>
	       ${jeu.historique[fn:length(jeu.historique)-1]}
	     </label>
	     
	     <br/><br/><br/>
	     <h4>Historique</h4>
	     <ol class="list-group">
	      <c:forEach items="${jeu.historique}" var="his">
	         <li class="list-group-item">${his}</li>
	     </c:forEach>
	     </ol>
	     <c:if test="${fin==true}">
	     <div class="alert alert-success" style="font-size: 40px">
               <strong >FIN DE JEUX !</strong><br/>le nombre secret est  :  ${secret} !
          </div>
	     </c:if>
	     </form>
	   </div>
	</div>
 </div>
<script src="js/jquery.js"></script>
<script>
$(function(){
    $( "#jouer" ).on( 'click' , function(evt){
    	 var nombre= document.querySelector('#nbre').value
         console.log(nombre)
         if(nombre<0){
         	evt.preventDefault();
             var msg=document.querySelector('#message')
             $(msg).text("le Nombre que vous avez saisi est inferieure a 0 ")
             $(msg).addClass("alert");
             $(msg).addClass("alert-danger");
         }else if(nombre>100){
         	evt.preventDefault();
             var msg=document.querySelector('#message')
             $(msg).text("le Nombre que vous avez saisi est superieur a 100")
             $(msg).addClass("alert");
             $(msg).addClass("alert-danger");
         }
    });
});
   
</script>
</body>
</html>