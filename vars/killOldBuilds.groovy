import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
  while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
    if(currentBuild.rawBuild.getPreviousBuildInProgress() != null){
        currentBuild.rawBuild.getPreviousBuildInProgress().doStop()
    }
  }
}
