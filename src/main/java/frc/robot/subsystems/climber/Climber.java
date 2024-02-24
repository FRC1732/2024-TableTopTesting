// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Climber extends SubsystemBase {
  private CANSparkMax climberRightMotor;
  private CANSparkMax climberLeftMotor;
  
  private ShuffleboardTab climberTab;
 
  private double currentHeight = 0; //FIXME track this somewhere

  /** Creates a new Climber. */
  public Climber() {
    climberRightMotor =
        new CANSparkMax( 
            ClimberConstants.CLIMBER_MOTOR_RIGHT_CAN_ID, CANSparkMax.MotorType.kBrushless);
    climberLeftMotor =
        new CANSparkMax( 
            ClimberConstants.CLIMBER_MOTOR_LEFT_CAN_ID, CANSparkMax.MotorType.kBrushless);

     climberRightMotor.setInverted(ClimberConstants.CLIMBER_MOTOR_RIGHT_INVERTED);
     climberLeftMotor.setInverted(ClimberConstants.CLIMBER_MOTOR_LEFT_INVERTED);

    // if (ClimberConstants.DO_TESTING) {
    //   setUpShuffleBoard();
    // }
  }

  public void setUpShuffleBoard() {
    //climberTab = Shuffleboard.getTab("Climber");
    //FIXME add things here
    
  }

  public void climberExtend() {
    climberRightMotor.set(ClimberConstants.CLIMBER_MOTOR_RIGHT_SPEED);
    climberRightMotor.set(ClimberConstants.CLIMBER_MOTOR_LEFT_SPEED);

  }

  public void climberRetract() {
    climberRightMotor.set(-ClimberConstants.CLIMBER_MOTOR_RIGHT_SPEED);
    climberRightMotor.set(-ClimberConstants.CLIMBER_MOTOR_LEFT_SPEED);
  }

  public void stopClimber() {
    climberRightMotor.set(0);
    climberLeftMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // if (currentHeight > ClimberConstants.CLIMBER_MAX_HEIGHT_THRESHOLD) {
    //   stopClimber();
    // }

  }
}
