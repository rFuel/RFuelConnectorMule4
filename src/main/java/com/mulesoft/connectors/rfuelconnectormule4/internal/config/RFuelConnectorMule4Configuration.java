package com.mulesoft.connectors.rfuelconnectormule4.internal.config;

import com.mulesoft.connectors.rfuelconnectormule4.internal.config.refinement.RFuelConnectorMule4ConfigurationRefinement;
import com.mulesoft.connectors.rfuelconnectormule4.internal.connection.provider.ApiKeyAuthConnectionProvider;
import com.mulesoft.connectors.rfuelconnectormule4.internal.operation.GetReadOperation;
import com.mulesoft.connectors.rfuelconnectormule4.internal.operation.PutWriteOperation;
import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;

@Configuration
@Operations({GetReadOperation.class, PutWriteOperation.class})
@ConnectionProviders({ApiKeyAuthConnectionProvider.class})
public class RFuelConnectorMule4Configuration extends RFuelConnectorMule4ConfigurationRefinement {}
