package com.nurflugel.util.test;

import com.nurflugel.util.gradlescriptvisualizer.domain.Line;
import org.apache.commons.lang.BooleanUtils;
import java.util.ArrayList;
import java.util.List;

/** Util class to help with test resources. */
public class TestResources
{
  private static final String SOURCE_PATH_IDEA   = "build/resources/test/";
  private static final String SOURCE_PATH_GRADLE = "resources/test/";

  private TestResources() {}

  /** We do this because when unit tests run in the IDE the base file path is different than when running under Gradle, so we have to adjust it. */
  public static String getFilePath(String fileName)
  {
    String  property            = System.getProperty("running.in.gradle");
    boolean isGradleEnvironment = BooleanUtils.toBooleanObject(property, "yes", null, "dibble");

    return isGradleEnvironment ? (SOURCE_PATH_GRADLE + fileName)
                               : (SOURCE_PATH_IDEA + fileName);
  }

  public static List<Line> getLinesFromArray(String[]... lineArrays)
  {
    List<Line> results = new ArrayList<Line>();

    for (String[] lineArray : lineArrays)
    {
      for (String line : lineArray)
      {
        results.add(new Line(line));
      }
    }

    return results;
  }
}
