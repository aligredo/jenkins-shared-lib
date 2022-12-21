import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption
def call() {
  while(olderBuild != null) {
    def olderBuild = currentBuild.rawBuild.getPreviousBuildInProgress()
    olderBuild.doStop()
    olderBuild = currentBuild.rawBuild.getPreviousBuildInProgress()
  }
}