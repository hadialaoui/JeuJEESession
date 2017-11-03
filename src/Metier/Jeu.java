package Metier;

public class Jeu {
  private int secret;
  private boolean fin;
  
  public Jeu() {
	secret=55;//(int)(Math.random()*100);
	fin=false;
}
  
  public String jouer(int nb){
	  if(fin==false){
		  if(nb<secret)
			  return ("Votre nombre est plus petit");
		 
		  else if(nb>secret)
			  return ("Votre nombre est plus grand");
		  
		  else{
			  fin= true;
			  return ("Bravo vous avez gagnee");
		  }
	  }
	  else{
		  return ("le jeu est terminee");
	  }
 }

public int getSecret() {
	return secret;
}

public void setSecret(int secret) {
	this.secret = secret;
}

public boolean isFin() {
	return fin;
}

public void setFin(boolean fin) {
	this.fin = fin;
}
  
}
