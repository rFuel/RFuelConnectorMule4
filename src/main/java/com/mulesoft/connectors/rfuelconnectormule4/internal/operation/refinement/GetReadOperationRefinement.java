package com.mulesoft.connectors.rfuelconnectormule4.internal.operation.refinement;

import com.mulesoft.connectors.rfuelconnectormule4.internal.operation.base.GetReadOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class GetReadOperationRefinement extends GetReadOperationBase {
  public GetReadOperationRefinement() {
    super();
  }

  public GetReadOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }
}
