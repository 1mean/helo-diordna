package com.lxj.xpopup.core;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
import java.lang.Override;

public class BasePopupView_LifecycleAdapter implements GeneratedAdapter {
  final BasePopupView mReceiver;

  BasePopupView_LifecycleAdapter(BasePopupView receiver) {
    this.mReceiver = receiver;
  }

  @Override
  public void callMethods(LifecycleOwner owner, Lifecycle.Event event, boolean onAny,
      MethodCallsLogger logger) {
    boolean hasLogger = logger != null;
    if (onAny) {
      return;
    }
    if (event == Lifecycle.Event.ON_DESTROY) {
      if (!hasLogger || logger.approveCall("onDestroy", 1)) {
        mReceiver.onDestroy();
      }
      return;
    }
  }
}
