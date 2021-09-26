package com.tengfei.algo.demo.command;

import java.util.concurrent.Future;

public interface Command {

    void execute(CommandContext context);

    Future<Object> executeAsync(CommandContext context);

    String getCmdKey();
}
