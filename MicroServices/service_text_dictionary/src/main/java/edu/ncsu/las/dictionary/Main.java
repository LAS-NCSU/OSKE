package edu.ncsu.las.dictionary;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.ncsu.las.dictionary.model.DictionaryManager;

import java.io.IOException;
import java.net.URI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class.
 *
 */
public class Main {
	private static Logger logger =Logger.getLogger(Main.class.getName());
	private static JSONObject _properties;
	
	private static DictionaryManager _theDictionaryManager;
   
	/**
	 * Loads the json configuration from a value contained in an environment variable
	 * 
	 */
	public static void initialize(String environmentVariable) {
		if (_properties != null) {
			logger.log(Level.SEVERE, "System has already been initialized", new Exception("Illegal call"));
			System.exit(-1);
		}
		
		try {
			// Load the properties file
			String content = System.getenv(environmentVariable); //{"geo_api":{"service_url":"http://0.0.0.0:9001/geo/","cacheSize":20000,"providers":[{"name":"openStreetMap","userAgent":"YOUR_EMAIL_ADDRESS","restEndPoint":"http://nominatim.openstreetmap.org/search?format=json&q=","maxPerDay":86400,"requestRate":1,"parentArray":"","latitudeField":"lat","longitudeField":"lon"},{"name":"locationIQ","userAgent":"YOUR_EMAIL_ADDRESS","restEndPoint":"https://locationiq.org/v1/search.php?key=REGISTERED_KEY&format=json&q=","maxPerDay":10000,"requestRate":1,"parentArray":"","latitudeField":"lat","longitudeField":"lon"}]}}
			logger.log(Level.INFO, "System configuration: " +content);
			if (content == null) {
				logger.log(Level.WARNING, "No system configuration available in environment variable: " +environmentVariable);
				content = "{}";
			}
			_properties = new JSONObject(content);
		}
		catch (JSONException je) {
			logger.log(Level.SEVERE, "Unable to read configuration property file - malformed json: " +je);

			System.exit(-1);
		}		
		
		// Check all required properties are present:
		boolean foundMissing=false;
		for (Configuration c: Configuration.values()) {
			if ( c.isRequired() && (c.getParentConfiguration() == null || c.getParentConfiguration().isJSONArray()==false) &&  Main.hasConfigurationProperty(c) == false) {
				logger.log(Level.SEVERE, "Missing parameter - "+c.toString()+": "+c.getDescription());
				foundMissing = true;
			}
		}
		if (foundMissing) {
			logger.log(Level.SEVERE, "Exiting System - not all required properties are present.");
			System.exit(-1);
		}
		
		try {
			_theDictionaryManager = new DictionaryManager("wordnet", 1000); //TODO: getConfigurationPropertyAsInt(Configuration.GEO_API_CACHE_SIZE)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.log(Level.INFO, "System initialized.");
	}    
    
	
	public static JSONObject getConfiguration() { return _properties;	}
	
	
	private static JSONObject getConfigurationObject(Configuration property){
		if (property == null) { return _properties; }
		else {
			return Main.getConfigurationObject(property.getParentConfiguration()).getJSONObject(property.toString());
		}
	}
	
	public static String getConfigurationProperty(Configuration property) {
		return Main.getConfigurationObject(property.getParentConfiguration()).optString(property.toString());	
	}
	
	public static boolean hasConfigurationProperty(Configuration property) {
		return Main.getConfigurationObject(property.getParentConfiguration()).has(property.toString());	
	}

	/**
	 * 
	 * @param property
	 * @return 0 if it doesn't exist
	 */
	public static long getConfigurationPropertyAsLong(Configuration property) {
		return Main.getConfigurationObject(property.getParentConfiguration()).optLong(property.toString());	
	}
	
	/**
	 * 
	 * @param property
	 * @return 0 if it doesn't exist
	 */
	public static int getConfigurationPropertyAsInt(Configuration property) {
		return Main.getConfigurationObject(property.getParentConfiguration()).optInt(property.toString());	
	}	
	
	/**
	 * 
	 * @param property
	 * @return 0 if it doesn't exist
	 */
	public  static boolean getConfigurationPropertyAsBoolean(Configuration property) {
		return Main.getConfigurationObject(property.getParentConfiguration()).optBoolean(property.toString());	
	}	

	/**
	 * 
	 * @param property
	 * @return 
	 */
	public static JSONArray getConfigurationPropertyAsArray(Configuration property) {
		return Main.getConfigurationObject(property.getParentConfiguration()).getJSONArray(property.toString());	
	}
	
	/**
	 * 
	 * @param property
	 * @return 
	 */
	public static java.util.Properties getConfigurationPropertyAsProperties(Configuration property) {
		JSONObject jo = Main.getConfigurationObject(property);	
		java.util.Properties prop = new java.util.Properties();
		for (String key: jo.keySet()) {
			prop.setProperty(key, jo.getString(key));
		}
		return prop;
	}			
	
	public static DictionaryManager accessDiectionaryManager() { return _theDictionaryManager; }
    
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.ncsu.las.graph.api package
        final ResourceConfig rc = new ResourceConfig().packages("edu.ncsu.las.dictionary");
        
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create("http://0.0.0.0:9020/dictionary/"), rc);// "  Main.getConfigurationProperty(Configuration.GEO_API_SERVICE_URL)), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	
		Main.initialize("APPLICATION_PROPERTIES");
    	
		Main.startServer(); //final HttpServer server = startServer();
	    System.out.println(String.format("Jersey app started with WADL available at %sapplication.wadl", "http://0.0.0.0:9020/dictionary/"));
    }
}

