package tirando.onda.jee.bpm.exemplo1.web.servlet.listener;

import javax.annotation.Resource;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

public class JTAServletRequestListener implements ServletRequestListener {
	
	@Resource
	UserTransaction trx;

	public void requestInitialized(ServletRequestEvent sre) {
		try {
			trx.begin();
		} catch (Exception e) {
			throw new RuntimeException("JTA begin exception",e);
		}
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		try {
			switch (trx.getStatus()) {
			case Status.STATUS_ACTIVE:
				trx.commit();
				break;
			case Status.STATUS_MARKED_ROLLBACK:
				trx.rollback();
				break;
			}
		} catch (Exception e) {
			throw new RuntimeException("JTA end exception",e);
		}
	}

}
