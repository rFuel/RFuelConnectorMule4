package com.mulesoft.connectors.rfuelconnectormule4.internal.connection.provider;

import com.mulesoft.connectors.rfuelconnectormule4.internal.connection.provider.refinement.ApiKeyAuthConnectionProviderRefinement;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

/**
 * This is the last layer of the connection provider generation gap pattern. It is what finally gets
 * exposed as the connection provider, including all customizations made in the refinement layer.
 */
@Alias("api-key-auth")
@DisplayName("Api Key Auth Connection Provider")
public class ApiKeyAuthConnectionProvider extends ApiKeyAuthConnectionProviderRefinement {}
