/*******************************************************************************
 * Copyright (c) 2001, 2008 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Flemming N. Larsen
 *     - Initial implementation
 *******************************************************************************/
package robocode;


import robocode.peer.RobotStatics;
import robocode.peer.serialize.RbSerializer;
import robocode.peer.serialize.ISerializableHelper;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.IPaintEvents;
import robocode.robotinterfaces.IPaintRobot;

import java.awt.*;
import java.nio.ByteBuffer;


/**
 * This event occurs when your robot should paint, where the {@link
 * Robot#onPaint(Graphics2D) onPaint()} is called on your robot.
 * </p>
 * You can use this event for setting the event priority by calling
 * {@link AdvancedRobot#setEventPriority(String, int)
 * setEventPriority("PaintEvent", priority)}
 *
 * @author Flemming N. Larsen (original)
 */
public final class PaintEvent extends Event {
	private static final long serialVersionUID = 1L;
	private final static int DEFAULT_PRIORITY = 5;

	/**
	 * Called by the game to create a new PaintEvent.
	 */
	public PaintEvent() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final int getDefaultPriority() {
		return DEFAULT_PRIORITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final void dispatch(IBasicRobot robot, RobotStatics statics, Graphics2D graphics) {
		if (statics.isPaintRobot()) {
			IPaintEvents listener = ((IPaintRobot) robot).getPaintEventListener();

			if (listener != null) {
				listener.onPaint(graphics);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	byte getSerializationType() {
		throw new Error("Serialization of this type is not supported");
	}
}
