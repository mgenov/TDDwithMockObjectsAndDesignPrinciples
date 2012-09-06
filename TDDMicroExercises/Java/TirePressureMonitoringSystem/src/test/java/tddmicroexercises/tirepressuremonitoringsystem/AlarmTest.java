package tddmicroexercises.tirepressuremonitoringsystem;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Miroslav Genov (mgenov@gmail.com)
 */
public class AlarmTest {

  private static final double LOW_PRESSURE_THRESHOLD = 17d;
  private static final double NORMAL_PRESSURE = LOW_PRESSURE_THRESHOLD + 1;
  private static final double HIGH_PRESSURE_THRESHOLD = 21d;

  Mockery context = new Mockery();

  private Alarm alarm;

  private TelemetrySensor telemetrySensor;

  @Before
  public void initializeAlarm() {
    telemetrySensor = context.mock(TelemetrySensor.class);
    alarm = new Alarm(telemetrySensor, LOW_PRESSURE_THRESHOLD, HIGH_PRESSURE_THRESHOLD);
  }


  @Test
  public void initiallyAlarmIsOff() {
    assertThat(alarm.isAlarmOn(), is(equalTo(false)));
  }

  @Test
  public void alarmIsTurnedOnWhenPressureIsLowerThenLowerThreshold() {
    pretendPressureReturnedFromSensorIs(LOW_PRESSURE_THRESHOLD - 1);
    assertAlarmCheckTurnsAlarmOn();
  }

  @Test
  public void alarmIsTurnedOnWhenPressureIsHigherThenHigherThreshold() {
    pretendPressureReturnedFromSensorIs(HIGH_PRESSURE_THRESHOLD + 1);
    assertAlarmCheckTurnsAlarmOn();
  }

  @Test
  public void alarmIsOffWhenPressureIsInBoundaries() {
    pretendPressureReturnedFromSensorIs(NORMAL_PRESSURE);
    assertAlarmCheckTurnsAlarmOff();
  }

  private void assertAlarmCheckTurnsAlarmOff() {
    alarm.check();
    assertAlarmStatus(false);
  }

  private void assertAlarmCheckTurnsAlarmOn() {
    alarm.check();
    assertAlarmStatus(true);
  }

  private void assertAlarmStatus(boolean expectedStatus) {
    assertThat(alarm.isAlarmOn(), is(equalTo(expectedStatus)));
  }

  private void pretendPressureReturnedFromSensorIs(final double expectedPressure) {
      context.checking(new Expectations() {{
        oneOf(telemetrySensor).popNextPressurePsiValue();
        will(returnValue(expectedPressure));
      }});
    }

}
