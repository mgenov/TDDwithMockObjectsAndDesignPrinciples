package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

public class RandomPressureTelemetryTelemetrySensor implements TelemetrySensor {
  public static final double OFFSET = 16;

  public double popNextPressurePsiValue() {
    double pressureTelemetryValue;
    pressureTelemetryValue = samplePressure();

    return OFFSET + pressureTelemetryValue;
  }

  private double samplePressure() {
    // placeholder implementation that simulate a real randomPressureTelemetrySensor in a real tire
    Random basicRandomNumbersGenerator = new Random(42);
    double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
    return pressureTelemetryValue;
  }
}
