package presentation;

import java.util.ArrayList;

public class EssaiForm {
    private int nombre;
   // private String message;
    private ArrayList<String> historique;
    
    
   
	public EssaiForm() {
		historique=new ArrayList<>();
	}
	public int getNombre() {
	return nombre;
}
public void setNombre(int nombre) {
	this.nombre = nombre;
}
	public ArrayList<String> getHistorique() {
		return historique;
	}
	public void setHistorique(ArrayList<String> historique) {
		this.historique = historique;
	}
	
	public void addToHistorique(String resultat){
		this.historique.add("Nombre : "+nombre+" Indication : "+resultat);
	}
	/*public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}*/
    
}
