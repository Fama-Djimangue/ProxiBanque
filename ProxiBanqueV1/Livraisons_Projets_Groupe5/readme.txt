	************************************
*****  	    Description de l'application   	*****
	************************************

ProxiBanque permet de se connecter � la base de donn�es et permet selon l'utilisateur :conseilleur ou gerant.

Pour cette Version de ProxiBanque, nous avons cr��r manuellement deux agences et deux g�rants dans la base de donn�es.
	G�rant 1: 
		Login: baytam    Mot de Passe: admin1
	G�rant 2: 
		Login: weuz    Mot de Passe: admin2 
	
Les utilisateurs ont aussi la possibilit� de changer leur mot de passe lors de la connexion.
	Si l'utilisateur connect� est un conseillier, il aura acc�s aux modules suivants:
		- Gestion des clients : Pour la suppression celui des comptes et cartes n'est pas encore fait.
		- Gestion des comptes: en cours
		- Gestion transactions : 
		et ci-dessous les module qui ne sont pas encore pris en charge.
		- Gestion Audit
		- Gestion des Cartes
		- Gestion Patrimoine

	Si c'est un g�rant:
		- Gestion des Conseillers
		- Gestion Audit qui n'est pes encore pris en charge
	
		
NB: - lots au service d'authentification (lot N�1): fait
	- service de virement compte � compte (lot N�2): fait
	- service d'�dition d'un Relev� d'identit� Bancaire (lot N�3) : encours
	- service d�di� aux clients fortun�s (lot N�4): pas encore fait.
 
		
	************************************
*****  	     Pr�-requis avant execution		*****
	************************************
Installer un jdk ou au moins un jre sur son ordinateur.
Pour l'installation merci de suivre les �tapes suivantes:

	-Rendez-vous sur la partie Java du site d�Oracle : http://www.oracle.com/technetwork/java
	-Dans la zone de droite �software downloads�, cliquez sur le lien �Java SE� (pour Java Standard Edition)
	-Cliquez sur l�ic�ne �Java� pour t�l�charger le JDK
	-Accepter la licence
	-De pr�f�rence choisir la version la plus r�cente (derni�re sur la liste)
		-si votre machine est une 64 bit, choisir le jdk dont le nom a 'windows-X64' avant le '.exe'
		-si votre machine est une 32 bit, choisir le jdk dont le nom a 'windows-i586' avant le '.exe'
		-la version 32 bit fonctionne sur un Syst�me Windows 32 bit ou 64 bit.
	-Cliquez sur le bouton �Enregistrer le fichier�. Le t�l�chargement commence
	-Double cliquez sur le fichier t�l�charg�. L�assistant d�installation du JDK se lance
	-Cliquez sur le bouton �Next� des fen�tres qui vont s'afficher
	-Au moment d�installer un environnement d�ex�cution ind�pendant du JDK, l�assistant vous consulte. Acceptez les options par d�faut et cliquez sur Next
	-Ainsi m�me si vous supprimez par la suite le r�pertoire d�installation du JDK (qui contient aussi une JRE), vous pourrez tout de m�me ex�cuter des programmes Java sur votre ordinateur
	-Vous arrivez � l��cran de fin d�installation, qui vous pr�cise que l�installation s�est bien d�roul�e 
	-Cliquez sur Close: L�installation du JDK est termin�e. 

	************************************
*****  		Version du jdk utilis�		  	*****
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
***** 	Mise en place de la base de donn�es    		*****
	************************************
T�l�charger et installer une base de donn�es Mysql
D�marre les services de mysql et lancer phpMyAdmin.
Pour lancer phpMyAdmin vous pouvez aussi saisir directe sur votre navigateur l'url suivant: http://localhost/phpmyadmin/
	Dans Mysql, importer la base donn�es "proxibanquev1" suivant les inctructions suivantes:
	-sur l'onglet "Base de Donn�es" dans le champ "Cr�er une base de donn�es" saisir "proxibanquev1" 
	-sur l'onglet "importer", cliquer "choisir un fichier" puis placer vous dans le dossier 'livraison'
	 et choisir le fichier 'proxibanquev1.sql' puis cliquer sur le bouton "Ex�cuter" en bas de page.	 
	
	************************************
***** 	    Execution de l'application    		*****
	************************************

1) 	Assurer vous que les services Mysql et Apache de phpMyAdmin sont d�marr�s.

2)	A l'aide de votre interpretteur de commande (cmd.exe), lancez la fen�tre 
	placer vous dans le dossier o� vous avez t�l�charg� les fichiers compress�s "proxibanquev1.jar"
	('cd [chemin]/[dossier cible]').

3) Entrer la commande 'java -jar proxibanquev1.jar'.