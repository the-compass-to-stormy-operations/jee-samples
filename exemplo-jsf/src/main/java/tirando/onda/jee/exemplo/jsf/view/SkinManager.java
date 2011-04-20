package tirando.onda.jee.exemplo.jsf.view;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.model.SelectItem;

public class SkinManager {

	private String skin;
	private String[] skinItens;
	
	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String[] getSkinItens() {
		return skinItens;
	}

	public void setSkinItens(String[] skinItens) {
		this.skinItens = skinItens;
	}
	
	public Collection<SelectItem> getSelectSkinItens() {
		ArrayList<SelectItem> result = new ArrayList<SelectItem>();
		for (int i = 0; i < skinItens.length; i++) {
			result.add(new SelectItem(skinItens[i]));
		}
		return result;
	}

}
