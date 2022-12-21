import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
    sh "echo ana gaiiiiiiiiii"
    sh "echo ${currentBuild}"
    sh "echo ${currentBuild.rawBuild}"
    sh "echo ${currentBuild.rawBuild.getPreviousCompletedBuild()}"
    Run previousBuild = currentBuild.rawBuild.getPreviousCompletedBuild()
    sh "echo ana geeeeeeeeeet"
    while (previousBuild != null) {
        echo ">> Older build #${previousBuild.number}"
        if (previousBuild.isInProgress()) {
            def executor = previousBuild.getExecutor()
            if (executor != null) {
                echo ">> Aborting older build #${previousBuild.number}"
                executor.interrupt(Result.ABORTED, new UserInterruption(
                    "Aborted by newer build #${currentBuild.number}"
                ))
            }
        }

        previousBuild = previousBuild.getPreviousCompletedBuild()
    }
}