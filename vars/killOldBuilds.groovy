import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption
def call() {
  while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
    def olderBuild = currentBuild.rawBuild.getPreviousBuildInProgress()
    olderBuild.doStop()
  }
}