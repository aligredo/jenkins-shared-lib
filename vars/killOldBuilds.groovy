import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption
import hudson.model.RunT
def call() {
  while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
    RunT olderBuild = currentBuild.rawBuild.getPreviousBuildInProgress()
    sh "echo Abortig build #${olderBuild.number}"
    currentBuild.rawBuild.getPreviousBuildInProgress().doStop()
  }
}