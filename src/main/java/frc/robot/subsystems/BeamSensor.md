# Beam Sensor Wiring

12 Volts to both sides. \
L+ is brown. \
L- is blue/ground.

On the NPN reciever, the signal is on the black wire. \
Attach black wire to analog on rio.

Lower analog values indicate that the beam is not broken. \
Higher values indicate that the beam is broken.

In testing a threshold of 700 was used.

```
public class BreakSensor extends SubsystemBase {
  /** Creates a new BreakSensor. */
  AnalogInput analog;
  int counter = 0;

  public BreakSensor() {
    analog = new AnalogInput(0);
    Shuffleboard.getTab("MAIN").addNumber("Sensor Value", this::getValue);
    Shuffleboard.getTab("MAIN").addBoolean("Beam Broken", this::getBeamBroken);
    this.setDefaultCommand(new Command() {
      {
        addRequirements(BreakSensor.this);
      }
    });
  }

  public int getValue() {
    return analog.getValue();
  }
  
  public boolean getBeamBroken() {
    return analog.getValue() > 700;
  }

  @Override
  public void periodic() {

  }
}

```