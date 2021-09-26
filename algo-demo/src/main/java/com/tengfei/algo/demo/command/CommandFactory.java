package com.tengfei.algo.demo.command;

import java.util.concurrent.Future;

public interface CommandFactory {

    void execute(String key, CommandContext context);

    Future<Object> executeAsync(String key, CommandContext context);

    void registerCommand(Command command);
}
