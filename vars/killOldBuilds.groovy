import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption
import hudson.model.Run
def call() {
  while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
    Run = currentBuild.rawBuild.getPreviousBuildInProgress()
    sh "echo Abortig build #${olderBuild.number}"
    currentBuild.rawBuild.getPreviousBuildInProgress().doStop()
  }
}