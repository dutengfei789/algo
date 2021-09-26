package com.tengfei.algo.demo.command.impl;

import com.tengfei.algo.demo.command.Command;
import com.tengfei.algo.demo.command.CommandContext;
import com.tengfei.algo.demo.command.CommandFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class CommandFactoryImpl implements CommandFactory {

    private Map<String, Command> commandByKey = new HashMap<>();


    @Override
    public void execute(String key, CommandContext context) {
        if (commandByKey.containsKey(key)) {
            commandByKey.get(key).execute(context);
        }else {
            throw new IllegalArgumentException("command " + key+" is not mapped");
        }

    }

    @Override
    public Future<Object> executeAsync(String key, CommandContext context) {
        if (commandByKey.containsKey(key)) {
            return  commandByKey.get(key).executeAsync(context);
        }else {
            throw new IllegalArgumentException("command " + key+" is not mapped");
        }
    }

    @Override
    public void registerCommand(final Command command) {

        Command mapped = commandByKey.get(command.getCmdKey());
        if (mapped != command) {
            if (mapped != null) {
                System.out.println("Replacing command impl for" + command.getCmdKey() + command);
            }else {
                System.out.println("add command impl for" + command.getCmdKey() + command);

            }
            commandByKey.put(command.getCmdKey(), command);
        }
    }
}
