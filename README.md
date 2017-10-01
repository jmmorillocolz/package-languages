# Class Languages
## README Versión en Español
Es una clase que permite manejar las traducciones de los mensajes que se muestran al los usuarios en una aplicación desarrollada en JAVA . Hereda de la clase Properties  del paquete java.util

### Modo de empleo
- Agregue un nuevo paquete a su proyecto y llámelo "Languages".
- Agregue la clase Languages incluída en este repositorio.
- Agregue al menos un "Property File" con los Key y Values de su preferencia. (En el descargable escuentra uno llamado "es-Es.properties") puede usarlo como ejemplo

### Ejemplo de Llamada

```[java]
Languages translate = new Languages("es-Es");
translate.getProperty("Not Found");
```
###Agregar más idiomas
Realmente puede agregar todos los paquetes de idiomas que desee. Siempre que agregue un nuevo archivo .properties, debe indicar en la clase Languages los nuevos idiomas disponibles. 
Agruegue la clase de su nuevo idioma al final de la clase Language:
```
 public class French implements Language {

        /**
         * Cargar el idioma Francés
         */
        @Override
        public void Load() {
            getProperties("fr-Fr.properties");//Esto hace referencia al archivo del mismo nombre
        }
    }
```
Luego, agregue el nuevo idioma al STORAGE_LANGUAGE
```
 private void StorageLanguages() {
        STORAGE_LANGUAGE = new HashMap<String, Language>();
        
        STORAGE_LANGUAGE.put("es-Es", new Spanish());
        STORAGE_LANGUAGE.put("en-En", new English());
        STORAGE_LANGUAGE.put("fr-Fr", new French());
        //AGREGAR MÁS IDIOMAS
    }
```
### Observación
El archivo .properties contiene las claves y valores que se configuran para la traducción. Recuerde siempre manejar las mismas KEY en todos los archivos .properties y el VALUE que corresponda según el idioma. Por ejemplo para el KEY "Not Found" el valor en inglés es "Not Found", pero el VALUE para español debe ser "No encontrado". Cuando quiera traducir un texto, debe tener en cuenta que se traduce por KEY almacenada en el archivo .properties, así pues, para este ejemplo será válido traducir "Not Found" porque es una KEY válida.

## README English Version
It's a class that allows to handle the translations of the messages that are shown to the users in an application developed in JAVA. Inherited from the Properties class of the java.util package.

### How to use
- Add a new package to your project and call it "Languages".
- Add the Languages class included in this repository.
- Add at least one "Property File" with the Key and Values of your choice. (In the downloadable you have one called "es-Es.properties") you can use it as an example.

### Call Example
```[java]
Languages translate = new Languages("es-Es");
translate.getProperty("Not Found");
```
### Add more languages
You can actually add all the language packs you want. Whenever you add a new .properties file, you must indicate in the Languages class the new languages available.
Aggregate your new language class to the end of the Language class:
```
 public class French implements Language {

        /**
         * Cargar el idioma Francés
         */
        @Override
        public void Load() {
            getProperties("fr-Fr.properties");//Esto hace referencia al archivo del mismo nombre
        }
    }
```
Then add the new language to the STORAGE_LANGUAGE
```
 private void StorageLanguages() {
        STORAGE_LANGUAGE = new HashMap<String, Language>();
        
        STORAGE_LANGUAGE.put("es-Es", new Spanish());
        STORAGE_LANGUAGE.put("en-En", new English());
        STORAGE_LANGUAGE.put("fr-Fr", new French());
        //AGREGAR MÁS IDIOMAS
    }
```
### NOTE
The .properties file contains the keys and values that are configured for translation. Always remember to handle the same KEYs in all .properties files and the corresponding VALUE according to the language. For example, for the KEY "Not Found" the English value is "Not Found", but the VALUE for Spanish should be "No encontrado". When you want to translate a text, you must take into account that it's translated by KEY stored in the .properties file, so for this example it will be valid to translate "Not Found" because it's a valid KEY.

