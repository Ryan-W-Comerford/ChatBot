#!/bin/bash

SRC_DIR="src/main/java"
BIN_DIR="bin"

mkdir -p "$BIN_DIR"

javac -d "$BIN_DIR" "$SRC_DIR/com/chat/simulator/"*.java
if [ $? -ne 0 ]; then
    echo "Error Compiling"
    exit 1
fi

java -cp "$BIN_DIR" com.chat.simulator.ChatSimulator