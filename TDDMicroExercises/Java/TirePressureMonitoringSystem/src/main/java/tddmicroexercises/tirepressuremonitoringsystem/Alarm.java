package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm implements IAlarm {
  private final double lowPressureThreshold = 17;
  private final double highPressureThreshold = 21;

  Sensor sensor = new Sensor();

  boolean alarmOn = false;
  private long alarmCount = 0;

  public void check() {
    double psiPressureValue = sensor.popNextPressurePsiValue();

    if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue) {
      alarmOn = true;
      alarmCount += 1;
    }
  }

  public boolean isAlarmOn() {
    return alarmOn;
  }
}
