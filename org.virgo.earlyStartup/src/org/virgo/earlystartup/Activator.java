package org.virgo.earlystartup;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IStartup {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.virgo.earlyStartup"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	public void earlyStartup() {
		for (IServer server : ServerCore.getServers()) {
			if (server.getServerType().getId().matches(Messages.Activator_SERVER_REGEXP)) {
				try {
					server.start("run", new NullProgressMonitor()); //$NON-NLS-1$
					StatusManager.getManager().handle(	new Status(IStatus.INFO, PLUGIN_ID,
															Messages.Activator_AutoStartMessage_1 + server.getName()
																+ Messages.Activator_AutoStartMessage_2));
				} catch (CoreException e) {
					StatusManager.getManager().handle(	new Status(IStatus.WARNING, PLUGIN_ID,
															Messages.Activator_AutoStartWarningMessage
																+ server.getName() + ".", e)); //$NON-NLS-2$
				}
			}
		}
	}
}
