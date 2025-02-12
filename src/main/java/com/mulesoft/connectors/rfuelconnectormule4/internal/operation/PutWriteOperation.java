package com.mulesoft.connectors.rfuelconnectormule4.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.rfuelconnectormule4.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.rfuelconnectormule4.internal.metadata.PutWriteOutputMetadataResolver;
import com.mulesoft.connectors.rfuelconnectormule4.internal.operation.refinement.PutWriteOperationRefinement;
import java.io.InputStream;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class PutWriteOperation extends PutWriteOperationRefinement {
  public PutWriteOperation() {
    super();
  }

  public PutWriteOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  /**
   * Update write
   *
   * <p>This operation makes an HTTP PUT request to the /write endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param taskQueryParam ALWAYS use '055'
   * @param correlationidQueryParam The Correlation ID is how we track messages through the system
   *     to provide support
   * @param shostQueryParam The Source-Host is defined in this properties file
   * @param dacctQueryParam The name of the Database Account where the data file (or pointer)
   *     resides.
   * @param mscatQueryParam The micro-service catalog as described in rFuel documentation.
   * @param payloadQueryParam The data which is to be written back to the database.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Update write")
  @MediaType("text/plain")
  @OutputResolver(
      output = PutWriteOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void putWrite(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional @DisplayName("task") @Summary("ALWAYS use '055'") String taskQueryParam,
      @Optional
          @DisplayName("correlationid")
          @Summary(
              "The Correlation ID is how we track messages through the system to provide support")
          String correlationidQueryParam,
      @Optional @DisplayName("shost") @Summary("The Source-Host is defined in this properties file")
          String shostQueryParam,
      @Optional
          @DisplayName("dacct")
          @Summary("The name of the Database Account where the data file (or pointer) resides.")
          String dacctQueryParam,
      @Optional
          @DisplayName("mscat")
          @Summary("The micro-service catalog as described in rFuel documentation.")
          String mscatQueryParam,
      @Optional
          @DisplayName("payload")
          @Summary("The data which is to be written back to the database.")
          String payloadQueryParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.putWrite(
        config,
        connection,
        taskQueryParam,
        correlationidQueryParam,
        shostQueryParam,
        dacctQueryParam,
        mscatQueryParam,
        payloadQueryParam,
        parameters,
        overrides,
        callback);
  }
}
