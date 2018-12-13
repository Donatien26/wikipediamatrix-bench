# Wikipedia a quoi ca sert ?

Le but de ce programme est d'extraire les tableaux wikipedia qui sont qualifi?? en tant que wikitable sortable. Nous avions au d??part plus de 300 Urls wikipedia et le but ??tait de :
*r??cuperer le plus de tableau possible
*Les exporter en fichier CSV dans le dossier output/html

#Licence
```
GNU V3
``` 
#Preambule
Afin d'utiliser l'extracteur il faut tout d'abord installer un ??diteur de texte java (exemple Eclipse) et un JEE java.

```
<https://www.eclipse.org/downloads/>
``` 
Lors de l'installation d'eclipse, ce dernier propose directement d'installer un JEE.

#Executer
Importer le dossier :
```
wikimatrix
``` 
et se rendre dans la classe
```
mvnTest
``` 

Il faut ensuite ce rendre dans la classe `mvnTest` et l'executer, les resultats se trouveront dans le fichier `output`

Si l'utilisateur d??sire extraire de nouveaux URLs il doit se rendre dans le fichier wikitext.txt et y ajouter les URls qu'il desire recuperer et relancer le programme

Pour charger un autre fichier .txt contenant d'autres URls changer la valeur de charger
```
		File charger = new File("inputdata" + File.separator + "wikiurls.txt");
``` 

Pour stocker dans un autre r??pertoire changer l'attribut destination
```
		String destination = "output" + File.separator + "html" + File.separator;
```
#Maven dependances
Ajouter les d??pendances suivantes dans le fichier pom.xml qui g??re les dependances maven.
```
    <dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<!-- jsoup HTML parser library @ https://jsoup.org/ -->
			<groupId>org.jsoup</groupId>
			<artifactId>jsoup</artifactId>
			<version>1.11.3</version>
		</dependency>
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-csv</artifactId>
			<version>1.6</version>
		</dependency>
``` 




#Le diagramme de classe :

![Ci dessus le diagramme de classe de cette application](https://github.com/Donatien26/wikipediamatrix-bench/blob/master/wikimatrix/diagramme.png?raw=true "Title")
