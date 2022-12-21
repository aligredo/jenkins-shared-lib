import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
    sh "echo ana gaiiiiiiiiii"
    //Run previousBuild = currentBuild.rawBuild.getPreviousBuildInProgress()
    sh "echo ${currentBuild}"
    sh "echo ${currentBuild.rawBuild}"
    sh "echo ${currentBuild.rawBuild.getPreviousBuildInProgress()}"

    sh "echo ana geeeeeeeeeet"
    while (previousBuild != null) {
        if (previousBuild.isInProgress()) {
            def executor = previousBuild.getExecutor()
            if (executor != null) {
                echo ">> Aborting older build #${previousBuild.number}"
                executor.interrupt(Result.ABORTED, new UserInterruption(
                    "Aborted by newer build #${currentBuild.number}"
                ))
            }
        }

        previousBuild = previousBuild.getPreviousBuildInProgress()
    }
}