package com.mulesoft.connectors.rfuelconnectormule4.internal.extension;

import com.mulesoft.connectivity.rest.commons.api.error.RestError;
import com.mulesoft.connectors.rfuelconnectormule4.internal.config.RFuelConnectorMule4Configuration;
import org.mule.runtime.api.meta.Category;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;
import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;

@Extension(name = "RFuel Connector Mule4", category = Category.CERTIFIED)
@Xml(prefix = "r-fuel-connector-mule-4")
@Configurations({RFuelConnectorMule4Configuration.class})
@ErrorTypes(RestError.class)
@RequiresEnterpriseLicense(allowEvaluationLicense = true)
public class RFuelConnectorMule4 {
  public static final String API_METADATA_CATEGORY = "rFuel Connector - Mule 4";
}
