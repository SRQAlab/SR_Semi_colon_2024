package psl.espn.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.Properties;

public class PropertiesFileReader {
	String type=null;
	public PropertiesFileReader(String type)
	{
		this.type=type;
	}
	public  String GetParameterValue(String ParameterName) throws IOException
	{
		InputStream input = null;
		Properties prop = new Properties();
		input = getClass().getClassLoader().getResourceAsStream(type+".properties");
		
		// load a properties file
		prop.load(input);
		String ParameterValue=prop.getProperty(ParameterName);
		
		return ParameterValue;

	}
	
}
