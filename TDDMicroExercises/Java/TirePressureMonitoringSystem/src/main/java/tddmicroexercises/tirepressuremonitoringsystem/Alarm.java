package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm implements IAlarm {
  private final double lowPressureThreshold;
  private final double highPressureThreshold;

  private final TelemetrySensor telemetrySensor;

  public Alarm(TelemetrySensor telemetrySensor, double  lowPressureThreshold, double highPressureThreshold) {
    this.telemetrySensor = telemetrySensor;
    this.lowPressureThreshold = lowPressureThreshold;
    this.highPressureThreshold = highPressureThreshold;
  }

  boolean alarmOn = false;

  public void check() {
    double psiPressureValue = telemetrySensor.popNextPressurePsiValue();

    if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue) {
      alarmOn = true;
    }
  }

  public boolean isAlarmOn() {
    return alarmOn;
  }
}
