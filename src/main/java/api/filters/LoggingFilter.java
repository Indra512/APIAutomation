package api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.reporting.ExtentReportManager;
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
		logger.info("Request: {} {}", requestSpec.getMethod(), requestSpec.getURI());
		logger.info("Headers: {}", requestSpec.getHeaders());
		if (requestSpec.getBody() != null) {
			logger.info("Body: {}", requestSpec.getBody().toString());
		}
		ExtentReportManager.logRequest(requestSpec);
	}

	public void logResponse(Response response) {
		logger.info("Response Headers: {}", response.getHeaders());
		logger.info("Response Status: {}", response.getStatusCode());
		logger.info("Response Body: {}",  response.getBody().asString());
		ExtentReportManager.logResponse(response);
	}
}
