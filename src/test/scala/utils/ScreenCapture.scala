package utils

import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}
import org.openqa.selenium.io.FileHandler

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

object ScreenCapture {
  // THIS IS EMPTY
  def takeScreenshot(
                      driver: WebDriver,
                      basePath: String = "/Users/andrew.boyce/Documents/Screenshots/Cucumber",
                      prefix: String = ""
                    ): Unit = {
    // Set up params with default options
    // Create a timestamp
    val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
    // Take a screenshot
    val screenshotFile = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    // Build a full path based on input strings and timestamp
    val fullPath = s"${basePath}/${prefix}_${timeStamp}.png"
    // Save the screenshot to the destination
    FileHandler.copy(screenshotFile, new File(fullPath))
    // Print out where the screenshot has been saved locally
    println(s"Screenshot saved to: $fullPath")
  }

}