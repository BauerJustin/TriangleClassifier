import java.io.Serializable;
import java.util.Locale;

public class Settings implements Serializable	{
	
	private Locale locale = Locale.ENGLISH;
	
	public Locale getLocale() {
		return locale;
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
