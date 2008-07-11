package com.googlecode.svntask.command;

import java.io.File;

import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

import com.googlecode.svntask.Command;


/**
 * Used for executing svn update. Defaults to recursive and force == true.
 * 
 * @author jonstevens
 */
public class Update extends Command
{
	private String path;
	private boolean recursive = true;
	private boolean force = true;

	@Override
	public void execute() throws Exception
	{
		// Get the Update Client
		SVNUpdateClient client = this.getTask().getSvnClient().getUpdateClient();

		// Execute svn info
		client.doUpdate(new File(path), SVNRevision.HEAD, this.recursive, this.force);
	}

	@Override
	protected void validateAttributes() throws Exception
	{
		if (path == null)
			throw new Exception("path cannot be null");
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public void setRecursive(boolean recursive)
	{
		this.recursive = recursive;
	}

	public void setForce(boolean force)
	{
		this.force = force;
	}
}