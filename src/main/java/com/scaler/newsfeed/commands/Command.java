package com.scaler.newsfeed.commands;

public interface Command {
    boolean matched(String query);
    void execute(String query);
}
