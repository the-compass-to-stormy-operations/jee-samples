package tirando.onda.jee.facelets;

import java.net.URL;

import com.sun.facelets.impl.DefaultResourceResolver;

public class TemplateResourceResolver extends DefaultResourceResolver {

	public URL resolveUrl(String resource) {
		URL url = null;

		if (url == null) {
			url = super.resolveUrl(resource);
		}

		if (url == null) {
			url = Thread.currentThread().getContextClassLoader().getResource("META-INF/"+resource);
		}
		return url;
	}

}
