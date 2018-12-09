	************************************
*****  	    Description de l'application   	*****
	************************************

ProxiBanque permet de se connecter à la base de données et permet selon l'utilisateur :conseilleur ou gerant.

Pour cette Version de ProxiBanque, nous avons créér manuellement deux agences et deux gérants dans la base de données.
	Gérant 1: 
		Login: baytam    Mot de Passe: admin1
	Gérant 2: 
		Login: weuz    Mot de Passe: admin2 
	
Les utilisateurs ont aussi la possibilité de changer leur mot de passe lors de la connexion.
	Si l'utilisateur connecté est un conseillier, il aura accès aux modules suivants:
		- Gestion des clients : Pour la suppression celui des comptes et cartes n'est pas encore fait.
		- Gestion des comptes: en cours
		- Gestion transactions : 
		et ci-dessous les module qui ne sont pas encore pris en charge.
		- Gestion Audit
		- Gestion des Cartes
		- Gestion Patrimoine

	Si c'est un gérant:
		- Gestion des Conseillers
		- Gestion Audit qui n'est pes encore pris en charge
	
		
NB: - lots au service d'authentification (lot N°1): fait
	- service de virement compte à compte (lot N°2): fait
	- service d'édition d'un Relevé d'identité Bancaire (lot N°3) : encours
	- service dédié aux clients fortunés (lot N°4): pas encore fait.
 
		
	************************************
*****  	     Pré-requis avant execution		*****
	************************************
Installer un jdk ou au moins un jre sur son ordinateur.
Pour l'installation merci de suivre les étapes suivantes:

	-Rendez-vous sur la partie Java du site d’Oracle : http://www.oracle.com/technetwork/java
	-Dans la zone de droite ’software downloads’, cliquez sur le lien ’Java SE’ (pour Java Standard Edition)
	-Cliquez sur l’icône ’Java’ pour télécharger le JDK
	-Accepter la licence
	-De préférence choisir la version la plus récente (dernière sur la liste)
		-si votre machine est une 64 bit, choisir le jdk dont le nom a 'windows-X64' avant le '.exe'
		-si votre machine est une 32 bit, choisir le jdk dont le nom a 'windows-i586' avant le '.exe'
		-la version 32 bit fonctionne sur un Système Windows 32 bit ou 64 bit.
	-Cliquez sur le bouton ’Enregistrer le fichier’. Le téléchargement commence
	-Double cliquez sur le fichier téléchargé. L’assistant d’installation du JDK se lance
	-Cliquez sur le bouton ’Next’ des fenêtres qui vont s'afficher
	-Au moment d’installer un environnement d’exécution indépendant du JDK, l’assistant vous consulte. Acceptez les options par défaut et cliquez sur Next
	-Ainsi même si vous supprimez par la suite le répertoire d’installation du JDK (qui contient aussi une JRE), vous pourrez tout de même exécuter des programmes Java sur votre ordinateur
	-Vous arrivez à l’écran de fin d’installation, qui vous précise que l’installation s’est bien déroulée 
	-Cliquez sur Close: L’installation du JDK est terminée. 

	************************************
*****  		Version du jdk utilisé		  	*****
	************************************
java version "1.8.0_73"
Java(TM) SE Runtime Environment (build 1.8.0_73-b02)
Java HotSpot(TM) 64-Bit Server VM (build 25.73-b02, mixed mode)

	************************************
*****  	          Documentation			  	*****
	************************************
Veuillez suivre les indications suivantes:

1) Rendez vous dans le dossier 'Livraisons_Projets_Groupe5': vous y trouverez les dossier:
	- repertoire doc : contient la documentation :  Double cliquez sur 'index.html' .


	************************************
***** 	Mise en place de la base de données    		*****
	************************************
Télécharger et installer une base de données Mysql
Démarre les services de mysql et lancer phpMyAdmin.
Pour lancer phpMyAdmin vous pouvez aussi saisir directe sur votre navigateur l'url suivant: http://localhost/phpmyadmin/
	Dans Mysql, importer la base données "proxibanquev1" suivant les inctructions suivantes:
	-sur l'onglet "Base de Données" dans le champ "Créer une base de données" saisir "proxibanquev1" 
	-sur l'onglet "importer", cliquer "choisir un fichier" puis placer vous dans le dossier 'livraison'
	 et choisir le fichier 'proxibanquev1.sql' puis cliquer sur le bouton "Exécuter" en bas de page.	 
	
	************************************
***** 	    Execution de l'application    		*****
	************************************

1) 	Assurer vous que les services Mysql et Apache de phpMyAdmin sont démarrés.

2)	A l'aide de votre interpretteur de commande (cmd.exe), lancez la fenêtre 
	placer vous dans le dossier où vous avez téléchargé les fichiers compressés "proxibanquev1.jar"
	('cd [chemin]/[dossier cible]').

3) Entrer la commande 'java -jar proxibanquev1.jar'.