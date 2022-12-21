import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
  while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
    Run = currentBuild.rawBuild.getPreviousBuildInProgress()
    sh "echo Abortig build #${olderBuild.number}"
    currentBuild.rawBuild.getPreviousBuildInProgress().doStop()
  }
}