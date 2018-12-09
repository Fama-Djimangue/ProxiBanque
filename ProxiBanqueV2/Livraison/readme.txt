	************************************
*****  	Description de l'application:   	*****
	************************************
ProxiBanque est une application bancaire qui permet à ses conseillers:
	- de se connecter à la base de données
	- d'afficher Liste des clients de la banque
	- d'enregistrer l'édition d'un client dans la base de données
	- d'afficher la liste des comptes d'un client de la banque
	- d'effectuer des virements Compte à Compte


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

Installer tomcat sur votre ordinateur:

- Rendez-vous sur le site  https://tomcat.apache.org/download-80.cgi  et cliquer sur le lien pour télécharger le logiciel et installer Tomcat "32-bit/64-bit Windows Service Installer" choisir la version "apache-tomcat-8.5.28"

- Ensuite allez dans C:\Program Files (x86)\Apache Software Foundation et ouvrir le répertoire d'installation de tomcat et Editer le fichier tomcat-users.xml (il se trouve dans le dossier "conf" du repertoire)

- Ajouter les lignes de codes suivants pour choisir un login et un mot de passe pour tomcat:
<role rolename="manager-gui"/>
<user username="admin" password="adminadmin" roles="manager-gui"/>


	************************************
*****  		Version du jdk utilisé		  	*****
	************************************
java version "1.8.0_73"
Java(TM) SE Runtime Environment (build 1.8.0_73-b02)
Java HotSpot(TM) 64-Bit Server VM (build 25.73-b02, mixed mode)



	************************************
*****  	Documentation:			  	*****
	************************************
Veuillez suivre les indications suivantes:

1) Rendez vous dans le dossier 'Livraison\doc'.

2) Double cliquez sur 'index.html'.


	************************************
***** 	Mise en place de la base de données    		*****
	************************************
Télécharger et installer une base de données Mysql
Démarre les services de mysql et lancer phpMyAdmin.
Pour lancer phpMyAdmin vous pouvez aussi saisir directe sur votre navigateur l'url suivant: http://localhost/phpmyadmin/
	Dans Mysql, importer la base données "proxibanquev2" suivant les inctructions suivantes:
	-sur l'onglet "Base de Données" dans le champ "Créer une base de données" saisir "proxibanquev2" 
	-sur l'onglet "importer", cliquer "choisir un fichier" puis placer vous dans le dossier 'Livraison'
	 et choisir le fichier 'proxibanquev2.sql' puis cliquer sur le bouton "Exécuter" en bas de page.	 

Creer un utilisateur "root" avec un mot de passse "".
NB : Vous pouvez changer le user et le pwd de la BDD dans le fichier web.xml à la ligne 64.
	
	************************************
***** 	    Déploiement dans le serveur Tomcat     		*****
	************************************

Démarrer le serveur Tomcat:

- double-cliquez sur bin/startup.bat du repertoire "apache-tomcat-8.0.20"
	
Notez la dernière ligne (INFO : Server Startup in XXXX ms ) prouvant que le serveur est bien démarré et précisant le temps de démarrage en millisecondes .

 Copiez le fichier ProxiBanqueV2.war dans le répertoire webapps de déploiement de Tomcat. Cela revient à déployer l’application.
 
Remarque : Notez que tomcat a ’dézippé’ le war en créant un répertoire de même nom.
Votre application est désormais bien déployée. Reste à la tester.

Avec votre navigateur , allez sur l’adresse de l’application : http://localhost:8080/ProxiBanqueV2/

Pour tester l'application:
	login:"fama"
	Mot de passe: "passer"		
	
	ou bien
	login : "mawa"
	Mot de passe : "passer"