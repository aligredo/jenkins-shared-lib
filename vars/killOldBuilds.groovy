import hudson.model.Result
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
  while(currentBuild.rawBuild.getPreviousBuildInProgress() != null) {
    echo ">> Aborting older build #${currentBuild.rawBuild.getPreviousBuildInProgress().number}"
    def executor = currentBuild.rawBuild.getPreviousBuildInProgress().previousBuild.getExecutor()
    executor.interrupt(Result.ABORTED, new UserInterruption(
                    "Aborted by newer build #${currentBuild.number}"
                ))
    currentBuild.rawBuild.getPreviousBuildInProgress().doStop()
  }
}