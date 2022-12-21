import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
  while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
    sh "echo Aborting older build #${currentBuild.rawBuild.getPreviousBuildInProgress().number}"
    currentBuild.rawBuild.getPreviousBuildInProgress().doStop()
  }
}