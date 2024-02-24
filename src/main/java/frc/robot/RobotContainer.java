// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.climber.Extend;
import frc.robot.commands.climber.Retract;
import frc.robot.subsystems.climber.Climber;

/** Add your docs here. */
public class RobotContainer {
    private Climber ourClimber;

    private CommandJoystick ourController;
    private Trigger buttonX;
    private Trigger buttonY;

    public RobotContainer() {
        ourClimber = new Climber();
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        ourController = new CommandJoystick(0);
        buttonX = ourController.button(4);
        buttonY = ourController.button(3);

        System.out.println("Configure buttons.");

        buttonX.whileTrue(new Extend(ourClimber));
        //buttonX.onFalse(new PrintCommand("X Button Released."));
        buttonY.whileTrue(new Retract(ourClimber));
        //buttonY.onFalse(new PrintCommand("Y Button Released."));
    }
}
