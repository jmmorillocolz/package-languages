/**
 * VERSIÓN ESPAÑOL
 * Permite manejar el idioma a mostrar en los mensajes de la aplicación
 * Idiomas Disponibles:
 * Inglés - en-En
 * Español - es-Es
 *
 * Llamada: - Instancie un objeto -    Languages lan = new Languages("es-Es");
 *          - Aplique la traducción al texto deseado -   lan.getProperty("A required argument has not been found");
 *
 * Uso de la clase:
 *  Agregue el archivo Properties File con las Key y Value de su preferencia
 *  Agregue una clase con el nombre del Idioma, esta debe implementar la interface Language
 *  Agregue el Idioma en el StorageLanguages
 *
 * ENGLISH VERSION
 *
 * This class Allows you to manage the language and display the messages of the application
 * Available languages:
 * English - en-En
 * Spanish - es-Es
 *
 * Call:  - Instantiate an object  - Languages lan = new Languages("en-En");
 *        - Applying the translation to a text - lan.getProperty("A required argument has not been found");
 *
 * Steps to use the class:
 *
 *  Add the Properties File with the Key and Value of your choice
 *  *  Add a class with the language name, it must implement the language interface
 *  *  Add Language to StorageLanguages
 *
 * @author José Miguel Morillo jmmorillocolz@gmail.com
 * @since 2017-09-14
 * @version 1.0.0 - https://github.com/jmmorillocolz/package-languages.git
 * 
 * @update 2017-09-24
 * @version 1.0.1
 */
package Languages;

import java.io.IOException;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;


public class Languages extends Properties {

    /**
     * Lista de tipo clase Language que contiene los Idiomas cargados.
     */
    private Map<String, Language> STORAGE_LANGUAGE;

    /**
     * Constructor de la Clase, recibe como parámetro el idioma a mostrar
     *
     * @param language
     */
    public Languages(String language) throws Exception {

        StorageLanguages();
        SearchLanguage(language);

        STORAGE_LANGUAGE.get(SearchLanguage(language)).Load();
    }

    /**
     * Carga los Idiomas en la variable STORAGE.
     */
    private void StorageLanguages() {
        STORAGE_LANGUAGE = new HashMap<String, Language>();

        STORAGE_LANGUAGE.put("es-Es", new Spanish());
        STORAGE_LANGUAGE.put("en-En", new English());
        //AGREGAR MÁS IDIOMAS
    }

    /**
     * Busca el idioma en el Storage, si existe retorna el index, si no existe
     * ejecuta una exception
     *
     * @param language Idioma a buscar
     * @return Valor entero (index del array)
     */
    private String SearchLanguage(String language) throws Exception {
        String key = "";
        if (STORAGE_LANGUAGE.containsKey(language)) {
            key = language;
        } else {
            throw new Exception("Not available");
        }

        return key;
    }

    /**
     * Obtiene la propiedad definida para idioma indicado
     *
     * @param language Idioma a cargar
     */
    public void getProperties(String language) {
        try {
            this.load(getClass().getResourceAsStream(language));
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    /**
     * Interface de Idiomas Tiene como único método Load()
     */
    public interface Language {

        void Load();
    }

    /**
     * Clase Spanish que implementa la interface Language
     */
    public class Spanish implements Language {

        /**
         * Cargar el idioma Español
         */
        @Override
        public void Load() {
            getProperties("es-Es.properties");
        }
    }

    /**
     * Clase English que implementa la interface Language
     */
    public class English implements Language {

        /**
         * Cargar el idioma Inglés
         */
        @Override
        public void Load() {
            getProperties("en-En.properties");
        }
    }
    //AGREGAR MÁS CLASES PARA IDIOMAS
}
