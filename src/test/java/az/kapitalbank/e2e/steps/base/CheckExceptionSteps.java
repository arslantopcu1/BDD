package az.kapitalbank.e2e.steps.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Serializable;

import az.kapitalbank.e2e.stepDef.dependency.ResultStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import net.thucydides.core.steps.ScenarioSteps;

@Component
public class CheckExceptionSteps extends ScenarioSteps implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ResultStoreService resultStoreService;

	public void checkExceptionHttpStatus(String httpStatusCode) {
		Exception catchedException = resultStoreService.getCatchedException();
		assertNotNull(catchedException);
		assertEquals(catchedException.getClass(), HttpClientErrorException.class);
		int statusCode = ((HttpClientErrorException) catchedException).getStatusCode().value();
		assertEquals(httpStatusCode, Integer.toString(statusCode));
	}

	public void checkResourceAccessException() {
		Exception catchedException = resultStoreService.getCatchedException();
		assertNotNull(catchedException);
		assertEquals(catchedException.getClass(), ResourceAccessException.class);
	}

}
