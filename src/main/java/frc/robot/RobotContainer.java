// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.climber.Extend;
import frc.robot.commands.climber.Retract;
import frc.robot.subsystems.climber.Climber;

/** Add your docs here. */
public class RobotContainer {
    Climber ourClimber;

    public RobotContainer() {
        ourClimber = new Climber();
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        CommandXboxController ourController = new CommandXboxController(0);
        Trigger buttonX = ourController.button(4);
        Trigger buttonY = ourController.button(3);

        buttonX
            .whileTrue(new Extend(ourClimber));

        buttonY
            .whileTrue(new Retract(ourClimber));
    }
}
