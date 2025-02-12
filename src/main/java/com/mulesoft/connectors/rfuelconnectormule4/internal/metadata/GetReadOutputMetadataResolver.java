package com.mulesoft.connectors.rfuelconnectormule4.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.StringOutputMetadataResolver;
import com.mulesoft.connectors.rfuelconnectormule4.internal.extension.RFuelConnectorMule4;

public class GetReadOutputMetadataResolver extends StringOutputMetadataResolver {
  @Override
  public String getResolverName() {
    return "get-read-output-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return RFuelConnectorMule4.API_METADATA_CATEGORY;
  }
}
