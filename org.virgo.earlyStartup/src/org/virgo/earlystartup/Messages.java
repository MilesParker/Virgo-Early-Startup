/*******************************************************************************
 * Copyright (c) 2009, 2012 SpringSource, a divison of VMware, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SpringSource, a division of VMware, Inc. - initial API and implementation
 *******************************************************************************/

package org.virgo.earlystartup;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author Miles Parker
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.virgo.earlystartup.messages"; //$NON-NLS-1$
	public static String Activator_AutoStartMessage_1;
	public static String Activator_AutoStartMessage_2;
	public static String Activator_AutoStartWarningMessage;
	public static String Activator_SERVER_REGEXP;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
