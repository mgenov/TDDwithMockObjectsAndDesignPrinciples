package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Miroslav Genov (mgenov@gmail.com)
 */
public class AlarmTest {

  @Test
  public void initiallyAlarmIsOff() {
    assertThat(new Alarm().isAlarmOn(),is(equalTo(false)));
  }

}
