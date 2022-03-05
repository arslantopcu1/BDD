package az.kapitalbank.e2e.stepDef.dependency;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ResultStoreService implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ResultStoreService.class);

	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

	private Exception catchedException;

	public static ResultStoreService resultStoreServiceInstance;
	
	@PostConstruct
	public void init() {
		ResultStoreService.resultStoreServiceInstance = this;
	}

	public static void refresh() {
		if (ResultStoreService.resultStoreServiceInstance != null){
			ResultStoreService.resultStoreServiceInstance.refreshContext();
		}
		
	}

	// CHECKSTYLE:OFF
	@SuppressWarnings("PMD.NullAssignment")
	public void refreshContext() {
		this.resultMap = new ConcurrentHashMap<>();
		this.catchedException = null;
	}

	public void catchException(Exception catchedException) {
		this.catchedException = catchedException;
		ResultStoreService.logger.error("catched exception", catchedException);
	}

	public void addResult(String key, Object object) {
		System.out.println("ADD RESULT key:" + key + " result:" + object);
		resultMap.put(key, object);
	}

	public Object getResult(String key) {
		Object result = resultMap.get(key);
		System.out.println("GET RESULT key:" + key + " result:" + result);
		return result;
	}

	public Exception getCatchedException() {
		return catchedException;
	}

	public void setCatchedException(Exception catchedException) {
		this.catchedException = catchedException;
	}
}
