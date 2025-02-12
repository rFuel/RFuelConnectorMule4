package com.mulesoft.connectors.rfuelconnectormule4.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.rfuelconnectormule4.internal.metadata.GetReadOutputMetadataResolver;
import com.mulesoft.connectors.rfuelconnectormule4.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.rfuelconnectormule4.internal.operation.refinement.GetReadOperationRefinement;
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
public class GetReadOperation extends GetReadOperationRefinement {
  public GetReadOperation() {
    super();
  }

  public GetReadOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  /**
   * Get read
   *
   * <p>This operation makes an HTTP GET request to the /read endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param taskQueryParam ALWAYS use '050'
   * @param correlationidQueryParam The Correlation ID is how we track messages through the system
   *     to provide support
   * @param shostQueryParam The Source-Host is defined in this properties file
   * @param dacctQueryParam The name of the Database Account where the data file (or pointer)
   *     resides.
   * @param mapQueryParam The map is the artefact described in rFuel documentation.
   * @param itemQueryParam The item ID of the record being read.
   * @param grpQueryParam Signifies a group read (many maps and items).
   * @param formatQueryParam Allows you to swap formats between XML and JSON.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get read")
  @MediaType("text/plain")
  @OutputResolver(
      output = GetReadOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getRead(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional @DisplayName("task") @Summary("ALWAYS use '050'") String taskQueryParam,
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
          @DisplayName("map")
          @Summary("The map is the artefact described in rFuel documentation.")
          String mapQueryParam,
      @Optional @DisplayName("item") @Summary("The item ID of the record being read.")
          String itemQueryParam,
      @Optional @DisplayName("grp") @Summary("Signifies a group read (many maps and items).")
          String grpQueryParam,
      @Optional @DisplayName("format") @Summary("Allows you to swap formats between XML and JSON.")
          String formatQueryParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getRead(
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
        parameters,
        overrides,
        callback);
  }
}
