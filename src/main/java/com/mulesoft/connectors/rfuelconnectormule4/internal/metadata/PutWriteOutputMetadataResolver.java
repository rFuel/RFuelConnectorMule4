package com.mulesoft.connectors.rfuelconnectormule4.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.StringOutputMetadataResolver;
import com.mulesoft.connectors.rfuelconnectormule4.internal.extension.RFuelConnectorMule4;

public class PutWriteOutputMetadataResolver extends StringOutputMetadataResolver {
  @Override
  public String getResolverName() {
    return "put-write-output-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return RFuelConnectorMule4.API_METADATA_CATEGORY;
  }
}
