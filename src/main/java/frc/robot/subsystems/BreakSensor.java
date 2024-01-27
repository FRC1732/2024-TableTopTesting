// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
