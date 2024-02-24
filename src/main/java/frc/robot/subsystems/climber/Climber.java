// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Climber extends SubsystemBase {
  private CANSparkFlex climberRightMotor;
  private CANSparkFlex climberLeftMotor;

  /** Creates a new Climber. */
  public Climber() {
    climberRightMotor =
        new CANSparkFlex( 
            ClimberConstants.CLIMBER_MOTOR_RIGHT_CAN_ID, CANSparkMax.MotorType.kBrushless);
    climberLeftMotor =
        new CANSparkFlex( 
            ClimberConstants.CLIMBER_MOTOR_LEFT_CAN_ID, CANSparkMax.MotorType.kBrushless);

    climberRightMotor.setInverted(ClimberConstants.CLIMBER_MOTOR_RIGHT_INVERTED);
    climberLeftMotor.follow(climberRightMotor);

    if (ClimberConstants.DO_TESTING) {
     
    }
  }

  public void climberExtend() {
    climberRightMotor.set(ClimberConstants.CLIMBER_MOTOR_SPEED);
  }

  public void climberRetract() {
    climberRightMotor.set(-ClimberConstants.CLIMBER_MOTOR_SPEED);
  }

  public void stopClimber() {
    climberRightMotor.set(0);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
