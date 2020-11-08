package service;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;
import scala.concurrent.ExecutionContext;
import scala.concurrent.ExecutionContextExecutor;
import javax.inject.Inject;

public class DatabaseExecutionContext implements ExecutionContextExecutor {

    // получения исполнителя для текущего контекста DB
    private final ExecutionContext executionContext;

    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
        this.executionContext = actorSystem.dispatchers().lookup("app.system.dispatchers.customexecuter");
    }
    @Override
    public ExecutionContext prepare() {
        return executionContext.prepare();
    }

    @Override
    public void execute(Runnable command) {
        executionContext.execute(command);
    }

    @Override
    public void reportFailure(Throwable cause) {
        executionContext.reportFailure(cause);

    }
}
