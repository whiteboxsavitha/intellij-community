// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.yaml.highlighting;

import com.intellij.openapi.application.ex.PathManagerEx;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.jetbrains.yaml.inspections.YAMLRecursiveAliasInspection;
import org.jetbrains.yaml.inspections.YAMLUnresolvedAliasInspection;

public class YAMLHighlightingTest extends LightPlatformCodeInsightFixtureTestCase {
  @Override
  protected String getTestDataPath() {
    return PathManagerEx.getCommunityHomePath() + "/plugins/yaml/testSrc/org/jetbrains/yaml/highlighting/data/";
  }

  public void testBlockScalarHeaderError() {
    doTest();
  }

  public void testMultipleAnchorsError() {
    doTest();
  }

  public void testMultipleTagsError() {
    doTest();
  }

  public void testUnresolvedAlias() {
    myFixture.enableInspections(YAMLUnresolvedAliasInspection.class);
    doTest();
  }

  public void testRecursiveAlias() {
    myFixture.enableInspections(YAMLRecursiveAliasInspection.class);
    doTest();
  }

  private void doTest() {
    myFixture.testHighlighting(true, false, false, getTestName(true) + ".yml");
  }
}
