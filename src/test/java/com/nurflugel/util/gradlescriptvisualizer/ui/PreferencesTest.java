package com.nurflugel.util.gradlescriptvisualizer.ui;

import com.nurflugel.util.gradlescriptvisualizer.ui.GradleScriptPreferences;
import org.testng.annotations.Test;

/** Created with IntelliJ IDEA. User: dbulla Date: 6/20/12 Time: 10:58 AM To change this template use File | Settings | File Templates. */
public class PreferencesTest
{


  @Test
  public void testSystemProperties()
  {
    GradleScriptPreferences preferences=new GradleScriptPreferences(this.getClass());
    preferences.setUseHttpProxy(true);
    preferences.setUseProxyAuthentication(true);
  }
}
