package com.mulesoft.connectors.rfuelconnectormule4.internal.operation.base;

import com.mulesoft.connectivity.rest.commons.api.binding.HttpRequestBinding;
import com.mulesoft.connectivity.rest.commons.api.binding.HttpResponseBinding;
import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RestError;
import com.mulesoft.connectivity.rest.commons.api.operation.BaseRestOperation;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectivity.rest.commons.internal.util.RestRequestBuilder;
import com.mulesoft.connectivity.rest.commons.internal.util.StreamUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.exception.ModuleException;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
import org.mule.runtime.http.api.HttpConstants;

/** Higher part of the Operation. It has the implementation of the operation. */
public abstract class GetReadOperationBase extends BaseRestOperation {
  protected static final String OPERATION_PATH = "/read";

  protected static final RestRequestBuilder.ParameterArrayFormat QUERY_PARAM_FORMAT =
      RestRequestBuilder.ParameterArrayFormat.MULTIMAP;

  public GetReadOperationBase() {
    super();
  }

  public GetReadOperationBase(ExpressionLanguage arg0) {
    super(arg0);
  }

  protected void getRead(
      RestConfiguration config,
      RestConnection connection,
      String taskQueryParam,
      String correlationidQueryParam,
      String shostQueryParam,
      String dacctQueryParam,
      String mapQueryParam,
      String itemQueryParam,
      String grpQueryParam,
      String formatQueryParam,
      RequestParameters parameters,
      ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    try {
      Map<String, Object> customParameterBindings = new HashMap<>();
      getReadMain(
          config,
          connection,
          taskQueryParam,
          correlationidQueryParam,
          shostQueryParam,
          dacctQueryParam,
          mapQueryParam,
          itemQueryParam,
          grpQueryParam,
          formatQueryParam,
          customParameterBindings,
          parameters,
          overrides,
          callback);
    } catch (ModuleException e) {
      callback.error(e);
    } catch (Throwable e) {
      callback.error(new ModuleException("Unknown error", RestError.CONNECTIVITY, e));
    }
  }

  protected void getReadMain(
      RestConfiguration config,
      RestConnection connection,
      String taskQueryParam,
      String correlationidQueryParam,
      String shostQueryParam,
      String dacctQueryParam,
      String mapQueryParam,
      String itemQueryParam,
      String grpQueryParam,
      String formatQueryParam,
      Map<String, Object> customParameterBindings,
      RequestParameters parameters,
      ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    Map<String, Object> parameterBindings = new HashMap<>();
    parameterBindings = StreamUtils.resolveCursorProvider(parameterBindings);
    customParameterBindings = StreamUtils.resolveCursorProvider(customParameterBindings);
    RestRequestBuilder builder =
        getRequestBuilderWithBindings(
                connection.getBaseUri(),
                OPERATION_PATH,
                HttpConstants.Method.GET,
                parameters,
                overrides,
                connection,
                config,
                parameterBindings,
                customParameterBindings)
            .setQueryParamFormat(QUERY_PARAM_FORMAT)
            .addHeader("accept", "text/plain")
            .addQueryParam("task", taskQueryParam)
            .addQueryParam("correlationid", correlationidQueryParam)
            .addQueryParam("shost", shostQueryParam)
            .addQueryParam("dacct", dacctQueryParam)
            .addQueryParam("map", mapQueryParam)
            .addQueryParam("item", itemQueryParam)
            .addQueryParam("grp", grpQueryParam)
            .addQueryParam("format", formatQueryParam);
    doRequest(
        config,
        connection,
        builder,
        overrides.getResponseTimeoutAsMillis(),
        parameterBindings,
        customParameterBindings,
        callbackObjectAttributesAdapter(callback));
  }

  @Override
  protected String getRequestBodyMediaType() {
    return "application/json";
  }

  @Override
  protected String getResponseBodyMediaType() {
    return "text/plain";
  }

  @Override
  protected HttpRequestBinding getRequestBindings() {
    HttpRequestBinding bindings = new HttpRequestBinding();
    return bindings;
  }

  @Override
  protected HttpResponseBinding getResponseBindings() {
    HttpResponseBinding bindings = new HttpResponseBinding();
    return bindings;
  }
}
