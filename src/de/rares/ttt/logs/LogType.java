package de.rares.ttt.logs;

public enum LogType {

    ERROR("INFO " ), WARN("INFO " ), INFO("INFO " );

    String index;

    LogType(String s) {
    index = s;
    }
}
