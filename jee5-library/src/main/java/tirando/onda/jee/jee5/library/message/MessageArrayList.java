package tirando.onda.jee.jee5.library.message;

import java.util.ArrayList;

public class MessageArrayList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;

	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < this.size(); i++)
				if (this.get(i) == null)
					return i;
		} else {
			for (int i = 0; i < this.size(); i++)
				if (this.get(i).equals(o))
					return i;
		}
		return -1;
	}
	
}