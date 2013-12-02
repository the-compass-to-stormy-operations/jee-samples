#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.faces.managedbean;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.model.SelectItem;

public class SkinManagerBean {

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
	
	public Collection<SelectItem> getSkinSelectItens() {
		ArrayList<SelectItem> result = new ArrayList<SelectItem>();
		for (int i = 0; i < skinItens.length; i++) {
			result.add(new SelectItem(skinItens[i]));
		}
		return result;
	}

}
