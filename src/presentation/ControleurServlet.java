package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.Jeu;

@WebServlet({ "/index.php", "*.php" })
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jeu metier ;
	private ArrayList<HttpSession> sessions;
       
 @Override
public void init() throws ServletException {
	 metier=new Jeu();
	 sessions=new ArrayList<>();
}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String path=request.getServletPath();
		if(path.equals("/index.php")){
			 request.setAttribute("jeu", new EssaiForm()); 
			  request.getRequestDispatcher("VueJeu.jsp").forward(request, response);
		}
		else if(path.equals("/jouer.php")){
			String action=request.getParameter("jouer");
			HttpSession session=request.getSession();
			if(action.equals("essaie")){
						if(metier.isFin()==false){
						int nombre=Integer.parseInt(request.getParameter("nombre"));
						String resultat=metier.jouer(nombre);
						  if(session.getAttribute("jeu") != null){
							 EssaiForm  model=(EssaiForm)session.getAttribute("jeu");
							 model.setNombre(nombre);
							 model.addToHistorique(resultat);
							 request.setAttribute("fin", metier.isFin());
							 request.setAttribute("secret", metier.getSecret());
										 // System.out.println("session");
							 }else{	
							 sessions.add(session);
							 EssaiForm model=new EssaiForm();
							 model.setNombre(nombre);
							 model.addToHistorique(resultat);
							 session.setAttribute("jeu", model);
							 request.setAttribute("fin", metier.isFin());
							 request.setAttribute("secret", metier.getSecret());
										  //System.out.println("non session");
							 }
						}else{
						  request.setAttribute("fin", metier.isFin());
						  request.setAttribute("secret", metier.getSecret());
						}
			}else if (action.equals("rejouer")){
				if(!sessions.isEmpty() && metier.isFin()){
				for(HttpSession s:sessions){
					s.invalidate();
				}
				sessions.clear();
				metier.setFin(false);
				request.setAttribute("fin", metier.isFin());
				//request.setAttribute("jeu", new EssaiForm());
				}
			}
			 this.getServletContext().getRequestDispatcher("/VueJeu.jsp")
			          .forward(request, response);
	}

   }
}
