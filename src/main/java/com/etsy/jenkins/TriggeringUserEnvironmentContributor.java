package com.etsy.jenkins;

import hudson.EnvVars;
import hudson.Extension;
import hudson.model.Cause;
import hudson.model.EnvironmentContributor;
import hudson.model.Run;
import hudson.model.TaskListener;

@Extension
public class TriggeringUserEnvironmentContributor
extends EnvironmentContributor {

  @Override
  public void buildEnvironmentFor(Run r, EnvVars envs, TaskListener listener) {
    Cause.UserCause cause =
        (Cause.UserCause) r.getCause(Cause.UserCause.class);
    if (cause == null)  return;
    envs.put("TRIGGERING_USER", cause.getUserName());

    // TODO Traverse upstream causes too!
  }
}

