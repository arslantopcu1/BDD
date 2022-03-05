package az.kapitalbank.e2e.stepDef.dependency;

import io.cucumber.java.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContextRefresher {

	private static final Logger logger = LoggerFactory.getLogger(ContextRefresher.class);

	@After(value = "@refreshContext", order = 1)
	public void afterResetData() {
		logger.info("refresh context");
		ResultStoreService.refresh();
	}

}
