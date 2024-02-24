// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */
public class RobotContainer {
    Climber ourClimber = new Climber();

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        XboxController ourController = new XboxController(0);
        JoystickButton joystickY = new JoystickButton(ourController, XboxController.Button.kY.value);
        JoystickButton joystickX = new JoystickButton(ourController, XboxController.Button.kX.value);

        joystickY
            .onTrue(new InstantCommand(() -> ourClimber.climberExtend()))
            .onFalse(new InstantCommand(() -> ourClimber.stopClimber()));

        joystickX
            .onTrue(new InstantCommand(() -> ourClimber.climberRetract()))
            .onFalse(new InstantCommand(() -> ourClimber.stopClimber()));
    }
}
