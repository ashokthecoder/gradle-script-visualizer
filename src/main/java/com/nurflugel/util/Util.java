package com.nurflugel.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.Date;
import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Util class. */
public class Util
{
  public static final Cursor busyCursor           = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
  public static final Cursor normalCursor         = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
  public static final String VERSION              = "1.0.6";
  public static final String DEPENDS_ON           = "dependsOn";
  public static final String APPLY_FROM           = "apply from: ";
  public static final String DEPENDS_ON_TEXT      = "dependsOn:";
  public static final String EXECUTE_TEXT         = ".execute()";
  public static final String SPACE                = " ";
  public static final String PERIOD               = ".";
  public static final String NO_TYPE              = "noType";
  public static final String EACH                 = ".each";
  public static final String SINGLE_QUOTE         = "'";
  public static final String DOUBLE_QUOTE         = "\"";
  public static final String COMMA                = ",";
  public static final String OPEN_SQUARE_BRACKET  = "[";
  public static final String CLOSE_SQUARE_BRACKET = "]";
  public static final String EMPTY_TEXT           = "";
  public static final String OPEN_PARENTHESIS     = "(";
  public static final String CLOSE_PARENTHESIS    = ")";
  public static final String TYPE                 = "type:";
  public static final String UNDERSCORE           = "_";
  public static final String COLON                = ":";
  public static final String SLASH                = "/";
  public static final String BACKSLASH            = "\\";
  public static final String HYPHEN               = "-";
  // -------------------------- STATIC METHODS --------------------------

  /** Sets the look and feel. */
  @SuppressWarnings("UseOfSystemOutOrSystemErr")
  public static LookAndFeel setLookAndFeel(String feelName, Component component)
  {
    LookAndFeel currentLAF = UIManager.getLookAndFeel();

    try
    {
      UIManager.setLookAndFeel(feelName);
      SwingUtilities.updateComponentTreeUI(component);
    }
    catch (Exception e)
    {
      System.out.println("Error setting native LAF: " + feelName + e.getMessage());
    }

    return currentLAF;
  }

  public static LookAndFeel setLookAndFeel(LookAndFeel lookAndFeel, Component component)
  {
    return setLookAndFeel(lookAndFeel.getName(), component);
  }

  public static void centerApp(Object object)
  {
    if (object instanceof Container)
    {
      Container comp = (Container) object;

      center(comp);
    }
  }

  /** Centers the component on the screen. */
  @SuppressWarnings("NumericCastThatLosesPrecision")
  public static void center(Container container)
  {
    Toolkit   defaultToolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize     = defaultToolkit.getScreenSize();
    int       x              = (int) ((screenSize.getWidth() - container.getWidth()) / 2);
    int       y              = (int) ((screenSize.getHeight() - container.getHeight()) / 2);

    container.setBounds(x, y, container.getWidth(), container.getHeight());
  }

  /** Add the help listener - link to the help files. */
  public static void addHelpListener(String helpSetName, JButton helpButton, JFrame theFrame)
  {
    /*
     * ClassLoader classLoader = theFrame.getClass().getClassLoader();
     *
     * try
     * {
     * URL                       hsURL                 = HelpSet.findHelpSet(classLoader, helpSetName);
     * HelpSet                   helpSet               = new HelpSet(null, hsURL);
     * HelpBroker                helpBroker            = helpSet.createHelpBroker();
     * CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(helpBroker);
     *
     * helpButton.addActionListener(displayHelpFromSource);
     * }
     * catch (HelpSetException ee)
     * {  // Say what the exception really is
     * System.out.println("Exception! " + ee.getMessage());
     * // LOGGER.error("HelpSet " + ee.getMessage());
     * // LOGGER.error("HelpSet " + HELP_HS + " not found");
     * }
     */
  }

  private Util() {}
}
