# JeuJEESession
une application web J2EE qui respecte le modèle MVC qui permet de simuler un jeu entre les clients http et le serveur web
Le principe du jeu est le suivant :
-	Le serveur choisit un nombre aléatoire entre 0 et 100
-	Un client http connecté, doit saisir un nombre pour deviner le nombre secret.
-	Le serveur répond avec les éventualités suivantes :
    - Votre nombre est plus grand
    - Votre nombre est plus petit
    - Bravo, vous avez gagné. Et dans ce cas-là¬ le jeu s’arrête et pour chaque tentative de jouer le serveur envoi au client un message qui indique que le jeu est terminé en affichant le nombre secret recherché.

