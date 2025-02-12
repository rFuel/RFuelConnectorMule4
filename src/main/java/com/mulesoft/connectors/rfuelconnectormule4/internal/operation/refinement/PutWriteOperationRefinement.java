package com.mulesoft.connectors.rfuelconnectormule4.internal.operation.refinement;

import com.mulesoft.connectors.rfuelconnectormule4.internal.operation.base.PutWriteOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class PutWriteOperationRefinement extends PutWriteOperationBase {
  public PutWriteOperationRefinement() {
    super();
  }

  public PutWriteOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }
}
