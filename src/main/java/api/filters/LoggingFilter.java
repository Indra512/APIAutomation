package api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("Base Url: " + requestSpec.getBaseUri());
		logger.info("Request Headers: " + requestSpec.getHeaders());
		if (requestSpec.getBody() != null)
			logger.info("Request Payload: " + requestSpec.getBody());
	}

	public void logResponse(Response response) {
		logger.info("Status Code: " + response.getStatusCode());
		logger.info("Response Payload: " + response.getBody().asPrettyString());
		logger.info("Response Time: " + response.getTime());
	}
}
